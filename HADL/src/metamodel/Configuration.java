package metamodel;

import java.util.ArrayList;

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

	/**
	 * Fait appel au connecteur demandé par le port ayant les propriétés
	 * "propriete" et l'envoie au port
	 * 
	 * @param propriete
	 *            Les proporiétés du port appellant.
	 * @return Le connecteur associé au port qui appelle la méthode
	 */
	public Connecteur connect(Propriete propriete) {// TODO Peut être pas finie
		return findConnecteur(propriete);
	}

	// TODO à impléménter
	/**
	 * 
	 * @param propriete
	 *            Information sur le port fourni pour la connection
	 * @return Retourne le connecteur à associer au port.
	 */
	private Connecteur findConnecteur(Propriete propriete) {
		return null;
	}
}
