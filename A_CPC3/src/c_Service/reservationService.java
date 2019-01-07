package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.reservation;

public class reservationService {

	public boolean resWrite(reservation res) {

		DAO resDAO = DAO.getInstance();
		Connection con = getConnection();
		resDAO.setConnection(con);
		
		boolean Result = false;
		int Count = resDAO.resWrite(res);
		
		if(Count > 0) {
			Result = true;
			commit(con);
		}else {
			Result = false;
			rollback(con);
		}
		
		close(con);
		return Result;
	}

}
