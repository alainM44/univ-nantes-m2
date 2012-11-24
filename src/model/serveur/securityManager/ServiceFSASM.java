package model.serveur.securityManager;

import java.util.HashMap;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.service.ServiceF;

public class ServiceFSASM extends ServiceF {

	public ServiceFSASM(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le service ServiceFSASM doit déterminer si le client, dont le nom est
	 * fourni dans le port, peut s'identifier à la database en faisant appelle
	 * au service ServiceRCQuery
	 */
	@Override
	public void action() {
		SecurityManager manager = (SecurityManager) getParentComposant();
		String name = (String) getValueInPortF("name");
		manager.setToIdentify(name);
		callService("ServiceRCQuery");
		setValueInPortR(manager.isIdentify(), "isAdmis");
		//On remet tout les paramètres dans leur état initial
		manager.setIdentify(false);
		manager.setToIdentify(null);

	}

}
