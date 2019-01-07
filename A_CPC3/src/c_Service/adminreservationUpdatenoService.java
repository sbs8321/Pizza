package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;

public class adminreservationUpdatenoService {

	public boolean no(int num, String id) {
		DAO yesDAO =DAO.getInstance();
		Connection con = getConnection();
		yesDAO.setConnection(con);
		
		boolean Result = false;
		
		int result = yesDAO.chshno(num);
		int result1 = yesDAO.idnocount(id);
		
		if(result > 0 && result1 >0) {
			Result = true;
			commit(con);
		}else {
			System.out.println("실패야");
			Result = false;
			rollback(con);
		}
		
		close(con);
		return Result;
	}

}
