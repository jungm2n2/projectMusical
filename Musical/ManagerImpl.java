package Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ManagerImpl implements Manager{
	
	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07"};
	String[] arrPW = {"11111", "22222", "33333"};
	String[] arrName = {"±è¿µ¿î", "ÀÌÁ¤¹Î", "¾È½Ã¿¬"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25"};
	String[] arrGender = {"M", "F", "F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832"};
	String[] arrPoint = {"10000", "10000", "10000"};


	BufferedReader br = new BufferedReader(
		       	new InputStreamReader(System.in));
	
	@Override
	public void userSearch() {
		
		
		
		
	}

	@Override
	public void reservationTicket() {
	}

	@Override
	public void totalSale() {
	}

	@Override
	public void logout() {
	}

}
