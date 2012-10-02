package serveur;

import java.rmi.RemoteException;

public interface InterfaceSujetDiscussion {

	public void inscription (InterfaceAffichageClient c ) throws RemoteException;
	
	public void desInscription(InterfaceAffichageClient c) throws RemoteException;
	
	public void diffuse(String Message) throws RemoteException;
	
}
