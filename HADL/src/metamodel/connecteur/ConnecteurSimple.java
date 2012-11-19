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
	private Glu gluNS;
	private Glu gluSN;

	public ConnecteurSimple(Glu gluNS, Glu gluSN) {
		super();
		this.gluNS = gluNS;
		this.gluSN = gluSN;
	}

	public Glu getGluNS() {
		return gluNS;
	}

	public void setGluNS(Glu gluNS) {
		this.gluNS = gluNS;
	}

	public Glu getGluSN() {
		return gluSN;
	}

	public void setGluSN(Glu gluSN) {
		this.gluSN = gluSN;
	}

}
