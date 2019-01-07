package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;

public class itemDeleteService {

	public boolean deleteService(int code) {

		DAO DeleteDAO = DAO.getInstance();
		Connection con = getConnection();
		DeleteDAO.setConnection(con);
		
		boolean delete = false;
		
		int itemDelete = DeleteDAO.itemDelete(code);
		
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
