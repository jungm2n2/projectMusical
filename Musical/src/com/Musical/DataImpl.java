
package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DataImpl implements Data {
	
	private final String F_USER_LIST = "userData.txt";
	private final String F_TITLE_LIST = "titleData.txt";

	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07","admin"};
	String[] arrPW = {"11111", "22222", "33333","1111"};
	String[] arrName = {"�迵��", "������", "�Ƚÿ�","������"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25","1111-11-11"};
	String[] arrGender = {"M", "F", "F","F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM","ADMIN@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832","010-1111-1111"};
	String[] arrPoint = {"10000", "10000", "10000","0"};

	//������ ������ �Է�.����
	String[] arrTitle = {"������� ����", "���������", "Ĺ��", "���̴�", "��ų �� ���̵�", "�ι̿��� �ٸ���"};
	String [] arrActorPairs = {"���̺�,�ֿ�","�����,������","������,����ȭ","������,���¿�","������,��ȿ��","������,������"};
	String [] arrDate = {"7/1(��)","7/2(��)","7/3(��)", "7/8(��)","7/9(��)", "7/10(��)"};	
	String [] arrTime = {"11:00", "13:30", "15:00", "17:00", "19:30", "21:00"};
	int [] arrCost = {100000,120000,70000,50000,80000,150000};


	HashMap<String, CustomerVO> customerDB = new HashMap<>();
	HashMap<String, TitleVO> titleDB = new HashMap<>();

	public DataImpl() {
		loadData();
	}

	public void inputCustomer() {	

		for(int i=0;i<arrID.length;i++) {

			CustomerVO vo = new CustomerVO();

			vo.setId(arrID[i]);
			vo.setPw(arrPW[i]);
			vo.setName(arrName[i]);
			vo.setBirth(arrBirth[i]);
			vo.setGender(arrGender[i]);
			vo.setMail(arrMail[i]);
			vo.setPhone(arrPhone[i]);
			vo.setPoint(arrPoint[i]);

			customerDB.put(arrID[i], vo);
		}
	}
	//����

	public void inputTitle() {
		Random rd = new Random();
		for(int i=0;i<arrTitle.length;i++) {
			ArrayList<DetailsInfo> arrInfo = new ArrayList<>();
			for(int j = 0;  j < 3; j++) {
				DetailsInfo temp = new DetailsInfo();
				temp.setActorPairs(arrActorPairs[rd.nextInt(6)]);
				temp.setDate(arrDate[rd.nextInt(6)]);
				temp.setTime(arrTime[rd.nextInt(6)]);
				temp.setCost(arrCost[rd.nextInt(6)]);
				
				arrInfo.add(temp);
			}
			titleDB.put(arrTitle[i], new TitleVO(arrTitle[i], arrInfo));
		}
	}

	@Override
	public void saveData() {
		try {
			File f = new File("c:\\Musical\\" + F_USER_LIST);

			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();				
			}

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(customerDB);
			fos.close();
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());}
	}

	public void saveTitle() {
		try {
			File f = new File("c:\\Musical\\" + F_TITLE_LIST);

			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();				
			}

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(titleDB);
			fos.close();
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());}
	}

	@Override
	public void loadData() {

		loadFile(F_USER_LIST);
		loadFile(F_TITLE_LIST);
		//		try {
		//			File f = new File("c:\\Musical\\userlist.txt");
		//
		//			if(!f.exists()) {				
		//				inputCustomer();				
		//			}
		//			else {				
		//				FileInputStream fis = new FileInputStream(f);
		//				ObjectInputStream ois = new ObjectInputStream(fis);
		//				
		//				customerDB = (HashMap<String, CustomerVO>)ois.readObject();
		//				
		//				fis.close();
		//				ois.close();
		//				
		//			}
		//
		//		} catch (Exception e) {
		//			System.out.println(e.toString());
		//		}
	}

	void loadFile(String path) {

		try {
			File f = new File("c:\\Musical\\" + path);

			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();	
			}

			if(path.equals(F_USER_LIST) && !f.exists()) {
				inputCustomer();
				return;
			}
			else if(path.equals(F_TITLE_LIST) && !f.exists()) {
				inputTitle();
				return;
			}

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			if(path.equals(F_USER_LIST)) {
				customerDB = (HashMap<String, CustomerVO>)ois.readObject();
			}
			else {
				titleDB = (HashMap<String, TitleVO>)ois.readObject();
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public HashMap<String, CustomerVO> getcustomerDB() {
		return customerDB;
	}

	public void setcustomerDB(HashMap<String, CustomerVO> customerDB) {
		this.customerDB = customerDB;
	}

	public HashMap<String, TitleVO> gettitleDB() {
		return titleDB;
	}

	public void settitleDB(HashMap<String, TitleVO> titleDB) {
		this.titleDB = titleDB;
	}




}