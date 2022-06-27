package Musical;

public class MusicalVO {
	
	String id;
	String pw;
	String name;
	String birth;
	String gender;
	String mail;
	String phone;
	String point;
	
	public MusicalVO() {
		
		
		
	}
	
	public MusicalVO(String id, String pw, String name, String birth, String gender, String mail, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
	}
	
	public MusicalVO(String id, String pw, String name, String birth, String gender, String mail, String phone,
			String point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
		this.point = point;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	
	
	
	
 
}
