package f_vo;

import java.sql.Date;

public class re_Board {
	
	private int board_num;
	private int board_ID;
	private int re_board_num;
	private String re_board_name;
	private String re_board_content;
	private Date re_board_date;
	
	@Override
	public String toString() {
		return "re_Board [board_num=" + board_num + ", re_board_num=" + re_board_num + ", re_board_name="
				+ re_board_name + ", re_board_content=" + re_board_content + ", re_board_date=" + re_board_date + "]";
	}
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getRe_board_num() {
		return re_board_num;
	}
	public void setRe_board_num(int re_board_num) {
		this.re_board_num = re_board_num;
	}
	public String getRe_board_name() {
		return re_board_name;
	}
	public void setRe_board_name(String re_board_name) {
		this.re_board_name = re_board_name;
	}
	public String getRe_board_content() {
		return re_board_content;
	}
	public void setRe_board_content(String re_board_content) {
		this.re_board_content = re_board_content;
	}
	public Date getRe_board_date() {
		return re_board_date;
	}
	public void setRe_board_date(Date re_board_date) {
		this.re_board_date = re_board_date;
	}

	public int getBoard_ID() {
		return board_ID;
	}

	public void setBoard_ID(int board_ID) {
		this.board_ID = board_ID;
	}
	
	
}
	
	
