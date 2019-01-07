package c_Service;

import static e_db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.Board;

public class BoardListService {

	/*public ArrayList<Board> boardList() {
		
		//o 글 목록 
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		ArrayList<Board> boardList = null;
		boardList = listDAO.boardlist();
		
		return boardList;
	}*/

	public int listCount() {
		//o 글갯수
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.listCount();
		close(con);

		return listCount;
	}

	public ArrayList<Board> boardList(int page) {
		
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		ArrayList<Board> boardList = null;
		boardList = listDAO.boardlist(page);
		close(con);
		
		
		
		return boardList;
	}

}
