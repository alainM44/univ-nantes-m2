package serveur;

import java.rmi.Naming;
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
		try {
			// Création du serveur de forum et enregistrement sur le réseau
			// ////////////////////////////////////////////////////////////
			System.setProperty("java.security.policy",
					"file:///home/alain/workspace/SCP_TP2_Mess/no.policy");
			// /////////////////////////////////
			LocateRegistry.createRegistry(8686);
			ServeurForum leServeur = new ServeurForum();
			Naming.bind("//localhost/ServeurForum", leServeur);
			System.out.println("Démarrage du serveur");
		} catch (Exception e) {
			System.out.println("erreur enregistrement serveur");
			return;
		}
	}
}
