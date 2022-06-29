package com.Musical;
//�ÿ�
import java.io.*;
import java.util.HashMap;

public class MusicalMain {

	static DataImpl di = new DataImpl();

	static HashMap<String, CustomerVO> customerMap = di.getCustomerMap();
	static HashMap<String, TitleVO> titleMap = di.getTitleMap();

	static ManagerImpl implM = new ManagerImpl(customerMap, titleMap);
	static CustomerImpl implC = new CustomerImpl(customerMap, titleMap); 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int num;
		System.out.println("===================================================================");
		System.out.println("=  =====  ==  ====  ===      ===    ====     ======  =====  =======\n"
				         + "=   ===   ==  ====  ==  ====  ===  ====  ===  ====    ====  =======\n"
				         + "=  =   =  ==  ====  ==  ====  ===  ===  =========  ==  ===  =======\n"
					     + "=  == ==  ==  ====  ===  ========  ===  ========  ====  ==  =======\n"
				         + "=  =====  ==  ====  =======  ====  ===  ========        ==  =======\n"
				         + "=  =====  ==  ====  ==  ====  ===  ===  ========  ====  ==  =======\n"
					     + "=  =====  ==   ==   ==  ====  ===  ====  ===  ==  ====  ==  =======\n"
					     + "=  =====  ===      ====      ===    ====     ===  ====  ==        =\n");
		System.out.println("===================================================================");
		
		while(true) {

			do {
				System.out.println(" ==================================================================");
				System.out.println("��           �ѤѤѤѤ�        �ѤѤѤѤѤ�        �ѤѤѤ�       ��");                                                  
				System.out.println("��          ��1.�α��Τ�      ��2.ȸ�����Ԥ�      ��3.�����      ��");
				System.out.println("��           �ѤѤѤѤ�        �ѤѤѤѤѤ�        �ѤѤѤ�       ��");
				System.out.println(" ==================================================================");
				num = Integer.parseInt(br.readLine());
			}while(num<1 || 3<num);


			switch(num) {
			case 1 :
				login(di.getCustomerMap()); break;
			case 2 : 
				signUp(); break;
			case 3 :
				di.saveData();
				System.out.println("����Ǿ����ϴ�.");
				System.exit(0);
			}
		}
	}
	public static void login(HashMap<String, CustomerVO> customerMap) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		String id,pw;

		do{
			System.out.println("���̵�?");
			id = br.readLine();

			if(!customerMap.containsKey(id)) {
				System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
			}else {break;}				
		}while(true);


		System.out.println("��й�ȣ�� �Է��ϼ���.");

		do{
			pw = br.readLine();
			CustomerVO vo = new CustomerVO();
			vo = customerMap.get(id);
			//do{
			if(!vo.getPw().equals(pw)) {
				System.out.println("��й�ȣ�� Ȯ�� ���ּ���");
				//pw = br.readLine();
			}else {
				if(id.equals("admin") && pw.equals("1111")) {
					implM.menu();
					break;
				}
				else {
					System.out.println("�α��� ����!");
					implC.start(id);
					break;
				}
			}				
		}while(true);

	}

	public static void signUp() {

		SignUpException exp = new SignUpException();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		CustomerVO vo = new CustomerVO();

		while(true) {
			try {
				System.out.println("���̵� �Է��ϼ���.");
				String id = br.readLine();
				exp.inputFormat(id);
				vo.setId(id);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}

		try {
			System.out.println("��й�ȣ�� �Է��ϼ���.");
			String pw = br.readLine();

			System.out.println("��й�ȣ�� ��Ȯ�����ּ���.");
			do {
				String pw2 = br.readLine();

				if(pw.equals(pw2)) {
					vo.setPw(pw2); break;
				}
				else {
					System.out.println("��й�ȣ�� �ٸ��ϴ�.�ٽ��Է����ּ���.");
				}
			}while(true);
		} catch (Exception e) {
			System.out.println(e.toString());     
		}
		try {
			System.out.println("�̸�?");
			String name = br.readLine();
			vo.setName(name);
		} catch (Exception e) {
			System.out.println(e.toString());     
		}

		while(true) {
			try {
				System.out.println("����? [F/M]");
				String gender = br.readLine(); 
				exp.genderInputFormat(gender);
				vo.setGender(gender);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}

		while(true) {
			try {
				System.out.println("�������?[yyyy-mm-dd]");
				String birth = br.readLine();
				exp.birthInputFormat(birth);
				vo.setBirth(birth);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}


		while(true) {
			try {
				System.out.println("�̸��� �ּ�?");
				String mail = br.readLine();
				exp.mailInputFormat(mail);
				vo.setMail(mail);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}


		while(true) {
			try {
				System.out.println("�ڵ��� ��ȣ?[010-xxxx-xxxx]");
				String phone = br.readLine();
				exp.telInputFormat(phone);
				vo.setPhone(phone);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}
		System.out.println("===================================================================");
		System.out.println("                          ȸ������ ���� !");
		System.out.println("===================================================================");

		customerMap.put(vo.getId(), vo);

	}

}