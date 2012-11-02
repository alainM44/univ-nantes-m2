package metamodel;

import iMetamodel.IPort;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         ATTENTION : Il est possible que la classe Service vienne à être
 *         supprimer ou bien que son "rôle" intrasèque soit modifié au cours du
 *         développement.
 *         <p>
 *         Penser à modifier le diagramme du métamodèle en cas de modification.
 *         </p>
 * 
 */
public class Service implements IPort {

	private String name;

	public Service(String string) {
		// TODO Auto-generated constructor stub
		name = string;
	}

}
