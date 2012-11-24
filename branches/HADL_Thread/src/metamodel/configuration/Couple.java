package metamodel.configuration;


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
