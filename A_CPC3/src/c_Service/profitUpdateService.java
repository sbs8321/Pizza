package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.item;
import f_vo.profit;

public class profitUpdateService {

	public profit proupdate(int num) {
		
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);
		
		
		profit profit = null;
		profit = viewDAO.profitview(num);
		return profit;
	}

}
