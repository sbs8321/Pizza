package f_vo;

import java.sql.Date;

public class reservation {
	
	private int num;
	private String name;
	private String dday;
	private String teacher;
	private String time;
	private int child;
	private Date dates;
	private String contents;
	private int chsh;
	private String id;
	private String phone;
	private int blin=0;
	
	public int getBlin() {
		return blin;
	}
	public void setBlin(int blin) {
		this.blin = blin;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "reservation [num=" + num + ", name=" + name + ", dday=" + dday + ", teacher=" + teacher + ", time="
				+ time + ", child=" + child + ", dates=" + dates + ", contents=" + contents + ", chsh=" + chsh + ", id="
				+ id + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getChsh() {
		return chsh;
	}
	public void setChsh(int chsh) {
		this.chsh = chsh;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDday() {
		return dday;
	}
	public void setDday(String dday) {
		this.dday = dday;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	

}
