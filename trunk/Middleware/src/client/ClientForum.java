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

package client;

import ihm.Placement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import serveur.IServeurForum;
import serveur.ISujetDiscussion;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant un client du forum. Il sert uniquement à orienter un
 *         client sur un SujetDiscussion.
 * 
 */
@SuppressWarnings("serial")
public class ClientForum extends JFrame {
	JButton boutonInscriptionSport = new JButton("sport");
	JButton boutonInscriptionMusique = new JButton("musique");
	JButton boutonInscriptionCinema = new JButton("cinema");
	JButton boutonQuit = new JButton("Quit");

	/**
	 * Classe d'écrivant les actin à effectuer lors d'un enclanchement de bouton
	 * 
	 * @author Alain MARGUERITE
	 * @author Romain RINCÉ
	 * 
	 */
	class ActionInscription implements ActionListener {
		private String titre;
		private boolean inscrit = false;
		private AffichageClient ihmSujet; // affichage client associé au bouton
		private ISujetDiscussion sujetDiscussionServeur; // Sujet associé au
															// bouton

		/**
		 * Constructeur principal
		 * 
		 * @param titre
		 *            titre du sujet de discussion ex : sport musique .....
		 * @param sujet
		 *            référence sur un sujet de discussion (crée par le serveur)
		 * 
		 * @throws RemoteException
		 */
		public ActionInscription(String titre, ISujetDiscussion sujet)
				throws RemoteException {
			super();
			this.sujetDiscussionServeur = sujet;
			this.titre = titre;
			this.inscrit = true;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				this.ihmSujet = new AffichageClient(titre,
						sujetDiscussionServeur);
				this.sujetDiscussionServeur.inscription(ihmSujet);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				System.out.println("erreur ClientForum.java actionPerformed");
			}

		}

	}

	IServeurForum leServeur;

	public ClientForum() throws RemoteException {
		try {
			leServeur = (IServeurForum) Naming
					.lookup("//localhost/ServeurForum");
			System.out.println("Connecté au serveur");
		} catch (Exception e) {
			System.out.println("ClientForum.java erreur nommage serveur");
			e.printStackTrace();
			return;
		}
		setTitle("ForumRMI");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		// North area
		Box boxNorth = Box.createHorizontalBox();
		boxNorth.add(new JLabel("Bienvenue dans le ForumRMI"));
		add(boxNorth);
		// add(Box.createVerticalGlue());

		// center area
		Box boxCenter = Box.createHorizontalBox();
		boxCenter.add(new JLabel("VISU"));
		boxCenter.add(Box.createHorizontalGlue());
		boxCenter.add(new JLabel("LIST"));
		add(boxCenter);

		// south area
		Box boxSouth = Box.createHorizontalBox();
		boxSouth.add(new JTextField("blah"));
		boxSouth.add(boutonQuit);
		add(boxSouth);
		boutonInscriptionSport.addActionListener(new ActionInscription("sport",
				leServeur.obtientSujet("sport")));
		boutonInscriptionMusique.addActionListener(new ActionInscription(
				"musique", leServeur.obtientSujet("musique")));
		boutonInscriptionCinema.addActionListener(new ActionInscription(
				"cinema", leServeur.obtientSujet("cinema")));
		boutonQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent();
				f.dispose();

			}
		});
		setVisible(true);
		pack();
	}

	public static void main(String[] argv) throws RemoteException {

		System.setProperty("java.security.policy", "file:./no.policy");
		new ClientForum();
	}
}
