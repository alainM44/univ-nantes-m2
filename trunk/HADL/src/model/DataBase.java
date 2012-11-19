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

package model;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.port.Port;
import metamodel.propiete.Propriete;
import metamodel.propiete.ProprieteFonc;
import metamodel.service.Service;

import composant.Composant;
import composant.InterfaceComposant;

public class DataBase extends Composant {

	public DataBase(InterfaceComposant requis, InterfaceComposant fourni,
			HashMap<String, Propriete> proprietes) {
		super(requis, fourni, proprietes);
		// TODO Auto-generated constructor stub
	}




}
