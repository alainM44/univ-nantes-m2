package metamodel;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.connecteur.Connecteur;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;

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
public class Configuration {// TODO Réfléchir ! Est ce que la classe
							// configuration peut être remplacer par un fichier
							// texte ?
	private Composite composite;
	private ArrayList<Binding> bindings;
	private ArrayList<Connecteur> connecteurs;


	public Connecteur attachement( ) {
		
		return null;
	}

	// TODO à impléménter
	/**
	 * µ
	 * 
	 * @return Retourne le connecteur à associer au port.
	 */
	private Connecteur findConnecteur() {
		return null;
	}
}
