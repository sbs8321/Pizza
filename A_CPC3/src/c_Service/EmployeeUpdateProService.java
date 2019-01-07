package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Employee;

public class EmployeeUpdateProService {

	public boolean emproupdate(Employee emp) {
		
		DAO emupDAO =DAO.getInstance();
		Connection con = getConnection();
		emupDAO.setConnection(con);
		
		boolean update = false;
		
		int up = emupDAO.updateEm(emp);
		
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
