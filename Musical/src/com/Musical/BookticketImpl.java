package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookticketImpl implements Bookticket{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String selectedTitle = null;
	BookticketVO paymentHistory = new BookticketVO();
	HashMap<String, TitleVO> titleMap = null;

	public BookticketImpl(HashMap<String, TitleVO> pTitleMap) {
		this.titleMap = pTitleMap;
	}

	public BookticketVO enterBookticket(){
		try {
			selectMusical();
			selectActor();
			selectDate();
			selectTime();
			selectSeat();
			payment();
		} catch (Exception e) {
			//TODO: handle exception
		}

		System.out.println();
		System.out.println("���� ���� ����");
		System.out.println(paymentHistory.toString());

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
	public void selectActor() {
		System.out.println("===========================================================================");
		System.out.println("                         <��� ������ �����ϼ���>");
		System.out.println("===========================================================================");

		System.out.println("1. " + titleMap.get(selectedTitle).getActorPairs1());
		System.out.println("2. " + titleMap.get(selectedTitle).getActorPairs2());

		if(inputSelect().equals("1")) {
			paymentHistory.setActor(titleMap.get(selectedTitle).getActorPairs1());
		}
		else {
			paymentHistory.setActor(titleMap.get(selectedTitle).getActorPairs2());
		}
		System.out.println(paymentHistory.getActor() + "�� �����ϼ̽��ϴ�.");
	}

	public void selectDate() {
		select("��¥", titleMap.get(selectedTitle).getDate());
	}

	@Override
	public void selectTime() {
		select("�ð�", titleMap.get(selectedTitle).getTime());
	}

	@Override
	public void payment() {
		paymentHistory.setCost(titleMap.get(selectedTitle).getCost());
		System.out.println("������ " + paymentHistory.getCost() + " �� �Դϴ�.");
		System.out.println("���� �ƽ��ϴ�.");
		titleMap.get(selectedTitle).setTotalSales(paymentHistory.getCost());
	}

	//����� �̱��� ����
	@Override
	public void selectSeat() {
		String[] seatState = titleMap.get(selectedTitle).getStateOfSeat();
		System.out.println("===========================================================================");
		System.out.println("                           <�¼��� �����ϼ���>");
		System.out.println("===========================================================================");
		seatDraw(seatState);
		String selected;
		while(true) {
			
			selected = inputSelect();
			
			if(seatState[Integer.valueOf(selected) - 1] == "��") {
				System.out.println("������ �� ���� �¼��Դϴ�.");
			}
			else {
				break;
			}
		}
		
		seatState[Integer.valueOf(selected) - 1] = "��";

		System.out.println(selected + "���� �����ϼ̽��ϴ�.");
		paymentHistory.setSeat(selected);
	}


/////////�Ʒ��δ� ���۸޼���
	
	public void select(String pStr, String[] pArr){
		System.out.println("===========================================================================");
		System.out.println("                        <"+pStr + "��(��) �����ϼ���>");
		System.out.println("===========================================================================");

		int titleIdx = 1;

		for (String strKey : pArr) {
			System.out.println(titleIdx++ + ". " + strKey);
		}

		String selected = pArr[Integer.parseInt(inputSelect()) - 1];

		System.out.println(selected + "�� �����ϼ̽��ϴ�.");

		if(pStr.equals("��¥")){
			paymentHistory.setDate(selected);
		}
		else {
			paymentHistory.setTime(selected);
		}
	}

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
