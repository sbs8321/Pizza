package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.item;

public class ItemListService {

	public ArrayList<item> itemList() {
		ArrayList<item> itemList = null;
		DAO itemlistDAO = DAO.getInstance();
		Connection con = getConnection();
		itemlistDAO.setConnection(con);
		itemList = itemlistDAO.itemlsit();
					
		return itemList;
	}

	

}
