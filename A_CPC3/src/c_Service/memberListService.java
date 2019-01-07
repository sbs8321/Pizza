package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.Member;

public class memberListService {
		//o 회원목록
		public ArrayList<Member> memberList() {
			ArrayList<Member> memberList = null;
			DAO listDAO = DAO.getInstance();
			Connection con = getConnection();
			listDAO.setConnection(con);
			memberList = listDAO.memberlsit();
						
			return memberList;
		}
}
