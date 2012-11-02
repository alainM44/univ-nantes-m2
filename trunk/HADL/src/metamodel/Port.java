package metamodel;

import iMetamodel.IPort;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Port implements IPort {
	private Propriete propriete;
	private String name;

	public Port(String string) {
		this.name = string;
	}

	/**
	 * Effectue la liaison avec le connecteur et retourne un Object fourni par
	 * le service demandé
	 * 
	 * @param config
	 *            La configuration du système
	 * @param args
	 *            Les arguments du système
	 * @return Object 
	 *        Retourne un Object fourni par le service demandé
	 */
	public Object need(Configuration config, Object[] args) {
		config.connect(propriete);
		return null;// TODO Pas finie
	}

	public String getName() {
		return name;
	}

}
