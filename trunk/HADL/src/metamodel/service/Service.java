package metamodel.service;

import java.util.HashMap;

import configuration.Configuration;

import metamodel.port.Port;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.RoleF;
import metamodel.role.RoleR;

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

	private RoleR roler;
	private RoleF rolef;
	
	public Service(String string) {
		name = string;
	}	

	public PortR getPortR(String name) {
		return portR.get(name);
	}

	public PortF getPortF(String name) {
		return portF.get(name);
	}

	
	

	public Object getName() {

		return name;
	}

	public RoleR getRoler() {
		return roler;
	}

	public void setRoler(RoleR roler) {
		this.roler = roler;
	}

	public RoleF getRolef() {
		return rolef;
	}

	public void setRolef(RoleF rolef) {
		this.rolef = rolef;
	}



}
