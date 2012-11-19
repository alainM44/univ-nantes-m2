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

import metamodel.connecteur.Glu;
import metamodel.service.Service;

/**
 * Classe décrivant un role
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Observable
 */
public class Role extends Observable implements Observer{

	private String name;
	private Glu glu;
	private Service service;

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Glu getGlu() {
		return glu;
	}

	public void setGlu(Glu glu) {
		this.glu = glu;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
