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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 *         Classe d'un client de serveur de messagerie
 *         <p>
 *         Compilation : pour le serveur avec Eclipse par exemple. Le client se
 *         placer dans le dossier du projet pui
 *         <tt> javac src/main/RmiClient.java src/main/RmiServerIntf.java<tt>
 *         </p>
 *         <p>
 *         Pour executer Le serveur Avec Eclipse Le client : cd bin/ java
 *         main.RmiClient
 *         </p>
 * 
 * 
 */

public class RmiClient {
	/** "server" is the reference of the remote object */
	RmiServerIntf server = null;
	/** client username */
	private static String username;
	/** client password */
	private static String password;

	public String getMessage() {
		try {
			server = (RmiServerIntf) Naming.lookup("//localhost/RmiServer");
			return server.getMessage();
		} catch (Exception e) {
			System.err.println("RmiClient exception: " + e);
			e.printStackTrace();

			return e.getMessage();
		}
	}

	public static void main(String args[]) throws RemoteException {
		System.setProperty("java.security.policy",
				"file:///home/alain/workspace/SCP_TP2_Mess/no.policy");
		// Create and install a security manager
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());

		RmiClient cli = new RmiClient();

		System.out.println("***************************************");
		System.out.println("********Messagerie instantanée*********");
		System.out.println("***************************************");
		System.out.print("Connexion au serveur:");
		System.out.println(cli.getMessage());
		System.out.print("Username :");
		username = RmiClient.lireString();
		System.out.print("Password :");
		password = RmiClient.lireString();
		if (!cli.server.ConnexionRequets(username, password))
			System.out.println("Erreur de connexion");
		System.out.println("Vous êtes connecté au serveur de messagerie");
		
		System.out.println(cli.server.displayMembersList());
	}

	/**
	 * 
	 * @return ligne saisie sur l'entrée standard
	 */
	public static String lireString() {// lecture d'une chaine
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		return ligne_lue;
	}

	public static double lireDouble() {// lecture d'un double
		double x = 0; // valeur à lire
		try {
			String ligne_lue = lireString();
			x = Double.parseDouble(ligne_lue);
		} catch (NumberFormatException err) {
			System.out.println("***Erreur de données Double attendu***");
			System.exit(0);
		}
		return x;
	}

}