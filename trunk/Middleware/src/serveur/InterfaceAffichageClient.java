package serveur;

import java.rmi.RemoteException;

public interface InterfaceAffichageClient extends Remote{
	public void affiche (String message) throws RemoteException;

}