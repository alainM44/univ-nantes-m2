package model.client;

import java.util.HashMap;
import java.util.Observable;

import metamodel.port.PortF;
import metamodel.port.PortR;

public class ServiceRConnexionRPC extends metamodel.service.ServiceR {

	public ServiceRConnexionRPC(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super(name, portR, portF);
	}

	/**
	 * Alain modif : uncomment to undo changes
	 * 
	 * Lance une demande de connexion en tant qu'administrateur au serveur
	 */
	@Override
	public void action() {
		// setValueInPortR("Admin", "name");
		// setValueInPortR("reponse?", "requete");

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
		System.out
				.println("[Reponse du serveur] : \n\t\t " + getValueInPortF("retourRequete"));

	}

	// / Alain ajout Begin////////////
	/**
	 * Demande de connexion à la configuration server.
	 * 
	 * @param string
	 */
	public void connexion(String name) {
		setValueInPortR(name, "name");
		setValueInPortR(null, "requete");
		execute();
	}

	/**
	 * Demande de connexion à la configuration server.
	 * 
	 * @param string
	 * @param string2 
	 */
	public void requete(String name, String requete) {
		setValueInPortR(name, "name");
		setValueInPortR(requete, "requete");
		execute();
	}

	// / Alain ajout FIN////////////

}
