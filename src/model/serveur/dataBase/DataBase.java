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

package model.serveur.dataBase;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.propiete.Propriete;

/**
 * Classe décrivant un composant ayant le rôle d'une base de données
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Composant
 */
public class DataBase extends Composant {

	private ArrayList<String> listeAdmis;
	private HashMap<String, String> database;

	public DataBase(String name, InterfaceComposant requis,
			InterfaceComposant fourni, HashMap<String, Propriete> proprietes) {
		super(name, requis, fourni, proprietes);

		// liste des utlilisateurs autorisés
		listeAdmis = new ArrayList<String>();
		listeAdmis.add("Admin");
		listeAdmis.add("toto");

		// Contenu de la base de donnée
		database = new HashMap<String, String>();
		database.put("dans quel", "etat gere");
		database.put("qui est lenemi", "un fou");
		database.put("pourquoi lenemi est fou",
				"il croit que l ennemi c est vous alors que l ennemi c est lui");
		database.put(
				"Rech.proj.pr.proj.priv.selfdef.dem.brut.poss.S'adr.a.lhôt.Mar.",
				"Et plus si affinites");
		database.put("reponse?", "42");
		database.put("1+1", "2");
		database.put("2+2", "4");
		database.put("bonjour", "au revoir!");

	}

	public boolean isAdmis(String name) {
		return listeAdmis.contains(name);
	}

	public String getValueInDatabase(String requete) {
		return database.get(requete);
	}

}
