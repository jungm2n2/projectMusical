package com.Musical;
//�ÿ�
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

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
		while(true) {

			do {
				System.out.println("1.�α��� \n2.ȸ������ \n3.����");
				System.out.println("---------------------------------\n:");
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

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		try {
			System.out.println("���̵� �Է��ϼ���.");
			String id = br.readLine();

			System.out.println("��й�ȣ�� �Է��ϼ���.");
			String pw = br.readLine();

			System.out.println("��й�ȣ�� ��Ȯ�����ּ���.");
			do {
				String pw2 = br.readLine();

				if(pw.equals(pw2)) {break;
				}
				else {
					System.out.println("��й�ȣ�� �ٸ��ϴ�.�ٽ��Է����ּ���.");
				}

			}while(true);

			System.out.println("�̸�?");
			String name = br.readLine();

			System.out.println("����? [F/M]");
			String gender = br.readLine(); 

			System.out.println("�������?[yyyy-mm-dd]");
			String birth = br.readLine();

			System.out.println("�̸��� �ּ�?");
			String mail = br.readLine();

			System.out.println("�ڵ��� ��ȣ?[010-xxxx-xxxx]");
			String phone = br.readLine();

			CustomerVO vo = new CustomerVO(id, pw, name, birth, gender, mail, phone);

			customerMap.put(vo.getId(), vo);

		} catch (Exception e) {

			System.out.println(e.toString());     
		}



	}

}
