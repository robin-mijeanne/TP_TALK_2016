import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Talk.AfficherMessage;

/**
 * 
 */

/**
 * @author robin
 *
 */
public class ServeurChat{

	/**
	 * @param args
	 */
	public static ORB orb;
	public static Talk.AfficherMessage monTalk;
	
	public static void main(String[] args) {

		//Serveur
		try {
			// Intialisation de l'ORB
			//************************
			orb = org.omg.CORBA.ORB.init(args,null);

			// Gestion du POA
			//****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// Creation du servant
			//*********************
			ChatImpl monTalk = new ChatImpl();

			// Activer le servant au sein du POA et recuperer son ID
			byte[] monEuroId = rootPOA.activate_object(monTalk);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();


			// Enregistrement dans le service de nommage
			//*******************************************
			// Recuperation du naming service
			NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			
			String nomObj = "chat";
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(monTalk));
			System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");

			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monTalk));
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(IORServant);

			// Lancement de l'ORB et mise en attente de requete
			//**************************************************
			orb.run();

			// Casting de l'objet CORBA au type convertisseur euro

			String message;
			Scanner sc= new Scanner(System.in);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
