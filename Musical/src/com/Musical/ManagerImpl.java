package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	
	
	
	@Override
	public void userSearch() {	

	
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

	//Á¤¹Î
	@Override
	public void inputTitle() {


		
	}



}


