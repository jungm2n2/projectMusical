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
			System.out.println("작품을 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String seletedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);
			
			ph.setTitle(seletedTitle);
			System.out.println(seletedTitle + "을 선택하셨습니다.");
			
			return seletedTitle;
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
			System.out.println("배우 조합을 선택하세요.");

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
			System.out.println(pStr + "을(를) 선택하세요.");

			int titleIdx = 1;

			for (String strKey : pArr) {
				System.out.println(titleIdx++ + ". " + strKey);
			}

			String seleted = pArr[Integer.parseInt(inputSelect()) - 1];
			
			System.out.println(seleted + "을 선택하셨습니다.");

			if(pStr.equals("날짜")){
				ph.setDate(seleted);
			}
			else {
				ph.setTime(seleted);
			}
	
	}
	
	@Override
	public void payMoney() {
			ph.setCost(titleMap.get(pickTitle).getCost());
			System.out.println("가격은 " + ph.getCost() + " 원 입니다.");
			System.out.println("결제 됐습니다.");
	}

	//현재는 미구현 상태
	@Override
	public void selectSeat(String pTitle) {
			ArrayList<String> arrTitle = new ArrayList<>();
			System.out.println("보고싶은 작품을 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String inputValue = inputSelect();
			String seletedTitle = arrTitle.get(Integer.parseInt(inputValue) - 1);
			
			System.out.println(seletedTitle + "을 선택하셨습니다.");
			
	}
	

}
