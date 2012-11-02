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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe implémentant un sujet de discussion (sport, musique ....) d'un
 *         Sujet de Discussion.
 * @see ISujetDiscussion
 * @see UnicastRemoteObject
 */
public class SujetDiscussion extends UnicastRemoteObject implements
		ISujetDiscussion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6540161618078886953L;
	/*
	 * Titre et identifiant unique du sujet de discussion
	 */
	private String mtitre;
	// private IAffichageClient mAffichageClient;
	/*
	 * liste des protagonistes de ce sujet de discussion
	 */
	private ArrayList<IAffichageClient> protagonistes;

	/**
	 * Constructeur
	 * 
	 * @param titre
	 *            Nom et identifiant du sujet de discussion
	 * @throws RemoteException
	 */
	public SujetDiscussion(String titre) throws RemoteException {
		super();
		mtitre = titre;
		protagonistes = new ArrayList<IAffichageClient>();
	}

	@Override
	public synchronized void inscription(IAffichageClient c)
			throws RemoteException {
		// mAffichageClient=c;
		protagonistes.add(c);
	}

	@Override
	public synchronized void desInscription(IAffichageClient c)
			throws RemoteException {
		protagonistes.get(protagonistes.indexOf(c)).fermetureSujet();
		protagonistes.remove(c);
	}

	@Override
	public synchronized void diffuse(String message) throws RemoteException {
		for (IAffichageClient iac : protagonistes)
			try {
				iac.affiche(message);
			} catch (RemoteException e) {
				System.out.println("Erreur SujetDiscussion.java diffuse");
			}
	}

	@Override
	public synchronized String getTitre() throws RemoteException {
		return mtitre;
	}
}
