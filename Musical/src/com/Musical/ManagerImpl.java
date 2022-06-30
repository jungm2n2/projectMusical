package com.Musical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

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
					System.out.println(" ===========================================================================");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ           ㅣ");                                                  
					System.out.println("ㅣ               ㅣ1.회원조회ㅣ   ㅣ2.예매현황ㅣ   ㅣ3.매출 조회ㅣ         ㅣ");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ           ㅣ");
					System.out.println("ㅣ                      ㅡㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ                     ㅣ");
					System.out.println("ㅣ                     ㅣ4.뮤지컬 추가ㅣ     ㅣ5.메인ㅣ                    ㅣ");
					System.out.println("ㅣ                      ㅡㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ                     ㅣ");
					System.out.println(" ===========================================================================");
					num =Integer.parseInt(br.readLine());
				}while(num<1 || 5<num);

				switch(num) {
				case 1 :
					searchCustomer(); break;
				case 2 : 
					reserveTicket(); break;
				case 3 :
					totalSale(); break;
				case 4:
					addMusical(); break;
				default :
//					System.out.println("종료되었습니다.");
//					메인으로 가기로 바꿔서 주석처리
					return;
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	@Override
	public void searchCustomer() {	

		Iterator<String> it = customerMap.keySet().iterator();

		while(it.hasNext()) {
			CustomerVO vo = customerMap.get(it.next());
			System.out.println(vo.toString());
		}
	}

	@Override
	public void reserveTicket() {
		
		for (String strKey : customerMap.keySet()) {
			
			if(customerMap.get(strKey).getPh().size() > 0) {
				customerMap.get(strKey).printTicket();
			}
		}
	}

	@Override
	public void totalSale() {
		
		try {
			System.out.println(" ===========================================================================");
			System.out.println("                       <매출을 볼 뮤지컬을 선택해주세요>");
			System.out.println(" ===========================================================================");
			
			ArrayList<String> arrTitle = new ArrayList<>();
			int idx = 1;
			for (String strKey : titleMap.keySet()) {
				System.out.println(idx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			String inputNumber = br.readLine();
			
			TitleVO tv = titleMap.get(arrTitle.get(Integer.parseInt(inputNumber) - 1));
			
			System.out.println(tv.getTitle() + "의 총 매출은 " + tv.getTotalSales() + "원 입니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void addMusical() {
		//다른 것들 작동 되는지 확인 후 수정
		try {
			
			String musicalTitle = null;
			String actorPairs = null;
			String date = null;
			String time = null;
			int cost = 0;
			
			System.out.println("추가할 뮤지컬의 이름을 입력하세요.");
			musicalTitle = br.readLine();
			
			ArrayList<DetailsInfo> arrInfo = new ArrayList<>();
			
			for (int i = 0; i < 3; i++) {
				DetailsInfo temp = new DetailsInfo();
				System.out.println((i + 1) + "회차 정보를 입력합니다.");
				
				System.out.println((i + 1) + "회차 배우 조합을 입력하세요. [이정민,시연]");
				actorPairs = br.readLine();
				
				System.out.println((i + 1) + "회차 날짜을 입력하세요. [7/9(토)]");
				date = br.readLine();
				
				System.out.println((i + 1) + "회차 시간을 입력하세요. [11:00]");
				time = br.readLine();
				
				System.out.println((i + 1) + "회차 티켓 금액을 입력하세요. [150000]");
				cost = Integer.parseInt(br.readLine());
				
				temp.setActorPairs(actorPairs);
				temp.setDate(date);
				temp.setTime(time);
				temp.setCost(cost);
				
				arrInfo.add(temp);
			}
			titleMap.put(musicalTitle, new TitleVO(musicalTitle, arrInfo));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
