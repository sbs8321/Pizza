package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.profit;

public class profitAddService {

	public boolean profitAdd(profit pro) {
		
		DAO proDAO =DAO.getInstance();
		Connection con = getConnection();
		proDAO.setConnection(con);
		
		boolean add = false;
		
		int ad = proDAO.addprofit(pro);
		
		if(ad>0) {
			add = true;
			commit(con);
		}else {
			add = false;
			rollback(con);
		}
		
		
		return add;
	}

}
