import java.util.Observable;
import java.util.Observer;

public class SCMediator// implements Observer
{
	private Sensor s;
	private Camera c;

	public void setS(Sensor s)
	{
//		this.s.deleteObserver(this);
		this.s = s;
		// s.addObserver(this);
	}

	public void setC(Camera c)
	{
//		this.c.deleteObserver(this);
		this.c = c;
		// c.addObserver(this);
	}

	public SCMediator(Sensor s, Camera c)
	{
		super();
		this.s = s;
		this.c = c;
		// c.addObserver(this);
		// s.addObserver(this);
	}

	void onDetect()
	{
		c.click();
	}

//	@Override
//	public void update(Observable arg0, Object arg1)
//	{
//		if (arg0 instanceof Camera)
//			s.reset();
//		else if (arg0 instanceof Sensor)
//			c.click();
//
//	}

	public void onClick()
	{
		s.reset();
		
	}
}
