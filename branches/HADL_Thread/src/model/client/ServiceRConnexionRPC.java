package model.client;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;

public class ServiceRConnexionRPC extends metamodel.service.ServiceR {

	public ServiceRConnexionRPC(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lance une demande de connexion en tant qu'administrateur au serveur
	 */
	@Override
	public void action() {
		setValueInPortR("Admin", "name");
		setValueInPortR("reponse?", "requete");

	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 *      Affiche le retour du serveur : Un affichage
	 *      "Echec de la connexion à la database" est considéré comme un echec
	 *      d'identification (La dataBase ne reconnait pas le client)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("La réponse est "+getValueInPortF("retourRequete"));

	}

}
