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

//TODO pattern delegate passer la liste des adresses des serveurs(objectsRMI)
//2eme serveur a l'adresse du 1er 
//3ème à l'adresse des deux premiers
//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import serveur.IAffichageClient;
import serveur.ISujetDiscussion;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe implémentant une IHM Client ou s'afficheront les diffusions
 *         d'un Sujet de Discussion.
 * 
 * @see IAffichageClient
 * @see UnicastRemoteObject
 */
public class AffichageClient extends UnicastRemoteObject implements
		IAffichageClient {
	private static final long serialVersionUID = 2L;

	ISujetDiscussion sujetDiscussion;
	private String mtitreForum;
	private JScrollPane mJPanelDicussion;
	private JFrame mFramePrincipale = new JFrame();
	private JTextArea mJtextAreaDiscussion;
	private Font mFontName;
	private Font mFonteTxt;
	private JTextField mJtextFieldComposeMesage;
	private JLabel mLabelCenter;
	private JButton mButonEnvoi = new JButton("ENVOI");
	private String mClientName = new String();
	private ClientForum mClientForum;

	/**
	 * 
	 * @author alain
	 * 
	 */
	class ActionEnvoi implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			try {
				sujetDiscussion.diffuse(mClientName,
						mJtextFieldComposeMesage.getText());
			} catch (RemoteException e1) {
				System.out
						.println("Erreur AffichageClient.java envoi du message :"
								+ mJtextFieldComposeMesage.getText());
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Constructeur de l'iHM
	 * 
	 * @param titre
	 *            titre du forum
	 * @param s
	 *            référence du sujet de discussion
	 * @param client
	 *            Nom du client
	 * @throws RemoteException
	 */
	public AffichageClient(String titre, ISujetDiscussion s, ClientForum client)
			throws RemoteException {
		mtitreForum = titre;
		sujetDiscussion = s;
		mClientForum = client;
		mClientName = client.getmName();
		mButonEnvoi.addActionListener(new ActionEnvoi());
		mFramePrincipale.setTitle("Forum " + titre);
		mFramePrincipale.setPreferredSize(new Dimension(300, 300));
		mFramePrincipale.setLayout(new BorderLayout());
		mJtextAreaDiscussion = new JTextArea(10, 20);
		mJtextAreaDiscussion.setEditable(false);
		mFontName = new Font("TimesRoman", Font.BOLD, 13);
		mFonteTxt = new Font("TimesRoman", Font.PLAIN, 11);
		mJPanelDicussion = new JScrollPane(mJtextAreaDiscussion);
		mJPanelDicussion
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		mLabelCenter = new JLabel("Bienvenu dans le forum " + titre);
		mLabelCenter.setSize(30, 150);
		// mFramePrincipale.add(mLabelCenter, BorderLayout.NORTH);
		mFramePrincipale.add(mJPanelDicussion, BorderLayout.NORTH);

		mJtextFieldComposeMesage = new JTextField("blah");
		mJtextFieldComposeMesage.setSize(new Dimension(10, 5));

		mLabelCenter.setPreferredSize(new Dimension(150, 10));
		mButonEnvoi.setFocusable(true);

		// south area
		Box boxSouth = Box.createHorizontalBox();
		// boxSouth.add(mLabelCenter);
		boxSouth.add(mJtextFieldComposeMesage);
		boxSouth.add(mButonEnvoi);

		mFramePrincipale.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					fermetureSujet();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		mFramePrincipale.add(boxSouth, BorderLayout.SOUTH);
		mFramePrincipale.setResizable(false);
		mFramePrincipale.pack();
		mFramePrincipale.setVisible(true);
	}

	@Override
	public void affiche(String user, String message) throws RemoteException {
		mJtextFieldComposeMesage.setText("");
		mJtextAreaDiscussion.setFont(mFontName);
		mJtextAreaDiscussion.setForeground(Color.BLUE);
		mJtextAreaDiscussion.append("\n" + user + " :");
		mJtextAreaDiscussion.setFont(mFonteTxt);
		mJtextAreaDiscussion.append(message);
	}

	/**
	 * Permet de fermer lIHM client
	 */
	public void termine() throws RemoteException {
		mFramePrincipale.dispose();
	}

	@Override
	public void fermetureSujet() throws RemoteException {
		mClientForum.fermetureSujet(mtitreForum);

	}

}
