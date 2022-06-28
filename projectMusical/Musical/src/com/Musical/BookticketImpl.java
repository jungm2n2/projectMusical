package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookticketImpl implements Bookticket{


	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;
	
	
	ArrayList<String> bookticketInfo = new ArrayList<>();

	
	
	public BookticketImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
	}

	public void ViewMenu(){
		//회원정보를 받아와야함.
		//이 메서드가 예매버튼을 누르거나 예매 요청을 받는 거라고 생각하자.

		String pickTitle = selectMusical();
		selectActor(pickTitle);
		selectDate(pickTitle);
		selectTime(pickTitle);
		
		System.out.println();
		System.out.println();
		System.out.println("나의 예매 내역");
		bookticketInfo.forEach((info)->{System.out.println(info);});
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
			
			
			bookticketInfo.add(seletedTitle);
			System.out.println(seletedTitle + "을 선택하셨습니다.");
			
			return seletedTitle;
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public void selectActor(String pTitle) {
		try {
			System.out.println("배우 조합을 선택하세요.");

			System.out.println("1. " + titleMap.get(pTitle).getActor1());
			System.out.println("2. " + titleMap.get(pTitle).getActor2());

			
			String inputValue;
			inputValue = br.readLine();
			if(inputValue.equals("1")) {
				bookticketInfo.add(titleMap.get(pTitle).getActor1());
			}
			else {
				bookticketInfo.add(titleMap.get(pTitle).getActor2());
			}

			System.out.println(bookticketInfo.get(bookticketInfo.size() - 1) + "을 선택하셨습니다.");
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void selectDate(String pTitle) {
		try {
			System.out.println("날짜를 선택하세요.");

			int titleIdx = 1;

			for (String strKey : titleMap.get(pTitle).getDate()) {
				System.out.println(titleIdx++ + ". " + strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedDate = titleMap.get(pTitle).getDate()[Integer.parseInt(inputValue) - 1];
			
			System.out.println(seletedDate + "을 선택하셨습니다.");
			bookticketInfo.add(seletedDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void selectTime(String pTitle) {
		try {
			System.out.println("시간을 선택하세요.");

			int titleIdx = 1;
			
			for (String strKey : titleMap.get(pTitle).getTime()) {
				System.out.println(titleIdx++ + ". " + strKey);
			}
			
			String inputValue;
			inputValue = br.readLine();
			String seletedTime = titleMap.get(pTitle).getTime()[Integer.parseInt(inputValue) - 1];
			
			System.out.println(seletedTime + "을 선택하셨습니다.");
			
			
			bookticketInfo.add(seletedTime);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

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
