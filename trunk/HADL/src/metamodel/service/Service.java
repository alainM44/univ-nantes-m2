package metamodel.service;

import java.util.HashMap;

import configuration.Configuration;

import metamodel.port.Port;
import metamodel.port.PortF;
import metamodel.port.PortR;

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

public abstract class Service {

	private String name;
	private Configuration config;
	private HashMap<String, PortR> portR;
	private HashMap<String, PortF> portF;

	public Service(String string) {
		name = string;
	}

	public PortR getPortR(String name) {
		return portR.get(name);
	}

	public PortF getPortF(String name) {
		return portF.get(name);
	}

	/**
	 * Attache un port à un rôle, c'est la configuration du Service qui prend en
	 * charge cette liaison.
	 * 
	 * @param port
	 *            Port à attacher
	 */
	public void attache() {

		config.attachement(this);

	}

}
