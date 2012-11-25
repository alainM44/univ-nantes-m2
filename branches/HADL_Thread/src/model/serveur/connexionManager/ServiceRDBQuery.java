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
package model.serveur.connexionManager;

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
public class ServiceRDBQuery extends ServiceR {

	public ServiceRDBQuery(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Demande une requete à la database
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = (ConnexionManager) getParentComposant();
		setValueInPortR(connexionManager.getRequete(), "requete");
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 *      Récupère la réponse de la requête fournie
	 */
	@Override
	public void update(Observable o, Object arg) {
		ConnexionManager connexionManager = (ConnexionManager) getParentComposant();
		connexionManager
				.setDatabaseValue((String) getValueInPortF("retourRequete"));
	}

}
