import java.util.ArrayList;
import java.util.List;


public aspect CameraExtension {
	List<SCMediator> Camera.mediators = new ArrayList<SCMediator>();

	void Camera.addMediator(SCMediator m)
	{
		m.setC(this);
	}
	
	after(Camera c):
		execution(* Camera.click()) && this(c){
		for(SCMediator m : c.mediators)
			m.onClick();
	}
}
