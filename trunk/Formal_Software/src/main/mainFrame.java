package main;
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe décrivant une IHM permettant de simuler un automate
 * @see JFrame
 */
@SuppressWarnings("serial")
public class mainFrame extends JFrame {

	private HashMap<String, ImageIcon> mMapImage; // recueil des différentes
													// images
	private String mCurrentState; // décrit l'état courant
	private JLabel mLabelImage;
	private JTextArea mJtxtArea;
	private JButton mButSwap;
	private JButton mButQuit;

	/**
	 * Constructeur principal
	 */
	public mainFrame() {
		// //////////////////////////////////////////// general parameters
		super();
		setTitle("Formal Software project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));
		// /////////////////////////////////////////////////////////////////////////////
		// north area
		mMapImage = new HashMap<String, ImageIcon>();
		mMapImage.put("etat1", new ImageIcon(
				"/home/alain/workspace/Formal_Software/Automate1.png"));
		mMapImage.put("etat2", new ImageIcon(
				"/home/alain/workspace/Formal_Software/Automate2.png"));
		mMapImage.put("etat3", new ImageIcon(
				"/home/alain/workspace/Formal_Software/Automate3.png"));
		mMapImage.put("etat4", new ImageIcon(
				"/home/alain/workspace/Formal_Software/Automate4.png"));
		mCurrentState = new String("etat1");
		mLabelImage = new JLabel(mMapImage.get("etat1"), SwingConstants.CENTER);
		add(mLabelImage, BorderLayout.NORTH);
		// ///////////////////////////////////////////////////////center area
		mJtxtArea = new JTextArea("Begin" + "\n");
		mJtxtArea
				.setBorder(BorderFactory.createLineBorder(Color.lightGray, 20));
		add(mJtxtArea, BorderLayout.CENTER);
		// //////////////////////////////////////////////////// south area
		Box southBox = Box.createHorizontalBox();
		mButSwap = new JButton("SWAP");
		mButSwap.addActionListener(new SwapButtonHandler());
		southBox.add(mButSwap);
		southBox.add(Box.createHorizontalGlue());
		mButQuit = new JButton("QUIT");
		mButQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent().getParent();
				f.dispose();
			}
		});
		southBox.add(mButQuit);
		add(southBox, BorderLayout.SOUTH);
		// /////////////////////////////////////////////////////////////////////////////////
		// end south area
		setVisible(true);
		pack();
	}

	/**
	 * 
	 * @author alain
	 * @author Romain RINCÉ
	 * 
	 *         Classe décrivant les actions à effectuer lors d'un clique bouton
	 * @see ActionListener
	 */
	public class SwapButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			mainFrame f = (mainFrame) source.getParent().getParent()
					.getParent().getParent().getParent();

			// TODO ALGO DE LAUTOMATE
			// System.out.println(source.getParent().toString());
			if (mCurrentState.equals("etat1")) {
				f.setImage("etat2");
				f.setmCurrentState("etat2");
			} else if (mCurrentState.equals("etat2")) {
				f.setImage("etat3");
				f.setmCurrentState("etat3");
			} else if (mCurrentState.equals("etat3")) {
				f.setImage("etat4");
				f.setmCurrentState("etat4");
			} else if (mCurrentState.equals("etat4")) {
				f.setImage("etat1");
				f.setmCurrentState("etat1");
			}
			writeChangeState(mCurrentState);
		}

	}

	public void setImage(String state) {
		mLabelImage.setIcon(mMapImage.get(state));
		repaint();
	}

	public void writeChangeState(String state) {
		mJtxtArea.append("Passage à l'" + state + "\n");
	}

	public void setmCurrentState(String mCurrentState) {
		this.mCurrentState = mCurrentState;
	}

	public static void main(String[] args) {
		mainFrame m = new mainFrame();
	}

}
