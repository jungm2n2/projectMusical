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
		//ȸ�������� �޾ƿ;���.
		//�� �޼��尡 ���Ź�ư�� �����ų� ���� ��û�� �޴� �Ŷ�� ��������.

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
		System.out.println("���� ���� ����");
		System.out.println(ph.toString());

		return ph;
	}


	@Override
	public String selectMusical() {
		ArrayList<String> arrTitle = new ArrayList<>();
		System.out.println("===================================================================");
		System.out.println("                        <��ǰ�� �����ϼ���>");
		System.out.println("===================================================================");

		int titleIdx = 1;

		for (String strKey : titleMap.keySet()) {
			System.out.println(titleIdx++ + ". " + strKey);
			arrTitle.add(strKey);
		}

		String selectedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);

		ph.setTitle(selectedTitle);
		System.out.println(selectedTitle + "�� �����ϼ̽��ϴ�.");

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
		System.out.println("                     <��� ������ �����ϼ���>");
		System.out.println("===================================================================");

		System.out.println("1. " + titleMap.get(pickTitle).getActor1());
		System.out.println("2. " + titleMap.get(pickTitle).getActor2());

		if(inputSelect().equals("1")) {
			ph.setActor(titleMap.get(pickTitle).getActor1());
		}
		else {
			ph.setActor(titleMap.get(pickTitle).getActor2());
		}
		System.out.println(ph.getActor() + "�� �����ϼ̽��ϴ�.");
	}


	public void selectDate() {
		select("��¥", titleMap.get(pickTitle).getDate());
	}

	@Override
	public void selectTime() {
		select("�ð�", titleMap.get(pickTitle).getTime());

	}

	public void select(String pStr, String[] pArr){
		System.out.println("===================================================================");
		System.out.println("                     <"+pStr + "��(��) �����ϼ���>");
		System.out.println("===================================================================");

		int titleIdx = 1;

		for (String strKey : pArr) {
			System.out.println(titleIdx++ + ". " + strKey);
		}

		String selected = pArr[Integer.parseInt(inputSelect()) - 1];

		System.out.println(selected + "�� �����ϼ̽��ϴ�.");

		if(pStr.equals("��¥")){
			ph.setDate(selected);
		}
		else {
			ph.setTime(selected);
		}
	}

	@Override
	public void payMoney() {
		ph.setCost(titleMap.get(pickTitle).getCost());
		System.out.println("������ " + ph.getCost() + " �� �Դϴ�.");
		System.out.println("���� �ƽ��ϴ�.");
		titleMap.get(pickTitle).setTotalCost(ph.getCost());
	}

	//����� �̱��� ����
	@Override
	public void selectSeat() {
		String[] seat = titleMap.get(pickTitle).getStateSeat();
		System.out.println("===================================================================");
		System.out.println("                      <�¼��� �����ϼ���>");
		System.out.println("===================================================================");
		seatDraw(seat);
		String selected;
		while(true) {
			
			selected = inputSelect();
			
			if(seat[Integer.valueOf(selected) - 1] == "��") {
				System.out.println("������ �� ���� �¼��Դϴ�.");
			}
			else {
				break;
			}
		}
		
		
		seat[Integer.valueOf(selected) - 1] = "��";

		System.out.println(selected + "���� �����ϼ̽��ϴ�.");
		ph.setMySeat(selected);
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

}
