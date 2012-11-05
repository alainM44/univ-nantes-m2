import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Camera extends Observable
{
	String name;
	List<Sensor> sensors;
	
	public Camera(String name)
	{
		super();
		this.name = name;
		sensors = new ArrayList<Sensor>();
	}

	void addSensor(Sensor sensor)
	{
		sensors.add(sensor);
	}

	void click()
	{
		System.out.println(name +" click");
//		setChanged();
//		notifyObservers();
	}
}
