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
package human;

import ia.IA;
import ia.IIA;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.HashMap;
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

;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant un client du forum. Il sert uniquement à orienter un
 *         client sur un SujetDiscussion.
 * 
 */
@SuppressWarnings("serial")
public class Human extends JFrame {

	// private enum {etat1;et
	private HashMap<String, ImageIcon> mMapImageClient; // recueil des
														// différente
	// imagesent
	private String mCurrentStateClient = new String(); // décrit l'état courant
	private JLabel mLabelImageClient;
	private JTextArea mJtxtAreaClient;
	private JScrollPane mJPanel;
	private JFrame mIhmClient;
	private JButton mButBegin;
	private JButton mButData;
	private JButton mButEnd;
	private JButton mButQuit;
	private static IIA ia;

	/**
	 * 
	 * 
	 * @author Alain MARGUERITE
	 * @author Romain RINCÉ
	 * 
	 */

	// Création d'une variable locale permettant d'interoger le server

	public Human() throws RemoteException {
		construireIHM();
	}

	public void construireIHM() {
		// //////////////////////////////////////////// general parameters
		mIhmClient = new JFrame("Formal Software project (Human)");
		mIhmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mIhmClient.setLayout(new BorderLayout());

		mIhmClient.setPreferredSize(new Dimension(600, 570));
		// ///////////////////////////////////////////////////////center area

		mMapImageClient = new HashMap<String, ImageIcon>();
		mMapImageClient.put("etat1", new ImageIcon(
				"/home/alain/workspace/Formal_Software/img/Automate1.png"));
		mMapImageClient.put("etat2", new ImageIcon(
				"/home/alain/workspace/Formal_Software/img/Automate2.png"));
		mMapImageClient.put("etat3", new ImageIcon(
				"/home/alain/workspace/Formal_Software/img/Automate3.png"));
		mMapImageClient.put("etat4", new ImageIcon(
				"/home/alain/workspace/Formal_Software/img/Automate4.png"));
		mCurrentStateClient = new String("etat1");
		mLabelImageClient = new JLabel(mMapImageClient.get("etat1"),
				SwingConstants.CENTER);
		mLabelImageClient.setBorder(BorderFactory.createLineBorder(
				Color.lightGray, 26));

		mIhmClient.add(mLabelImageClient, BorderLayout.NORTH);
		// /////////////////////////////////////////////////////////: center area
		mJtxtAreaClient = new JTextArea("Client connecté au serveur : "+"\n");
		mJtxtAreaClient.setLineWrap(true);
		mJPanel = new JScrollPane(mJtxtAreaClient);
		mJPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mIhmClient.add(mJPanel, BorderLayout.CENTER);
		// ///////////////////////////////////////////////////////south area
		mButBegin = new JButton("Begin");
		mButBegin.addActionListener(new ButtonBeginHandler());
		mButData = new JButton("Data");
		mButData.addActionListener(new ButtonDataHandler());
		mButEnd = new JButton("End");
		mButEnd.addActionListener(new ButtonEndHandler());
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
		mButData.setEnabled(false);
		mButEnd.setEnabled(false);

		southBox.add(mButBegin);
		southBox.add(mButData);
		southBox.add(mButEnd);
		southBox.add(mButQuit);
		southBox.add(Box.createHorizontalGlue());
		mIhmClient.add(southBox, BorderLayout.SOUTH);
		// /////////////////////////////////////////////////////////////////////////////////
		// end south area
		mIhmClient.setVisible(true);
		mIhmClient.pack();
	}

	public void setmCurrentStateClient(String mCurrentState, String msg) {
		this.mCurrentStateClient = mCurrentState;
		switch (mCurrentStateClient) {
		case "etat1":
			mButBegin.setEnabled(true);
			mButEnd.setEnabled(false);
			mButData.setEnabled(false);
			break;
		case "etat2":
			mButBegin.setEnabled(false);

			break;
		case "etat3":
			break;
		case "etat4":
			mButBegin.setEnabled(false);
			mButEnd.setEnabled(false);
			mButData.setEnabled(false);
			break;
		default:
			break;
		}
		writeChangeStateClient(mCurrentState, msg);
		setImageClient(mCurrentState);
	}

