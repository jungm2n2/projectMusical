package com.Musical;

import java.io.Serializable;

public class BookTicketVO implements Serializable {
	String title;
	String actor;
	String date;
	String time;
	int cost;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		String str = String.format("%s %s %s %s %d ", title, actor, date, time, cost);
		return str;
	}
	
	
}
