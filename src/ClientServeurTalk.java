/**
 * Client / Serveur de talk
 * @author Robin DEGIRONDE
 * @author Charles BANQUET
 * @author Rémi BARBASTE
 */
 
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
public class ClientServeurTalk extends Thread{

	public static ORB orb;
	public static Talk.AfficherMessage monTalk;

	public void run()
	{
		orb.run();
	}

	public static void main(String args[]) {

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
			TalkImpl monTalk = new TalkImpl();

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
			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String nomObj = in.readLine();
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(monTalk));
			System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");

			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monTalk));
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(IORServant);

			// Lancement de l'ORB et mise en attente de requete
			//**************************************************
			new ClientServeurTalk().start();

			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");
			String idObj = in.readLine();

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantTalk = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantTalk));

			// Casting de l'objet CORBA au type convertisseur euro

			String message;
			Scanner sc= new Scanner(System.in);

			 AfficherMessage monTalkClient = Talk.AfficherMessageHelper.narrow(distantTalk);

			while (true)
			{
				System.out.print("Tappez votre message: ");
				message= sc.nextLine();
				monTalkClient.afficherMessage(message);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
