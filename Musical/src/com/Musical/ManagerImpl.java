package com.Musical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
		try {
			
			String musicalTitle = null;
			String actorPairs1 = null;
			String actorPairs2 = null;
			
			System.out.println(" ===========================================================================");
			System.out.println("                     <�߰��� �������� �̸��� �Է��ϼ���>");
			System.out.println(" ===========================================================================");
			musicalTitle = br.readLine();
			
			System.out.println(" ===========================================================================");
			System.out.println("                  <��� ����1 �� �Է��ϼ���. [������,�ÿ�]>");
			System.out.println(" ===========================================================================");
			actorPairs1 = br.readLine();
			
			System.out.println(" ===========================================================================");
			System.out.println("                  <��� ����2 �� �Է��ϼ���. [����,�Ƚÿ�]>");
			System.out.println(" ===========================================================================");
			actorPairs2 = br.readLine();
			
			
//			�ӽ÷� ������ �����ͼ� �־��༭ ������ ����
			String [] arrTime = {"11:00","15:00","19:30"};
			String [] arrDate = {"7/1(��)","7/2(��)","7/3(��)"};
			int [] arrCost = {10000,20000,30000};
			
		
			TitleVO vo = new TitleVO(musicalTitle, actorPairs1, actorPairs2, arrDate, arrTime, arrCost[2]);
			
			titleMap.put(vo.getTitle(), vo);
			
//			�� �Ʒ��� ������� �߰��ؾ��ϴµ� ������ �ٲ�� �� �� ���Ƽ� �ϴ� ����
//			System.out.println("��¥1 �� �Է��ϼ���.");
//			System.out.println("��¥2 �� �Է��ϼ���.");
//			System.out.println("��¥3 �� �Է��ϼ���.");
//			
//			System.out.println("�ð�1 �� �Է��ϼ���.");
//			System.out.println("�ð�2 �� �Է��ϼ���.");
//			System.out.println("�ð�3 �� �Է��ϼ���.");
//			System.out.println("Ƽ�� ������ �Է��ϼ���.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
