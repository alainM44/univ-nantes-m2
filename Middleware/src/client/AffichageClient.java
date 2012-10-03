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
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	ISujetDiscussion sujetDiscussion;
	private static final long serialVersionUID = 2L;

	JFrame f = new JFrame();

	JTextArea discussion = new JTextArea(10, 20);

	JTextField composeMessage = new JTextField(20);

	JButton boutonEnvoi = new JButton("ENVOI");

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

	public AffichageClient(String titre, ISujetDiscussion s)
			throws RemoteException {
		sujetDiscussion = s;
		Placement.p(f, new Label(titre), 1, 1, 1, 1);
		Placement.p(f, discussion, 1, 2, 1, 1);
		Placement.p(f, composeMessage, 1, 3, 1, 1);
		Placement.p(f, boutonEnvoi, 1, 4, 1, 1);
		boutonEnvoi.addActionListener(new ActionEnvoi());
		f.pack();
		f.setVisible(true);
	}

	/**
	 * Ajoute a l'écran le message diffusé
	 */
	@Override
	public void affiche(String message) {
		discussion.append(message);
	}

	public void termine() {
		f.dispose();
	}
}
