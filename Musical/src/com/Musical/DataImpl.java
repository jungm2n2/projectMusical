
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
	String[] arrName = {"김영운", "이정민", "안시연","관리자"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25","1111-11-11"};
	String[] arrGender = {"M", "F", "F","F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM","ADMIN@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832","010-1111-1111"};
	String[] arrPoint = {"10000", "10000", "10000","0"};

	//뮤지컬 데이터 입력.정민
	String[] arrTitle = {"오페라의 유령", "레미제라블", "캣츠"};
	String [] arrActor1 = {"아이비,주원","김소현,김준현","김지연,정성화"};
	String [] arrActor2 = {"옥주현,조승우","정선아,박효신","최정원,남경주"};
	String [] arrTime = {"11:00","15:00","19:30"};
	String [] arrDate = {"7/1(금)","7/2(토)","7/3(일)"};
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

	//정민

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