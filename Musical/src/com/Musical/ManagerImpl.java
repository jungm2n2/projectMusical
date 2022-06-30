package com.Musical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class ManagerImpl implements Manager{

	BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;


	public ManagerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
	}

	public void menu() {
		int num;
		while(true) {
			try {
				do {
					System.out.println(" ===========================================================================");
					System.out.println("��                �ѤѤѤѤѤ�     �ѤѤѤѤѤ�     �ѤѤѤѤѤ�           ��");                                                  
					System.out.println("��               ��1.ȸ����ȸ��   ��2.������Ȳ��   ��3.���� ��ȸ��         ��");
					System.out.println("��                �ѤѤѤѤѤ�     �ѤѤѤѤѤ�     �ѤѤѤѤѤ�           ��");
					System.out.println("��                      �ѤѤѤѤѤѤ�        �ѤѤѤ�                     ��");
					System.out.println("��                     ��4.������ �߰���     ��5.���Τ�                    ��");
					System.out.println("��                      �ѤѤѤѤѤѤ�        �ѤѤѤ�                     ��");
					System.out.println(" ===========================================================================");
					num =Integer.parseInt(br.readLine());
				}while(num<1 || 5<num);

				switch(num) {
				case 1 :
					searchCustomer(); break;
				case 2 : 
					reserveTicket(); break;
				case 3 :
					totalSale(); break;
				case 4:
					addMusical(); break;
				default :
//					System.out.println("����Ǿ����ϴ�.");
//					�������� ����� �ٲ㼭 �ּ�ó��
					return;
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	@Override
	public void searchCustomer() {	

		Iterator<String> it = customerMap.keySet().iterator();

		while(it.hasNext()) {
			CustomerVO vo = customerMap.get(it.next());
			System.out.println(vo.toString());
		}
	}

	@Override
	public void reserveTicket() {
		
		for (String strKey : customerMap.keySet()) {
			
			if(customerMap.get(strKey).getPh().size() > 0) {
				customerMap.get(strKey).printTicket();
			}
		}
	}

	@Override
	public void totalSale() {
		
		try {
			System.out.println(" ===========================================================================");
			System.out.println("                       <������ �� �������� �������ּ���>");
			System.out.println(" ===========================================================================");
			
			ArrayList<String> arrTitle = new ArrayList<>();
			int idx = 1;
			for (String strKey : titleMap.keySet()) {
				System.out.println(idx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			String inputNumber = br.readLine();
			
			TitleVO tv = titleMap.get(arrTitle.get(Integer.parseInt(inputNumber) - 1));
			
			System.out.println(tv.getTitle() + "�� �� ������ " + tv.getTotalSales() + "�� �Դϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void addMusical() {
		//�ٸ� �͵� �۵� �Ǵ��� Ȯ�� �� ����
		try {
			
			String musicalTitle = null;
			String actorPairs = null;
			String date = null;
			String time = null;
			int cost = 0;
			
			System.out.println("�߰��� �������� �̸��� �Է��ϼ���.");
			musicalTitle = br.readLine();
			
			ArrayList<DetailsInfo> arrInfo = new ArrayList<>();
			
			for (int i = 0; i < 3; i++) {
				DetailsInfo temp = new DetailsInfo();
				System.out.println((i + 1) + "ȸ�� ������ �Է��մϴ�.");
				
				System.out.println((i + 1) + "ȸ�� ��� ������ �Է��ϼ���. [������,�ÿ�]");
				actorPairs = br.readLine();
				
				System.out.println((i + 1) + "ȸ�� ��¥�� �Է��ϼ���. [7/9(��)]");
				date = br.readLine();
				
				System.out.println((i + 1) + "ȸ�� �ð��� �Է��ϼ���. [11:00]");
				time = br.readLine();
				
				System.out.println((i + 1) + "ȸ�� Ƽ�� �ݾ��� �Է��ϼ���. [150000]");
				cost = Integer.parseInt(br.readLine());
				
				temp.setActorPairs(actorPairs);
				temp.setDate(date);
				temp.setTime(time);
				temp.setCost(cost);
				
				arrInfo.add(temp);
			}
			titleMap.put(musicalTitle, new TitleVO(musicalTitle, arrInfo));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
