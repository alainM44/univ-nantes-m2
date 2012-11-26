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
package model.serveur.dataBase;

import java.util.HashMap;

import javax.xml.crypto.Data;





import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

/**
 * Service du composant {@link DataBase} fournissant une reponse à une requête
 * de sécurité
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see ServiceF
 */
public class ServiceFSecurityManagement extends ServiceF {

	public ServiceFSecurityManagement(String name,
			HashMap<String, PortR> portR, HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Demande à la database si le client, dont le nom est fourni dans le port,
	 * peut se connecter
	 */
	@Override
	public void action() {
		DataBase dataBase = (DataBase) getParentComposant();
		boolean admis = dataBase.isAdmis((String) getValueInPortF("name"));
		setValueInPortR(admis, "isAdmis");
	}

}
