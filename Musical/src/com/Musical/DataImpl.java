
package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataImpl implements Data {

	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07","admin"};
	String[] arrPW = {"11111", "22222", "33333","1111"};
	String[] arrName = {"�迵��", "������", "�Ƚÿ�","������"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25","1111-11-11"};
	String[] arrGender = {"M", "F", "F","F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM","ADMIN@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832","010-1111-1111"};
	String[] arrPoint = {"10000", "10000", "10000","0"};

	//������ ������ �Է�.����
	String[] arrTitle = {"������� ����", "���������", "Ĺ��"};
	String [] arrActor1 = {"���̺�,�ֿ�","�����,������","������,����ȭ"};
	String [] arrActor2 = {"������,���¿�","������,��ȿ��","������,������"};
	String [] arrTime = {"11:00","15:00","19:30"};
	String [] arrDate = {"7/1(��)","7/2(��)","7/3(��)"};
	int [] arrCost = {10000,20000,30000};

	HashMap<String, CustomerVO> customerMap = new HashMap<>();
	HashMap<String, TitleVO> titleMap = new HashMap<>();

	public DataImpl() {
		inputTitle();
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

			customerMap.put(arrID[i], vo);

		}
	}

	//����

	public void inputTitle() {
		for(int i=0;i<arrTitle.length;i++) {

			TitleVO vo = new TitleVO();


			vo.setTitle(arrTitle[i]);
			vo.setActor1(arrActor1[i]);
			vo.setActor2(arrActor2[i]);
			vo.setTime(arrTime);
			vo.setDate(arrDate);
			vo.setCost(arrCost[i]);

			titleMap.put(arrTitle[i], vo);
		}
	}

	@Override
	public void saveData() {

		try {
			File f = new File("c:\\Musical\\userlist.txt");
			
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();				
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(customerMap);
			fos.close();
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());}

	}

	@Override
	public void loadData() {

		try {
			File f = new File("c:\\Musical\\userlist.txt");

			if(!f.exists()) {				
				inputCustomer();				
			}
			else {				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				customerMap = (HashMap<String, CustomerVO>)ois.readObject();
				
				fis.close();
				ois.close();
				
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Override
	public void snycData() {
		// TODO Auto-generated method stub

	}

	public HashMap<String, CustomerVO> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(HashMap<String, CustomerVO> customerMap) {
		this.customerMap = customerMap;
	}

	public HashMap<String, TitleVO> getTitleMap() {
		return titleMap;
	}

	public void setTitleMap(HashMap<String, TitleVO> titleMap) {
		this.titleMap = titleMap;
	}




}