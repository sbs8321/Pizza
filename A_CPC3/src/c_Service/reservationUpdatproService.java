package c_Service;

import static e_db.JdbcUtil.commit;
import static e_db.JdbcUtil.getConnection;
import static e_db.JdbcUtil.rollback;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.reservation;

public class reservationUpdatproService {

	public boolean resupWrite(reservation res) {
		
		DAO upDAO =DAO.getInstance();
		Connection con = getConnection();
		upDAO.setConnection(con);
		
		boolean update = false;
		
		int up = upDAO.updateres(res);
		
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
