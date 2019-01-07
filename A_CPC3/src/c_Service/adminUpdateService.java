package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Member;

public class adminUpdateService {

	public boolean adminupdate(Member member) {
		DAO memberDAO =DAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		boolean joinResult = false;
		
		int result = memberDAO.adminUpdate(member);
		
		if(result > 0) {
			joinResult = true;
			commit(con);
		}else {
			joinResult = false;
			rollback(con);
		}
		
		close(con);
		return joinResult;
	}

}
