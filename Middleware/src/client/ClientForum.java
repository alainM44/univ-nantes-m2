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


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.Box;
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

	String name= new String("Anonyme");
	JLabel mLabelNorth = new JLabel(
			"Bienvenue dans le ForumRMI, veuillez entrer votre nom :");
	JTextField mjtfNorth = new JTextField("");
	JButton mButtonSave = new JButton("SAVE");
	JButton boutonRefreshListServer = new JButton("RefreshList");
	JTextField mjtfSouth = new JTextField("blahblah");
	JButton boutonCreateServer = new JButton("CreateServer");
	JButton boutonJoin = new JButton("JoinServer");
	JButton boutonQuit = new JButton("Quit");
	JList mlist;
	DefaultListModel mlistModel;
	IServeurForum leServeur;

	/**
	 * Classe d'écrivant les actions à effectuer lors d'un enclanchement de
	 * bouton
	 * 
	 * @author Alain MARGUERITE
	 * @author Romain RINCÉ
	 * 
	 */
	class ActionInscription implements ActionListener {

		private AffichageClient ihmSujet; // affichage client associé au bouton

		// private ISujetDiscussion sujetDiscussionServeur; // Sujet associé au
		// bouton

		// Création d'une variable locale permettant d'interoger le server

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
		public ActionInscription() throws RemoteException {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ISujetDiscussion sujetDiscussionServeur = leServeur
						.obtientSujet((String) mlist.getSelectedValue());
				String titre = (String) mlist.getSelectedValue();
				System.out.println("tata" + titre);
				ihmSujet = new AffichageClient(titre, sujetDiscussionServeur,name);

				sujetDiscussionServeur.inscription(ihmSujet);
			} catch (RemoteException e1) {
				System.out.println("erreur ClientForum.java actionPerformed");
			}

		}
	}

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
		setPreferredSize(new Dimension(800, 400));
		setTitle("ForumRMI");
		setLayout(new BorderLayout());

		// North area
		Box boxNorth = Box.createHorizontalBox();
		boxNorth.add(mLabelNorth);
		mjtfNorth = new JTextField("blahblah");
		mjtfNorth.setSize(new Dimension(10, 10));
		mButtonSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				name=mjtfNorth.getText();
				mjtfNorth.setVisible(false);
				mButtonSave.setVisible(false);
				mLabelNorth.setText("Bienvenu(e) "+name);
			}
		});
		boxNorth.add(mjtfNorth);
		boxNorth.add(mButtonSave);
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

		JScrollPane listScrollPane = new JScrollPane(mlist);
		add(listScrollPane, BorderLayout.CENTER);

		// south area
		Box boxSouth = Box.createHorizontalBox();
		mjtfSouth = new JTextField("blahblah");
		mjtfSouth.setSize(new Dimension(10, 10));
		boutonCreateServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					leServeur.creerSujet(mjtfSouth.getText());
					rafraichir();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					System.out
							.println("Erreur a la création d'un nouveau serveur");
					e1.printStackTrace();
				}

			}
		});
		boxSouth.add(boutonCreateServer);
		boxSouth.add(mjtfSouth);
		boutonRefreshListServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rafraichir();

			}
		});
		boxSouth.add(boutonRefreshListServer);

		boutonJoin.addActionListener(new ActionInscription());
		boxSouth.add(boutonJoin);

		boxSouth.add(Box.createHorizontalGlue());
		boxSouth.add(boutonQuit);
		boutonQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent().getParent();
				f.dispose();
			}
		});

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

	/**
	 * Rafraichir la liste des serveurs
	 * 
	 * @throws RemoteException
	 */
	public void rafraichir() {
		// mlistModel = new DefaultListModel();
		ArrayList<String> sujets = new ArrayList<String>();
		try {
			sujets = leServeur.getSujets();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur dans l'obtention des sujets");
			e.printStackTrace();
		}
		mlistModel.removeAllElements();
		for (String sujet : sujets) {

			mlistModel.addElement(sujet);
			System.out.println(sujet);
		}
	}
}
