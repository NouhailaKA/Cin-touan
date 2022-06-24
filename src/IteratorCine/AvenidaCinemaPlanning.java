package IteratorCine;

import CompositeCine.*;

public class AvenidaCinemaPlanning implements Planning{

	static final int MAX_ITEMS = 100;
    int numberOfFilms = 0;
    private Film[] films;
    
    

    public AvenidaCinemaPlanning() {
    	films = new Film[MAX_ITEMS];

        addfilm("A Million Ways to Die in the West", "While it offers a few laughs and boasts a talented cast, Seth MacFarla…","https://m.media-amazon.com/images/M/MV5BMTQ0NDcyNjg0MV5BMl5BanBnXkFtZTgwMzk4NTA4MTE@._V1_.jpg","Movie","12/06/2022","17:00");
        addfilm("Wild Wild West", "The two best hired guns in the West must save President Grant from the clutches of a nineteenth-century inventor-villain.","https://images-na.ssl-images-amazon.com/images/S/pv-target-images/997dcaf438a8ef32949e44126ef5815df6898bc6fa14e579b03bd93852a8701c._RI_V_TTW_.jpg","Movie","12/06/2022","19:00");
        addfilm("West Side Story", "Two youngsters from rival New York City gangs fall in love, but tensions between their respective friends build toward tragedy.","https://c8.alamy.com/compfr/f2wex8/west-side-story-film-poster-f2wex8.jpg","Movie","12/06/2022","20:00");

	}



    private void addfilm(String title, String description, String poster, String type, String date, String time)  {
        Film film = new Film(title, description, poster, type, date, time);
        if (numberOfFilms >= MAX_ITEMS) {
            System.err.println("Sorry we only allow 100 films per week ");
        } else {
            films [numberOfFilms] =  film;
            numberOfFilms += 1;
        }
    }

    
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new AvenidaCinemaIterator(films);
	}

}
