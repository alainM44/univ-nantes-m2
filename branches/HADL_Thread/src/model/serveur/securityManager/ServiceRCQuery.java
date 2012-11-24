package model.serveur.securityManager;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

public class ServiceRCQuery extends ServiceR {

	public ServiceRCQuery(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Envoie le nom du client à identifié à la database
	 */
	@Override
	public void action() {
SecurityManager manager = (SecurityManager) getParentComposant();
setValueInPortR(manager.getToIdentify(), "name");
	}

	/** (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * Recupère le retour d'identification de la database : true ou false
	 */
	@Override
	public void update(Observable o, Object arg) {
		SecurityManager manager = (SecurityManager) getParentComposant();
		manager.setIdentify((Boolean) getValueInPortF("isAdmis"));
		
	}

}
