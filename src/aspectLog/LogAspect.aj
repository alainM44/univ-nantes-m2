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
package aspectLog;

import metamodel.connecteur.Glu;
import metamodel.role.RoleF;
import metamodel.role.RoleR;
import metamodel.service.Service;

/**
 * Classe permettant la journalisation des différentes actions de l'application
 * HADL_Project
 * 
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public aspect LogAspect {
	pointcut executeService(Service service) : call(void metamodel.service.Service.execute())&& target(service);

	before(Service service): executeService(service){
		System.out.println("[TRACE] :  execution du service : "
				+ service.getName());
	}

	pointcut updateRoleR(RoleR r) : execution(* metamodel.role.RoleR.update(..)) && target(r);

	before(RoleR r): updateRoleR(r){
		System.out.println("[TRACE] :  execution du role requis  : " //TODO to fix
				+ r);
	}

	pointcut updateGlu(Glu g) : execution(* metamodel.connecteur.Glu.update(..)) && target(g);

	before(Glu g): updateGlu(g){
		System.out.println("[TRACE] :  execution d'une glu : " + g);//TODO to fix
	}

	pointcut updateRoleF(RoleF f) : execution(* metamodel.role.RoleF.update(..)) && target(f);

	before(RoleF f): updateRoleF(f){
		System.out.println("[TRACE] :  execution du role fournis  : "//TODO to fix
				+ f);
	}

	pointcut demandeConnexion(String name) : call(void model.client.ServiceRConnexionRPC.connexion(String)) && args(name);

	before(String name): demandeConnexion(name){
		System.out.println("[TRACE] :  Demande de connexion \n\t le login : "
				+ name);
	}

	pointcut demandeRequete(String name, String requete) : call(void model.client.ServiceRConnexionRPC.requete(String,String)) && args(name,requete);

	before(String name, String requete): demandeRequete(name,requete){
		System.out.println("[TRACE] :  Demande de requete  : \n\t login : "
				+ name + " \n\t requete : " + requete);
	}
}
