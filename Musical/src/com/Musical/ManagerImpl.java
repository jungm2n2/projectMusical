package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class ManagerImpl implements Manager{

	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07"};
	String[] arrPW = {"11111", "22222", "33333"};
	String[] arrName = {"김영운", "이정민", "안시연"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25"};
	String[] arrGender = {"M", "F", "F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832"};
	String[] arrPoint = {"10000", "10000", "10000"};
	
	
	
	//뮤지컬 데이터 입력.정민
	String[] arrTitle = {"오페라의 유령", "레미제라블", "캣츠"};
	String [] arrActor1 = {"아이비,김준현","김소현,주원","옥주현,조권"};
	String [] arrActor2 = {"옥주현,조권","아이비,김준현","김소현,주원"};
	String [] arrTime = {"11:00","15:00","19:30"};
	String [] arrDate = {"7/1(금)","7/2(토)","7/3(일)"};


	BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	HashMap<String, MusicalVO> hMap = new HashMap<>();
	
	//
	HashMap<String, ShowVO> h = new HashMap<>();

	@Override
	public void userSearch() {	

		for(int i=0;i<arrID.length;i++) {

			MusicalVO vo = new MusicalVO();

			vo.setId(arrID[i]);
			vo.setPw(arrPW[i]);
			vo.setName(arrName[i]);
			vo.setBirth(arrBirth[i]);
			vo.setGender(arrGender[i]);
			vo.setMail(arrMail[i]);
			vo.setPhone(arrPhone[i]);
			vo.setPoint(arrPoint[i]);

			hMap.put(arrID[i], vo);

		}
		
		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String id = it.next();
			MusicalVO vo = hMap.get(id);
	
			System.out.println(vo.toString());
		}
	}
	
	@Override
	public void reservationTicket() {
		
	
	}

	@Override
	public void totalSale() {
		
		
	}

	@Override
	public void logout() {
		
		
	}

	
	//정민
	@Override
	public void inputTitle() {
		
		
		for(int i=0;i<arrTitle.length;i++) {
			
			ShowVO vo = new ShowVO();

			
			vo.setTitle(arrTitle[i]);
			vo.setActor1(arrActor1[i]);
			vo.setActor2(arrActor2[i]);
			vo.setTime(arrTime);
			vo.setDate(arrDate);

			h.put(arrTitle[i], vo);

		}
		
		Iterator<String> it = h.keySet().iterator();
		
		while(it.hasNext()) {
			
			String title = it.next();
			ShowVO vo = h.get(title);
	
			System.out.println(vo.toString());
		}
	}
		
		
		
	}


