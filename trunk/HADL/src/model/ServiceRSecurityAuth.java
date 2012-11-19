package model;

import java.util.HashMap;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

public class ServiceRSecurityAuth  extends ServiceR{

	public ServiceRSecurityAuth(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
