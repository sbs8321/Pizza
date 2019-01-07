package f_vo;

import java.sql.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private int yy;
	private String dirthday;
	private String phonenum;
	private int child;
	private String gender;
	private Date day;
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	private int reservation;
	
	
	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYy() {
		return yy;
	}

	public void setYy(int yy) {
		this.yy = yy;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	private String email;
	

	

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", yy=" + yy + ", dirthday="
				+ dirthday + ", phonenum=" + phonenum + ", child=" + child + ", gender=" + gender + ", email=" + email
				+ "]";
	}

	public String getDirthday() {
		return dirthday;
	}

	public void setDirthday(String dirthday) {
		this.dirthday = dirthday;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


}
