package IteratorCine;

import java.util.ArrayList;

import CompositeCine.*;

public class EspanolCinemaIterator implements Iterator{
	
	ArrayList<Film> films;
	int position = 0;
	
	public EspanolCinemaIterator(ArrayList<Film> films) {
		super();
		this.films = films;
	}

	@Override
	public boolean hasNext() {
		if (position >= films.size()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Object object = films.get(position);
		position = position + 1;
		return object;
	}

}
