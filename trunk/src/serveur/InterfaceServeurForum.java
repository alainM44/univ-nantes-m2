package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServeurForum  extends Remote{
	public InterfaceSujetDiscussion obientSujet(String titre) throws RemoteException;

}
