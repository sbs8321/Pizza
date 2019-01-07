package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.reservation;

public class memberreservationService {

	public ArrayList<reservation> memberreservationList(String id) {
		DAO reDAO = DAO.getInstance();
		Connection con = getConnection();
		reDAO.setConnection(con);
		
		
		ArrayList<reservation> reservationList = reDAO.memberreservationtList(id);
		close(con);
		
		return reservationList;
	}

}
