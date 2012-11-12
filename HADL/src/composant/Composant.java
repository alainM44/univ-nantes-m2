package composant;

import java.util.AbstractList;
import java.util.HashMap;

import metamodel.propiete.Propriete;
import metamodel.service.Service;
import metamodel.service.ServiceF;
import metamodel.service.ServiceR;

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
	private InterfaceComposant fourni;
	public InterfaceComposant getRequis() {
		return requis;
	}
	public void setRequis(InterfaceComposant requis) {
		this.requis = requis;
	}
	public InterfaceComposant getFournis() {
		return fourni;
	}
	public void setFournis(InterfaceComposant fournis) {
		this.fourni = fournis;
	}

	


}
