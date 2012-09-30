package metamodel;

import iMetamodel.IPort;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Port implements IPort {
	private Propriete propriete;

	/**
	 * Effectue la liaison avec le connecteur et retourne un Object fourni par
	 * le service demandé
	 * 
	 * @param config
	 *            La configuration du système
	 * @param args
	 *            Les arguments du système
	 * @return Retourne un Object fourni par le service demandé
	 */
	public Object need(Configuration config, Object[] args) {
		config.connect(propriete);
		return null;// TODO Pas finie
	}

}
