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
/**
 * 
 */
package model.serveur.configurationServer;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.Service;
import metamodel.service.ServiceF;

/**
 * 
 * 
 */
public class ServiceInterfaceConfig extends ServiceF {

	/**
	 * @param name
	 * @param portR
	 * @param portF
	 */
	public ServiceInterfaceConfig(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see metamodel.service.ServiceF#action()
	 */
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}




}
