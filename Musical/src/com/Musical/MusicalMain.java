package com.Musical;

//�ÿ�
import java.io.*;
import java.util.HashMap;


/*
 -���� �ʿ�
1. ���� �������� ������ ������ �ϳ��� ��ǰ����, ��¥,���,�ð� �� ��� �ٸ��� �����ص� �����δ� �ϳ��� �����÷� �Ǵ��ؼ� �¼��� ��ġ�� ����
 	1-1. �������� �����ͱ����� �ϳ��� �������� ���+��¥+�ð� �� ������ ��� �ִ� ������ �ٲ�� �ҵ�
2. TitleVO�� toString()�������̵� �޼��带 ���� �κ��� �� ������ ���� �� ����. Ȯ�� �� ���ٸ� ���� Ȥ�� ����.


 -���� �Ϸ�
1. ������� �޼���� ����
 1-1. �� ���ؿ���(����) �ִ��� ������ ������ ������.. �����ϰ� ����� �κе� �ְ�, ���� ��ġ���� ����.
2. ȸ�������� �����ϸ� ���� �� �ش� �����͵� �����.(��. ����� �����ư���� �������� ��)
3. ������ �α��� �� �����ư ������ ���ᰡ �Ǿ �ٽ� ���� �޴��� ���ƿ��� ����.
	1-1. ����� "����Ǿ����ϴ�" �� ���ͼ� ����� �޴� �̸��� "��������" �� �ٲ�
4. ������ �޴����� "������ �߰�"�� ����. �ٸ� ���� �����ʿ���׿��� 1���� �������� �ʾƼ� ��¥,���,�ð�,�¼� ���� ������ ����.
	
*/


public class MusicalMain {
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		DataImpl database = new DataImpl();

		HashMap<String, CustomerVO> customerMap = database.getcustomerDB();
		HashMap<String, TitleVO> titleMap = database.gettitleDB();

		ManagerImpl manager = new ManagerImpl(customerMap, titleMap);
		CustomerImpl customer = new CustomerImpl(customerMap, titleMap); 
		MusicalMain mainObject = new MusicalMain();
		
		System.out.println(" ===========================================================================");
		System.out.println(" ======  =====  ==  ====  ===      ===    ====     ======  =====  ==========\n"
				+ " ======   ===   ==  ====  ==  ====  ===  ====  ===  ====    ====  ==========\n"
				+ " ======  =   =  ==  ====  ==  ====  ===  ===  =========  ==  ===  ==========\n"
				+ " ======  == ==  ==  ====  ===  ========  ===  ========  ====  ==  ==========\n"
				+ " ======  =====  ==  ====  =======  ====  ===  ========        ==  ==========\n"
				+ " ======  =====  ==  ====  ==  ====  ===  ===  ========  ====  ==  ==========\n"
				+ " ======  =====  ==   ==   ==  ====  ===  ====  ===  ==  ====  ==  ==========\n"
				+ " ======  =====  ===      ====      ===    ====     ===  ====  ==        ====");
		System.out.println(" ===========================================================================");
		int num;
		while(true) {

			do {
				System.out.println();
				System.out.println();
				System.out.println(" ===========================================================================");
				System.out.println("��             �ѤѤѤѤ�          �ѤѤѤѤѤ�             �ѤѤѤ�       ��");                                                  
				System.out.println("��            ��1.�α��Τ�        ��2.ȸ�����Ԥ�           ��3.�����      ��");
				System.out.println("��             �ѤѤѤѤ�          �ѤѤѤѤѤ�             �ѤѤѤ�       ��");
				System.out.println(" ===========================================================================");
				num = Integer.parseInt(br.readLine());
			}while(num<1 || 3<num);


			switch(num) {
			case 1 :
				mainObject.login(customerMap, manager, customer); break;
			case 2 : 
				mainObject.signUp(customerMap); break;
			case 3 :
				database.saveData();
				database.saveTitle();
				System.out.println("����Ǿ����ϴ�.");
				System.exit(0);
			}
		}
	}
	public void login(HashMap<String, CustomerVO> customerMap, ManagerImpl manager, CustomerImpl customer) throws IOException {
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
			//do{
			if(!customerMap.get(id).getPw().equals(pw)) {
				System.out.println("��й�ȣ�� Ȯ�� ���ּ���");
				//pw = br.readLine();
			}else {
				if(id.equals("admin") && pw.equals("1111")) {
					manager.menu();
					break;
				}
				else {
					System.out.println("�α��� ����!");
					customer.succesLogIn(id);
					break;
				}
			}				
		}while(true);

	}

	public void signUp(HashMap<String, CustomerVO> customerMap) {

		SignUpException exp = new SignUpException();


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
		System.out.println(" ===========================================================================");
		System.out.println("                               ȸ������ ���� !");
		System.out.println(" ===========================================================================");

		customerMap.put(vo.getId(), vo);

	}
}