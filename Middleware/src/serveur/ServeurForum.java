package serveur;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurForum extends UnicastRemoteObject implements
		InterfaceServeurForum {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SujetDiscussion sport;
	SujetDiscussion musique;
	SujetDiscussion cinema;

	public ServeurForum() throws RemoteException {

	}

	@Override
	public InterfaceSujetDiscussion obientSujet(String titre)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// ////////////////////////////////////////////////////////////
		System.setProperty("java.security.policy",
				"file:///home/alain/workspace/SCP_TP2_Mess/no.policy");
		// /////////////////////////////////

		// Create and install a security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Security manager installed.");
		} else {
			System.out.println("Security manager already exists.");
		}

		try {
			// Création du serveur de forum et enregistrement sur le réseau
			LocateRegistry.createRegistry(1099);
			ServeurForum leServeur = new ServeurForum();
			Naming.bind("//localhost/ServeurForum", leServeur);
			System.out.println("Démarrage du serveur");
		} catch (Exception e) {
			System.out.println("erreur enregistrement serveur");
			return;
		}
	}
}
