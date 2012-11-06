package metamodel.connecteur;

import metamodel.role.Role;
import iNterface.Interface;

public class InterfaceConnecteur extends Interface {

	private Connecteur connecteur;
	private Role role;

	public Connecteur getConnecteur() {
		return connecteur;
	}

	public void setConnecteur(Connecteur connecteur) {
		this.connecteur = connecteur;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
