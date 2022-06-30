package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CustomerImpl implements Customer{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;
	String curCustomer;
	SignUpException se = new SignUpException();

	public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
	}
	
	public void succesLogIn(String pLogInCustomer) {
		try {  
			int selectMenu = 0;
			curCustomer = pLogInCustomer;
			while(true){   
				do {
					System.out.println(" ===========================================================================");
					System.out.println("��                �ѤѤѤѤѤѤ�    �ѤѤѤѤѤ�     �ѤѤѤѤѤѤѤ�      ��");                                                  
					System.out.println("��               ��1.������������  ��2.�����ϱ��  ��3.���ų��� ��ȸ��     ��");
					System.out.println("��                �ѤѤѤѤѤѤ�    �ѤѤѤѤѤ�    �ѤѤѤѤѤѤѤ�       ��");
					System.out.println("��                        �ѤѤѤѤѤ�        �ѤѤѤѤѤ�                 ��");
					System.out.println("��                       ��4.�α׾ƿ���      ��5.ȸ��Ż���                ��");
					System.out.println("��                        �ѤѤѤѤѤ�        �ѤѤѤѤѤ�                 ��");
					System.out.println(" ===========================================================================");
					selectMenu = Integer.parseInt(br.readLine());
				}while(selectMenu<1||selectMenu>5);


				switch (selectMenu) {

				case(1):updateCustomerInfo();break;
				case(2):reserveMusical();break;
				case(3):reserveHistory();break;
				case(4):logout();return;
				case(5):deleteCustomerInfo();return;
            
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

	@Override
	public void updateCustomerInfo() {

		try {

			System.out.print("��й�ȣ�� �Է����ּ���");
			String changepw = (br.readLine());

			CustomerVO vo = customerMap.get(curCustomer);

			if(!vo.getPw().equals(changepw)){
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
				return;
			}else {
				System.out.println("��й�ȣ ���� �Ϸ�");
			}

			System.out.println("�����ϰ���� ȸ�������� �����ϼ���");
			System.out.println("1.��й�ȣ \n2.�̸��� \n3.�ڵ�����ȣ");
			int num2 = (Integer.parseInt(br.readLine()));

			boolean flag = false;

			switch (num2) {
			case 1:
				System.out.println("������ ��й�ȣ?");
				vo.setPw(br.readLine());flag = true; 
				break;

			case 2:

				while(true) {
					try { System.out.println("������ �̸���?");
					vo.setMail(br.readLine());
					se.mailInputFormat(vo.getMail());
					flag = true;
					break;

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				break;

			case 3:

				while(true) {

					try {System.out.println("������ �ڵ��� ��ȣ?");
					vo.setPhone(br.readLine());
					se.telInputFormat(vo.getPhone());
					flag = true;
					break;

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				break;

			default:
				flag = false; break;
			}

			if(flag) {
				customerMap.put(curCustomer, vo);
				System.out.println("���� �Ϸ�!");
			}else {
				System.out.println("��ȣ�� �ٽ� �Է��ϼ���"); 
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void reserveMusical() {
		BookticketImpl bk = new BookticketImpl(titleMap);
		customerMap.get(curCustomer).getPh().add(bk.enterBookticket());
	}

	@Override
	public void logout() {
		
		try {
			System.out.println("�α׾ƿ� �Ͻðڽ��ϱ�?[Y/N]");
			String answer = br.readLine();

			if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�");

			}else if(answer.equals("N") || answer.equals("n")) {
				return;
			}else {
				System.out.println("�ٽ� �Է����ּ���");
				return;
			}

		} catch (Exception e) {

		}
	}

	@Override
	public void deleteCustomerInfo() {
		try {

			System.out.print("Ż���Ͻðڽ��ϱ�?[Y/N]");
			String yn = br.readLine();

			if(yn.equals("Y") || yn.equals("y")) {
				customerMap.remove(curCustomer);
				System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
			}else if(yn.equals("N") || yn.equals("n")) {
				return;
			}else {
				System.out.println("�ٽ� �Է����ּ���");
				return;
			}
		
		
	
		} catch (Exception e) {

		}
	}
	
	@Override
	public void reserveHistory() {
		customerMap.get(curCustomer).printTicket();
	}

	
	//�������� ���� ����
	
	/*@Override
	public boolean searchID(String id) {

		return customerMap.containsKey(id);

	}
	*/
}