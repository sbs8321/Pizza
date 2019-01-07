package c_Service;


import static e_db.JdbcUtil.*;

import java.sql.Connection;

import d_Dao.DAO;

//o 글 삭제 
public class BoardDeleteService {

	public boolean deleteService(int num) {
		
		DAO DeleteDAO = DAO.getInstance();
		Connection con = getConnection();
		DeleteDAO.setConnection(con);
		
		boolean delete = false;
		
		int boardDelete = DeleteDAO.Delete(num);
		
		if(boardDelete>0) {
			delete = true;
			commit(con);
		}else {
			delete = false;
			rollback(con);
		}
		
		
		return delete;
	}

}
