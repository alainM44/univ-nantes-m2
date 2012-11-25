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
package model.client;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see ServiceR
 */
public class ServiceRConnexionRPC extends metamodel.service.ServiceR {

	public ServiceRConnexionRPC(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Alain modif : uncomment to undo changes
	 * 
	 * Lance une demande de connexion en tant qu'administrateur au serveur
	 */
	@Override
	public void action() {
		// setValueInPortR("Admin", "name");
		// setValueInPortR("reponse?", "requete");

	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 *      Affiche le retour du serveur : Un affichage
	 *      "Echec de la connexion à la database" est considéré comme un echec
	 *      d'identification (La dataBase ne reconnait pas le client)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("[Reponse du serveur] : \n\t\t "
				+ getValueInPortF("retourRequete"));

	}

	// / Alain ajout Begin////////////
	/**
	 * Demande de connexion à la configuration server.
	 * 
	 * @param string
	 */
	public void connexion(String name) {
		setValueInPortR(name, "name");
		setValueInPortR(null, "requete");
		execute();
	}

	/**
	 * Demande de connexion à la configuration server.
	 * 
	 * @param string
	 * @param string2
	 */
	public void requete(String name, String requete) {
		setValueInPortR(name, "name");
		setValueInPortR(requete, "requete");
		execute();
	}

	// / Alain ajout FIN////////////

}
