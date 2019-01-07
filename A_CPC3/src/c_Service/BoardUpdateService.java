package c_Service;

import static e_db.JdbcUtil.*;


import java.sql.Connection;

import d_Dao.DAO;

import f_vo.Board;

public class BoardUpdateService {

	public boolean boardUpdate(Board board) {
		//o 리뷰 게시판 글 수정
		DAO updateDAO = DAO.getInstance();
		Connection con = getConnection();
		updateDAO.setConnection(con);
		boolean updates = false;
		int update = 0;
		update = updateDAO.boardUpdate(board);
		
		
		if(update > 0) {
			System.out.println("수정 성공");
			commit(con);
			updates = true;
		}else {
			System.out.println("수정 오류");
			rollback(con);
			updates = false;
		}
		
		
		return updates;
	}

}
