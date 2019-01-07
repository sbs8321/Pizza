package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.ActionForward;
import f_vo.Board;

public class BoardViewService {
	//o 리뷰 게시판 글 상세보기 
	public Board boardview(int num) {
		DAO viewDAO =DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);
		Board board = new Board();
		board = viewDAO.viewBoard(num);
		
		return board;
	}

}
