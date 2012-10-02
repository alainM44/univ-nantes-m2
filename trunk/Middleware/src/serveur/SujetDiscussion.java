package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import list.Liste;

public class SujetDiscussion extends UnicastRemoteObject implements InterfaceSujetDiscussion {

	private final String titre;
	//liste des protagonistes de ce sujet de discussion
	//attention List et pas LISTE
	private Liste<InterfaceAffichageClient> protagonistes;
	public SujetDiscussion(String titre) throws RemoteException {
		super();
		this.titre = titre;
		this.protagonistes =new Liste<InterfaceAffichageClient>();
	}
	
	public synchronized void inscription (InterfaceAffichageClient c){
		//TODO
	}
	
	public synchronized void desInscription (InterfaceAffichageClient c){
		//TODO
	}
	public synchronized void diffuse (String message){
		//TODO
	}
	
	
	
	
}
