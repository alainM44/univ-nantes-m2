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
 *Classe décrivant la configuration main 
 *
 * @author alain MARGUERITE
 * @author romain RINCÉ 
 *
 */

package model.client.configurationMain;

import java.util.HashMap;

import metamodel.composant.Composant;
import metamodel.configuration.Configuration;
import metamodel.configuration.Couple;
import metamodel.configuration.InterfaceConfig;
import metamodel.connecteur.Connecteur;
import metamodel.propiete.Propriete;

/**
 *Classe décrivant la configuration main 
 *
 * @author alain MARGUERITE
 * @author romain RINCÉ 
 *
 */
public class ConfigurationMain extends Configuration {

	/**
	 * @param name
	 * @param bindings
	 * @param composants
	 * @param interfacesConfigsR
	 * @param interfacesConfigsF
	 * @param connecteurs
	 * @param attachements
	 * @param proprietes
	 */
	public ConfigurationMain(String name, HashMap<String, Couple> bindings,
			HashMap<String, Composant> composants,
			InterfaceConfig interfacesConfigsR,
			InterfaceConfig interfacesConfigsF,
			HashMap<String, Connecteur> connecteurs,
			HashMap<String, String> attachements,
			HashMap<String, Propriete> proprietes) {
		super(name, bindings, composants, interfacesConfigsR, interfacesConfigsF,
				connecteurs, attachements, proprietes);
		// TODO Auto-generated constructor stub
	}

}
