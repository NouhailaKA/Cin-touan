package IteratorCine;

import CompositeCine.*;

public class AvenidaCinemaIterator implements Iterator{
	
    Film[] films;
    int position = 0;

    public AvenidaCinemaIterator(Film[] films) {
        this.films = films;
    }

    public Film next() {
        Film film = films[position];
        position = position + 1;
        return film;
    }

    public boolean hasNext() {
        if (position >= films.length || films[position] == null) {
            return false;
        } else {
            return true;
        }
    }

}
