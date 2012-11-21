package model.serveur.configurationServer;

import java.util.HashMap;



import metamodel.composant.Composant;
import metamodel.configuration.Configuration;
import metamodel.configuration.Couple;
import metamodel.configuration.InterfaceConfig;
import metamodel.connecteur.Connecteur;
import metamodel.propiete.Propriete;


public class ConfigurationServer extends Configuration {

	public ConfigurationServer(HashMap<String, Couple> bindings,
			HashMap<String, Composant> composants,
			InterfaceConfig interfacesConfigsR,
			InterfaceConfig interfacesConfigsF,
			HashMap<String, Connecteur> connecteurs,
			HashMap<String, String> attachements,
			HashMap<String, Propriete> proprietes) {
		super(bindings, composants, interfacesConfigsR, interfacesConfigsF,
				connecteurs, attachements, proprietes);
		// TODO Auto-generated constructor stub
	}



//	public ConfigurationServer(String name){
//		
//		 new composite
//		return new Configuration(composite, bindings, composants, interfacesConfigsR, interfacesConfigsF, connecteurs, attachements, serviceOrientation);
//	}

}
