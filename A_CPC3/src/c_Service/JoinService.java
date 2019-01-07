package c_Service;

import static e_db.JdbcUtil.*;


import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Member;

public class JoinService {
	
public boolean memberJoin(Member member) {
	//o 회원가입
		DAO memberDAO =DAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		boolean joinResult = false;
		
		int result = memberDAO.memberJoin(member);
		
		if(result > 0) {
			joinResult = true;
			commit(con);
		}else {
			joinResult = false;
			rollback(con);
		}
		
		close(con);
		return joinResult;
	}


}
