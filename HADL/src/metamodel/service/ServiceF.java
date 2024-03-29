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

package metamodel.service;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.RoleR;

/**
 * Classe décrivant une service requis
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Service
 */
public abstract class ServiceF extends Service {

	public ServiceF(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
//		System.out.println(this.getName() + " update");
		if (bindService == null) {
			action();
			setChanged();
			notifyObservers();
		} else {
			bindService.setPortF(portF);
			bindService.action();
			setPortR(bindService.getPortR());
			setChanged();
			notifyObservers();
		}
	}

	public abstract void action();
}
