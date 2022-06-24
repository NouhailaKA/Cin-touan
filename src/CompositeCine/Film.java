package CompositeCine;

import java.util.Iterator;


public class Film extends PlanningComponent{
	
	// Menu Item Implementation: Classic Data Holder
	
	protected String title;
	protected String description;
	protected String poster;
	protected String type;
	protected String date;
	protected String time;

	
	public Film(String title, String description, String poster, String type, String date, String time) {
		super();
		this.title = title;
		this.description = description;
		this.poster = poster;
		this.type = type;
		this.date = date;
		this.time = time;
	}

	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}



	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}



	@Override
	public String getPoster() {
		// TODO Auto-generated method stub
		return poster;
	}



	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}



	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}



	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return time;
	}




	public void print() {
		System.out.println(""+ getTitle());
		System.out.println(" Description :  "+getDescription());
		System.out.println("Lien Poster:  "+getPoster());
		System.out.println("Type Film :  "+getType());
		System.out.println("Date :  "+getDate());
		System.out.println("Time :  "+getTime());
	}
	

}
