package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.re_Board;

public class reBoardWriteService {

	public boolean reWirte(re_Board reboard) {
		//o댓글 쓰기
		DAO rewriteDAO = DAO.getInstance();
		Connection con = getConnection();
		rewriteDAO.setConnection(con);
		
		boolean Result = false;
		int Count = rewriteDAO.reboardWrite(reboard);
		
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
