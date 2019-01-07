package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;

public class reBoardDeleteService {

	public boolean deleteService(int num) {
		DAO reDeleteDAO = DAO.getInstance();
		Connection con = getConnection();
		reDeleteDAO.setConnection(con);
		
		boolean delete = false;
		
		int reboardDelete = reDeleteDAO.reDelete(num);
		
		if(reboardDelete>0) {
			delete = true;
			commit(con);
		}else {
			delete = false;
			rollback(con);
		}
		
		
		return delete;
	}

}
