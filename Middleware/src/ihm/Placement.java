package ihm;

import java.awt.*;

import javax.swing.BoxLayout;

public class Placement {

	// static GridBagLayout placeur= new GridBagLayout();
	static GridBagConstraints c = new GridBagConstraints();

	// procedure generale de positionnement
	// -------------------------------------
	public static void p(Container cont, Component comp, int x, int y, int w,
			int h, int pos, int t, int l, int b, int r, double wx, double wy,
			int fill) {

		// cont.setLayout(placeur);

		cont.setLayout(new BoxLayout(cont, BoxLayout.PAGE_AXIS));
		c.gridx = x;
		c.gridy = y; // position (en nbre de cellules) du coin nord-est
		c.gridwidth = w;
		c.gridheight = h; // largeur et hauteur (en nbre de cellules)
		c.fill = fill; // directions d'expansion : NONE, BOTH, HORIZONTAL,
						// VERTICAL
		c.anchor = pos; // position du composant dans ses cellules :
						// CENTER, EAST,NORTHEAST, NORTH, NORTHWEST,
						// WEST, SOUTHWEST, SOUTH, SOUTHEAST ...
		c.weightx = wx;
		c.weighty = wy; // ponderation de la distribution de l'espace
						// supplementaire en cas d'agrandissement
		c.insets = new Insets(t, l, b, r); // marges en pixels
		// placeur.setConstraints(comp, c);
		cont.add(comp);
	};

	// placement d'un composant qui ne grossit pas
	// --------------------------------------------
	public static void p(Container cont, Component comp, int x, int y, int w,
			int h, int pos, int t, int l, int b, int r) {
		p(cont, comp, x, y, w, h, pos, t, l, b, r, 0.0, 0.0,
				GridBagConstraints.NONE);
	};

	// positionnement d'un composant sans marges qui ne grossit pas
	// -------------------------------------------------------------
	public static void p(Container cont, Component comp, int x, int y, int w,
			int h, int pos) {
		p(cont, comp, x, y, w, h, pos, 0, 0, 0, 0, 1.0, 1.0,
				GridBagConstraints.NONE);
	};

	// positionnement au centre d'un composant sans marges qui ne grossit pas
	// -----------------------------------------------------------------------
	public static void p(Container cont, Component comp, int x, int y, int w,
			int h) {
		p(cont, comp, x, y, w, h, GridBagConstraints.CENTER, 0, 0, 0, 0, 1.0,
				1.0, GridBagConstraints.NONE);
	};
}