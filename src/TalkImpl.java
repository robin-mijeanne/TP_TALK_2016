/**
 * Convertisseur Euro - Implementation de l'objet CORBA
 * @author Yann Steff & Emmanuel Lavinal
 */
public class TalkImpl  extends Talk.AfficherMessagePOA {

	// Constructeur
	//***************
	public TalkImpl(){

	}
	
	public void afficherMessage(String message)
	{
		System.out.println("\n"+message);
	}
}
