package IteratorCine;

import java.util.ArrayList;

import CompositeCine.*;

public class EspanolCinemaPlanning implements Planning{
    private ArrayList<Film> films;

    public EspanolCinemaPlanning() {
        films = new ArrayList<Film>();

        addfilm("Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb", "An insane general triggers a path to nuclear holocaust that a war room","https://m.media-amazon.com/images/I/516BLiJwFdL._AC_.jpg","Comédie","12/06/2022","19:00");
        addfilm("Star Trek", "The brash James T. Kirk tries to live up to his father's legacy with M","https://cdn.europosters.eu/image/750/posters/star-trek-discovery-next-adventure-i72536.jpg","Adventure","12/06/2022","20:00");
    }

    public void addfilm(String title, String description, String poster, String type, String date, String time) {
        Film f = new Film(title, description, poster, type, date, time);
        films.add(f);
    }


    public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new EspanolCinemaIterator(films);
	}
    //other code that relies on ArrayList
}
