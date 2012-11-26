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

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

/**
 * Service du composant {@link DataBase} permettant de fournir une donné suite à
 * une reqête SQL.
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see ServiceF
 */
public class ServiceFExecuteSQL extends ServiceF {

	public ServiceFExecuteSQL(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Renvoi la valeur dans la database pour la requete donnée
	 */
	@Override
	public void action() {
		DataBase dataBase = (DataBase) getParentComposant();
		String requete = (String) getValueInPortF("requete");
		setValueInPortR(dataBase.getValueInDatabase(requete), "retourRequete");
	}

}
