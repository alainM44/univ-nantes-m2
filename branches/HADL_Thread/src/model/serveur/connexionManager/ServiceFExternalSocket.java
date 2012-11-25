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
	 *      S'identifie en fournissant le nom du client au SecurityManager
	 * 
	 *      Si l'identification fonctionne, on demande une valeur dans la
	 *      database
	 */
	@Override
	public void action() {
		ConnexionManager connexionManager = ((ConnexionManager) getParentComposant());
		connexionManager.setClientName((String) getValueInPortF("name"));
		connexionManager.setRequete((String) getValueInPortF("requete"));

		if ((connexionManager.clientsAuthenticated.get(connexionManager
				.getClientName()) == null)
				&& connexionManager.getRequete() == null) // demande de
															// connexion
		{
	
			callService("ServiceRSecurityAuth");
			connexionManager.clientsAuthenticated.put(
					connexionManager.getClientName(),
					connexionManager.isAutentified());

			if (connexionManager.clientsAuthenticated.get(connexionManager
					.getClientName()))
				setValueInPortR("Vous êtes autorisé à effectuer des reqêtes ",
						"retourRequete");
			else
				setValueInPortR(
						"Vous n'est pas autorisé à effectuer des requetes",
						"retourRequete");

		} else if (((String) getValueInPortF("requete") != null)
				&& (String) getValueInPortF("name") != null) {

			// request
			if (!connexionManager.clientsAuthenticated.get(connexionManager
					.getClientName())) {
				setValueInPortR(
						"Vous n'est pas autorisé à effectuer des requetes",
						"retourRequete");
			} else {
				connexionManager
						.setRequete((String) getValueInPortF("requete"));
				callService("ServiceRDBQuery");

				setValueInPortR(connexionManager.getDatabaseValue(),
						"retourRequete");
			}
		} else {
			System.err
					.println("erreur dans le passage des paramètres de la requête");
			System.exit(0);
		}

		// On remet tout les paramètres dans leur état initial
		connexionManager.setClientName(null);
		connexionManager.setAutentified(false);
		connexionManager.setDatabaseValue(null);
		connexionManager.setRequete(null);
		setValueInPortF(null, "name");
		setValueInPortF(null, "requete");
	}
}
