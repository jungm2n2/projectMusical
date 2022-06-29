package com.Musical;

public class SignUpException {

	public void inputFormat(String str) throws Exception {

		if(str.length()<8 || 15< str.length()) {

			throw new Exception("8자 이상 15자 이하로 작성해주세요");
		}

		int num = 0,eng = 0;
		for(int i=0;i<str.length();i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				num++;
			}else if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))) {
				eng++;
			}

		}

		if(num ==0 || eng==0) {
			throw new Exception("영대소문자와 숫자를 혼용해야합니다.");
		}	

	}

	public void nameInputFormat(String str) throws Exception {

		if(str.length()<2 || 6<str.length())
			throw new Exception("저장할수 없는 양식입니다.");

	}

	public void genderInputFormat(String str) throws Exception {
		char ch = str.charAt(0);

		if(ch !='m' && ch !='M' && ch !='F' && ch!='f') {

			throw new Exception("M과 F로만 입력해주세요.");
		}	
	}
     
	//[yyyy-mm-dd] 이형태로 입력할 수 있게 예외처리하기 : 정민
	public void birthInputFormat(String str) throws Exception {

		int birth = Integer.parseInt(str);

		if(str.length()>6) {
			throw new Exception("주민등록번호 앞자리 형태로 입력해주세요");	
		}
		if(birth<000101 || 991231< birth) {
			throw new Exception("유효하지 않은 범위입니다.");
		}

	}

	public void mailInputFormat (String str) throws Exception {

		boolean flag = false;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='@' && str.charAt(i)=='.') {
				flag = true;
				break;
			}		
		}
		if(!flag) {
			throw new Exception("잘못된 이메일 형식입니다.");
		}

		int num = 0,eng = 0;
		for(int i=0;i<str.length();i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				num++;
			}else if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))) {
				eng++;
			}
		}

		if(num ==0 || eng==0) {
			throw new Exception("잘못된 이메일 형식입니다.");
		}

	}
	//[010-xxxx-xxxx] 이형태로 입력할 수 있게 예외처리하기 : 정민
	public void telInputFormat(String str) throws Exception {

		for(int i=0;i<str.length();i++) {
			if(!(0<=str.charAt(i) && str.charAt(i)<=9)) {
				throw new Exception("잘못된 번호입니다.");
			}
			if(str.length()>11) {
				throw new Exception("잘못된 번호입니다.");
			}

		}



	}

}
