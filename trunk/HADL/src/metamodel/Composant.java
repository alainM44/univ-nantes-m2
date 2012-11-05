package metamodel;

import java.util.AbstractList;

import metamodel.port.Port;
import metamodel.propiete.Propriete;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Note sur le métamodèle en général :
 *         <p>
 *         Il est nécessaire de trouver qui est la classe "gérante" du système.
 *         Il est fortement probable que ce rôle soit attribué à la classe
 *         Configuration. Les appels de méthodes se faisant donc par son
 *         intermédaire.
 *         </p>
 */
public class Composant {
	private Interface requis;
	private Interface fournis;
	private AbstractList<Propriete> proprietes;
	
	/**
	 * La méthode à besoin des services d'un autre composant.
	 * 
	 * @param config Configuration du systeme
	 * @param port Port demandant la requête
	 * @param args Les arguments nécessaire pour se voir offrir le service
	 * @return Retourne le resultat du service demandé
	 */
	public Object need(Configuration config, Port port, Object args[]){
		return port.need(config, args);//Peut-être pas finie

	}
}
