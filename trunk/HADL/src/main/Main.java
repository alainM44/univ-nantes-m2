package main;

import java.util.HashMap;


import metamodel.composant.InterfaceComposant;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
import metamodel.role.RoleR;
import metamodel.service.Service;
import model.serveur.connexionManager.ConnexionManager;
import model.serveur.connexionManager.PortFDBQuery;
import model.serveur.connexionManager.PortFExternalSocket;
import model.serveur.connexionManager.PortFSecurityAuth;
import model.serveur.connexionManager.PortRDBQuery;
import model.serveur.connexionManager.PortRExternalSocket;
import model.serveur.connexionManager.PortRSecurityAuth;
import model.serveur.connexionManager.ServiceFExternalSocket;
import model.serveur.connexionManager.ServiceRDBQuery;
import model.serveur.connexionManager.ServiceRSecurityAuth;
import model.serveur.dataBase.DataBase;
import model.serveur.dataBase.PortFExecuteSQL;
import model.serveur.dataBase.PortFSecurityManagement;
import model.serveur.dataBase.PortRExecuteSQL;
import model.serveur.dataBase.PortRSecurityManagement;
import model.serveur.dataBase.ServiceFExecuteSQL;
import model.serveur.dataBase.ServiceFSecurityManagement;
import model.serveur.securityManager.PortFCQuery;
import model.serveur.securityManager.PortFSASM;
import model.serveur.securityManager.PortRCQuery;
import model.serveur.securityManager.PortRSASM;
import model.serveur.securityManager.ServiceFSASM;
import model.serveur.securityManager.ServiceRCQuery;


public class Main {

	/**
	 * TODO : propriétés Connecteurs
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// /////// COMPOSANT DATABASE
		HashMap<String, Propriete> proprietes = new HashMap<String, Propriete>();
		InterfaceComposant fourni = new InterfaceComposant();
		HashMap<String, PortR> portR = new HashMap<String, PortR>();
		portR.put("PortRExecuteSQL", new PortRExecuteSQL("PortRExecuteSQL"));

		HashMap<String, PortF> portF = new HashMap<String, PortF>();
		portF.put("PortFExecuteSQL", new PortFExecuteSQL("PortFExecuteSQL"));

		ServiceFExecuteSQL serviceFExecuteSQL = new ServiceFExecuteSQL(
				"ServiceFExecuteS" +
				"L", portR, portF);

		portR = new HashMap<String, PortR>();
		portR.put("PortRSecurityManagement", new PortRSecurityManagement(
				"PortRSecurityManagement"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFSecurityManagement", new PortFSecurityManagement(
				"PortFSecurityManagement"));
		ServiceFSecurityManagement serviceFSecurityManagement = new ServiceFSecurityManagement(
				"ServiceFSecurityManagement", portR, portF);

		fourni.addService(serviceFExecuteSQL);
		fourni.addService(serviceFSecurityManagement);
		InterfaceComposant requis = new InterfaceComposant();
		new DataBase(requis, fourni, proprietes);
		// FIN COMPOSANT DATABASE ////////////////////////////

		// /////// COMPOSANT CONNEXIONMANAGER
		proprietes = new HashMap<String, Propriete>();

		portR = new HashMap<String, PortR>();
		portR.put("PortRDBQuery", new PortRDBQuery("PortRDBQuery"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFDBQuery", new PortFDBQuery("PortFDBQuery"));

		ServiceRDBQuery serviceRDBQuery = new ServiceRDBQuery(
				"ServiceRDBQuery", portR, portF);

		portR = new HashMap<String, PortR>();
		portR.put("PortRSecurityAuth", new PortRSecurityAuth(
				"PortRSecurityAuth"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFSecurityAuth", new PortFSecurityAuth(
				"PortFSecurityAuth"));
		ServiceRSecurityAuth serviceRSecurityAuth = new ServiceRSecurityAuth(
				"ServiceRSecurityAuth", portR, portF);

		portR = new HashMap<String, PortR>();
		portR.put("PortRExternalSocket", new PortRExternalSocket(
				"PortRExternalSocket"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFExternalSocket", new PortFExternalSocket(
				"PortFExternalSocket"));
		ServiceFExternalSocket serviceFExternalSocket = new ServiceFExternalSocket(
				"ServiceFExternalSocket", portR, portF);
		fourni = new InterfaceComposant();
		fourni.addService(serviceFExternalSocket);
		requis = new InterfaceComposant();
		requis.addService(serviceRSecurityAuth);
		requis.addService(serviceRDBQuery);
		new ConnexionManager(requis, fourni, proprietes);
		// FIN CONNEXIONMANAGER ////////////////////////////

		// /////// COMPOSANT SecurityManager
		proprietes = new HashMap<String, Propriete>();

		portR = new HashMap<String, PortR>();
		portR.put("PortRSASM", new PortRSASM("PortRSASM"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFSASM", new PortFSASM("PortFSASM"));

		ServiceFSASM serviceFSAM = new ServiceFSASM("serviceFSAM", portR, portF);

		portR = new HashMap<String, PortR>();
		portR.put("PortRCQuery", new PortRCQuery("PortRCQuery"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFCQuery ", new PortFCQuery("PortFCQuery"));
		ServiceRCQuery serviceRCQuery = new ServiceRCQuery("ServiceRCQuery",
				portR, portF);

		fourni = new InterfaceComposant();
		fourni.addService(serviceFSAM);
		requis = new InterfaceComposant();
		requis.addService(serviceRCQuery);
		new ConnexionManager(requis, fourni, proprietes);
		// FIN SecurityManager ////////////////////////////

		// //////////////CONNECTEURS//////////////////////

		ConnecteurCMtoSM connecteurCMtoSM = new ConnecteurCMtoSM();
	}
}