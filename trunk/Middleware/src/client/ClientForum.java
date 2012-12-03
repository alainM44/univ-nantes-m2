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
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.FrameWarning;

import serveur.IServeurForum;
import serveur.ISujetDiscussion;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant un client du forum. Il sert uniquement à orienter un
 *         client sur un SujetDiscussion.
 * 
 *         TODO on peut rejoindre quand on a crée mais pas un serveur qu'un
 *         autre a creer
 * 
 */
@SuppressWarnings("serial")
public class ClientForum extends JFrame implements ListSelectionListener {

	private String mName = new String("Anonyme");
	private JLabel mLabelNorth = new JLabel(
			"Bienvenue dans le ForumRMI, veuillez entrer votre nom :");
	private JTextField mjtfNorth = new JTextField("");
	private JButton mButtonSave = new JButton("SAVE");
	private JButton boutonRefreshListServer = new JButton("RefreshList");
	private JTextField mjtfSouth = new JTextField("blahblah");
	private JButton boutonCreateServer = new JButton("CreateServer");
	private JButton boutonJoin = new JButton("JoinServer");
	private JButton boutonQuit = new JButton("Quit");
	private JList mlist;
	private DefaultListModel mlistModel;
	private IServeurForum leServeur;

	private HashMap<String, Boolean> mHMforumOuverts;

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
		private ClientForum source;

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
		public ActionInscription(ClientForum clientforum)
				throws RemoteException {
			super();
			source = clientforum;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String titre = (String) mlist.getSelectedValue();
			System.out.println(mHMforumOuverts);

			if (mHMforumOuverts.get(titre)) // dforum déjà ouvert
			{
				new FrameWarning();
				System.out.println("NANNNNNN déjà inscrit");
				// new JFrame("Désolé forum déjà ouvert");

			} else {
				try {
					ISujetDiscussion sujetDiscussionServeur = leServeur
							.obtientSujet((String) mlist.getSelectedValue());

					System.out.println("tata1" + titre);
					mHMforumOuverts.put(titre, true);
					ihmSujet = new AffichageClient(titre,
							sujetDiscussionServeur, source);
					sujetDiscussionServeur.inscription(ihmSujet);
				} catch (RemoteException e1) {
					System.out
							.println("erreur ClientForum.java actionPerformed");
					e1.printStackTrace();
				}

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
		mjtfNorth = new JTextField("tape here you pseudo");
		mjtfNorth.setSize(new Dimension(10, 10));
		mButtonSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mName = mjtfNorth.getText();
				mjtfNorth.setVisible(false);
				mButtonSave.setVisible(false);
				mLabelNorth.setText("Bienvenue " + mName);
			}
		});
		boxNorth.add(mjtfNorth);
		boxNorth.add(mButtonSave);
		add(boxNorth, BorderLayout.NORTH);
		// add(Box.createRigidArea(new DimensionUIResource(0, 20)));

		// center area
		mlistModel = new DefaultListModel();
		ArrayList<String> sujets = new ArrayList<String>();
		sujets = leServeur.getSujets();
		mHMforumOuverts = new HashMap<String, Boolean>();
		// on peuple la liste
		for (String sujet : sujets) {
			mlistModel.addElement(sujet);
			mHMforumOuverts.put(sujet, false);
		}
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
					mHMforumOuverts.put(mjtfSouth.getText(), false);
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

		boutonJoin.addActionListener(new ActionInscription(this));
		boxSouth.add(boutonJoin);
		boxSouth.add(Box.createHorizontalGlue());
		boxSouth.add(boutonQuit);
		boutonQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
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

	public String getmName() {
		return mName;
	}

	public void fermetureSujet(String titreSujet) throws RemoteException {
		System.out.println("on est plus inscrit");
		mHMforumOuverts.put(titreSujet, false);
		System.out.println(mHMforumOuverts);
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
			mHMforumOuverts.put(sujet, false);
			mlistModel.addElement(sujet);
			System.out.println(sujet);
		}
	}
}
