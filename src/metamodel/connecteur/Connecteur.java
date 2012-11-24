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

package metamodel.connecteur;

import java.util.HashMap;

/**
 * Classe décrivant un connecteur (pattern composite)
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see InterfaceConnecteur
 */
public class Connecteur// extends InterfaceConnecteur
// TODO Probleme connecteur ne doit pas etendre InterfaceConnecteur
{
	private String name;
	private InterfaceConnecteur irequise;
	private InterfaceConnecteur ifournie;

	public Connecteur(String name,InterfaceConnecteur irequise, InterfaceConnecteur ifournie) {
		super();
		this.name = name;
		this.irequise = irequise;
		this.ifournie = ifournie;
	}

	public InterfaceConnecteur getIrequise() {
		return irequise;
	}

	public InterfaceConnecteur getIfournie() {
		return ifournie;
	}

	public String getName() {
		return name;
	}

	
}
