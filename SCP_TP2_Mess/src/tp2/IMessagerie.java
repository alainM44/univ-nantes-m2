package tp2;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IMessagerie extends Remote
{

	public String echo(String msg) throws RemoteException;
		
	
}
