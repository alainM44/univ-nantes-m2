package metamodel.connecteur;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.Role;
import metamodel.role.RoleF;
import metamodel.role.RoleR;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public abstract class Glu extends Observable implements Observer {

	private RoleR roleR;
	private RoleF roleF;

	public PortR getPortR(String name){
		return roleR.getService().getPortR(name);
	}
	public PortF getPortF(String name){
		return roleF.getService().getPortF(name);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		execute();
	}

	public Glu(RoleR roleR, RoleF roleF) {
		super();
		this.roleR = roleR;
		this.roleF = roleF;
	}

	/**
	 * ; Action de la glue
	 */
	public abstract void action();

	public void execute() {
		action();
		notifyObservers(roleF);
	}

}
