/*   This file is part of HADL_Project.

 HADL_Project is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 HADL_Project is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with HADL_Project.  If not, see <http://www.gnu.org/licenses/>
 */

package metamodel.connecteur;

import metamodel.iNterface.Interface;
import metamodel.role.RoleF;
import metamodel.role.RoleR;

/**
 * Classe décrivant l'interface d'un connecteur
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Interface
 */

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
