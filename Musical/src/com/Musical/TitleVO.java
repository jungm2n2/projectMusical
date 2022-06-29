package com.Musical;

public class TitleVO {
	
	private String title;
	private String actor1;
	private String actor2;
	private String[] time;
	private String[] date;
	private int curReservationNumber;
	private int maxReservationNumber;
	private String[] stateSeat;
	private int cost;
	private int totalCost;
	
	public TitleVO() {
		curReservationNumber = 0;
		maxReservationNumber = 9;
		stateSeat = new String[9];
		for (int i = 0; i < maxReservationNumber; i++) {
			stateSeat[i] = String.valueOf(i + 1);
		}
		
		
	}
	
	public TitleVO(String title, String actor1, String actor2, String[] time, String[] date, int cost) {
		super();
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCurReservationNumber() {
		return curReservationNumber;
	}

	public void setCurReservationNumber(int curReservationNumber) {
		this.curReservationNumber = curReservationNumber;
	}

	public int getMaxReservationNumber() {
		return maxReservationNumber;
	}

	public void setMaxReservationNumber(int maxReservationNumber) {
		this.maxReservationNumber = maxReservationNumber;
	}

	public String[] getStateSeat() {
		return stateSeat;
	}

	public void setStateSeat(String[] stateSeat) {
		this.stateSeat = stateSeat;
	}
	
	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost += totalCost;
	}

	@Override
	public String toString() {
		String str = String.format("%-12s %-4s %-5s %2s %5s %5s %5s %5s %5s %d %d",title,actor1,actor2,
				time[0],time[1],time[2],date[0],date[1],date[2],cost, totalCost);
		
		return str;
	}
}
