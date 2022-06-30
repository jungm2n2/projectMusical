package com.Musical;

import java.io.Serializable;
import java.util.ArrayList;


class DetailsInfo implements Serializable{
	
	private String actorPairs;
	private String date;
	private String time;
	private int maxReservationsNumber;
	private String[] stateOfSeat;
	private int cost;
	
	
	public DetailsInfo() {
		defaultSetting();
	}
	
	public DetailsInfo(String actorPairs, String date, String time, int maxReservationsNumber, String[] stateOfSeat, int cost) {
		this.actorPairs = actorPairs;
		this.date = date;
		this.time = time;
		this.maxReservationsNumber = maxReservationsNumber;
		this.stateOfSeat = stateOfSeat;
		this.cost = cost;
		defaultSetting();
	}
	public String getActorPairs() {
		return actorPairs;
	}
	public void setActorPairs(String actorPairs) {
		this.actorPairs = actorPairs;
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
	public int getMaxReservationsNumber() {
		return maxReservationsNumber;
	}
	public void setMaxReservationsNumber(int maxReservationsNumber) {
		this.maxReservationsNumber = maxReservationsNumber;
	}
	public String[] getStateOfSeat() {
		return stateOfSeat;
	}
	public void setStateOfSeat(String[] stateOfSeat) {
		this.stateOfSeat = stateOfSeat;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void defaultSetting(){
		maxReservationsNumber = 9;
		stateOfSeat = new String[9];
		for (int i = 0; i < maxReservationsNumber; i++) {
			stateOfSeat[i] = String.valueOf(i + 1);
		}
	}
	@Override
	public String toString() {
		String str = String.format("%-12s %-10s %-8s %d", actorPairs, date, time, cost);
		return str;
	}
}

public class TitleVO implements Serializable{
	
	private String title;
	
	ArrayList<DetailsInfo> info = null;
	
	private int totalSales;
	
	public TitleVO() {
	}
	
	public TitleVO(String title, ArrayList<DetailsInfo> pInfo) {
		this.title = title;
		info = pInfo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales += totalSales;
	}

	public ArrayList<DetailsInfo> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<DetailsInfo> info) {
		this.info = info;
	}

	public void printInfo() {
		System.out.println(title + "의 공연 정보입니다.");
		
		int idx = 1;
		for (DetailsInfo detailsInfo : info) {
			System.out.println((idx++) + " " + detailsInfo.toString());
		}
	}
}
