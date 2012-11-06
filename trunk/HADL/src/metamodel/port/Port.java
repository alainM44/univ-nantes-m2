package metamodel.port;

import metamodel.role.Role;



/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public abstract class Port<T>{

	private String name;
	private Role role;

	public Port(String string) {
		this.name = string;
	}
	
	public abstract void attachement();


	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
