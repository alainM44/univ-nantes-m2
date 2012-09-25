package tp2;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ClientMessagerie
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}
		try
		{
			String toDiffuse = new String("");
			IMessagerie mess = (IMessagerie) Naming.lookup("//127.0.0.1");

			String reponse = mess.echo("chavabien?");
			System.out.println(reponse);

		}
		catch (Exception e)
		{
			System.err.println("ComputePi exception:");
			e.printStackTrace();
		}

	}
}
