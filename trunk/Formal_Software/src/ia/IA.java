package ia;

/*   This file is part of FormalSoftwareProject.

 FormalSoftwareProject is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 FormalSoftwareProject is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with FormalSoftwareProject.  If not, see <http://www.gnu.org/licenses/>
 */

import ia.IIA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.tools.JavaCompiler;
import javax.swing.Timer;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant une IHM permettant de simuler un automate
 * @see JFrame
 */
@SuppressWarnings("serial")
public class IA extends UnicastRemoteObject implements IIA {// extends JFrame {

	// private enum {etat1;et
	private HashMap<String, ImageIcon> mMapImageServeur; // recueil des
															// différente
	// images
	private String mCurrentStateServeur = new String(); // décrit l'état courant
	private JLabel mLabelImageServeur;
	private JScrollPane mJScrollPane;
	private JTextArea mJtxtAreaServeur;
	private JFrame mIhmIA;
	private JButton mButQuit;

	protected IA() throws RemoteException {
		super();
		construireIHM();
	}

	public void construireIHM() {
		// //////////////////////////////////////////// general parameters
		mIhmIA = new JFrame("Formal Software project (IA)");
		mIhmIA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mIhmIA.setLayout(new BorderLayout());

		mIhmIA.setPreferredSize(new Dimension(600, 570));
		// ///////////////////////////////////////////////////////center area

		mMapImageServeur = new HashMap<String, ImageIcon>();
		mMapImageServeur
				.put("etat1",
						new ImageIcon(
								"/home/alain/workspace/Formal_Software/img/AutomateServeur1.png"));
		mMapImageServeur
				.put("etat2",
						new ImageIcon(
								"/home/alain/workspace/Formal_Software/img/AutomateServeur2.png"));
		mMapImageServeur
				.put("etat3",
						new ImageIcon(
								"/home/alain/workspace/Formal_Software/img/AutomateServeur3.png"));
		mMapImageServeur
				.put("etat4",
						new ImageIcon(
								"/home/alain/workspace/Formal_Software/img/AutomateServeur4.png"));
		mCurrentStateServeur = new String("etat1");
		mLabelImageServeur = new JLabel(mMapImageServeur.get("etat1"),
				SwingConstants.CENTER);
		mLabelImageServeur.setBorder(BorderFactory.createLineBorder(
				Color.lightGray, 26));

		mIhmIA.add(mLabelImageServeur, BorderLayout.NORTH);
		// /////////////////////////////////////////////////////////: center
		// area
		mJtxtAreaServeur = new JTextArea("Serveur lancé: " + "\n");
		mJtxtAreaServeur.setLineWrap(true);
		mJScrollPane = new JScrollPane(mJtxtAreaServeur);
		mJScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mIhmIA.add(mJScrollPane, BorderLayout.CENTER);

		// ///////////////////////////////////////////////////////south area
		mButQuit = new JButton("Quit");
		mButQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent().getParent();
				f.dispose();
			}
		});
		Box southBox = Box.createHorizontalBox();
		southBox.add(mButQuit);
		southBox.add(Box.createHorizontalGlue());
		mIhmIA.add(southBox, BorderLayout.SOUTH);
		// /////////////////////////////////////////////////////////////////////////////////
		// end south area
		mIhmIA.setVisible(true);
		mIhmIA.pack();
	}

	public void setmCurrentStateServeur(String mCurrentState, String msg) {
		this.mCurrentStateServeur = mCurrentState;
		switch (mCurrentStateServeur) {
		case "etat1":
			// mButBegin.setEnabled(true);
			// mButEnd.setEnabled(false);
			// mButData.setEnabled(false);
			break;
		case "etat2":
			// mButBegin.setEnabled(true);
			// mButEnd.setEnabled(false);
			// mButData.setEnabled(false);
			break;
		case "etat3":
			// mButBegin.setEnabled(true);
			// mButEnd.setEnabled(false);
			// mButData.setEnabled(false);
			break;
		case "etat4":
			// mButBegin.setEnabled(true);
			// mButEnd.setEnabled(false);
			// mButData.setEnabled(false);
			break;
		default:
			break;
		}
		writeChangeStateServeur(mCurrentState, msg);
		setImageServeur(mCurrentState);
	}

	public void setImageServeur(String state) {
		mLabelImageServeur.setIcon(mMapImageServeur.get(state));
		mLabelImageServeur.repaint();
		mIhmIA.repaint();
	}

	public void writeChangeStateServeur(String state, String msg) {

		Calendar cal = Calendar.getInstance();
		System.out.println("[Serveur :" + cal.get(Calendar.MINUTE) + "s"
				+ cal.get(Calendar.SECOND) + cal.get(Calendar.MILLISECOND)
				+ "ms] Passage à l'" + state + " " + msg + "\n");
		mJtxtAreaServeur.append("[Serveur :" + cal.get(Calendar.MINUTE) + "s"
				+ cal.get(Calendar.SECOND) + cal.get(Calendar.MILLISECOND)
				+ "ms] Passage à l'" + state + " " + msg + "\n");
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
			IA leServeur = new IA();
			Naming.bind("//localhost/IA", leServeur);
			System.out.println("Démarrage du serveur");
		} catch (Exception e) {
			System.out.println("erreur enregistrement serveur");
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void sendBegin() {
		setmCurrentStateServeur("etat2", "Human puts on begin");

	}


	@Override
	public void sendEnd() {
		setmCurrentStateServeur("etat1", "Human puts on end1");
		// System.out.println("Human puts on end0");
		// Thread worker = new Thread() {
		// public void run() {
		//
		// try {
		// Thread.sleep(2500);
		// } catch (InterruptedException ex) {
		// }
		//
		// // Report the result using invokeLater().
		// SwingUtilities.invokeLater(new Runnable() {
		// public void run() {
		// setmCurrentStateServeur("etat1", "Human puts on end1");
		// }
		// });
		// }
		// };
		//
		// worker.start();
	}



	@Override
	public void sendData() {

		setmCurrentStateServeur("etat4", "Human puts on DATA");
	}



	@Override
	public String whatCanIDo() throws RemoteException, InterruptedException {
		return chooseAway();
	}

	private String chooseAway() throws InterruptedException {
		String IaOrder = new String();
		Random r = new Random();
		int valeur;
		switch (mCurrentStateServeur) {
		case "etat1":
			IaOrder = "Serveur has no orders on (etat1)";
			System.out.println("I wait im on etat1");
			break;

		case "etat2":
			valeur = 1 + r.nextInt(4 - 1);
			switch (valeur) {
			case 1:
				IaOrder = "etat1";
				setmCurrentStateServeur("etat1", "send bgrej");

				break;
			case 2:
				IaOrder = "etat3";
				setmCurrentStateServeur("etat3", "send bgack");

				break;
			case 3:
				System.out.println("I wait (random) ");
				break;

			default:
				System.out.println("erreur random");
				break;
			}
			break;
		case "etat3":
			IaOrder = "Serveur has no orders on (etat3)";
			System.out.println("I wait");
			break;
		case "etat4":
			valeur = 1 + r.nextInt(3 - 1);
			switch (valeur) {
			case 1:
				IaOrder = "etat3";
				setmCurrentStateServeur("etat3", "send dack");
				// TODO
			case 2:
				System.out.println("I wait");
				break;

			default:
				System.out.println("erreur random");
				break;
			}

		default:
			break;
		}
		return IaOrder;
	}
}
