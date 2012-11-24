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


	private RoleR roleR;


	private RoleF roleF;


	public InterfaceConnecteur(RoleR roleR, RoleF roleF) {
		super();
		this.roleR = roleR;
		this.roleF = roleF;
	}


	public RoleR getRoleR() {
		return roleR;
	}


	public RoleF getRoleF() {
		return roleF;
	}

	

	
}
