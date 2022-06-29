package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookticketImpl implements Bookticket{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String currCustomer = null;
	String pickTitle = null;
	BookticketVO ph = new BookticketVO();
	HashMap<String, TitleVO> titleMap = null;

	public BookticketImpl(String pCustomer, HashMap<String, TitleVO> pTitleMap) {
		currCustomer = pCustomer;
		this.titleMap = pTitleMap;
	}

	public BookticketVO ViewMenu(){
		//회원정보를 받아와야함.
		//이 메서드가 예매버튼을 누르거나 예매 요청을 받는 거라고 생각하자.

		try {
			pickTitle = selectMusical();
			selectActor();
			selectDate();
			selectTime();
			selectSeat();
			payMoney();
		} catch (Exception e) {
			//TODO: handle exception
		}

		System.out.println();
		System.out.println();
		System.out.println("나의 예매 내역");
		System.out.println(ph.toString());

		return ph;
	}


	@Override
	public String selectMusical() {
		ArrayList<String> arrTitle = new ArrayList<>();
		System.out.println("===================================================================");
		System.out.println("                        <작품을 선택하세요>");
		System.out.println("===================================================================");

		int titleIdx = 1;

		for (String strKey : titleMap.keySet()) {
			System.out.println(titleIdx++ + ". " + strKey);
			arrTitle.add(strKey);
		}

		String selectedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);

		ph.setTitle(selectedTitle);
		System.out.println(selectedTitle + "을 선택하셨습니다.");

		return selectedTitle;
	}

	String inputSelect(){
		try {
			String inputValue = br.readLine();
			return inputValue;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	@Override
	public void selectActor() {
		System.out.println("===================================================================");
		System.out.println("                     <배우 조합을 선택하세요>");
		System.out.println("===================================================================");

		System.out.println("1. " + titleMap.get(pickTitle).getActor1());
		System.out.println("2. " + titleMap.get(pickTitle).getActor2());

		if(inputSelect().equals("1")) {
			ph.setActor(titleMap.get(pickTitle).getActor1());
		}
		else {
			ph.setActor(titleMap.get(pickTitle).getActor2());
		}
		System.out.println(ph.getActor() + "을 선택하셨습니다.");
	}


	public void selectDate() {
		select("날짜", titleMap.get(pickTitle).getDate());
	}

	@Override
	public void selectTime() {
		select("시간", titleMap.get(pickTitle).getTime());

	}

	public void select(String pStr, String[] pArr){
		System.out.println("===================================================================");
		System.out.println("                     <"+pStr + "을(를) 선택하세요>");
		System.out.println("===================================================================");

		int titleIdx = 1;

		for (String strKey : pArr) {
			System.out.println(titleIdx++ + ". " + strKey);
		}

		String selected = pArr[Integer.parseInt(inputSelect()) - 1];

		System.out.println(selected + "을 선택하셨습니다.");

		if(pStr.equals("날짜")){
			ph.setDate(selected);
		}
		else {
			ph.setTime(selected);
		}
	}

	@Override
	public void payMoney() {
		ph.setCost(titleMap.get(pickTitle).getCost());
		System.out.println("가격은 " + ph.getCost() + " 원 입니다.");
		System.out.println("결제 됐습니다.");
		titleMap.get(pickTitle).setTotalCost(ph.getCost());
	}

	//현재는 미구현 상태
	@Override
	public void selectSeat() {
		String[] seat = titleMap.get(pickTitle).getStateSeat();
		System.out.println("===================================================================");
		System.out.println("                      <좌석을 선택하세요>");
		System.out.println("===================================================================");
		seatDraw(seat);
		String selected;
		while(true) {
			
			selected = inputSelect();
			
			if(seat[Integer.valueOf(selected) - 1] == "■") {
				System.out.println("선택할 수 없는 좌석입니다.");
			}
			else {
				break;
			}
		}
		
		
		seat[Integer.valueOf(selected) - 1] = "■";

		System.out.println(selected + "번을 선택하셨습니다.");
		ph.setMySeat(selected);
	}

	void seatDraw(String[] pSeat){
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[0], pSeat[1], pSeat[2]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[3], pSeat[4], pSeat[5]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[6], pSeat[7], pSeat[8]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
	}

}
