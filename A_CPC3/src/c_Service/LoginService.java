package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;

import d_Dao.DAO;
import f_vo.Member;

public class LoginService {
	//o 로그인
	public Member memberLogin(Member member) {
		Member result = null;
		DAO loginDAO = DAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		Member loginMember = loginDAO.memberLogin(member);
		close(con);
		
		if(loginMember != null) {
			result = loginMember;
			System.out.println("ser"+loginMember.toString());
		}else {
			result = null;
		}
		
		return result;
	}

}
