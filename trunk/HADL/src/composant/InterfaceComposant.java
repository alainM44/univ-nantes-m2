package composant;

import iNterface.Interface;

import java.util.HashMap;
import metamodel.service.Service;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public class InterfaceComposant extends Interface {

	public HashMap<String, Service> services;

	public HashMap<String, Service> getServices() {
		return services;
	}

	public void setServices(HashMap<String, Service> services) {
		this.services = services;
	}

	public Service getService(String name) {
		return services.get(name);
	}

}
