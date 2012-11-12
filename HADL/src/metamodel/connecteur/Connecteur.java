package metamodel.connecteur;

import java.util.AbstractList;
import java.util.HashMap;

import metamodel.role.Role;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Connecteur extends InterfaceConnecteur {

	private HashMap<String, InterfaceConnecteur> interfacesConnecteurs;
	//private HashMap<String, InterfaceConnecteur>  roles;
	private Glu gluNS;
	private Glu gluSN;
}
