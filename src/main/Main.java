/*   This file is part of HADL_Project.

     HADL_Project is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     HADL_Project is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with HADL_Project.  If not, see <http://www.gnu.org/licenses/>
*/

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import aspectLog.LogAspect;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.configuration.Couple;
import metamodel.configuration.InterfaceConfig;
import metamodel.connecteur.Connecteur;
import metamodel.connecteur.InterfaceConnecteur;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
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
import model.serveur.configurationServer.PortFServeur;
import model.serveur.configurationServer.PortRServeur;
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
import model.serveur.securityManager.SecurityManager;
import model.serveur.securityManager.ServiceFSASM;
import model.serveur.securityManager.ServiceRCQuery;

public class Main {

    /**
     * TODO : propriétés Connecteurs
     * 
     * @param args
     */
    public static void main(String[] args) {



	///////////////////////////////////////////////////////////
	////********INITIALISATION DES DIFFERENTS COMPOSANT **/////
	////********DE LA CONFIGURATION SERVEUR*********** **/////
	///////////////////////////////////////////////////////////


	////DEBUT COMPOSANT DATABASE ////////////////////////////
	HashMap<String, Propriete> proprietes = new HashMap<String, Propriete>();
	InterfaceComposant fourni = new InterfaceComposant();
	HashMap<String, PortR> portR = new HashMap<String, PortR>();
	portR.put("retourRequete", new PortRExecuteSQL("PortRExecuteSQL"));

	HashMap<String, PortF> portF = new HashMap<String, PortF>();
	portF.put("requete", new PortFExecuteSQL("PortFExecuteSQL"));

	ServiceFExecuteSQL serviceFExecuteSQL = new ServiceFExecuteSQL(
								       "ServiceFExecuteSQL", portR, portF);

	portR = new HashMap<String, PortR>();
	portR.put("isAdmis", new PortRSecurityManagement(
							 "PortRSecurityManagement"));

	portF = new HashMap<String, PortF>();
	portF.put("name",
		  new PortFSecurityManagement("PortFSecurityManagement"));
	ServiceFSecurityManagement serviceFSecurityManagement = new ServiceFSecurityManagement(
											       "ServiceFSecurityManagement", portR, portF);

	fourni.addService(serviceFExecuteSQL);
	fourni.addService(serviceFSecurityManagement);
	InterfaceComposant requis = new InterfaceComposant();
	DataBase dataBase = new DataBase("DataBase", requis, fourni, proprietes);
	////FIN COMPOSANT DATABASE ////////////////////////////

	////DEBUT COMPOSANT CONNEXIONMANAGER
	proprietes = new HashMap<String, Propriete>();

	portR = new HashMap<String, PortR>();
	portR.put("requete", new PortRDBQuery("PortRDBQuery"));

	portF = new HashMap<String, PortF>();
	portF.put("retourRequete", new PortFDBQuery("PortFDBQuery"));

	ServiceRDBQuery serviceRDBQuery = new ServiceRDBQuery(
							      "ServiceRDBQuery", portR, portF);

	portR = new HashMap<String, PortR>();
	portR.put("name", new PortRSecurityAuth("PortRSecurityAuth"));

	portF = new HashMap<String, PortF>();
	portF.put("isAdmis", new PortFSecurityAuth("PortFSecurityAuth"));
	ServiceRSecurityAuth serviceRSecurityAuth = new ServiceRSecurityAuth(
									     "ServiceRSecurityAuth", portR, portF);

	portR = new HashMap<String, PortR>();
	portR.put("retourRequete", new PortRExternalSocket(
							   "PortRExternalSocket"));

	portF = new HashMap<String, PortF>();
	portF.put("name", new PortFExternalSocket("PortFExternalSocket"));
	portF.put("requete", new PortFExternalSocket("PortFExternalSocket"));

	ServiceFExternalSocket serviceFExternalSocket = new ServiceFExternalSocket(
										   "ServiceFExternalSocket", portR, portF);
	fourni = new InterfaceComposant();
	fourni.addService(serviceFExternalSocket);
	requis = new InterfaceComposant();
	requis.addService(serviceRSecurityAuth);
	requis.addService(serviceRDBQuery);
	ConnexionManager connexionManager = new ConnexionManager(
								 "ConnexionManager", requis, fourni, proprietes);
	////FIN COMPOSANT CONNEXIONMANAGER ////////////////////////////

	////DEBUT COMPOSANT SECURITYMANAGER ///////////////////////////
	proprietes = new HashMap<String, Propriete>();
	portR = new HashMap<String, PortR>();
	portR.put("isAdmis", new PortRSASM("PortRSASM"));

	portF = new HashMap<String, PortF>();
	portF.put("name", new PortFSASM("PortFSASM"));

	ServiceFSASM serviceFSAM = new ServiceFSASM("ServiceFSAM", portR, portF);

	portR = new HashMap<String, PortR>();
	portR.put("name", new PortRCQuery("PortRCQuery"));

	portF = new HashMap<String, PortF>();
	portF.put("isAdmis", new PortFCQuery("PortFCQuery"));
	ServiceRCQuery serviceRCQuery = new ServiceRCQuery("ServiceRCQuery",
							   portR, portF);

	fourni = new InterfaceComposant();
	fourni.addService(serviceFSAM);
	requis = new InterfaceComposant();
	requis.addService(serviceRCQuery);
	SecurityManager securityManager = new SecurityManager(
							      "SecurityManager", requis, fourni, proprietes);
	////FIN SECURITYMANANGER ////////////////////////////


	///////////////////////////////////////////////////////////
	////********INITIALISATION DES DIFFERENTS CONNECTEURS **/////
	////********DE LA CONFIGURATION SERVEUR*********** **/////
	///////////////////////////////////////////////////////////


	////DEBUT connecteurCMtoSM////////////////////////////////////////////////////
	RoleRSMtoCM roleR = new RoleRSMtoCM("RoleRSMtoCM");
	RoleFSMtoCM roleF = new RoleFSMtoCM("RoleFSMtoCM");
	InterfaceConnecteur ifournie = new InterfaceConnecteur(roleR, roleF);
	RoleRCMtoSM roleR2 = new RoleRCMtoSM("RoleRCMtoSM");
	RoleFCMtoSM roleF2 = new RoleFCMtoSM("RoleFCMtoSM");
	InterfaceConnecteur irequise = new InterfaceConnecteur(roleR2, roleF2);
	GluSMtoCM gluSMtoCM = new GluSMtoCM(roleR, roleF2);
	GluCMtoSM gluCMtoSM = new GluCMtoSM(roleR2, roleF);
	ConnecteurCMtoSM connecteurCMtoSM = new ConnecteurCMtoSM(
								 "ConnecteurCMtoSM", irequise, ifournie, gluSMtoCM, gluCMtoSM);
	////FINconnecteurCMtoSM////////////////////////////////////////////////////
	

	////DEBUT connecteurCMtoDBconnecteurCMtoSM////////////////////////////////////////////////////	       
	RoleRCMtoDB roleRCMtoDB = new RoleRCMtoDB("RoleRCMtoDB");
	RoleFCMtoDB roleFCMtoDB = new RoleFCMtoDB("RoleFCMtoDB");
	irequise = new InterfaceConnecteur(roleRCMtoDB, roleFCMtoDB);

	RoleRDBtoCM roleRDBtoCM = new RoleRDBtoCM("roleRDBtoCM");
	RoleFDBtoCM roleFDBtoCM = new RoleFDBtoCM("roleFDBtoCM");
	ifournie = new InterfaceConnecteur(roleRDBtoCM, roleFDBtoCM);

	GluDBtoCM gluDBtoCM = new GluDBtoCM(roleRDBtoCM, roleFCMtoDB);
	GluCMtoDB gluCMtoDB = new GluCMtoDB(roleRCMtoDB, roleFDBtoCM);
	ConnecteurCMtoDB connecteurCMtoDB = new ConnecteurCMtoDB(
								 "ConnecteurCMtoDB", irequise, ifournie, gluDBtoCM, gluCMtoDB);

	RoleRSMtoDB roleRSMtoDB = new RoleRSMtoDB("roleRSMtoDB");
	RoleFSMtoDB roleFSMtoDB = new RoleFSMtoDB("roleFSMtoDB");
	////FIN connecteurCMtoDBconnecteurCMtoSM////////////////////////////////////////////////////	       

	////DEBUT ConnecteurSMtoDB////////////////////////////////////////////////////////////
	irequise = new InterfaceConnecteur(roleRSMtoDB, roleFSMtoDB);

	RoleRDBtoSM roleRDBtoSM = new RoleRDBtoSM("roleRDBtoSM");
	RoleFDBtoSM roleFDBtoSM = new RoleFDBtoSM("roleFDBtoSM");
	ifournie = new InterfaceConnecteur(roleRDBtoSM, roleFDBtoSM);

	GluDBtoSM gluDBtoSM = new GluDBtoSM(roleRDBtoSM, roleFSMtoDB);
	GluSMtoDB gluSMtoDB = new GluSMtoDB(roleRSMtoDB, roleFDBtoSM);

	ConnecteurSMtoDB connecteurSMtoDB = new ConnecteurSMtoDB(
								 "ConnecteurSMtoDB", irequise, ifournie, gluDBtoSM, gluSMtoDB);
	////FIN CONNECTEURS////////////////////////////////////////////////////////

	////DEBUT Connecteur RPC/////////////////////////////////////////////////////
	RoleFStoC roleFStoC = new RoleFStoC("RoleFStoC");
	RoleRStoC roleRStoC = new RoleRStoC("RoleRStoC");
	RoleFCtoS roleFCtoS = new RoleFCtoS("RoleFCtoS");
	RoleRCtoS roleRCtoS = new RoleRCtoS("RoleRCtoS");
	ifournie = new InterfaceConnecteur(roleRStoC, roleFCtoS);
	irequise = new InterfaceConnecteur(roleRCtoS, roleFStoC);
	GluCtoS gluCtoS = new GluCtoS(roleRCtoS, roleFCtoS);
	GluStoC gluStoC = new GluStoC(roleRStoC, roleFStoC);

	ConnecteurRPC connecteurRPC = new ConnecteurRPC("ConnecteurRPC",
							irequise, ifournie, gluCtoS, gluStoC);
	////fin Connecteur RPC/////////////////////////////////////////////////////


	

	///// DEBUT ConfigurationSERVER //////////////////////////////////////////////
	HashMap<String, Couple> bindings = new HashMap<String, Couple>();
	bindings.put("ServiceFExternalSocket", new Couple(
							  "ServiceInterfaceConfig", "ConfigurationServeur", "f"));

	PortFServeur portFServeur = new PortFServeur("PortFServeur");
	PortFServeur portFServeur2 = new PortFServeur("PortFServeur");
	PortRServeur portRServeur = new PortRServeur("PortRServeur");
	portR = new HashMap<String, PortR>();
	portF = new HashMap<String, PortF>();

	portF.put("name", portFServeur);
	portF.put("requete", portFServeur2);
	portR.put("retourRequete", portRServeur);

	InterfaceConfig interfacesConfigsF = new InterfaceConfig();
	interfacesConfigsF.addService(new ServiceInterfaceConfig(
								 "ServiceInterfaceConfig", portR, portF));
	InterfaceConfig interfacesConfigsR = new InterfaceConfig();

	HashMap<String, Composant> composants = new HashMap<String, Composant>();
	composants.put(securityManager.getName(), securityManager);
	composants.put(dataBase.getName(), dataBase);
	composants.put(connexionManager.getName(), connexionManager);

	HashMap<String, Connecteur> connecteurs = new HashMap<String, Connecteur>();
	connecteurs.put(connecteurCMtoDB.getName(), connecteurCMtoDB);
	connecteurs.put(connecteurCMtoSM.getName(), connecteurCMtoSM);
	connecteurs.put(connecteurSMtoDB.getName(), connecteurSMtoDB);
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
	///// FIN ConfigurationSERVER //////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////
	////********INITIALISATION DES DIFFERENTS COMPOSANTS **/////
	////********DE LA CONFIGURATION MAIN*********** **/////
	///////////////////////////////////////////////////////////

	////DEBUT COMPOSANT CLIENT/////////////////////////////////////////////////////////
	PortFClient portFClient = new PortFClient("PortFClient");
	PortRClient portRClient = new PortRClient("PortRClient");
	PortRClient portRClient2 = new PortRClient("PortRClient");
	portR = new HashMap<String, PortR>();
	portF = new HashMap<String, PortF>();

	portF.put("retourRequete", portFClient);
	portR.put("name", portRClient);
	portR.put("requete", portRClient2);

	ServiceRConnexionRPC connexionRPC = new ServiceRConnexionRPC(
								     "ServiceRConnexionRPC", portR, portF);
	InterfaceComposant irequis = new InterfaceComposant();
	irequis.addService(connexionRPC);
	InterfaceComposant ifournis = new InterfaceComposant();
	proprietes = new HashMap<String, Propriete>();
	Client client = new Client("Client", irequis, ifournis, proprietes);
	///FIN COMPOSANT CLIENT//////////////////////////////////////////////////////////////////////

	////DEBUT ConfigMain//////////////////////////////////////////////////
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
								    "ConfigurationMain", bindings, composants, interfacesConfigsR,
								    interfacesConfigsF, connecteurs, attachements, proprietesConfig);
	////FIN ConfigMain///////////////////////////////////////////////////////
	




