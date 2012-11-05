package metamodel.port;



/**
 * @author Alain MARGUERITE
 * @author Romain RINCÉ
 */
public abstract class Port<T>{

	private String name;

	public Port(String string) {
		this.name = string;
	}
	
	public abstract void attachement();


	public String getName() {
		return name;
	}

}
