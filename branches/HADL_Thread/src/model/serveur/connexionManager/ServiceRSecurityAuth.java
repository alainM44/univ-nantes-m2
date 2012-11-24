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

	/**
	 * Fourni au port la nom du client à autentifié
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		setValueInPortR(connexionManager.getClientName(), "name");
	}


	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * Donne a son composant la réponse d'autentification de la Database
	 */
	@Override
	public void update(Observable o, Object arg) {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		connexionManager.setAutentified((Boolean) getValueInPortF("isAdmis"));
	}

}
