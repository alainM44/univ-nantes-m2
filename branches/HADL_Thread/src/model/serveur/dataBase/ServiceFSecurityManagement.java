package model.serveur.dataBase;

import java.util.HashMap;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

public class ServiceFSecurityManagement extends ServiceF {

	public ServiceFSecurityManagement(String name,
			HashMap<String, PortR> portR, HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 *  Demande à la database si le client, dont le nom est fourni dans le
	 * port, peut se connecter
	 */
	@Override
	public void action() {
		DataBase dataBase = (DataBase) getParentComposant();
		boolean admis = dataBase.isAdmis((String) getValueInPortF("name"));
		setValueInPortR(admis, "isAdmis");
	}

}
