package model.serveur.conneteurCMtoDB;

import metamodel.connecteur.ConnecteurSimple;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;

public class ConnecteurCMtoDB extends ConnecteurSimple {

	public ConnecteurCMtoDB(InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(irequise, ifournie, gluFtoR, gluRtoF);
		// TODO Auto-generated constructor stub
	}

}
