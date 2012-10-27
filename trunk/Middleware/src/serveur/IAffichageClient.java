/*   This file is part of ForumRMI.

    ForumRMI is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ForumRMI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ForumRMI.  If not, see <http://www.gnu.org/licenses/>
 */

package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Interface décrivant le comportement de l'affichage d'un client. le
 *         serveur doit en avoir connaissance
 * 
 * @see UnicastRemoteObject
 * 
 */
public interface IAffichageClient extends Remote {
	/**
	 * Afficher un message texte
	 * 
	 * @param message
	 *            String à afficher sur l'IHM du client
	 * @throws RemoteException
	 */
	public void affiche(String message) throws RemoteException;



}
