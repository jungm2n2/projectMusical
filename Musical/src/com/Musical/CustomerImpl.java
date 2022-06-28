package com.Musical;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerImpl implements Customer{
	
	HashMap<String, MusicalVO> hMap = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	MusicalVO vo = new MusicalVO(); 

	@Override
	public void userUpdate() {
		
		
		System.out.print("수정하고 싶은 회원의 아이디를 입력하세요");
		String str = sc.next();
		
		
		
		
		
		
		
	}


	
	
	@Override
	public void reservation() {
	}

	@Override
	public void logout() {
	}

	@Override
	public void userDelete() {
	}




	@Override
	public boolean searchId() {
		
		return false;
	}





	
	
}
