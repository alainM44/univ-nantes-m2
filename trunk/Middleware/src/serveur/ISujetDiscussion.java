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
 *         Interface décrivant le comportement d'un sujet de discussion Sujet de
 *         Discussion.
 * @see SujetDiscussion
 * @see UnicastRemoteObject
 */
public interface ISujetDiscussion extends Remote {
	/**
	 * Inscrire un client au sujet de Discussion
	 * 
	 * @param c
	 *            IHM du client à inscire
	 * @throws RemoteException
	 */
	public void inscription(IAffichageClient c) throws RemoteException;

	/**
	 * Désinscrire un client au sujet de Discussion
	 * 
	 * @param c
	 *            IHM du client à inscire
	 * @throws RemoteException
	 */
	public void desInscription(IAffichageClient c) throws RemoteException;

	/**
	 * 
	 * @param Message
	 *            Message à diffuser
	 * @throws RemoteException
	 */
	public void diffuse(String Message) throws RemoteException;

	/**
	 * 
	 * @return String le titre du sujet
	 * @throws RemoteException
	 */
	public String getTitre() throws RemoteException;
}
