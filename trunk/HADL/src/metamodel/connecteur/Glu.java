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

import java.util.Observable;
import java.util.Observer;

import org.omg.PortableInterceptor.ObjectReferenceFactory;

import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.RoleF;
import metamodel.role.RoleR;

/**
 * Classe décrivant le comportement d'une glu
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * @see Observable
 * @see Observer
 */
public abstract class Glu extends Observable implements Observer {

	private RoleR roleR;
	private RoleF roleF;

	public Object getValueInPortR(String name) {
		return roleR.getService().getValueInPortR(name);
	}



	public void setValueInPortF(Object e,String namePort){
		roleF.getService().setValueInPortF(e, namePort);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		execute();
	}

	public Glu(RoleR roleR, RoleF roleF) {
		super();
		this.roleR = roleR;
		this.roleF = roleF;
		roleR.addObserver(this);
	}

	/**
	 *  Action de la glue Le client DOIT appeller setPortF
	 */
	public abstract void action();

	public void execute() {
		action();
		notifyObservers(roleF);
	}

}
