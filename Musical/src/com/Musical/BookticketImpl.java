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
			System.out.println("��ǰ�� �����ϼ���.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String seletedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);
			
			ph.setTitle(seletedTitle);
			System.out.println(seletedTitle + "�� �����ϼ̽��ϴ�.");
			
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
			System.out.println("��� ������ �����ϼ���.");

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
			System.out.println(pStr + "��(��) �����ϼ���.");

			int titleIdx = 1;

			for (String strKey : pArr) {
				System.out.println(titleIdx++ + ". " + strKey);
			}

			String seleted = pArr[Integer.parseInt(inputSelect()) - 1];
			
			System.out.println(seleted + "�� �����ϼ̽��ϴ�.");

			if(pStr.equals("��¥")){
				ph.setDate(seleted);
			}
			else {
				ph.setTime(seleted);
			}
	
	}
	
	@Override
	public void payMoney() {
			ph.setCost(titleMap.get(pickTitle).getCost());
			System.out.println("������ " + ph.getCost() + " �� �Դϴ�.");
			System.out.println("���� �ƽ��ϴ�.");
	}

	//����� �̱��� ����
	@Override
	public void selectSeat(String pTitle) {
			ArrayList<String> arrTitle = new ArrayList<>();
			System.out.println("������� ��ǰ�� �����ϼ���.");

			int titleIdx = 1;

			for (String strKey : titleMap.keySet()) {
				System.out.println(titleIdx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			
			String inputValue = inputSelect();
			String seletedTitle = arrTitle.get(Integer.parseInt(inputValue) - 1);
			
			System.out.println(seletedTitle + "�� �����ϼ̽��ϴ�.");
			
	}
	

}
