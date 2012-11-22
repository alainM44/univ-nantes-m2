package model.serveur.dataBase;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import metamodel.service.Service;

public class ServiceFExecuteSQL extends Service {

	public ServiceFExecuteSQL(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
