package main;

import java.awt.color.CMMException;
import java.util.HashMap;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.configuration.Configuration;
import metamodel.configuration.Couple;
import metamodel.configuration.InterfaceConfig;
import metamodel.connecteur.Connecteur;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import metamodel.service.Service;
import model.client.Client;
import model.client.PortFClient;
import model.client.PortRClient;
import model.client.ServiceRConnexionRPC;
import model.client.configurationMain.ConfigurationMain;
import model.connecteurRPC.ConnecteurRPC;
import model.connecteurRPC.GluCtoS;
import model.connecteurRPC.GluStoC;
import model.connecteurRPC.RoleFCtoS;
import model.connecteurRPC.RoleFStoC;
import model.connecteurRPC.RoleRCtoS;
import model.connecteurRPC.RoleRStoC;
import model.serveur.configurationServer.ConfigurationServer;
import model.serveur.configurationServer.RoleFSMtoCM;
import model.serveur.configurationServer.ServiceInterfaceConfig;
import model.serveur.conneteurCMtoDB.ConnecteurCMtoDB;
import model.serveur.conneteurCMtoDB.GluCMtoDB;
import model.serveur.conneteurCMtoDB.GluDBtoCM;
import model.serveur.conneteurCMtoDB.RoleFCMtoDB;
import model.serveur.conneteurCMtoDB.RoleFDBtoCM;
import model.serveur.conneteurCMtoDB.RoleRCMtoDB;
import model.serveur.conneteurCMtoDB.RoleRDBtoCM;
import model.serveur.conneteurCMtoSM.ConnecteurCMtoSM;
import model.serveur.conneteurCMtoSM.GluCMtoSM;
import model.serveur.conneteurCMtoSM.GluSMtoCM;
import model.serveur.conneteurCMtoSM.RoleFCMtoSM;
import model.serveur.conneteurCMtoSM.RoleRCMtoSM;
import model.serveur.conneteurCMtoSM.RoleRSMtoCM;
import model.serveur.conneteurSMtoDB.ConnecteurSMtoDB;
import model.serveur.conneteurSMtoDB.GluDBtoSM;
import model.serveur.conneteurSMtoDB.GluSMtoDB;
import model.serveur.conneteurSMtoDB.RoleFDBtoSM;
import model.serveur.conneteurSMtoDB.RoleFSMtoDB;
import model.serveur.conneteurSMtoDB.RoleRDBtoSM;
import model.serveur.conneteurSMtoDB.RoleRSMtoDB;
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
import model.serveur.securityManager.SecurityManager;

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
				"ServiceFExecuteSQL", portR, portF);

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
		DataBase dataBase = new DataBase("DataBase", requis, fourni, proprietes);
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
		ConnexionManager connexionManager = new ConnexionManager(
				"ConnexionManager", requis, fourni, proprietes);
		// FIN CONNEXIONMANAGER ////////////////////////////

		// /////// COMPOSANT SecurityManager
		proprietes = new HashMap<String, Propriete>();

		portR = new HashMap<String, PortR>();
		portR.put("PortRSASM", new PortRSASM("PortRSASM"));

		portF = new HashMap<String, PortF>();
		portF.put("PortFSASM", new PortFSASM("PortFSASM"));

		ServiceFSASM serviceFSAM = new ServiceFSASM("ServiceFSAM", portR, portF);

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
		SecurityManager securityManager = new SecurityManager(
				"SecurityManager", requis, fourni, proprietes);
		// FIN SecurityManager ////////////////////////////

		// //////////////CONNECTEURS//////////////////////
		// connecteurCMtoSM
		RoleRSMtoCM roleR = new RoleRSMtoCM("RoleRSMtoCM");
		RoleFSMtoCM roleF = new RoleFSMtoCM("RoleFSMtoCM");
		InterfaceConnecteur ifournie = new InterfaceConnecteur(roleR, roleF);
		RoleRCMtoSM roleR2 = new RoleRCMtoSM("RoleRCMtoSM");
		RoleFCMtoSM roleF2 = new RoleFCMtoSM("RoleFCMtoSM");
		InterfaceConnecteur irequise = new InterfaceConnecteur(roleR2, roleF2);
		GluSMtoCM gluSMtoCM = new GluSMtoCM(roleR, roleF2);
		GluCMtoSM gluCMtoSM = new GluCMtoSM(roleR2, roleF);
		ConnecteurCMtoSM connecteurCMtoSM = new ConnecteurCMtoSM("ConnecteurCMtoSM",irequise,
				ifournie, gluSMtoCM, gluCMtoSM);
		// connecteurCMtoDB
		RoleRCMtoDB roleRCMtoDB = new RoleRCMtoDB("RoleRCMtoDB");
		RoleFCMtoDB roleFCMtoDB = new RoleFCMtoDB("RoleFCMtoDB");
		irequise = new InterfaceConnecteur(roleRCMtoDB, roleFCMtoDB);

		RoleRDBtoCM roleRDBtoCM = new RoleRDBtoCM("roleRDBtoCM");
		RoleFDBtoCM roleFDBtoCM = new RoleFDBtoCM("roleFDBtoCM");
		ifournie = new InterfaceConnecteur(roleRDBtoCM, roleFDBtoCM);

		GluDBtoCM gluDBtoCM = new GluDBtoCM(roleRDBtoCM, roleFCMtoDB);
		GluCMtoDB gluCMtoDB = new GluCMtoDB(roleRCMtoDB, roleFDBtoCM);
		ConnecteurCMtoDB connecteurCMtoDB = new ConnecteurCMtoDB("ConnecteurCMtoDB",irequise,
				ifournie, gluDBtoCM, gluCMtoDB);

		RoleRSMtoDB roleRSMtoDB = new RoleRSMtoDB("roleRSMtoDB");
		RoleFSMtoDB roleFSMtoDB = new RoleFSMtoDB("roleFSMtoDB");
		// ConnecteurSMtoDB
		irequise = new InterfaceConnecteur(roleRSMtoDB, roleFSMtoDB);

		RoleRDBtoSM roleRDBtoSM = new RoleRDBtoSM("roleRDBtoSM");
		RoleFDBtoSM roleFDBtoSM = new RoleFDBtoSM("roleFDBtoSM");
		ifournie = new InterfaceConnecteur(roleRDBtoSM, roleFDBtoSM);

		GluDBtoSM gluDBtoSM = new GluDBtoSM(roleRDBtoSM, roleFSMtoDB);
		GluSMtoDB gluSMtoDB = new GluSMtoDB(roleRSMtoDB, roleFDBtoSM);

		ConnecteurSMtoDB connecteurSMtoDB = new ConnecteurSMtoDB("ConnecteurSMtoDB",irequise,
				ifournie, gluDBtoSM, gluSMtoDB);
		// /////FIN CONNECTEURS

		// /Connecteur RPC////
		RoleFStoC roleFStoC = new RoleFStoC("RoleFStoC");
		RoleRStoC roleRStoC = new RoleRStoC("RoleRStoC");
		ifournie = new InterfaceConnecteur(roleRStoC, roleFStoC);
		RoleFCtoS roleFCtoS = new RoleFCtoS("RoleFCtoS");
		RoleRCtoS roleRCtoS = new RoleRCtoS("RoleRCtoS");
		// irequise = new InterfaceConnecteur(roleRCtoS, roleFCtoS);
		GluCtoS gluCtoS = new GluCtoS(roleRCtoS, roleFCtoS);
		GluStoC gluStoC = new GluStoC(roleRStoC, roleFStoC);

		ConnecteurRPC connecteurRPC = new ConnecteurRPC("ConnecteurRPC",irequise, ifournie,
				gluCtoS, gluStoC);
		// /fin Connecteur RPC1111
		// COMPOSANT CLIENT//////////////////
		PortFClient portFClient = new PortFClient("PortFClient");
		PortRClient portRClient = new PortRClient("PortRClient");
		portR = new HashMap<String, PortR>();
		portF = new HashMap<String, PortF>();

		portF.put("PortFClient", portFClient);
		portR.put("PortRClient", portRClient);

		ServiceRConnexionRPC connexionRPC = new ServiceRConnexionRPC(
				"ServiceRConnexionRPC", portR, portF);
		InterfaceComposant irequis = new InterfaceComposant();
		irequis.addService(connexionRPC);
		InterfaceComposant ifournis = new InterfaceComposant();
		proprietes = new HashMap<String, Propriete>();
		Client client = new Client("Client", irequis, ifournis, proprietes);
		// //FIN COMPOSANT
		// CLIENT/////////////////////////////////////////////////////////////////////////////

		// //ConfigurationSERVER
		HashMap<String, Couple> bindings = new HashMap<String, Couple>();
		bindings.put("ServiceFExternalSocket", new Couple(
				"ServiceInterfaceConfig", "ConfigurationServeur", "f"));

		InterfaceConfig interfacesConfigsF = new InterfaceConfig();
		interfacesConfigsF.addService(new ServiceInterfaceConfig(
				"ServiceInterfaceConfig", null, null));
		InterfaceConfig interfacesConfigsR = new InterfaceConfig();

		HashMap<String, Composant> composants = new HashMap<String, Composant>();
		composants.put(securityManager.getName(), securityManager);
		composants.put(dataBase.getName(), dataBase);
		composants.put(connexionManager.getName(), connexionManager);

		HashMap<String, Connecteur> connecteurs = new HashMap<String, Connecteur>();
		connecteurs.put(connecteurCMtoDB.getName(), connecteurCMtoDB);
		connecteurs.put(connecteurCMtoSM.getName(), connecteurCMtoSM);
		connecteurs.put(connecteurSMtoDB.getName(), connecteurSMtoDB);
		System.out.println(connecteurs.size());
		HashMap<String, String> attachements = new HashMap<String, String>();

		attachements.put("ServiceFExecuteSQL", "ConnecteurCMtoDB");
		attachements.put("ServiceFSecurityManagement", "ConnecteurSMtoDB");
		attachements.put("ServiceRDBQuery", "ConnecteurCMtoDB");
		attachements.put("ServiceRSecurityAuth", "ConnecteurCMtoSM");
		attachements.put("ServiceFSAM", "ConnecteurCMtoSM");
		attachements.put("ServiceRCQuery", "ConnecteurSMtoDB");

		HashMap<String, Propriete> proprietesConfig = new HashMap<String, Propriete>(); // TODO
		ConfigurationServer configurationServeur = new ConfigurationServer(
				"ConfigurationServeur", bindings, composants,
				interfacesConfigsR, interfacesConfigsF, connecteurs,
				attachements, proprietesConfig);
		
		// /FIn config Server/////////////////////////

		// /ConfigMain
		bindings = new HashMap<String, Couple>();// TODO OR NOT
		composants = new HashMap<String, Composant>();
		composants.put(client.getName(), client);
		composants.put(configurationServeur.getName(), configurationServeur);

		interfacesConfigsF = new InterfaceConfig();
		interfacesConfigsR = new InterfaceConfig();
		connecteurs = new HashMap<String, Connecteur>();
		connecteurs.put("ConnecteurRPC", connecteurRPC);
		attachements = new HashMap<String, String>();
		attachements.put("ServiceRConnexionRPC", "ConnecteurRPC");
		attachements.put("ServiceInterfaceConfig", "ConnecteurRPC");

		proprietesConfig = new HashMap<String, Propriete>();
		ConfigurationMain configurationMain = new ConfigurationMain(
				"ConfigurationServeur", bindings, composants,
				interfacesConfigsR, interfacesConfigsF, connecteurs,
				attachements, proprietesConfig);
		// ////FIN ConfigMain
		
		client.getRequis().getService("ServiceRConnexionRPC").execute();
		
		
	}
}
