package tp2;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServeurMessagerie extends UnicastRemoteObject implements
		IMessagerie
{

	protected ServeurMessagerie() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String echo(String msg) throws RemoteException
	{
		// TODO Auto-generated method stub
		return "salut les chats";
	}

}
