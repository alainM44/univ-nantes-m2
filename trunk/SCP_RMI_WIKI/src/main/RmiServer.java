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

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
public class RmiServer extends UnicastRemoteObject implements RmiServerIntf {
	public static final String MESSAGE = "Hello world";
	public static HashMap<String, String> MembresLogin = new HashMap<String, String>();
	static {
		MembresLogin.put("toto", "toto");
		MembresLogin.put("tata", "tata");
	}
	public static ArrayList<String> MembresConnectes = new ArrayList<String>();
	static {
		MembresLogin.put("toto", "toto");
		MembresLogin.put("tata", "tata");
	}

	public RmiServer() throws RemoteException {
	}

	public String getMessage() {
		return MESSAGE;
	}

	public static void main(String args[]) {
		System.out.println("RMI server started");
		System.setProperty("java.security.policy",
				"file:///home/alain/workspace/SCP_TP2_Mess/no.policy");

		// Create and install a security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Security manager installed.");
		} else {
			System.out.println("Security manager already exists.");
		}

		try { // special exception handler for registry creation
			LocateRegistry.createRegistry(1099);
			System.out.println("java RMI registry created.");
		} catch (RemoteException e) {
			// do nothing, error means registry already exists
			System.out.println("java RMI registry already exists.");
		}

		try {
			// Instantiate RmiServer
			RmiServer obj = new RmiServer();

			// Bind this object instance to the name "RmiServer"
			Naming.rebind("//localhost/RmiServer", obj);

			System.out.println("PeerServer bound in registry");
		} catch (Exception e) {
			System.err.println("RMI server exception:" + e);
			e.printStackTrace();
		}
	}

	public boolean ConnexionRequets(String login, String mdp)
			throws RemoteException {
		// client connu ?
		boolean result = MembresLogin.get(login).equals(mdp);

		if (result)
			MembresConnectes.add(login);
		return result;
	}

	@Override
	public String displayMembersList() {
		return MembresConnectes.toString();
	}

}