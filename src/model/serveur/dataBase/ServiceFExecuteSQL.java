package model.serveur.dataBase;

import java.util.HashMap;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

public class ServiceFExecuteSQL extends ServiceF {

	public ServiceFExecuteSQL(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Renvoi la valeur dans la database pour la requete donnée
	 */
	@Override
	public void action() {
		DataBase dataBase = (DataBase) getParentComposant();
		String requete = (String) getValueInPortF("requete");
		setValueInPortR(dataBase.getValueInDatabase(requete), "retourRequete");
	}

}
