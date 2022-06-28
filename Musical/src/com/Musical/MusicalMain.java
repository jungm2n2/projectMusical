package com.Musical;
//시연
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class MusicalMain {

	static DataImpl di = new DataImpl();

	static HashMap<String, CustomerVO> customerMap = di.getCustomerMap();
	static HashMap<String, TitleVO> titleMap = di.getTitleMap();

	static ManagerImpl implM = new ManagerImpl(customerMap, titleMap);
	static CustomerImpl implC = new CustomerImpl(customerMap, titleMap);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int num;
		while(true) {

			do {
				System.out.println("1.로그인 \n2.회원가입 \n3.종료");
				System.out.println("---------------------------------\n:");
				num = Integer.parseInt(br.readLine());
			}while(num<1 || 3<num);


			switch(num) {
			case 1 :
				login(di.getCustomerMap()); break;
			case 2 : 
				signUp(); break;
			case 3 :
				di.saveData();
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
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

			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));

			try {
				System.out.println("아이디를 입력하세요.");
				String id = br.readLine();

				System.out.println("비밀번호를 입력하세요.");
				String pw = br.readLine();

				System.out.println("비밀번호를 재확인해주세요.");
				do {
					String pw2 = br.readLine();

					if(pw.equals(pw2)) {break;
					}
					else {
						System.out.println("비밀번호가 다릅니다.다시입력해주세요.");
					}

				}while(true);

				System.out.println("이름?");
				String name = br.readLine();

				System.out.println("성별? [F/M]");
				String gender = br.readLine(); 

				System.out.println("생년월일?[yyyy-mm-dd]");
				String birth = br.readLine();

				System.out.println("이메일 주소?");
				String mail = br.readLine();

				System.out.println("핸드폰 번호?[010-xxxx-xxxx]");
				String phone = br.readLine();

				CustomerVO vo = new CustomerVO(id, pw, name, birth, gender, mail, phone);

				customerMap.put(vo.getId(), vo);

			} catch (Exception e) {

				System.out.println(e.toString());     
			}



		}

	}
