package aspectLog;

import metamodel.service.Service;

public aspect LogAspect { 	
	

	pointcut executeService(Service service) : call(void metamodel.service.Service.execute())&& target(service);
	before(Service service): executeService(service){
		System.out.println("execution du servive :"+service.toString());
	}
}