package CompositeCine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlanningCinema extends PlanningComponent{
	
	
	ArrayList<PlanningComponent> planningComponents = new ArrayList<PlanningComponent>();



	@Override
	public void add(PlanningComponent planningComponent) {
		planningComponents.add(planningComponent);
	}
	

}
