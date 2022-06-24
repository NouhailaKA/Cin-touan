package CompositeCine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class PlanningComponent {
	
	public String getTitle() {
		throw new UnsupportedOperationException();
	}
	
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	
	public String getPoster() {
		throw new UnsupportedOperationException();
	}
	
	public String getType() {
		throw new UnsupportedOperationException();
	}
	
	public String getDate() {
		throw new UnsupportedOperationException();
	}
	
	public String getTime() {
		throw new UnsupportedOperationException();
	}
	
	
	public void add(PlanningComponent planningComponent) {
		throw new UnsupportedOperationException();
	}	
	
}
