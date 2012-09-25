package tp2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestServeurMessagerie
{

	/**
	 * @param args
	 * @throws AlreadyBoundException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException,
			AlreadyBoundException
	{
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}
		try
		{
		//	 LocateRegistry.createRegistry();
			//  Registry registry = LocateRegistry.getRegistry();
			ServeurMessagerie serveur = new ServeurMessagerie();
			Naming.rebind("//127.0.0.1", serveur);
			// TODO Auto-generated method stub
		}
		catch (Exception e)
		{
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}

	}

}
