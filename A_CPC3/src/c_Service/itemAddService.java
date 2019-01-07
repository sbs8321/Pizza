package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.item;

public class itemAddService {

	public boolean itemAdd(item item) {
		
		DAO itemDAO =DAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		
		boolean add = false;
		
		int ad = itemDAO.addItem(item);
		
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