	public void setImageClient(String state) {
		mLabelImageClient.setIcon(mMapImageClient.get(state));
		mLabelImageClient.repaint();
		mIhmClient.repaint();
	}

	public void writeChangeStateClient(String state, String msg) {
		Calendar cal = Calendar.getInstance();
		mJtxtAreaClient.append("[Client :" + cal.get(Calendar.MINUTE) + "m"
				+ cal.get(Calendar.SECOND) + "s"
				+ cal.get(Calendar.MILLISECOND) + "ms] Passage à l'" + state
				+ " " + msg + "\n");

		System.out.println("[Client :" + cal.get(Calendar.MINUTE) + "m"
				+ cal.get(Calendar.SECOND) + "s"
				+ cal.get(Calendar.MILLISECOND) + "ms] Passage à l'" + state
				+ " " + msg + "\n");
	}

	public void waitAndSee() throws InterruptedException {
		Thread worker = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
				}

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {

						String whatCanIdoo = new String();
						try {
							whatCanIdoo = ia.whatCanIDo();
							System.out.println("what can i do" + whatCanIdoo);
						} catch (RemoteException | InterruptedException e) {
							e.printStackTrace();
						}
						switch (mCurrentStateClient) {
						case "etat1":
							switch (whatCanIdoo) {
							case "etat2":
								setmCurrentStateClient("etat1", "IA send bgrej");
								mButBegin.setEnabled(true);
								break;
							}
							break;
						case "etat2":
							switch (whatCanIdoo) {
							case "etat1":
								setmCurrentStateClient("etat1", "IA send bgrej");
								mButBegin.setEnabled(true);
								break;
							case "etat3":
								setmCurrentStateClient("etat3",
										"IA send !bgack");
								mButData.setEnabled(true);
								mButBegin.setEnabled(false);
								mButEnd.setEnabled(true);
								break;

							default:
								System.out.println("wait...");
								try {
									waitAndSee();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								break;
							}
							break;
						case "etat3":
							break;
						case "etat4":
							switch (whatCanIdoo) {
							case "etat3":
								setmCurrentStateClient("etat3", "IA send dack");
								mButData.setEnabled(true);
								mButEnd.setEnabled(true);
								break;
							default:
								System.out.println("wait...");
								try {
									waitAndSee();
								} catch (InterruptedException e) {

									e.printStackTrace();
								}
								break;
							}
							break;
						default:
							System.out.println("ERROR DEFAUT wait..."
									+ mCurrentStateClient);
							try {
								waitAndSee();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							break;
						}

					}
				});
			}
		};

		worker.start(); 
	}

	public static void main(String[] argv) throws RemoteException {

		System.setProperty("java.security.policy", "file:./no.policy");
		try {
			Human.ia = (IIA) Naming.lookup("//localhost/IA");
			System.out.println("Connecté au serveur");
		} catch (Exception e) {
			System.out.println("ClientForum.java erreur nommage serveur");
			e.printStackTrace();
			return;
		}

		Human human = new Human();

	}
	public class ButtonEndHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setmCurrentStateClient("etat1", "human press on end button ");
			mButData.setEnabled(false);
			mButBegin.setEnabled(true);
			mButEnd.setEnabled(true);

			try {
				ia.sendEnd();
			} catch (RemoteException e2) {
				e2.printStackTrace();
			}
			try {
				waitAndSee();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}
	public class ButtonBeginHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setmCurrentStateClient("etat2", "human press on begin button ");

			try {
				ia.sendBegin();
				// System.out.println("send begin");
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				waitAndSee();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public class ButtonDataHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setmCurrentStateClient("etat4", "human press on data button ");

			try {
				ia.sendData();
				// System.out.println("send begin");
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				waitAndSee();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
