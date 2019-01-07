package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.reservation;

public class searchresService {

	public ArrayList<reservation> search(String search,int page, int limit) {
		DAO resDAO = DAO.getInstance();
		Connection con = getConnection();
		resDAO.setConnection(con);
		ArrayList<reservation> resList = resDAO.ressearch(search, page, limit);
		close(con);
		
		return resList;
	}

}
