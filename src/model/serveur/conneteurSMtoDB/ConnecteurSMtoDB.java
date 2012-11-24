package model.serveur.conneteurSMtoDB;

import metamodel.connecteur.ConnecteurSimple;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;

public class ConnecteurSMtoDB extends ConnecteurSimple {

	public ConnecteurSMtoDB(String name, InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(name, irequise, ifournie, gluFtoR, gluRtoF);
		// TODO Auto-generated constructor stub
	}

}
