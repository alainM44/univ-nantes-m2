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

package metamodel.configuration;

import java.util.HashMap;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.connecteur.Connecteur;
import metamodel.propiete.Propriete;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import metamodel.service.Service;

/**
 * Classe décrivant une configuration
 * 
 * <p>
 * La classe Configuration tient lieu de ciment entre toutes les instances des
 * classes du metamodèle HADL.
 * </p>
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Composant
 * 
 */

public class Configuration extends Composant {
	private InterfaceConfig interfacesConfigsR;
	private InterfaceConfig interfacesConfigsF;

	private HashMap<String, Couple> bindings;
	/**
	 * Regroupe les composants de la configurations
	 * 
	 * @Key Nom du composant
	 * @Value Composant associé
	 * 
	 */
	private HashMap<String, Composant> composants;
	/**
	 * Regroupe les connecteurs de la configurations
	 * 
	 * @Key Nom du connecteur
	 * @Value Connecteur associé
	 * 
	 */
	private HashMap<String, Connecteur> connecteurs;

	/**
	 * Regroupe les Attachements associés à la configuration
	 * 
	 * @Key Nom du service
	 * @Value Nom du connecteur
	 */
	private HashMap<String, String> attachements;


	public Configuration(HashMap<String, Couple> bindings,
			HashMap<String, Composant> composants,
			InterfaceConfig interfacesConfigsR,
			InterfaceConfig interfacesConfigsF,
			HashMap<String, Connecteur> connecteurs,
			HashMap<String, String> attachements,
			HashMap<String, Propriete> proprietes) {
		super(interfacesConfigsR, interfacesConfigsF, proprietes);
		this.bindings = bindings;
		this.composants = composants;
		this.interfacesConfigsR = interfacesConfigsR;
		this.interfacesConfigsF = interfacesConfigsF;
		this.connecteurs = connecteurs;
		this.attachements = attachements;

		// on recupère tous les service d'un composant
		for (String composantName : composants.keySet()) {
			InterfaceComposant icr = composants.get(composantName).getRequis();
			InterfaceComposant icf = composants.get(composantName).getFourni();
			// Traitement des services requis
			for (String serviceName : icr.getServices().keySet()) {
				Service service = icr.getService(serviceName);
				String connecteurToAttache = attachements.get(serviceName);
				RoleR roler;
				RoleF rolef;
				roler = connecteurs.get(connecteurToAttache).getIrequise()
						.getRoleR();
				rolef = connecteurs.get(connecteurToAttache).getIrequise()
						.getRoleF();
				service.setRoler(roler);
				service.setRolef(rolef);
				roler.setService(service);
				rolef.setService(service);

				if (bindings.containsKey(serviceName)) {
					Couple couple = bindings.get(serviceName);
					Composant composant = composants.get(couple.getComposant());
					Service bindservice;
					if (couple.getFouR() == "f") {
						bindservice = composant.getFourni().getService(
								couple.getName());
					} else {
						bindservice = composant.getRequis().getService(
								couple.getName());
					}
					service.setBindService(bindservice);
					bindservice.setBindService(service);
				}
			}
			// BOUCLE A OPTIMISER pn fait la même chose avec icf
			for (String serviceName : icf.getServices().keySet()) {
				Service service = icr.getService(serviceName);
				String connecteurToAttache = attachements.get(serviceName);
				RoleR roler;
				RoleF rolef;
				roler = connecteurs.get(connecteurToAttache).getIfournie()
						.getRoleR();
				rolef = connecteurs.get(connecteurToAttache).getIfournie()
						.getRoleF();
				service.setRoler(roler);
				service.setRolef(rolef);
				roler.setService(service);
				rolef.setService(service);

				if (bindings.containsKey(serviceName)) {
					Couple couple = bindings.get(serviceName);
					Composant composant = composants.get(couple.getComposant());
					Service bindservice;
					if (couple.getFouR() == "f") {
						bindservice = composant.getFourni().getService(
								couple.getName());
					} else {
						bindservice = composant.getRequis().getService(
								couple.getName());
					}
					service.setBindService(bindservice);
					bindservice.setBindService(service);
				}
			}
		}
	}
}
