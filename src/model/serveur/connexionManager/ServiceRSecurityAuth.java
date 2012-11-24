package model.serveur.connexionManager;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

public class ServiceRSecurityAuth extends ServiceR {

	public ServiceRSecurityAuth(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		setValueInPortR(connexionManager.getClientName(), "CMtoSM");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		connexionManager.setAutentified((Boolean) getValueInPortF("SMtoCM"));
	}

}