	ServiceRConnexionRPC RunFromServiceRPC = (ServiceRConnexionRPC) client
	    .getRequis().getService("ServiceRConnexionRPC");
	// RunFromServiceRPC.connexion("Admin");
	// RunFromServiceRPC.requete("Admin", "qui est l ennemi");
	// RunFromServiceRPC.connexion("Admin2");
	// RunFromServiceRPC.requete("Admin2", "qui est l ennemi");
	// RunFromServiceRPC
	// .requete("Admin",
	// "Rech.proj.pr.proj.priv.selfdef.dem.brut.poss.S'adr.a.lhôt.Mar.");

	menu(args, RunFromServiceRPC);
		
	//TODO erreur sale quand on tente une requete sans 'etre authentifié

    }

    public static void menu(String[] args,
			    ServiceRConnexionRPC runFromServiceRPC) {
	System.out.println("*****************************");
	System.out.println("********HADL_PROJECT*********");
	System.out.println("*****************************");
	System.out.println("Bienvenu(es) dans une application client-serveur.");
	System.out.println("Usage :");
	System.out.println("\t $connexion  login");
	System.out.println("\t $requete  login requete");
	System.out.println("\t $quit");

	String arg;
	boolean fin = false;
	String login = "";
	String requete = "";
	args = lireString();

	while (!fin) {

	    arg = args[0];
	    // use this type of check for "wordy" arguments
	    if (arg.equals("requete") && args.length == 3) {
		requete = args[2];
		String name = args[1];
		runFromServiceRPC.requete(name, requete);
		args = lireString();
	    } else if (arg.equals("connexion")) {
		login = args[1];
		System.out.println("connexion " + login);
		runFromServiceRPC.connexion(login);
		args = lireString();
	    } else if (arg.equals("quit")) {
		fin = true;
		System.out.println("quit ");

	    } else if (arg.equals("help")) {
		System.out.println("Usage :");
		System.out.println("\t $connexion  login");
		System.out.println("\t $requete  login requete");
		System.out.println("\t $quit");

	    } else {

		System.out.println("\033[2J\n");
		System.err
		    .println("erreur dans la saisie veuillez recommencer");
		System.out.println("Usage :");
		System.out.println("\t $connexion  login");
		System.out.println("\t $requete  login requete");
		System.out.println("\t $quit");
		args = lireString();

	    }
	}

    }

    /**
     * Fonction lisant une ligne sur l'entrée standart et renvoyant un tableau
     * de string
     * 
     * @return String[] de la ligne courante
     */
    public static String[] lireString() {// lecture d'une chaine
	String ligne_lue = null;
	String[] result = null;
	try {
	    InputStreamReader lecteur = new InputStreamReader(System.in);
	    BufferedReader entree = new BufferedReader(lecteur);
	    ligne_lue = entree.readLine();
	    result = ligne_lue.split(" ");
	} catch (IOException err) {
	    System.exit(0);
	}

	return result;
    }

}
