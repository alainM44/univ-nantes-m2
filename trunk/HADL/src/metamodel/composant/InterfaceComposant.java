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

package metamodel.composant;



import java.util.HashMap;

import metamodel.iNterface.Interface;
import metamodel.service.Service;

/**
 * Classe interface du composant appartenant au pattern composite
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Interface
 */
public class InterfaceComposant extends Interface {

	public HashMap<String, Service> services = new HashMap<String, Service>();

	
	public InterfaceComposant(HashMap<String, Service> services) {
		super();
		this.services = services;
	}

	public InterfaceComposant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addService(Service service){
		services.put(service.getName(),service);
	}
	public HashMap<String, Service> getServices() {
		return services;
	}

	public void setServices(HashMap<String, Service> services) {
		this.services = services;
	}

	public Service getService(String name) {
		return services.get(name);
	}

}
