package model.client;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;

public class ServiceRConnexionRPC extends metamodel.service.ServiceR {

	public ServiceRConnexionRPC(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		
		
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(getValueInPortF("PortFClient"));
		
	}

	

}
