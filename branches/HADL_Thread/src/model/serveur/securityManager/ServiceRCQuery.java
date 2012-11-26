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
package model.serveur.securityManager;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 */
public class ServiceRCQuery extends ServiceR {

	public ServiceRCQuery(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Envoie le nom du client à identifié à la database
	 */
	@Override
	public void action() {
		SecurityManager manager = (SecurityManager) getParentComposant();
		setValueInPortR(manager.getToIdentify(), "name");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 *      Recupère le retour d'identification de la database : true ou false
	 */
	@Override
	public void update(Observable o, Object arg) {
		SecurityManager manager = (SecurityManager) getParentComposant();
		manager.setIdentify((Boolean) getValueInPortF("isAdmis"));

	}

}
