/*   This file is part of ForumRMI.

    ForumRMI is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ForumRMI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ForumRMI.  If not, see <http://www.gnu.org/licenses/>
 */

package serveur;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant le serveur du forum. Il sert uniquement à orienter
 *         un client sur un SujetDiscussion.
 * 
 * @see IServeurForum
 * @see UnicastRemoteObject
 * 
 */
@SuppressWarnings("serial")
public class ServeurForum extends UnicastRemoteObject implements IServeurForum {
	// Écris en dur pour l'instant //TODO rendre la création de SujetDiscussion
	// dynamique
	SujetDiscussion sport;
	SujetDiscussion musique;
	SujetDiscussion cinema;
	ArrayList<String> sujetDiscussionsTitres;
	HashMap<String, SujetDiscussion> sujetDiscussions;

	/**
	 * Contructeur par defaut instanciant les différents Sujets de discussion.
	 * TODO effectuer l'instanciation d'un sujetde discussion lorsque le premier
	 * client se connecte
	 * 
	 * @throws RemoteException
	 */
	public ServeurForum() throws RemoteException {
		sport = new SujetDiscussion("sport");
		musique = new SujetDiscussion("musique");
		cinema = new SujetDiscussion("cinema");
		sujetDiscussionsTitres = new ArrayList<String>();
		sujetDiscussions = new HashMap<String, SujetDiscussion>();
	
		sujetDiscussionsTitres.add(sport.getTitre());
		sujetDiscussionsTitres.add(musique.getTitre());
		sujetDiscussionsTitres.add(cinema.getTitre());
		
		sujetDiscussions.put(sport.getTitre(),sport);
		sujetDiscussions.put(musique.getTitre(),musique);
		sujetDiscussions.put(cinema.getTitre(),cinema);


	}

	@Override
	public ISujetDiscussion obtientSujet(String titre) throws RemoteException {
		return sujetDiscussions.get(titre);
	}

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "file:./no.policy");
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
			e.printStackTrace();
			return;
		}
	}

	@Override
	public ArrayList<String> getSujets() throws RemoteException {
		System.out.println(sujetDiscussionsTitres);
		return sujetDiscussionsTitres;
	}

	@Override
	public void creerSujet(String nouveauSujet) throws RemoteException {
		sujetDiscussionsTitres.add(nouveauSujet);
		sujetDiscussions.put(nouveauSujet,new SujetDiscussion(nouveauSujet));
	}
}
