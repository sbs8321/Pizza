package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.item;

public class ItemUpdateService {

	public item itemview(String code) {
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);
		item item = null;
		item = viewDAO.itemview(code);
		return item;
	}

}
