package model.serveur.connexionManager;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceR;

public class ServiceRDBQuery extends ServiceR{

	public ServiceRDBQuery(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Demande une requete à la database
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = (ConnexionManager) getParentComposant();
		setValueInPortR(connexionManager.getRequete(), "requete");
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * Récupère la réponse de la requête fournie
	 */
	@Override
	public void update(Observable o, Object arg) {
		ConnexionManager connexionManager = (ConnexionManager) getParentComposant();
		connexionManager.setDatabaseValue((String) getValueInPortF("retourRequete"));
	}



}
