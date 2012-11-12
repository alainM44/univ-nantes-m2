package metamodel.connecteur;

import metamodel.role.Role;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import iNterface.Interface;

public class InterfaceConnecteur extends Interface {

	private Connecteur connecteur;
	// RequisNord
	private RoleR roleRN;
	// RequisSud
	private RoleR roleRS;
	// FournisSud
	private RoleF roleFS;
	// FournisNord
	private RoleF roleFN;

	public Connecteur getConnecteur() {
		return connecteur;
	}

	public void setConnecteur(Connecteur connecteur) {
		this.connecteur = connecteur;
	}

	public RoleR getRoleRN() {
		return roleRN;
	}

	public void setRoleRN(RoleR roleRN) {
		this.roleRN = roleRN;
	}

	public RoleR getRoleRS() {
		return roleRS;
	}

	public void setRoleRS(RoleR roleRS) {
		this.roleRS = roleRS;
	}

	public RoleF getRoleFS() {
		return roleFS;
	}

	public void setRoleFS(RoleF roleFS) {
		this.roleFS = roleFS;
	}

	public RoleF getRoleFN() {
		return roleFN;
	}

	public void setRoleFN(RoleF roleFN) {
		this.roleFN = roleFN;
	}

}
