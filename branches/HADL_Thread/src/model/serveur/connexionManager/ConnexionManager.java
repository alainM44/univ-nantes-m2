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

package model.serveur.connexionManager;

import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import metamodel.composant.Composant;
import metamodel.composant.InterfaceComposant;
import metamodel.propiete.Propriete;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 *
 */
public class ConnexionManager extends Composant {

	private boolean autentified;
	private String requete;
	private String databaseValue;
	private String clientName;
	
	
	protected HashMap<String, Boolean> clientsAuthenticated;

	public ConnexionManager(String name, InterfaceComposant requis,
			InterfaceComposant fourni, HashMap<String, Propriete> proprietes) {
		super(name, requis, fourni, proprietes);
		autentified = false;
		databaseValue = null;
		clientName =null;
		clientsAuthenticated =new HashMap<String, Boolean>();
		setRequete(null);

	}

	/**
	 * @return the autentified
	 */
	protected boolean isAutentified() {
		return autentified;
	}

	/**
	 * @param autentified the autentified to set
	 */
	protected void setAutentified(boolean autentified) {
		this.autentified = autentified;
	}

	/**
	 * @return the databaseValue
	 */
	protected String getDatabaseValue() {
		return databaseValue;
	}

	/**
	 * @param databaseValue the databaseValue to set
	 */
	protected void setDatabaseValue(String databaseValue) {
		this.databaseValue = databaseValue;
	}

	/**
	 * @return the clientName
	 */
	protected String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	protected void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the requete
	 */
	public String getRequete() {
		return requete;
	}

	/**
	 * @param requete the requete to set
	 */
	public void setRequete(String requete) {
		this.requete = requete;
	}

}
