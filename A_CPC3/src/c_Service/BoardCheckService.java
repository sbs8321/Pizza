package c_Service;

import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import f_vo.*;
import d_Dao.DAO;

public class BoardCheckService {

	public String checkService(int num) {
		//o 글 수정 삭제시 비밀번호 체크
		DAO checkDAO = DAO.getInstance();
		Connection con = getConnection();
		checkDAO.setConnection(con);
		
		String check = null;
		check = checkDAO.boardCheck(num);
		
		return check;
	}
	public Board viewBoard(int num) {
		DAO checkDAO = DAO.getInstance();
		Connection con = getConnection();
		checkDAO.setConnection(con);
		Board board = checkDAO.viewBoard(num);
		return board;
	}
}
