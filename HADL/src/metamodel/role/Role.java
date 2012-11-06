package metamodel.role;

import metamodel.connecteur.Glu;
import metamodel.port.Port;


/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Role {

	private String name;
	private Glu glu;
	private Port port;
	
	
	public Role(String name2) {
		name = name2;
	}


	public Glu getGlu() {
		return glu;
	}


	public void setGlu(Glu glu) {
		this.glu = glu;
	}


	public Port getPort() {
		return port;
	}


	public void setPort(Port port) {
		this.port = port;
	}

	
	
}
