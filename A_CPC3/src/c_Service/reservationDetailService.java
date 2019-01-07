package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.reservation;

public class reservationDetailService {

	public reservation resdetail(int num) {
		DAO resdao = DAO.getInstance();
		Connection con = getConnection();
		resdao.setConnection(con);
		
		reservation res = null;
		res = resdao.detailres(num);
		
		
		return res;
	}

}
