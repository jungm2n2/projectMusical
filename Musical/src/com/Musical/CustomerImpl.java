package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CustomerImpl implements Customer{
	
	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;
	String id;
	String answer;
	BookticketImpl bt = null;
	
	CustomerVO vo = new CustomerVO(); 

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
String changepw;
int num;

	public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
		bt = new BookticketImpl(customerMap, titleMap);
	}

	@Override
	public void userUpdate() {
		
		try {
			
			System.out.print("��й�ȣ��?? �Է����ּ���");
			changepw = (br.readLine());
			
			vo = customerMap.get(id);
			
			if(!vo.getPw().equals(changepw)){
				System.out.println("��й�ȣ��?? Ʋ�Ƚ��ϴ�");
				return;
		}else {
			System.out.println("��й��? ���� �Ϸ�");
		}
			
			System.out.println("������ ��й��??");
			
			vo.setPw(br.readLine());
			
			System.out.println("������ �̸���?");
			vo.setMail(br.readLine());
			
			System.out.println("������ �ڵ��� ��ȣ?");
			vo.setPhone(br.readLine());
			
			
			customerMap.put(id, vo);
			System.out.println("���� �Ϸ�!");
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
	}
			
	
	@Override
	public void reservation() {	
		//������ �ҷ����� �����ϱ�
		new BookticketImpl(id, titleMap).ViewMenu();
	

	
	
	}

	@Override
	public void logout() {
		
		try {
			System.out.println("�α׾ƿ� �Ͻðڽ��ϱ�?[Y/N]");
			answer = br.readLine();
			
			if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�??");
				System.exit(0);
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
	public void userDelete() {
		
		try {
			
			
			System.out.print("Ż���ϰ� ���� ȸ���� ���̵� �Է��ϼ���");
			id = br.readLine();
			

			if(!(searchId(id))){
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
				return;
			}
			
			customerMap.remove(id);
			System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�??");
			
			
		} catch (Exception e) {
			
		}
		
	
		
		
		
	}




	@Override
	public boolean searchId(String id) {
		
		return customerMap.containsKey(id);
		
		
		
	}
	
	public void start(String id1) {
		
		try {
			
			id = id1;
		while(true){	
			do {
			System.out.println("1.���������� 2.�����ϱ� 3.���ų��� ��ȸ 4.�α׾ƿ� 5.ȸ��Ż��");
			num = Integer.parseInt(br.readLine());
			}while(num<1||num>4);
			
			
			switch (num) {
			
			case(1):userUpdate();break;
			case(2):reservation();break;
			case(3):logout();break;
			case(4):logout();break;
			case(5):userDelete();break;
		
			}
		}
			
		} catch (Exception e) {
			
		}
		
		
	}





	
	
}
