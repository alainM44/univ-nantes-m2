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

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 *
 */
public class ServiceFSASM extends ServiceF {

	public ServiceFSASM(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le service ServiceFSASM doit déterminer si le client, dont le nom est
	 * fourni dans le port, peut s'identifier à la database en faisant appelle
	 * au service ServiceRCQuery
	 */
	@Override
	public void action() {
		SecurityManager manager = (SecurityManager) getParentComposant();
		String name = (String) getValueInPortF("name");
		manager.setToIdentify(name);
		callService("ServiceRCQuery");
		setValueInPortR(manager.isIdentify(), "isAdmis");
		//On remet tout les paramètres dans leur état initial
		manager.setIdentify(false);
		manager.setToIdentify(null);

	}

}
