package model.connecteurRPC;

import metamodel.connecteur.ConnecteurSimple;
import metamodel.connecteur.Glu;
import metamodel.connecteur.InterfaceConnecteur;

public class ConnecteurRPC extends ConnecteurSimple {

	public ConnecteurRPC(String name, InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(name, irequise, ifournie, gluFtoR, gluRtoF);
		// TODO Auto-generated constructor stub
	}

}
