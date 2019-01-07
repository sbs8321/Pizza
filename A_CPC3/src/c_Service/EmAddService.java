package c_Service;

import java.sql.Connection;
import static e_db.JdbcUtil.*;

import d_Dao.DAO;
import f_vo.Employee;

public class EmAddService {

	public boolean addEployee(Employee employee) {
		
		boolean addSuess = false;
		DAO emdao = DAO.getInstance();
		Connection con = getConnection();
		emdao.setConnection(con);
		int insertAdd=emdao.addEm(employee);
		
		if(insertAdd>0) {
			addSuess=true;
			commit(con);
		}else {
			
			rollback(con);
		}
		close(con);
		
		return addSuess;

	}

}
