package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.item;

public class itemUpdateServicepro {

	public boolean itemUpdate(item item) {
		DAO itemDAO =DAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		
		boolean update = false;
		
		int up = itemDAO.updatItem(item);
		
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


