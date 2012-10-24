package ia;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IIA extends Remote {
	public void sendBegin() throws RemoteException;

	public void sendEnd() throws RemoteException;

	public void sendData() throws RemoteException;

	
	public  String whatCanIDo() throws RemoteException, InterruptedException;

}
