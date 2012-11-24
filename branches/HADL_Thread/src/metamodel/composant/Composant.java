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
package metamodel.composant;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import metamodel.propiete.Propriete;
import metamodel.service.Service;

/**
 * 
 * Classe décrivant un composant (pattern composite)
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 * 
 */
public class Composant extends Observable implements Observer {
	private String name;
	private InterfaceComposant requis;
	private InterfaceComposant fourni;
	private HashMap<String, Propriete> proprietes;

	public Composant(String name, InterfaceComposant requis, InterfaceComposant fourni,
			HashMap<String, Propriete> proprietes) {
		super();
		this.name=name;
		this.requis = requis;
		this.fourni = fourni;
		this.proprietes = proprietes;
		
		//On indique à tous les services du composants le composant parent soit this
		for(String serviceName : this.requis.services.keySet())
		{
			Service service = this.requis.services.get(serviceName);
			service.setParentComposant(this);
			service.addObserver(this);
		}
		for(String serviceName : this.fourni.services.keySet())
		{
			Service service = this.fourni.services.get(serviceName);
			service.setParentComposant(this);
			service.addObserver(this);
		}
	}

	public InterfaceComposant getRequis() {
		return requis;
	}

	public void setRequis(InterfaceComposant requis) {
		this.requis = requis;
	}

	public InterfaceComposant getFourni() {
		return fourni;
	}

	public void setFourni(InterfaceComposant fourni) {
		this.fourni = fourni;
	}

	public HashMap<String, Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(HashMap<String, Propriete> proprietes) {
		this.proprietes = proprietes;
	}

	public String getName() {
		return name;
	}
	
	public Service getService(String serviceName)
	{
		if(requis.hasService(serviceName))
		return requis.getService(serviceName);
		else if(fourni.hasService(serviceName))
			return fourni.getService(serviceName);
		else return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(((Service) o).getName());
		deleteObservers();
	}

}
