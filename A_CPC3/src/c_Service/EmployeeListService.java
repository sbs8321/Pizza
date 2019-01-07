package c_Service;

import static e_db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.Employee;

public class EmployeeListService {

	public ArrayList<Employee> getEmployeeList() {
		DAO emDAO = DAO.getInstance();
		Connection con = getConnection();
		emDAO.setConnection(con);
		ArrayList<Employee> employeeList = emDAO.selectList();
		close(con);
		
		return employeeList;
	}

}
