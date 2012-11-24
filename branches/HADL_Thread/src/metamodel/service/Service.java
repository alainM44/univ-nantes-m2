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

package metamodel.service;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import metamodel.composant.Composant;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.role.RoleF;
import metamodel.role.RoleR;

/**
 * Classe décrivant un service
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */

public abstract class Service extends Observable implements Observer {

	private String name;

	protected HashMap<String, PortR> portR;
	protected HashMap<String, PortF> portF;

	protected RoleR roler;
	protected RoleF rolef;

	protected Service bindService;

	private Composant parentComposant;

	public Service(String name, HashMap<String, PortR> portR,
			HashMap<String, PortF> portF) {
		super();
		this.name = name;
		this.portR = portR;
		this.portF = portF;

	}

	public abstract void action();

	public void execute() {
		System.out.println(name + " execute");
		if (bindService == null) {

			action();
			setChanged();
			notifyObservers();// TODO

			// try {
			// wait();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else {
			bindService.setPortF(portF);
			bindService.action();
			setPortR(bindService.getPortR());
			setChanged();
			notifyObservers();
			// try {
			// bindService.wait();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, PortR> getPortR() {
		return portR;
	}

	public void setPortR(HashMap<String, PortR> portR) {
		this.portR = portR;
	}

	public HashMap<String, PortF> getPortF() {
		return portF;
	}

	public void setPortF(HashMap<String, PortF> portF) {
		this.portF = portF;
	}

	public RoleR getRoler() {
		return roler;
	}

	public void setRoler(RoleR roler) {
		this.roler = roler;
	}

	public RoleF getRolef() {
		return rolef;
	}

	public void setRolef(RoleF rolef) {
		rolef.addObserver(this);
		this.rolef = rolef;
	}

	public PortR getPortR(String name2) {
		return portR.get(name2);
	}

	public PortF getPortF(String name2) {
		return portF.get(name2);
	}

	public Object getValueInPortF(String name2) {
		return portF.get(name2).getValue();
	}

	public Object getValueInPortR(String name2) {
		return portR.get(name2).getValue();
	}

	public void setValueInPortF(Object e, String name2) {
		portF.get(name2).setValue(e);
	}

	public void setValueInPortR(Object e, String name2) {
		portR.get(name2).setValue(e);
	}

	public Service getBindService() {
		return bindService;
	}

	public void setBindService(Service bindService) {
		this.bindService = bindService;
	}

	/**
	 * @return the parentComposant
	 */
	public Composant getParentComposant() {
		return parentComposant;
	}

	/**
	 * @param parentComposant
	 *            the parentComposant to set
	 */
	public void setParentComposant(Composant parentComposant) {
		this.parentComposant = parentComposant;
	}

	public void callService(String serviceName) {
		Service calledService = parentComposant.getService(serviceName);
//		synchronized (calledService) {
//			calledService.execute();
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	calledService.execute();
	}

}
