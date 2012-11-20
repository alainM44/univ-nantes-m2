package metamodel.configuration;


public class Couple {

	private String name;
	private String composant;
	private String FouR;
	
	
	public Couple(String name, String composant,String FouR) {
		super();
		this.FouR=FouR;
		this.name = name;
		this.composant = composant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
