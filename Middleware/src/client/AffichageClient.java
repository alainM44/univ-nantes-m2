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
 * @see IAffichageClient
 * @see UnicastRemoteObject
 */
public class AffichageClient extends UnicastRemoteObject implements
		IAffichageClient {
	private static final long serialVersionUID = 2L;

	ISujetDiscussion sujetDiscussion;
	private JScrollPane mJPanel;
	private JFrame mFramePrincipale = new JFrame();
	private JTextArea mJtextAreaDiscussion;
	private JTextField mJtextFieldComposeMesage;
	private JLabel mLabelCenter;
	private JButton mButonEnvoi = new JButton("ENVOI");
	private String mClientName = new String();

	class ActionEnvoi implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			try {
				sujetDiscussion.diffuse(mJtextFieldComposeMesage.getText());
			} catch (RemoteException e1) {
				System.out
						.println("Erreur AffichageClient.java envoi du message :"
								+ mJtextFieldComposeMesage.getText());
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
	public AffichageClient(String titre, ISujetDiscussion s, String client)
			throws RemoteException {
		sujetDiscussion = s;
		mClientName = client;
		mButonEnvoi.addActionListener(new ActionEnvoi());
		mFramePrincipale.setTitle("Forum " + titre);
		mFramePrincipale.setPreferredSize(new Dimension(300, 300));
		mFramePrincipale.setLayout(new BorderLayout());
		mJtextAreaDiscussion = new JTextArea(10, 20);
		mJtextAreaDiscussion.setEditable(false);
		mJPanel = new JScrollPane(mJtextAreaDiscussion);
		mJPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		mLabelCenter = new JLabel("Bienvenu dans le forum " + titre);
		mLabelCenter.setSize(30, 150);
		mFramePrincipale.add(mLabelCenter, BorderLayout.NORTH);
		mFramePrincipale.add(mJPanel, BorderLayout.CENTER);

		mJtextFieldComposeMesage = new JTextField("blah");
		mJtextFieldComposeMesage.setSize(new Dimension(10, 5));

		mLabelCenter.setPreferredSize(new Dimension(150, 10));
		mButonEnvoi.setFocusable(true);

		// south area
		Box boxSouth = Box.createHorizontalBox();
		// boxSouth.add(mLabelCenter);
		boxSouth.add(mJtextFieldComposeMesage);
		boxSouth.add(mButonEnvoi);

		mFramePrincipale.add(boxSouth, BorderLayout.SOUTH);
		mFramePrincipale.setResizable(false);
		mFramePrincipale.pack();
		mFramePrincipale.setVisible(true);
	}

	@Override
	public void affiche(String message) {
		mJtextFieldComposeMesage.setText("");
		mJtextAreaDiscussion.append("\n" + mClientName + " :" + message);
	}

	/**
	 * Permet de fermer lIHM client
	 */
	public void termine() {
		mFramePrincipale.dispose();
	}

}
