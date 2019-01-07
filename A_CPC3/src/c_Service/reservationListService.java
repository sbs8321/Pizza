package c_Service;

import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import d_Dao.DAO;
import f_vo.Employee;
import f_vo.reservation;

public class reservationListService {

	
	
	
	public ArrayList<reservation> reservationList1(String date, int page,int limit) {
		DAO reDAO = DAO.getInstance();
		Connection con = getConnection();
		reDAO.setConnection(con);
		ArrayList<reservation> reservationList = reDAO.reservationtList1(date, page,limit);
		close(con);
		
		return reservationList;
	}

	
	public ArrayList<reservation> reservationList2(String date, int page,int limit) {
		DAO reDAO = DAO.getInstance();
		Connection con = getConnection();
		reDAO.setConnection(con);
		
		
		ArrayList<reservation> reservationList = reDAO.reservationtList2(date, page,limit);
		close(con);
		
		return reservationList;
	}
	
	public ArrayList<reservation> reservationList(String date, int page,int limit) {
		DAO reDAO = DAO.getInstance();
		Connection con = getConnection();
		reDAO.setConnection(con);
		
		
		ArrayList<reservation> reservationList = reDAO.reservationtList(date, page,limit);
		close(con);
		
		return reservationList;
	}
	
	public static int listCount(String date) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.reslistCount(date);
		close(con);

		return listCount;
	}
	
	
	
	//결제안함
	public static int listCount1(String date) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.reslistCount1(date);
		close(con);

		return listCount;
	}

	//결제함
	public static int listCount2(String date) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.reslistCount2(date);
		close(con);

		return listCount;
	}
	// 날짜 검색
	public static int listCount3(String date) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.reslistCount3(date);
		close(con);

		return listCount;
	}
	
	// 아이디 검색
	public static int listCount4(String search) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		int listCount =0;
		listCount = listDAO.reslistCount4(search);
		close(con);

		return listCount;
	}
	
	// 	이름 검색
		public static int listCount5(String search) {
			DAO listDAO = DAO.getInstance();
			Connection con = getConnection();
			listDAO.setConnection(con);
			
			int listCount =0;
			listCount = listDAO.reslistCount5(search);
			close(con);

			return listCount;
		}
	
		//이름 검색
			public static int listCount6(String search) {
				DAO listDAO = DAO.getInstance();
				Connection con = getConnection();
				listDAO.setConnection(con);
				
				int listCount =0;
				listCount = listDAO.reslistCount6(search);
				close(con);

				return listCount;
			}
	
	
	
	
	
	

}
