package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;

public class EmdeleteService {

	public boolean emdelete(int num) {
		
		DAO emdeDAO =DAO.getInstance();
		Connection con = getConnection();
		emdeDAO.setConnection(con);
		
		boolean update = false;
		
		int up = emdeDAO.deleteEm(num);
		
		if(up>0) {
			update = true;
			commit(con);
		}else {
			update = false;
			rollback(con);
		}
		
		
		return update;
	}

}
