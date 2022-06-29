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
	SignUpException se = new SignUpException();
	CustomerVO vo = new CustomerVO(); 

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String changepw;
	int num;


	public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;

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


			System.out.println("수정하고싶은 회원정보를 선택하세요");
			System.out.println("1.비밀번호 \n2.이메일 \n3.핸드폰번호");
			int num2 = (Integer.parseInt(br.readLine()));

			boolean flag = false;


			switch (num2) {
			case 1:
				System.out.println("수정할 비밀번호?");
				vo.setPw(br.readLine());flag = true; break;

			case 2:

				while(true) {
					try { System.out.println("수정할 이메일?");
					vo.setMail(br.readLine());
					se.mailInputFormat(vo.getMail());
					flag = true;
					break;

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			
				break;
				
			case 3:
				
				while(true) {
					
					try {System.out.println("수정할 핸드폰 번호?");
					vo.setPhone(br.readLine());
					se.telInputFormat(vo.getPhone());
					flag = true;
					break;
					
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				 break;
				 
			default:
				flag = false; break;

			}

			if(flag) {
				customerMap.put(id, vo);
				System.out.println("수정 완료!");
			}else {
				System.out.println("번호를 다시 입력하세요"); 
			}


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}


	@Override
	public void reservation() {

		BookticketImpl bk = new BookticketImpl(id, titleMap);
		customerMap.get(id).getPh().add(bk.ViewMenu());
	}

	@Override
	public void checkTicket() {
		customerMap.get(id).printTicket();
	}

	@Override
	public void logout() {

		try {
			System.out.println("로그아웃 하시겠습니까?[Y/N]");
			answer = br.readLine();

			if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("로그아웃이 완료되었습니다");

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


			System.out.print("탈퇴하시겠습니까?[Y/N]");
			String yn = br.readLine();

			if(yn.equals("Y") || yn.equals("y")) {
				customerMap.remove(id);
				System.out.println("회원탈퇴가 완료되었습니다");
			}else {
				System.out.println("다시 입력해주세요");
			}






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
					System.out.println(" ==================================================================");
					System.out.println("ㅣ         ㅡㅡㅡㅡㅡㅡㅡ   ㅡㅡㅡㅡㅡㅡ   ㅡㅡㅡㅡㅡㅡㅡㅡ       ㅣ");                                                  
					System.out.println("ㅣ        ㅣ1.내정보수정ㅣ ㅣ2.예매하기ㅣ ㅣ3.예매내역 조회ㅣ     ㅣ");
					System.out.println("ㅣ        ㅡㅡㅡㅡㅡㅡㅡ   ㅡㅡㅡㅡㅡㅡ    ㅡㅡㅡㅡㅡㅡㅡㅡ       ㅣ");
					System.out.println("ㅣ                 ㅡㅡㅡㅡㅡㅡ      ㅡㅡㅡㅡㅡㅡ                 ㅣ");
					System.out.println("ㅣ                ㅣ4.로그아웃ㅣ    ㅣ5.회원탈퇴ㅣ                ㅣ");
					System.out.println("ㅣ                 ㅡㅡㅡㅡㅡㅡ      ㅡㅡㅡㅡㅡㅡ                 ㅣ");
					System.out.println(" ==================================================================");
					num = Integer.parseInt(br.readLine());
				}while(num<1||num>5);


				switch (num) {

				case(1):userUpdate();break;
				case(2):reservation();break;
				case(3):checkTicket();break;
				case(4):logout();return;
				case(5):userDelete();return;

				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


}