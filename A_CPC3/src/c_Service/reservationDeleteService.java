package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;

public class reservationDeleteService {

	public boolean resdelete(int num) {
		DAO resDAO = DAO.getInstance();
		Connection con = getConnection();
		resDAO.setConnection(con);
		
		boolean delete = false;
		
		int itemDelete = resDAO.resDelete(num);
		
		if(itemDelete>0) {
			delete = true;
			commit(con);
		}else {
			delete = false;
			rollback(con);
		}
		
		
		return delete;
	}

}
