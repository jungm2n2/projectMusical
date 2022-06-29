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
     
	//[yyyy-mm-dd] �����·� �Է��� �� �ְ� ����ó���ϱ� : ����
	public void birthInputFormat(String str) throws Exception {

		int birth = Integer.parseInt(str);

		if(str.length()>6) {
			throw new Exception("�ֹε�Ϲ�ȣ ���ڸ� ���·� �Է����ּ���");	
		}
		if(birth<000101 || 991231< birth) {
			throw new Exception("��ȿ���� ���� �����Դϴ�.");
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
			throw new Exception("�߸��� �̸��� �����Դϴ�.");
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
			throw new Exception("�߸��� �̸��� �����Դϴ�.");
		}

	}
	//[010-xxxx-xxxx] �����·� �Է��� �� �ְ� ����ó���ϱ� : ����
	public void telInputFormat(String str) throws Exception {

		for(int i=0;i<str.length();i++) {
			if(!(0<=str.charAt(i) && str.charAt(i)<=9)) {
				throw new Exception("�߸��� ��ȣ�Դϴ�.");
			}
			if(str.length()>11) {
				throw new Exception("�߸��� ��ȣ�Դϴ�.");
			}

		}



	}

}
