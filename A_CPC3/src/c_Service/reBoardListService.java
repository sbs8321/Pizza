package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.re_Board;

public class reBoardListService {
	//o 리뷰 게시판  댓글 목록 보기
	public ArrayList<re_Board> reboardList(int num) {
		System.out.println("00001"+num);
		DAO relistDAO = DAO.getInstance();
		Connection con = getConnection();
		relistDAO.setConnection(con);
		
		ArrayList<re_Board> reboardList = null;
		reboardList = relistDAO.reboardlist(num);
		
		return reboardList;
	}

}
