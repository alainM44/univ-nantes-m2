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

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 *
 */
public class ServiceFExternalSocket extends ServiceF {

	public ServiceFExternalSocket(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * 
	 * @see metamodel.service.ServiceF#action()
	 * 
	 *      S'identifie en fournissant le nom du client au SecurityManager
	 * 
	 *      Si l'identification fonctionne, on demande une valeur dans la
	 *      database
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		connexionManager.setClientName((String) getValueInPortF("name"));
		connexionManager.setRequete((String) getValueInPortF("requete"));

		if ((connexionManager.clientsAuthenticated.get(connexionManager
				.getClientName()) == null)
				&& connexionManager.getRequete() == null) // demande de
															// connexion
		{
	
			callService("ServiceRSecurityAuth");
			connexionManager.clientsAuthenticated.put(
					connexionManager.getClientName(),
					connexionManager.isAutentified());

			if (connexionManager.clientsAuthenticated.get(connexionManager
					.getClientName()))
				setValueInPortR("Vous êtes autorisé à effectuer des reqêtes ",
						"retourRequete");
			else
				setValueInPortR(
						"Vous n'est pas autorisé à effectuer des requetes",
						"retourRequete");

		} else if (((String) getValueInPortF("requete") != null)
				&& (String) getValueInPortF("name") != null) {

			// request
			if (!connexionManager.clientsAuthenticated.get(connexionManager
					.getClientName())) {
				setValueInPortR(
						"Vous n'est pas autorisé à effectuer des requetes",
						"retourRequete");
			} else {
				connexionManager
						.setRequete((String) getValueInPortF("requete"));
				callService("ServiceRDBQuery");

				setValueInPortR(connexionManager.getDatabaseValue(),
						"retourRequete");
			}
		} else {
			System.err
					.println("erreur dans le passage des paramètres de la requête");
			System.exit(0);
		}

		// On remet tout les paramètres dans leur état initial
		connexionManager.setClientName(null);
		connexionManager.setAutentified(false);
		connexionManager.setDatabaseValue(null);
		connexionManager.setRequete(null);
		setValueInPortF(null, "name");
		setValueInPortF(null, "requete");
	}
}
