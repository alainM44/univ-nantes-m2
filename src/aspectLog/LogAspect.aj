package aspectLog;

public aspect LogAspect { 
	pointcut logRetrait() 
	: execution(* com.objis.demoaspectj.banque.CompteBancaire.retrait(..));

	before() : logRetrait() { 
		System.out.println("Avant le retrait"); 
	} 

	after() : logRetrait() { 
		System.out.println("Après le retrait"); 
	} 
}