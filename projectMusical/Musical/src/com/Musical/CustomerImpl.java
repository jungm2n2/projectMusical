package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CustomerImpl implements Customer{
	
	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;
	String id;
	String answer;
	BookticketImpl bt = null;
	
	CustomerVO vo = new CustomerVO(); 

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String changepw;
	int num;
	

	public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
		bt = new BookticketImpl(customerMap, titleMap);
	}

	@Override
	public void userUpdate() {
		
		try {
			
			System.out.print("비밀번호를 입력해주세요");
			changepw = (br.readLine());
			
			vo = customerMap.get(id);
			
			if(!vo.getPw().equals(changepw)){
				System.out.println("비밀번호가 틀렸습니다");
				return;
		}else {
			System.out.println("비밀번호 인증 완료");
		}
			
			System.out.println("수정할 비밀번호?");
			
			vo.setPw(br.readLine());
			
			System.out.println("수정할 이메일?");
			vo.setMail(br.readLine());
			
			System.out.println("수정할 핸드폰 번호?");
			vo.setPhone(br.readLine());
			
			
			customerMap.put(id, vo);
			System.out.println("수정 완료!");
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
	}
			
	
	@Override
	public void reservation() {
		
		//오빠꺼 불러오기 예매하기
		
	
	
		
		
		
	}

	@Override
	public void logout() {
		
		try {
			System.out.println("로그아웃 하시겠습니까?[Y/N]");
			answer = br.readLine();
			
			if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("로그아웃이 완료되었습니다");
				System.exit(0);
			}else if(answer.equals("N") || answer.equals("n")) {
				return;
			}else {
				System.out.println("다시 입력해주세요");
				return;
			}
			
			
			
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public void userDelete() {
		
		try {
			
			
			System.out.print("탈퇴하고 싶은 회원의 아이디를 입력하세요");
			id = br.readLine();
			

			if(!(searchId(id))){
				System.out.println("입력하신 아이디가 존재하지 않습니다");
				return;
			}
			
			customerMap.remove(id);
			System.out.println("회원탈퇴가 완료되었습니다");
			
			
		} catch (Exception e) {
			
		}
		
	
		
		
		
	}




	@Override
	public boolean searchId(String id) {
		
		return customerMap.containsKey(id);
		
		
		
	}
	
	public void start(String id1) {
		
		try {
			
			id = id1;
		while(true){	
			do {
			System.out.println("1.내정보수정 2.예매하기 3.예매내역 조회 4.로그아웃 5.회원탈퇴");
			num = Integer.parseInt(br.readLine());
			}while(num<1||num>4);
			
			
			switch (num) {
			
			case(1):userUpdate();break;
			case(2):reservation();break;
			case(3):logout();break;
			case(4):logout();break;
			case(5):userDelete();break;
		
			}
		}
			
		} catch (Exception e) {
			
		}
		
		
	}





	
	
}
