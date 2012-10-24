/*   This file is part of FormalSoftwareProject.

 FormalSoftwareProject is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 FormalSoftwareProject is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with FormalSoftwareProject.  If not, see <http://www.gnu.org/licenses/>
 */

package ia;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface de de l'objet remote
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 * @see Remote
 */
public interface IIA extends Remote {

	/**
	 * Signal que le client est passé dans l'état 2
	 * 
	 * @throws RemoteException
	 */
	public void sendBegin() throws RemoteException;

	/**
	 * Signal que le client est passé dans l'état 1
	 * 
	 * @throws RemoteException
	 */
	public void sendEnd() throws RemoteException;

	/**
	 * Signal que le client est passé dans l'état 3
	 * 
	 * @throws RemoteException
	 */
	public void sendData() throws RemoteException;

	
	/**
	 * Signal que le client est passé dans l'état 4
	 * 
	 * @throws RemoteException
	 */
	public String whatCanIDo() throws RemoteException, InterruptedException;

}
