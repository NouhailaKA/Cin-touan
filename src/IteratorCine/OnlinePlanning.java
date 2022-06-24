package IteratorCine;

import java.util.ArrayList;
import java.util.List;

import CompositeCine.*;

public class OnlinePlanning {
	
    private PlanningCinema plan;
    
    
    
    public OnlinePlanning(PlanningCinema a) {
		this.plan = a;
	}

    
    public List<Film> ListFilm(Iterator iterator) {
    	List<Film> listFilm = new ArrayList<Film>();
        while (iterator.hasNext()){
        	listFilm.add((Film) iterator.next());
        }
		return listFilm;
    }
    

}
