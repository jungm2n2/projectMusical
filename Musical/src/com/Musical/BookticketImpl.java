package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookticketImpl implements Bookticket{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String selectedTitle = null;
	String selectRound = null;
	BookticketVO paymentHistory = new BookticketVO();
	HashMap<String, TitleVO> titleMap = null;

	public BookticketImpl(HashMap<String, TitleVO> pTitleMap) {
		this.titleMap = pTitleMap;
	}

	public BookticketVO enterBookticket(){
		try {
			selectMusical();
			selectInfo();
			selectSeat();
			payment();
		} catch (Exception e) {
			//TODO: handle exception
		}

		if(paymentHistory != null) {
			System.out.println();
			System.out.println("나의 예매 내역");
			System.out.println(paymentHistory.toString());
		}
		
		return paymentHistory;
	}

	@Override
	public void selectMusical() {
		ArrayList<String> arrTitle = new ArrayList<>();
		System.out.println("===========================================================================");
		System.out.println("                           <작품을 선택하세요>");
		System.out.println("===========================================================================");

		int titleIdx = 1;

		for (String strKey : titleMap.keySet()) {
			System.out.println(titleIdx++ + ". " + strKey);
			arrTitle.add(strKey);
		}

		String selectedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);

		paymentHistory.setTitle(selectedTitle);
		System.out.println(selectedTitle + "을 선택하셨습니다.");
		this.selectedTitle = selectedTitle;
	}

	@Override
	public void selectInfo() {
		System.out.println("===================================================================");
		System.out.println("                     <원하는 회차를 선택하세요>");
		System.out.println("===================================================================");
//
		TitleVO tm = titleMap.get(selectedTitle);
		ArrayList<DetailsInfo> arrDI = tm.getInfo();
		
		tm.printInfo();
		
		selectRound = inputSelect();
		
		DetailsInfo di = arrDI.get(Integer.parseInt(selectRound) - 1);
		
		paymentHistory.setActor(di.getActorPairs());
		paymentHistory.setDate(di.getDate());
		paymentHistory.setTime(di.getTime());
		
		System.out.println(selectRound + " 회차를 선택하셨습니다.");
	}

	@Override
	public void selectSeat() {
	
		String[] seatState = titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getStateOfSeat();
		
		System.out.println("===================================================================");
		System.out.println("                      <좌석을 선택하세요>");
		System.out.println("===================================================================");
		seatDraw(seatState);
	
		String selected;
		
		while(true) {
			selected = inputSelect();
			
			if(seatState[Integer.valueOf(selected) - 1] == "■") {
				System.out.println("선택할 수 없는 좌석입니다. 다시 선택해주세요.");
			}
			else {
				break;
			}
		}
		
		seatState[Integer.valueOf(selected) - 1] = "■";

		System.out.println(selected + "번을 선택하셨습니다.");
		paymentHistory.setSeat(selected);
	}

	@Override
	public void payment() {
		paymentHistory.setCost(titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getCost());
		System.out.println("가격은 " + paymentHistory.getCost() + " 원 입니다.");
		
		System.out.println("결제 하시겠습니까?[Y/N]");
		
		String agree = inputSelect();
		
		if(!agree.equals("y") && !agree.equals("Y")) {
			System.out.println("결제가 취소되었습니다.");
	
			String[] seatState = titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getStateOfSeat();
			String selected = paymentHistory.getSeat();
			seatState[Integer.valueOf(selected) - 1] = selected;
			
			paymentHistory = null;
			return;
		}
		
		System.out.println("결제가 완료되었습니다.");
		titleMap.get(selectedTitle).setTotalSales(paymentHistory.getCost());
	}
	
/////////아래로는 헬퍼메서드

	void seatDraw(String[] pSeat){
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[0], pSeat[1], pSeat[2]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[3], pSeat[4], pSeat[5]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[6], pSeat[7], pSeat[8]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
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

}
