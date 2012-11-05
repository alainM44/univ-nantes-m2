import java.util.ArrayList;


public class main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Sensor s1 = new Sensor("s1");
		Sensor s2 = new Sensor("s2");
		Sensor s3 = new Sensor("s3");
		
		Camera c1 = new Camera("c1");
		Camera c2 = new Camera("c2");
		Camera c3 = new Camera("c3");
		
		ArrayList<SCMediator> SCMs = new ArrayList<SCMediator>();
		SCMs.add(new SCMediator(s1, c1));
		SCMs.add(new SCMediator(s2, c1));
		SCMs.add(new SCMediator(s2, c2));
		SCMs.add(new SCMediator(s3, c2));
		SCMs.add(new SCMediator(s3, c3));
		
		s2.detect();
		s1.detect();
		s3.detect();
		s1.detect();
	}
	
}
