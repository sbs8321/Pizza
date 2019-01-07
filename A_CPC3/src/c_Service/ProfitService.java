package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.item;
import f_vo.profit;

public class ProfitService {

	public ArrayList<profit> profitList() {
		
		
		ArrayList<profit> profitList = null;
		DAO proDAO = DAO.getInstance();
		Connection con = getConnection();
		proDAO.setConnection(con);
		profitList = proDAO.profitlsit();
					
		return profitList;
	}

}
