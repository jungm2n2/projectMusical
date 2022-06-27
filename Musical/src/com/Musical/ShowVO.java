package com.Musical;

public class ShowVO {
	
	private String title;
	private String actor1;
	private String actor2;
	private String[] time;
	private String[] date;
	
	
	public ShowVO() {
		
		
		
	}
	


	public ShowVO(String title, String actor1, String actor2, String[] time, String[] date) {
		super();
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.time = time;
		this.date = date;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getActor1() {
		return actor1;
	}





	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}





	public String getActor2() {
		return actor2;
	}





	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}





	public String[] getTime() {
		return time;
	}





	public void setTime(String[] time) {
		this.time = time;
	}





	public String[] getDate() {
		return date;
	}





	public void setDate(String[] date) {
		this.date = date;
	}





	@Override
	public String toString() {
		String str = String.format("%-12s %-4s %-5s %2s %5s %5s %5s %5s %5s",title,actor1,actor2,
				time[0],time[1],time[2],date[0],date[1],date[2]);
		
		return str;
	}
	

}
