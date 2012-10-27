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
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

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
	ISujetDiscussion sujetDiscussion;
	private JScrollPane mJPanel;
	private static final long serialVersionUID = 2L;

	JFrame mFramePrincipale = new JFrame();

	JTextArea discussion = new JTextArea(10, 20);

	JTextField composeMessage = new JTextField(20);

	JButton boutonEnvoi = new JButton("ENVOI");
	String clientName = new String();

	class ActionEnvoi implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			try {
				sujetDiscussion.diffuse(composeMessage.getText());
			} catch (RemoteException e1) {
				System.out
						.println("Erreur AffichageClient.java envoi du message :"
								+ composeMessage.getText());
			}
		}
	}

	public AffichageClient(String titre, ISujetDiscussion s, String client)
			throws RemoteException {
		sujetDiscussion = s;
		clientName = client;
		boutonEnvoi.addActionListener(new ActionEnvoi());
		mFramePrincipale.setTitle(titre);
		mFramePrincipale.setPreferredSize(new Dimension(300, 300));
		mFramePrincipale.setLayout(new BorderLayout());
		mJPanel = new JScrollPane(discussion);
		mJPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		mFramePrincipale.add(mJPanel, BorderLayout.NORTH);
		mFramePrincipale.add(composeMessage, BorderLayout.CENTER);
		boutonEnvoi.setFocusable(true);
	
		mFramePrincipale.add(boutonEnvoi, BorderLayout.SOUTH);
		mFramePrincipale.pack();
		mFramePrincipale.setVisible(true);
	}

	/**
	 * Ajoute a l'écran le message diffusé
	 */
	@Override
	public void affiche(String message) {
		composeMessage.setText("");
		discussion.append("\n" + clientName + " :" + message);
	}

	public void termine() {
		mFramePrincipale.dispose();
	}

}
