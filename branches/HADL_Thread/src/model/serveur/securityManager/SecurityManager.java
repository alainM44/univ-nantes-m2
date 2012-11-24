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
package model.serveur.securityManager;

import java.util.HashMap;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.propiete.Propriete;

/**
 * @author Romain RINCÉ
 * @author Alain MARGUERITE
 *
 */
public class SecurityManager extends Composant {

	private String toIdentify;
	private boolean isIdentify;
	
	/**
	 * @param requis
	 * @param fourni
	 * @param proprietes
	 */
	public SecurityManager(String name, InterfaceComposant requis,
			InterfaceComposant fourni, HashMap<String, Propriete> proprietes) {
		super(name, requis, fourni, proprietes);
toIdentify = null;
setIdentify(false);
	}

	/**
	 * @return the toIdentify
	 */
	public String getToIdentify() {
		return toIdentify;
	}

	/**
	 * @param toIdentify the toIdentify to set
	 */
	public void setToIdentify(String toIdentify) {
		this.toIdentify = toIdentify;
	}

	/**
	 * @return the isIdentify
	 */
	public boolean isIdentify() {
		return isIdentify;
	}

	/**
	 * @param isIdentify the isIdentify to set
	 */
	public void setIdentify(boolean isIdentify) {
		this.isIdentify = isIdentify;
	}

}
