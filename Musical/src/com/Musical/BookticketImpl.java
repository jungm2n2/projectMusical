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
	BookTicketVO ph = new BookTicketVO();
	HashMap<String, TitleVO> titleMap = null;
	
	public BookticketImpl(String pCustomer, HashMap<String, TitleVO> pTitleMap) {
		currCustomer = pCustomer;
		this.titleMap = pTitleMap;
	}

	public BookTicketVO ViewMenu(){
		//회원정보를 받아와야함.
		//이 메서드가 예매버튼을 누르거나 예매 요청을 받는 거라고 생각하자.
		
		pickTitle = selectMusical();
		selectActor();
		selectDate();
		selectTime();
		payMoney();
		
		System.out.println();
		System.out.println();
		System.out.println("나의 예매 내역");
		System.out.println(ph.toString());
		
		return ph;
	}


	@Override
	public String selectMusical() {
		try {

			ArrayList<String> arrTitle = new ArrayList<>();
			System.out.println("작품을 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedTitle = arrTitle.get(Integer.parseInt(inputValue) - 1);
			
			ph.setTitle(seletedTitle);
			System.out.println(seletedTitle + "을 선택하셨습니다.");
			
			return seletedTitle;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public void selectActor() {
		try {
			System.out.println("배우 조합을 선택하세요.");

			System.out.println("1. " + titleMap.get(pickTitle).getActor1());
			System.out.println("2. " + titleMap.get(pickTitle).getActor2());

			String inputValue;
			inputValue = br.readLine();
			if(inputValue.equals("1")) {
				ph.setActor(titleMap.get(pickTitle).getActor1());
			}
			else {
				ph.setActor(titleMap.get(pickTitle).getActor2());
			}
			System.out.println(ph.getActor() + "을 선택하셨습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void selectDate() {
		try {
			System.out.println("날짜를 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.get(pickTitle).getDate()) {
				System.out.println(titleIdx++ + ". " + strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedDate = titleMap.get(pickTitle).getDate()[Integer.parseInt(inputValue) - 1];
			
			System.out.println(seletedDate + "을 선택하셨습니다.");
			ph.setDate(seletedDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void selectTime() {
		try {
			System.out.println("시간을 선택하세요.");

			int titleIdx = 1;
			
			for (String strKey : titleMap.get(pickTitle).getTime()) {
				System.out.println(titleIdx++ + ". " + strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedTime = titleMap.get(pickTitle).getTime()[Integer.parseInt(inputValue) - 1];
			
			System.out.println(seletedTime + "을 선택하셨습니다.");
			
			ph.setTime(seletedTime);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void payMoney() {
		try {
			ph.setCost(titleMap.get(pickTitle).getCost());
			System.out.println("가격은 " + ph.getCost() + " 원 입니다.");
			System.out.println("결제 됐습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	//현재는 미구현 상태
	@Override
	public void selectSeat(String pTitle) {
		try {

			ArrayList<String> arrTitle = new ArrayList<>();
			System.out.println("보고싶은 작품을 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedTitle = arrTitle.get(Integer.parseInt(inputValue) - 1);
			
			System.out.println(seletedTitle + "을 선택하셨습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
