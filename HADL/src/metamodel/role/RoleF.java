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
import java.util.Observer;

/**
 * Classe décrivant un role fournis
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Role
 */
public class RoleF extends Role implements Observer {

	private String name;

	public RoleF(String name) {
		super(name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		getService().notifyAll();
	}

	
}
