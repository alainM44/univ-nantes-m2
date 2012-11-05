import java.util.ArrayList;
import java.util.List;

public aspect SensorExtension
{
	List<SCMediator> Sensor.mediators = new ArrayList<SCMediator>();

	void Sensor.addMediator(SCMediator m)
	{
		m.setS(this);
	}
	
	after(Sensor s):
		execution(* Sensor.detect()) && this(s){
		System.out.println("chat");
		for(SCMediator m : s.mediators)
			m.onDetect();
	}
}
