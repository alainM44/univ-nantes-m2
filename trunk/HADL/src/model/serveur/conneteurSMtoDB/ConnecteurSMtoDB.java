package model.serveur.conneteurSMtoDB;

import metamodel.connecteur.ConnecteurSimple;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;

public class ConnecteurSMtoDB extends ConnecteurSimple {

	public ConnecteurSMtoDB(InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(irequise, ifournie, gluFtoR, gluRtoF);
		// TODO Auto-generated constructor stub
	}

}
