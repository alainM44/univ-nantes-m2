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

package metamodel.configuration;

/**
 * Classe décrivant un couple service composant et l'orientation de celui ci
 *
 */
public class Couple {

	private String service;
	private String composant;
	private String FouR;
	
	
	public Couple(String service, String composant,String FouR) {
		super();
		this.FouR=FouR;
		this.service = service;
		this.composant = composant;
	}
	public String getService() {
		return service;
	}
	public void setService(String name) {
		this.service = name;
	}
	public String getComposant() {
		return composant;
	}
	public void setComposant(String composant) {
		this.composant = composant;
	}
		public String getFouR() {
			return FouR;
	}
	public void setFouR(String fouR) {
		FouR = fouR;
	}
	
	
	
}
