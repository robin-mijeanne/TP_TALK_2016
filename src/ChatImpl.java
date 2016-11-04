import java.util.ArrayList;

import Talk.AfficherMessage;

/**
 * 
 */

/**
 * @author robin
 *
 */
public class ChatImpl extends Talk.ChatPOA{
	
	ArrayList<AfficherMessage> clients;
	
	public ChatImpl() {
		this.clients = new ArrayList<AfficherMessage>();
	}
	
	@Override
	public void inscription(AfficherMessage client) {
		// TODO Auto-generated method stub
		this.clients.add(client);
		
	}
	
	@Override
	public void diffusion(String message) {
		// TODO Auto-generated method stub
		for (AfficherMessage client : this.clients){
			client.afficherMessage(message);
		}
	}

}
