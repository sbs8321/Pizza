package c_Service;


import static e_db.JdbcUtil.*;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Member;

public class MemberViewService {

	public Member viewService(String id) {
		//o회원 상세 보기
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);
		Member viewMember = viewDAO.memberView(id);
		close(con);
		
		return viewMember;
	}

	

}
