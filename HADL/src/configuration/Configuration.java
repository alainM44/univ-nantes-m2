package configuration;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Binding;

import composant.Composant;
import composant.Composite;
import composant.InterfaceComposant;

import metamodel.connecteur.Connecteur;
import metamodel.port.Port;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
import metamodel.role.Role;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import metamodel.service.Service;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         La classe Configuration tient lieu de ciment entre toutes les
 *         instances des classes du metamodèle HADL.
 * 
 * 
 *         Note sur le métamodèle en général :
 *         <p>
 *         Il est nécessaire de trouver qui est la classe "gérante" du système.
 *         Il est fortement probable que ce rôle soit attribué à la classe
 *         Configuration. Les appels de méthodes se faisant donc par son
 *         intermédaire.
 *         </p>
 */
public class Configuration extends Composant {// TODO Réfléchir ! Est ce que la
												// classe
	// configuration peut être remplacer par un fichier
	// texte ?
	private Composite composite;
	private HashMap<String, Binding> bindings;
	private HashMap<String, Composant> composants;
	private InterfaceConfig interfacesConfigsR;
	private InterfaceConfig interfacesConfigsF;
	/**
	 * @Key Nom du connecteur
	 * @Value Connecteur
	 * 
	 */
	private HashMap<String, Connecteur> connecteurs;

	/**
	 * Attachement
	 * 
	 * @Key Nom du service
	 * @Value Nom du connecteur
	 */
	private HashMap<String, String> attachements;

	/**
	 * Orientation de l'attachement entre le service et le connecteur
	 * 
	 * @Key Nom du service
	 * @Value Orientation N ou S
	 */
	private HashMap<String, String> serviceOrientation;

	public Configuration(Composite composite,
			HashMap<String, Binding> bindings,
			HashMap<String, Composant> composants,
			InterfaceConfig interfacesConfigsR,
			InterfaceConfig interfacesConfigsF,
			HashMap<String, Connecteur> connecteurs,
			HashMap<String, String> attachements,
			HashMap<String, String> serviceOrientation) {
		super();
		this.composite = composite;
		this.bindings = bindings;
		this.composants = composants;
		this.interfacesConfigsR = interfacesConfigsR;
		this.interfacesConfigsF = interfacesConfigsF;
		this.connecteurs = connecteurs;
		this.attachements = attachements;
		this.serviceOrientation = serviceOrientation;

		// on recupère tous les service d'un composant
		for (String composantName : composants.keySet()) {
			InterfaceComposant icr = composants.get(composantName).getRequis();
			InterfaceComposant icf = composants.get(composantName).getFournis();
			// Traitement des services requis
			for (String serviceName : icr.getServices().keySet()) {
				Service service = icr.getService(serviceName);
				String connecteurToAttache = attachements.get(serviceName);
				String orientation = serviceOrientation.get(serviceName);
				RoleR roler;
				RoleF rolef;
				if (orientation == "n") {
					roler = connecteurs.get(connecteurToAttache).getRoleRN();
					rolef = connecteurs.get(connecteurToAttache).getRoleFN();
				} else { // "s"
					roler = connecteurs.get(connecteurToAttache).getRoleRS();
					rolef = connecteurs.get(connecteurToAttache).getRoleFS();
				}
				service.setRoler(roler);
				service.setRolef(rolef);
				roler.setService(service);
				rolef.setService(service);

			}
			// BOUCLE A OPTIMISER pn fait la même chose avec icf
			for (String serviceName : icf.getServices().keySet()) {
				Service service = icr.getService(serviceName);
				String connecteurToAttache = attachements.get(serviceName);
				String orientation = serviceOrientation.get(serviceName);
				RoleR roler;
				RoleF rolef;
				if (orientation == "n") {
					roler = connecteurs.get(connecteurToAttache).getRoleRN();
					rolef = connecteurs.get(connecteurToAttache).getRoleFN();
				} else {// "s"
					roler = connecteurs.get(connecteurToAttache).getRoleRS();
					rolef = connecteurs.get(connecteurToAttache).getRoleFS();
				}
				service.setRoler(roler);
				service.setRolef(rolef);
				roler.setService(service);
				rolef.setService(service);
			}
		}
	}
}
