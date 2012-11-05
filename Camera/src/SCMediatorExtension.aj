


public aspect SCMediatorExtension {


	
	after(SCMediator m, Camera c ):
		execution(* SCMediator.setC(Sensor)) && this(c) && this(m) {
//		s.mediators.add(m);
//		c.mediators.add(m);
	}
	
}
