package metamodel.connecteur;

import java.util.AbstractList;
import java.util.HashMap;

import metamodel.role.Role;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Connecteur {

	private HashMap<String, InterfaceConnecteur> interfacesConnecteurs;
	private Role role;
	private AbstractList<Glu> glus;
}
