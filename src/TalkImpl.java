/**
 * Talk impl - Implementation de l'objet CORBA
 * @author Robin DEGIRONDE
 * @author Charles BANQUET
 * @author Rémi BARBASTE
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
