package com.Musical;

public class SignUpException {

	public void inputFormat(String str) throws Exception {

		if(str.length()<8 || 15< str.length()) {

			throw new Exception("8�� �̻� 15�� ���Ϸ� �ۼ����ּ���");
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
			throw new Exception("����ҹ��ڿ� ���ڸ� ȥ���ؾ��մϴ�.");
		}	

	}

	public void nameInputFormat(String str) throws Exception {

		if(str.length()<2 || 6<str.length())
			throw new Exception("�����Ҽ� ���� ����Դϴ�.");

	}

	public void genderInputFormat(String str) throws Exception {
		char ch = str.charAt(0);

		if(ch !='m' && ch !='M' && ch !='F' && ch!='f') {

			throw new Exception("M�� F�θ� �Է����ּ���.");
		}	
	}
     
	//[yyyy-mm-dd] �����·� �Է��� �� �ְ� ����ó���ϱ� : ���� (�Ϸ�)
	public void birthInputFormat(String str) throws Exception {

		boolean flag = false;
		
		if(str.charAt(4)=='-' && str.charAt(7)=='-')
			flag = true;
		if(!flag)
			throw new Exception("�߸��� ������� �����Դϴ�");

	
			int year =Integer.parseInt(str.substring(0, 4));
		
			if(year<0 || 2021<year) 
				throw new Exception("�߸��� �⵵�Դϴ�.");
			
			int month =  Integer.parseInt(str.substring(5,7));
			if(month<00 || month>12) 
				throw new Exception("�߸��� ���Դϴ�.");
			
			int day = Integer.parseInt(str.substring(8,10));
			if(day<00 || day>31) {
				throw new Exception("�߸��� ���Դϴ�.");
			
			}

		}


	
//�̸��� ����ó�� �Ϸ� (����)
	public void mailInputFormat (String str) throws Exception {
		
		int su1=0;
		int su2=0;
		int num = str.indexOf("@");
		int num1 = str.indexOf(".");
		int num3=0;
		int eng=0;
	

		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='@') {
				su1++;
			}else if(str.charAt(i)=='.') {
				su2++;
			}
		}	
		
		if (su1==0 || su2==0)	
			
			throw new Exception("�߸��� �̸��� �����Դϴ�.");
		
	
		for(int i=0;i<=num;i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				num3++;
			}else if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i)))  {
				eng++;
			}
		}

		if(num3 ==0 || eng==0) {
			throw new Exception("�����ڿ� ���ڸ� ȥ�����ּ���.");
		}
		
		
		for(int i=num+1;i<num1;i++) {
			
			if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))){
			}else {
				throw new Exception ("�����ڸ� �Է����ּ���");
			
			}
			
		}
			
		for(int i=num1+1;i<str.length();i++) {
			if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))) {
			}else {	
				throw new Exception ("�����ڸ� �Է����ּ���");
			
		}
			
			

}	
	}
	
	
	//[010-xxxx-xxxx] �����·� �Է��� �� �ְ� ����ó���ϱ� : ���� (�Ϸ�)
	public void telInputFormat(String str) throws Exception {
		
/*		if(str.length()!=13)	{
			
			throw new Exception("�߸��� ��ȣ�Դϴ�.");
		
		}
*/		
		boolean flag = false;
	
			if(str.charAt(3)=='-' && str.charAt(8)=='-') {
				flag = true;
			}		
		
		if(!flag) {
			throw new Exception("�߸��� �ڵ��� ��ȣ �����Դϴ�.");
		}
		
		String number = str.substring(0,3);
		if (!number.equals("010"))
			throw new Exception("�߸��� ��ȣ�Դϴ�.");

		for(int i=4;i<8;i++) {
			if(!('0'<=str.charAt(i) && str.charAt(i)<='9')) {
				throw new Exception("�߸��� ��ȣ�Դϴ�.");
			}
			
		}
		
		for(int j=9;j<13;j++) {
			
			if(!('0'<=str.charAt(j) && str.charAt(j)<='9')) {
				
				throw new Exception("�߸��� ��ȣ�Դϴ�.");
				
			}
		}
	}
	
	
	
}
