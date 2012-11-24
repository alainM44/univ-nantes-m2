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

package metamodel.connecteur;

/**
 * Classe décrivant un connecteur simple (pattern composite)
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Connecteur
 */
public class ConnecteurSimple extends Connecteur {
	private Glu gluFtoR;
	private Glu gluRtoF;


	public ConnecteurSimple(String name, InterfaceConnecteur irequise,
			InterfaceConnecteur ifournie, Glu gluFtoR, Glu gluRtoF) {
		super(name, irequise, ifournie);
		this.gluFtoR = gluFtoR;
		this.gluRtoF = gluRtoF;
	}
	public Glu getGluFtoR() {
		return gluFtoR;
	}
	public void setGluFtoR(Glu gluFtoR) {
		this.gluFtoR = gluFtoR;
	}
	public Glu getGluRtoF() {
		return gluRtoF;
	}
	public void setGluRtoF(Glu gluRtoF) {
		this.gluRtoF = gluRtoF;
	}





}
