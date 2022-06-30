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
			System.out.println("���� ���� ����");
			System.out.println(paymentHistory.toString());
		}
		
		return paymentHistory;
	}

	@Override
	public void selectMusical() {
		ArrayList<String> arrTitle = new ArrayList<>();
		System.out.println("===========================================================================");
		System.out.println("                           <��ǰ�� �����ϼ���>");
		System.out.println("===========================================================================");

		int titleIdx = 1;

		for (String strKey : titleMap.keySet()) {
			System.out.println(titleIdx++ + ". " + strKey);
			arrTitle.add(strKey);
		}

		String selectedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);

		paymentHistory.setTitle(selectedTitle);
		System.out.println(selectedTitle + "�� �����ϼ̽��ϴ�.");
		this.selectedTitle = selectedTitle;
	}

	@Override
	public void selectInfo() {
		System.out.println("===================================================================");
		System.out.println("                     <���ϴ� ȸ���� �����ϼ���>");
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
		
		System.out.println(selectRound + " ȸ���� �����ϼ̽��ϴ�.");
	}

	@Override
	public void selectSeat() {
	
		String[] seatState = titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getStateOfSeat();
		
		System.out.println("===================================================================");
		System.out.println("                      <�¼��� �����ϼ���>");
		System.out.println("===================================================================");
		seatDraw(seatState);
	
		String selected;
		
		while(true) {
			selected = inputSelect();
			
			if(seatState[Integer.valueOf(selected) - 1] == "��") {
				System.out.println("������ �� ���� �¼��Դϴ�. �ٽ� �������ּ���.");
			}
			else {
				break;
			}
		}
		
		seatState[Integer.valueOf(selected) - 1] = "��";

		System.out.println(selected + "���� �����ϼ̽��ϴ�.");
		paymentHistory.setSeat(selected);
	}

	@Override
	public void payment() {
		paymentHistory.setCost(titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getCost());
		System.out.println("������ " + paymentHistory.getCost() + " �� �Դϴ�.");
		
		System.out.println("���� �Ͻðڽ��ϱ�?[Y/N]");
		
		String agree = inputSelect();
		
		if(!agree.equals("y") && !agree.equals("Y")) {
			System.out.println("������ ��ҵǾ����ϴ�.");
	
			String[] seatState = titleMap.get(selectedTitle).getInfo().get(Integer.parseInt(selectRound) - 1).getStateOfSeat();
			String selected = paymentHistory.getSeat();
			seatState[Integer.valueOf(selected) - 1] = selected;
			
			paymentHistory = null;
			return;
		}
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		titleMap.get(selectedTitle).setTotalSales(paymentHistory.getCost());
	}
	
/////////�Ʒ��δ� ���۸޼���

	void seatDraw(String[] pSeat){
		System.out.println(" �ѤѤѤѤѤ�");
		System.out.printf("| %s | %s | %s |\n", pSeat[0], pSeat[1], pSeat[2]);
		System.out.println(" �ѤѤѤѤѤ�");
		System.out.printf("| %s | %s | %s |\n", pSeat[3], pSeat[4], pSeat[5]);
		System.out.println(" �ѤѤѤѤѤ�");
		System.out.printf("| %s | %s | %s |\n", pSeat[6], pSeat[7], pSeat[8]);
		System.out.println(" �ѤѤѤѤѤ�");
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
