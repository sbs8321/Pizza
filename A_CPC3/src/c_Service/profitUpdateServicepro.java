package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.profit;

public class profitUpdateServicepro {

	public boolean itemUpdate(profit pro) {
		
		DAO itemDAO =DAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		
		boolean update = false;
		
		int up = itemDAO.updateprofit(pro);
		
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
