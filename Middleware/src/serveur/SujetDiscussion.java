package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.xml.bind.Marshaller.Listener;

public class SujetDiscussion extends UnicastRemoteObject implements InterfaceSujetDiscussion {

	private final String titre;
	//liste des protagonistes de ce sujet de discussion
	//attention List et pas LISTE
	private Liste<InterfaceAffichageClient> protagonistes = new Liste<InterfaceAffichageClient>();
	public SujetDiscussion(String titre) throws RemoteException {
		super();
		this.titre = titre;
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
	s
	
}
