package com.Musical;

import java.io.Serializable;

public class TitleVO implements Serializable{
	
	private String title;
	private String actorCombi1;
	private String actorCombi2;
	private String[] time;
	private String[] date;
	private int curReservationsNumber;
	private int maxReservationsNumber;
	private String[] stateOfSeat;
	private int cost;
	private int totalSales;
	
	public TitleVO() {
		curReservationsNumber = 0;
		maxReservationsNumber = 9;
		stateOfSeat = new String[9];
		for (int i = 0; i < maxReservationsNumber; i++) {
			stateOfSeat[i] = String.valueOf(i + 1);
		}
	}
	
	public TitleVO(String title, String actor1, String actor2, String[] time, String[] date, int cost) {
		super();
		this.title = title;
		this.actorCombi1 = actor1;
		this.actorCombi2 = actor2;
		this.time = time;
		this.date = date;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getActorCombi1() {
		return actorCombi1;
	}

	public void setActorCombi1(String actorCombi1) {
		this.actorCombi1 = actorCombi1;
	}

	public String getActorCombi2() {
		return actorCombi2;
	}

	public void setActorCombi2(String actorCombi2) {
		this.actorCombi2 = actorCombi2;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCurReservationsNumber() {
		return curReservationsNumber;
	}

	public void setCurReservationsNumber(int curReservationNumber) {
		this.curReservationsNumber = curReservationNumber;
	}

	public int getMaxReservationsNumber() {
		return maxReservationsNumber;
	}

	public void setMaxReservationsNumber(int maxReservationNumber) {
		this.maxReservationsNumber = maxReservationNumber;
	}

	public String[] getStateOfSeat() {
		return stateOfSeat;
	}

	public void setStateOfSeat(String[] stateSeat) {
		this.stateOfSeat = stateSeat;
	}
	
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales += totalSales;
	}

	@Override
	public String toString() {
		String str = String.format("%-12s %-4s %-5s %2s %5s %5s %5s %5s %5s %d %d",title,actorCombi1,actorCombi2,
				time[0],time[1],time[2],date[0],date[1],date[2],cost, totalSales);
		
		return str;
	}

}
