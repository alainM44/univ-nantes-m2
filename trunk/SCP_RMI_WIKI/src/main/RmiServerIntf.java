/*   This file is part of IMessRmITP.

    IMessRmITP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    IMessRmITP is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with IMessRmITP.  If not, see <http://www.gnu.org/licenses/>
 */

package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Interface de l'objet distant. Elle doit être connue par le client
 * 
 */

public interface RmiServerIntf extends Remote {
	/**
	 * Première tentative dHello World. La connexion concrète entre le serveur
	 * et le client s'y trouve pour linstant
	 * 
	 * @return string de test
	 * @throws RemoteException
	 */
	public String getMessage() throws RemoteException;

	/**
	 * 
	 * @param login
	 *            username du client
	 * @param mdp
	 *            mot de passe du client
	 * @return boolean reponse a la requete de connexion
	 * @throws RemoteException
	 */
	public boolean ConnexionRequets(String login, String mdp)
			throws RemoteException;

	/**
	 * 
	 * @return Affichage en console de la liste des membres
	 */
	public String displayMembersList()throws RemoteException;
	
//	public String diffuse(String sentence);
}