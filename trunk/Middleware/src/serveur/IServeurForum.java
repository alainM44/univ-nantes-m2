package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServeurForum extends Remote {
	/**
	 * 
	 * @param titre
	 *            Titre du sujet de discussion servant ici d'identifiant.
	 * @return L'instance du Sujet de discussion
	 * @throws RemoteException
	 */
	public ISujetDiscussion obtientSujet(String titre) throws RemoteException;

	
	/**
	 *Méthode retournant la liste des noms des sujets de discussions. Utile pour un client
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getSujets() throws RemoteException;

}
