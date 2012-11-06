package configuration;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Binding;

import composant.Composant;
import composant.Composite;

import metamodel.connecteur.Connecteur;
import metamodel.port.Port;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
import metamodel.role.Role;
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
public class Configuration  extends Composant{// TODO Réfléchir ! Est ce que la classe
							// configuration peut être remplacer par un fichier
							// texte ?
	private Composite composite;
	private HashMap<String, Binding> bindings;
	private HashMap<String, Composant> composants;
	private InterfaceConfig interfacesConfigsR;
	private InterfaceConfig interfacesConfigsF;
	private HashMap<String, Connecteur> connecteurs;


	/**
	 * Attache un port avec un rôle en utilisant son service associé
	 * 
	 * @param service
	 *            Service associé au port à attacher
	 *            
	 * @return
	 */
	public void attachement(Service service, Port port) {
		//TODO
//		Port portaAttacher =service.getPortF(port.getName());
//		Role roleaAttacher =	roles.get("LeRoleAAttacher");		//comment on connait le role quil faut ?

//		roleaAttacher.setPort(portaAttacher);
//		portaAttacher.setRole(roleaAttacher);	
	}

	/**
	 * 
	 * 
	 * @return Retourne le connecteur à associer au port.
	 */
	private Connecteur findConnecteur() {
		return null;
	}
}
