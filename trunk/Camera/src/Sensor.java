import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Sensor extends Observable
{
	String name;
	List<Camera> cameras;

	public Sensor(String name)
	{
		super();
		this.name = name;
		cameras = new ArrayList<Camera>();
	}
	
	void addCamera(Camera camera)
	{
		cameras.add(camera);
	}

	void detect()
	{
		System.out.println(name+" detect");
//		setChanged();
//		notifyObservers();
	}

	void reset()
	{
		System.out.println(name + " reset");
		/* remise a zero */
	}
}
