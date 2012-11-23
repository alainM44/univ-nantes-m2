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

	/* (non-Javadoc)
	 * @see metamodel.service.ServiceF#action()
	 */
	@Override
	public void action() {
		String chat = new String("Chat Violet");
		setValueInPortR(chat, "CMtoClient");
	}



}
