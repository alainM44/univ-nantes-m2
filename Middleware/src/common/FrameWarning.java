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

package common;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Fenêtre pop up indiquant à l'utilisateur qu'il est déjà connecté.
 *         \\TODO IHM to improve
 * @see JFrame
 */
@SuppressWarnings("serial")
public class FrameWarning extends JFrame {
	public FrameWarning() {

		setTitle("Attention!");
		setLayout(new BorderLayout());
		add(new JLabel("Vous avec déjà ouvert cette discussion"),
				BorderLayout.CENTER);
		JButton ButOK = new JButton("OK");
		ButOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				JFrame f = (JFrame) source.getParent().getParent().getParent()
						.getParent();
				f.dispose();

			}
		});
		add(ButOK, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
}
