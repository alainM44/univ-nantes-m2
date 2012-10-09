package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServeurForum extends Remote {
	/**
	 * 
	 * @param titre
	 *            Titre du sujet de discussion servant ici d'identifiant.
	 * @return L'instance du Sujet de discussion
	 * @throws RemoteException
	 */
	public ISujetDiscussion obtientSujet(String titre) throws RemoteException;

}
