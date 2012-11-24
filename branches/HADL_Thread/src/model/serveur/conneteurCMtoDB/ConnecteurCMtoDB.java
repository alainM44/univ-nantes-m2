package model.serveur.conneteurCMtoDB;

import metamodel.connecteur.ConnecteurSimple;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;

public class ConnecteurCMtoDB extends ConnecteurSimple {

	public ConnecteurCMtoDB(String name, InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(name, irequise, ifournie, gluFtoR, gluRtoF);
		// TODO Auto-generated constructor stub
	}

}
