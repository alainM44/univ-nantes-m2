package metamodel;

import java.util.AbstractList;
import metamodel.propiete.Propriete;
import metamodel.service.Service;

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
	private InterfaceComposant requis;
	private InterfaceComposant fournis;

	

	public Service getServiceR(String name){
		return requis.services.get(name);
	}
	public Service getServiceF(String name){
		return fournis.services.get(name);
	}
}
