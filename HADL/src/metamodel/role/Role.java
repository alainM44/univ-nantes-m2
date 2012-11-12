package metamodel.role;

import java.util.HashMap;
import java.util.Observable;

import metamodel.connecteur.Glu;
import metamodel.port.Port;
import metamodel.service.Service;


/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class Role extends Observable{

	private String name;
	private Glu glu;
	private Service service;
	
	



	public Role(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public Glu getGlu() {
		return glu;
	}


	public void setGlu(Glu glu) {
		this.glu = glu;
	}




	
	
}
