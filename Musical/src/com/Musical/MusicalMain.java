package com.Musical;
//시연
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class MusicalMain {
	
	static DataImpl di = new DataImpl();

	static ManagerImpl implM = new ManagerImpl(di.getCustomerMap(), di.getTitleMap());
	static CustomerImpl implC = new CustomerImpl(di.getCustomerMap(), di.getTitleMap());


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.println("1.로그인 \n2.회원가입 \n3.종료");
		System.out.println("---------------------------------\n:");
		String str = br.readLine();

		switch(str) {
		case "1" :
			login(di.getCustomerMap()); break;
		case "2" : 
			signUp(); break;
		case "3" :
			System.exit(0);
		}

	}

	public static void login(HashMap<String, CustomerVO> customerMap) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		String id,pw;

		do{
			System.out.println("아이디?");
			id = br.readLine();

			if(!customerMap.containsKey(id)) {
				System.out.println("존재하지 않는 아이디 입니다.");
			}else {break;}				
		}while(true);


		System.out.println("비밀번호를 입력하세요.");
		pw = br.readLine();
		CustomerVO vo = new CustomerVO();
		vo = customerMap.get(id);
		do{
			if(!vo.getPw().equals(pw)) {
				System.out.println("비밀번호를 확인 해주세요");
				pw = br.readLine();
			}else {
				if(id.equals("admin") && pw.equals("1111")) {
					implM.menu();
					break;
				}
				else {
					System.out.println("로그인 성공!");
					implC.start(id);
					break;
				}
				
			}				
		}while(true);

	}

	public static void signUp() {
		/*		
		try {
			Iterator<NaverVO> it = lists.iterator();
			
	         System.out.println("아이디를 입력하세요.");
	         String id = sc.next();
	         exp.inputFormat(id);
	         vo.setId(id);
		
	         
	         System.out.println("비밀번호를 입력하세요.");
	         
	         String pw = sc.next();
	         
	         exp.inputFormat(pw);
	         
	         System.out.println("비밀번호를 재확인해주세요.");
	         
	         do {
	        	 String pw2 = sc.next();
	         
	        	 if(pw.equals(pw2)) {
	        	 
	        		 vo.setPw(pw2);
	        		 break;
	        	 }
	        	 else {
	        		 System.out.println("비밀번호가 다릅니다.다시입력해주세요.");
	        	 }
	        	 	      	 
	        }while(true);
	        
	         System.out.println("이름?");
	         String name = sc.next();
	         exp.nameInputFormat(name);
	         vo.setName(name);
	         
	         System.out.println("성별? [F/M]");
		        String gender= sc.next();
				exp.genderInputFormat(gender);
		        vo.setGender(gender);
		        
		     
		     System.out.println("생년월일?");
		        String birth = sc.next();
		        exp.birthInputFormat(birth);
		        vo.setBirth(birth);
		        
		        
		     System.out.println("이메일 주소?");
		      	String mail = sc.next();
		      	exp.mailInputFormat(mail);
		      	vo.setEmail(mail);
		      	
		      	
		     System.out.println("핸드폰 번호?");
		     	String tel = sc.next();
		     	
		     	vo.setTel(tel);
	         
		    	lists.add(vo);
	         
	      } catch (Exception e) {
	         
	         System.out.println(e.toString());     
	      }
		
	   }
*/
	}

}
