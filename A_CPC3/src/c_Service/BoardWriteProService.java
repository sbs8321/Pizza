package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Board;



public class BoardWriteProService {
	//o 리뷰 게시판 글쓰기
	public boolean boaedWrite(Board board) {
		
		DAO writeDAO = DAO.getInstance();
		Connection con = getConnection();
		writeDAO.setConnection(con);
		
		boolean Result = false;
		int Count = writeDAO.boardWrite(board);
		
		if(Count > 0) {
			Result = true;
			commit(con);
		}else {
			Result = false;
			rollback(con);
		}
		
		close(con);
		return Result;
		
	}
}


