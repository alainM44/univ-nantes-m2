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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
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
public class ClientForum extends JFrame implements ListSelectionListener {
	JButton boutonInscriptionSport = new JButton("sport");
	JButton boutonInscriptionMusique = new JButton("musique");
	JButton boutonInscriptionCinema = new JButton("cinema");
	JButton boutonCreateServer = new JButton("CreateServer");
	JButton boutonJoin = new JButton("JoinServer");
	JButton boutonQuit = new JButton("Quit");
	JList mlist;
	DefaultListModel mlistModel;

	/**
	 * Classe d'écrivant les actions à effectuer lors d'un enclanchement de
	 * bouton
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
			System.out.println("salut" + titre + sujet);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("toto");
			try {
				this.ihmSujet = new AffichageClient(titre,
						sujetDiscussionServeur);
				System.out.println("tata");
				this.sujetDiscussionServeur.inscription(ihmSujet);
			} catch (RemoteException e1) {
				System.out.println("erreur ClientForum.java actionPerformed");
			}

		}

	}

	// Création d'une variable locale permettant d'interoger le server
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

		// frame parameters
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		setTitle("ForumRMI");
		setLayout(new BorderLayout());

		// North area
		Box boxNorth = Box.createHorizontalBox();
		boxNorth.add(new JLabel("Bienvenue dans le ForumRMI"));
		add(boxNorth, BorderLayout.NORTH);
		// add(Box.createRigidArea(new DimensionUIResource(0, 20)));

		// center area
		mlistModel = new DefaultListModel();
		ArrayList<String> sujets = leServeur.getSujets();
		// on peuple la liste
		for (String sujet : sujets)
			mlistModel.addElement(sujet);
		System.out.println("liste des sujets :" + leServeur.getSujets());

		mlist = new JList(mlistModel);
		mlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mlist.setSelectedIndex(0);
		mlist.addListSelectionListener(this);
		mlist.setVisibleRowCount(5);
		// mlist.setSize(20,20);
		JScrollPane listScrollPane = new JScrollPane(mlist);
		// boxCenter.add(listScrollPane);
		add(listScrollPane, BorderLayout.CENTER);
		// add(Box.createVerticalGlue());

		// south area
		Box boxSouth = Box.createHorizontalBox();
		JTextField jtf = new JTextField("blahblah");
		jtf.setSize(new Dimension(10, 10));
		boxSouth.add(jtf);
		boxSouth.add(boutonCreateServer);
		boutonJoin.addActionListener(new ActionInscription((String) mlist
				.getSelectedValue(), leServeur.obtientSujet((String) mlist
				.getSelectedValue())));
		boxSouth.add(boutonJoin);

		boxSouth.add(Box.createHorizontalGlue());
		boxSouth.add(boutonQuit);
		boutonInscriptionSport.addActionListener(new ActionInscription("sport",
				leServeur.obtientSujet("sport")));
		// boutonInscriptionMusique.addActionListener(new ActionInscription(
		// "musique", leServeur.obtientSujet("musique")));
		// boutonInscriptionCinema.addActionListener(new ActionInscription(
		// "cinema", leServeur.obtientSujet("cinema")));
		boutonQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent();
				f.dispose();
			}
		});
		boxSouth.add(boutonInscriptionSport);
		add(boxSouth, BorderLayout.SOUTH);

		setVisible(true);
		pack();
	}

	public static void main(String[] argv) throws RemoteException {

		System.setProperty("java.security.policy", "file:./no.policy");
		new ClientForum();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
