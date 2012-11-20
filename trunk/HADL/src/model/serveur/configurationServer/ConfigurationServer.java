package model;

import java.util.HashMap;



import metamodel.connecteur.Connecteur;

import composant.Composant;
import composant.Composite;

import configuration.Configuration;
import configuration.InterfaceConfig;

public class ConfigurationServer extends Configuration {

	public ConfigurationServer(Composite composite,
			HashMap<String, Binding> bindings,
			HashMap<String, Composant> composants,
			InterfaceConfig interfacesConfigsR,
			InterfaceConfig interfacesConfigsF,
			HashMap<String, Connecteur> connecteurs,
			HashMap<String, String> attachements,
			HashMap<String, String> serviceOrientation) {
		
//		HashMap<String, Composant> composantss;
		super(composite, bindings, composants, interfacesConfigsR, interfacesConfigsF,
				connecteurs, attachements, serviceOrientation);
		// TODO Auto-generated constructor stub
	}

	public ConfigurationServer(String name){
		
//		 new composite
//		return new Configuration(composite, bindings, composants, interfacesConfigsR, interfacesConfigsF, connecteurs, attachements, serviceOrientation);
	}

}
