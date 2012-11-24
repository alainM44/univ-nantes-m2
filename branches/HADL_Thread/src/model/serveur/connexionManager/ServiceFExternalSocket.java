package model.serveur.connexionManager;

import java.util.HashMap;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

public class ServiceFExternalSocket extends ServiceF {

	public ServiceFExternalSocket(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see metamodel.service.ServiceF#action()
	 * 
	 * S'identifie en fournissant le nom du client au SecurityManager
	 * 
	 * Si l'identification fonctionne, on demande une valeur dans la database
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = ((ConnexionManager)getParentComposant());
		connexionManager.setClientName((String)getValueInPortF("name"));
		callService("ServiceRSecurityAuth");
		if(((ConnexionManager)getParentComposant()).isAutentified())
		{
			connexionManager.setRequete((String) getValueInPortF("requete"));
			callService("ServiceRDBQuery");
			setValueInPortR(connexionManager.getDatabaseValue(), "retourRequete");
		}
		else
		{
			setValueInPortR("You failed", "retourRequete");
		}
	}

}
