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
package metamodel.role;

import java.util.Observable;

/**
 * Classe décrivant un role requis
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Role
 */
public class RoleR extends Role {

	private String name;

	public RoleR(String name) {
		super(name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	// est notifié par le Service R et on notifie la glue
	@Override 
	public void update(Observable o, Object arg) {
//		System.out.println("Roler");
		setChanged();
		notifyObservers();
	}
}
