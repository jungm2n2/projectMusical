package com.Musical;

import java.io.BufferedReader;
import java.io.IOException;
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

	public void menu() {
		int num;
		while(true) {
			try {
				do {
					System.out.println("1.ȸ����ȸ \n2.������Ȳ \n3.������ȸ \n4.����\n:");
					num =Integer.parseInt(br.readLine());
				}while(num<1 || 4<num);

				switch(num) {
				case 1 :
					userSearch(); break;
				case 2 : 
					reservationTicket(); break;
				case 3 :
					totalSale(); break;
				default :
					System.out.println("����Ǿ����ϴ�.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}


	}

	@Override
	public void userSearch() {	

		Iterator<String> it = customerMap.keySet().iterator();

		while(it.hasNext()) {
			CustomerVO vo = customerMap.get(it.next());
			System.out.println(vo.toString());
		}


	}

	@Override
	public void reservationTicket() {


	}

	@Override
	public void totalSale() {


	}


}


