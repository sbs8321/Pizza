package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Employee;
import f_vo.item;

public class EmployeeUpdateService {

	public Employee empUpdte(int num) {
		
		DAO empUpDAO = DAO.getInstance();
		Connection con = getConnection();
		empUpDAO.setConnection(con);
		
		Employee emp = null;
		emp = empUpDAO.empUpdate(num);
		return emp;
	}

}
