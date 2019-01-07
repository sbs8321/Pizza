package d_Dao;


import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.close;
import static e_db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import f_vo.Member;
import f_vo.item;
import f_vo.profit;
import f_vo.re_Board;
import f_vo.reservation;
import f_vo.Board;
import f_vo.Employee;

public class DAO {

	private static DAO DAO;
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private DAO() {
	}

	public static DAO getInstance() {
		if (DAO == null) {
			DAO = new DAO();
		}
		return DAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	
	//o 회원가입
	public int memberJoin(Member member) {

		String sql = "INSERT INTO MEMBERSS VALUES(?,?,?,?,?,?,?,?,?,SYSDATE,?)";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getYy());
			pstmt.setString(5, member.getDirthday());
			pstmt.setString(6, member.getPhonenum());
			pstmt.setInt(7, member.getChild());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getGender());
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();

			// executeQuery : select 문만
			// executeUpdate : insert

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;

	}

	//o 로그인
	public Member memberLogin(Member member) {
		String sql = "SELECT * FROM MEMBERSS WHERE MEMBER_ID=? AND MEMBER_PASSWORD=?";
		Member loginMember = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
					loginMember = new Member();
					loginMember.setId(rs.getString("MEMBER_ID"));
					loginMember.setPassword(rs.getString("MEMBER_PASSWORD"));
					loginMember.setName(rs.getString("MEMBER_NAME"));
					loginMember.setDirthday(rs.getString("MEMBER_BIRTHDAY"));
					loginMember.setPhonenum(rs.getString("MEMBER_PHONENUM"));
					loginMember.setEmail(rs.getString("MEMBER_EMAIL"));
					loginMember.setChild(rs.getInt("MRMBER_CHILD"));
					loginMember.setYy(rs.getInt("MEMBER_YY"));
					loginMember.setGender(rs.getString("MEMBER_GENDER"));
					loginMember.setReservation(rs.getInt("MEMBER_RESERVATION"));
					loginMember.setDay(rs.getDate("MEMBER_DAY"));
					System.out.println("DAO"+loginMember.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return loginMember;
	}

	
	//o 회원목록
	public ArrayList<Member> memberlsit() {
		String sql = "SELECT * FROM MEMBERSS";
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					member = new Member();
					member.setId(rs.getString("MEMBER_ID"));
					member.setPassword(rs.getString("MEMBER_PASSWORD"));
					member.setName(rs.getString("MEMBER_NAME"));
					member.setDirthday(rs.getString("MEMBER_BIRTHDAY"));
					member.setPhonenum(rs.getString("MEMBER_PHONENUM"));
					member.setEmail(rs.getString("MEMBER_EMAIL"));
					member.setChild(rs.getInt("MRMBER_CHILD"));
					member.setYy(rs.getInt("MEMBER_YY"));
					member.setGender(rs.getString("MEMBER_GENDER"));
					member.setReservation(rs.getInt("MEMBER_RESERVATION"));
					member.setDay(rs.getDate("MEMBER_DAY"));
					System.out.println("DAO"+member.toString());
					memberList.add(member);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	
	//o회원 상세 보기
	public Member memberView(String id) {
		String sql = "SELECT * FROM MEMBERSS WHERE MEMBER_ID=? ";
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("MEMBER_ID"));
				member.setPassword(rs.getString("MEMBER_PASSWORD"));
				member.setName(rs.getString("MEMBER_NAME"));
				member.setDirthday(rs.getString("MEMBER_BIRTHDAY"));
				member.setPhonenum(rs.getString("MEMBER_PHONENUM"));
				member.setEmail(rs.getString("MEMBER_EMAIL"));
				member.setChild(rs.getInt("MRMBER_CHILD"));
				member.setYy(rs.getInt("MEMBER_YY"));
				member.setGender(rs.getString("MEMBER_GENDER"));
				member.setReservation(rs.getInt("MEMBER_RESERVATION"));
				member.setDay(rs.getDate("MEMBER_DAY"));
				System.out.println("DAO"+member.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 보기오류" + e.getStackTrace());
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	
	public int memberDelete(String id) {
		String sql = "DELETE MEMBER WHERE ID=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			delete = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}
	
	
	
	
	public boolean memberCheck(String id) {
		String sql = "SELECT ID FROM MEMBER WHERE ID=?";
		boolean ckeckMember = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("id"));
				if(rs.getString("id").equals(id)) {
					ckeckMember = true;
				}else {
					ckeckMember = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ckeckMember;
	}
	
	public int memberUpdate(Member member) {

		String sql = "UPDATE MEMBERSS SET MEMBER_PASSWORD=?,MEMBER_NAME=?,MEMBER_YY=?,MEMBER_BIRTHDAY=?,MEMBER_PHONENUM=?,MRMBER_CHILD=?, MEMBER_EMAIL=?,MEMBER_GENDER=? WHERE MEMBER_ID=?";
		System.out.println(sql);
		int insertCount = 0;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getYy());
			pstmt.setString(4, member.getDirthday());
			pstmt.setString(5, member.getPhonenum());
			pstmt.setInt(6, member.getChild());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getId());
			insertCount = pstmt.executeUpdate();

			// executeQuery : select 문만
			// executeUpdate : insert

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}
	
	//글번호 처리
	public int getNext() {
		String sql = "SELECT MAX(BOARD_NUM) FROM BOARD";
		try {
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1; //글이 등록 되어있을때
			}else {
				return 1;
			}
		}catch(Exception e) {
			System.out.println("글번호오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	
		
	//o 리뷰 게시판 글쓰기
	public int boardWrite(Board board) {
		String sql = "INSERT INTO BOARD VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE)";
		int result = 0;
		int num =0;
		String sql1 = "SELECT MAX(BOARD_NUM) FROM BOARD";
		try {
			
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1; //글이 등록 되어있을때
			}else {
				num=1; // 글이 등록 되어 있지 않을때
			}
			//글번호 처리
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBoard_name());
			pstmt.setString(3, board.getBoard_pass());
			pstmt.setString(4, board.getBoard_subject());
			pstmt.setString(5, board.getBoard_content());
			pstmt.setString(6, "1");
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			//pstmt.setDate(11, );
			result = pstmt.executeUpdate();
			
			System.out.println(board.toString());
		}catch(Exception e) {
			System.out.println("글쓰기 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	//o 글 목록 
	public ArrayList<Board> boardlist(int page) {
		String sql = "SELECT * FROM BOARD WHERE ROWNUM < = 10 AND BOARD_NUM <= ? ORDER BY BOARD_NUM DESC";
		ArrayList<Board> boardlist= new ArrayList<Board>();
		Board board = null;
		String sql1 = "SELECT MAX(BOARD_NUM) FROM BOARD";
		int num =0;
		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1; //글이 등록 되어있을때
			}else {
				num=1; // 글이 등록 되어 있지 않을때
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num - (page -1)*10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
				board = new Board();
				board.setBoard_num(rs.getInt("BOARD_NUM"));
				board.setBoard_name(rs.getString("BOARD_NAME"));
				board.setBoard_pass(rs.getString("BOARD_PASS"));
				board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setBoard_file(rs.getString("BOARD_FILE"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
				board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
				board.setBoard_readcount(rs.getInt("BOARD_READCOUNT"));
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				boardlist.add(board);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("글 불러오기 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardlist;
	}

	
	
	//o 리뷰 게시판 글 상세보기 
	public Board viewBoard(int num) {
		
		String sql = "SELECT * FROM BOARD WHERE BOARD_NUM=?";
		String sql1 ="SELECT BOARD_READCOUNT FROM BOARD WHERE BOARD_NUM=?";
		String sql2 ="UPDATE BOARD SET BOARD_READCOUNT=? WHERE BOARD_NUM=? ";
		Board board = null;
		int redCount = 0;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				redCount = rs.getInt("BOARD_READCOUNT")+1;
				System.out.println(redCount+"하ㅏ하하");
			}else {
				redCount = redCount;
			}
			//조회수 처리 
			//쿼리문을 이용해서 원래의 리드 카운트를 불러오고 그 리드 카운트에 1을 더해준다
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, redCount);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("조회수 증가");
				commit(con);
				
			}else {
				System.out.println("조회수 오류");
				rollback(con);
			}
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				board = new Board();
				board.setBoard_num(rs.getInt("BOARD_NUM"));
				board.setBoard_name(rs.getString("BOARD_NAME"));
				board.setBoard_pass(rs.getString("BOARD_PASS"));
				board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setBoard_file(rs.getString("BOARD_FILE"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
				board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
				board.setBoard_readcount(redCount);
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				System.out.println(rs.getInt("BOARD_NUM"));
			}
		}catch(Exception e) {
			System.out.println("글불러오기 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return board;
	}

	
	//o 리뷰 게시판 글 수정
	public int boardUpdate(Board board) {
		String sql = "UPDATE BOARD SET BOARD_SUBJECT=?, BOARD_NAME=?,BOARD_PASS=?,BOARD_CONTENT=? WHERE BOARD_NUM=?";
		int result = 0;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_subject());
			pstmt.setString(2, board.getBoard_name());
			pstmt.setString(3, board.getBoard_pass());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setInt(5, board.getBoard_num());
			result = pstmt.executeUpdate();			
			System.out.println(board.toString());
			
		}catch(Exception e) {
			System.out.println("수정 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//o 글 수정 삭제시 비밀번호 체크
	public String boardCheck(int num) {
		String sql = "SELECT BOARD_PASS FROM BOARD WHERE BOARD_NUM=?";
		String check = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getString("BOARD_PASS");
			}
		}catch(Exception e) {
			System.out.println("비밀번호 찾기 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}

	
	//o 글 삭제 
	public int Delete(int num) {
		String sql = "DELETE BOARD WHERE BOARD_NUM=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			delete = pstmt.executeUpdate();
			
			
			System.out.println("글삭제 확인");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}

	
	//o댓글 쓰기
	public int reboardWrite(re_Board reboard) {
		String sql = "SELECT MAX(RE_BOARD_NUM) FROM RE_BOARD";
		int renum =0;
		String sql1 = "INSERT INTO RE_BOARD VALUES (?,?,?,?,SYSDATE)";
		int write = 0;
		try {	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				renum = rs.getInt(1)+1;
			}else {
				renum=1;
			}
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, reboard.getBoard_num());
			pstmt.setInt(2, renum);
			pstmt.setString(3, reboard.getRe_board_name());
			pstmt.setString(4, reboard.getRe_board_content());
			write = pstmt.executeUpdate();		
			System.out.println(reboard.toString());
		}catch(Exception e) {
			System.out.println("댓글쓰기 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return write;
	}

	
	//o 리뷰 게시판 댓글 목록 보기
	public ArrayList<re_Board> reboardlist(int boardnum) {
		String sql = "SELECT * FROM RE_BOARD WHERE BOARD_NUM=? ORDER BY RE_BOARD_NUM";
		ArrayList<re_Board> reboardlist= new ArrayList<re_Board>();
		re_Board reboard = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();
				while(rs.next()){
					reboard = new re_Board();
				reboard.setBoard_num(rs.getInt("BOARD_NUM"));
				reboard.setRe_board_num(rs.getInt("RE_BOARD_NUM"));
				reboard.setRe_board_name(rs.getString("RE_BOARD_NAME"));
				reboard.setRe_board_content(rs.getString("RE_BOARD_CONTENT"));
				reboard.setRe_board_date(rs.getDate("RE_BOARD_DATE"));
				reboardlist.add(reboard);
				System.out.println(reboard.toString());
				}
			
		}catch(Exception e) {
			System.out.println("댓글 불러오기 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return reboardlist;
	}

	public int reDelete(int num) {
		String sql = "DELETE RE_BOARD WHERE RE_BOARD_NUM=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			delete = pstmt.executeUpdate();
			System.out.println("댓글삭제 확인");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}

	//전체 글 갯수 조회
	public int listCount() {
		int listCount = 0;
		
		String sql = "SELECT COUNT(*) FROM BOARD";

		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
						}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	
	
	
	// 페이징 처리를 위한 목록 조회
	public ArrayList<Board> boardlist(int page, int limit) {
		String sql = "SELECT * FROM (SELECT ROWNUM RN2, V1. * FROM (SELECT * FROM BOARD ORDER BY BOARD_RE_REF DESC, BOARD_RE_SEQ ASC) V1) V2 WHERE V2.RN2 BETWEEN ? AND ?";
		//ROWNUM DB 에서 제공하는 일련 번호 // 로우넘을 기준으로 어디서부터 어디까지 할꺼냐?
		
		int startRow = (page-1)*limit+1;
		int endRow = page*limit;
		ArrayList<Board> boardList = new ArrayList<Board>();
		Board board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
				board = new Board();
				board.setBoard_num(rs.getInt("BOARD_NUM"));
				board.setBoard_name(rs.getString("BOARD_NAME"));
				board.setBoard_pass(rs.getString("BOARD_PASS"));
				board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setBoard_file(rs.getString("BOARD_FILE"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
				board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
				board.setBoard_readcount(rs.getInt("BOARD_READCOUNT"));
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				boardList.add(board);
				System.out.println(board.toString());
				}while(rs.next());
			}
			}catch(Exception e) {
				System.out.println("글목록 보여주기 오류");
				e.printStackTrace();
			}finally {
			close(pstmt);
			close(rs);
			}
		return boardList;
	}
	
	
	
	// 재고 관리
	public ArrayList<item> itemlsit() {
		String sql = "SELECT * FROM INVENTORY";
		ArrayList<item> itemList = new ArrayList<item>();
		item item = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					item = new item();
					item.setCode(rs.getInt("CODE"));
					item.setName(rs.getString("NAME"));
					item.setAmount(rs.getString("AMOUNT"));
					item.setSdate(rs.getString("SDATE"));
					item.setSupplier(rs.getString("SUPPLIER"));
					itemList.add(item);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}
	
	
	
	
    // 품목 추가
	public int addItem(item item) {
		String sql = "INSERT INTO INVENTORY VALUES (?,?,?,?,?)";
		int add = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getAmount());
			pstmt.setString(4, item.getSdate());
			pstmt.setString(5, item.getSupplier());
			add = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return add;
	
	}

	public item itemview(String code) {
		String sql = "SELECT * FROM INVENTORY WHERE CODE=?";
		item item = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					item = new item();
					item.setCode(rs.getInt("CODE"));
					item.setName(rs.getString("NAME"));
					item.setAmount(rs.getString("AMOUNT"));
					item.setSdate(rs.getString("SDATE"));
					item.setSupplier(rs.getString("SUPPLIER"));
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return item;
	}

	public int updatItem(item item) {
		String sql = "UPDATE INVENTORY SET NAME=?, AMOUNT=?,SDATE=?,SUPPLIER=? WHERE CODE=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getAmount());
			pstmt.setString(3, item.getSdate());
			pstmt.setString(4, item.getSupplier());
			pstmt.setInt(5, item.getCode());
			result = pstmt.executeUpdate();			
			System.out.println(item.toString());
		}catch(Exception e) {
			System.out.println("수정 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
	
	//재고 삭제
	public int itemDelete(int code) {
			String sql = "DELETE INVENTORY WHERE CODE=?";
			int delete =0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				delete = pstmt.executeUpdate();
				System.out.println("재고삭제 확인");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류" + e.getStackTrace());
			}finally {
				close(rs);
				close(pstmt);
			}
			return delete;
	}

	public ArrayList<Employee> selectList() {
		String sql = "SELECT * FROM EMPLOYEE";
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee em = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					em = new Employee();
					em.setName(rs.getString("name"));
					em.setAge(rs.getInt("age"));
					em.setAddress(rs.getString("address"));
					em.setPhone(rs.getString("phone"));
					em.setPhonenumber2(rs.getString("phonenumber2"));
					em.setNum(rs.getInt("num"));
					employeeList.add(em);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return employeeList;

	}

	public int addEm(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?)";
		int insertCount = 0;
		int num=0;
		String sql1 = "SELECT MAX(NUM) FROM EMPLOYEE";
		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1; 
			}else {
				num=1; 
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getAge());
			pstmt.setString(3, employee.getAddress());
			pstmt.setString(4, employee.getPhone());
			pstmt.setString(5, employee.getPhonenumber2());
			pstmt.setInt(6, num);
			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public Employee empUpdate(int num) {
		String sql = "SELECT * FROM EMPLOYEE WHERE num=?";
		Employee emp = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					emp = new Employee();
					emp.setNum(rs.getInt("NUM"));
					emp.setName(rs.getString("NAME"));
					emp.setAddress(rs.getString("ADDRESS"));
					emp.setAge(rs.getInt("AGE"));
					emp.setPhone(rs.getString("PHONE"));
					emp.setPhonenumber2(rs.getString("PHONENUMBER2"));
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return emp;
	}

	public int updateEm(Employee emp) {
		String sql = "UPDATE EMPLOYEE SET NAME=?, AGE=?,ADDRESS=?,PHONE=?, PHONENUMBER2=? WHERE NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,emp.getName());
			pstmt.setInt(2,emp.getAge());
			pstmt.setString(3,emp.getAddress() );
			pstmt.setString(4,emp.getPhone());
			pstmt.setString(5, emp.getPhonenumber2());
			pstmt.setInt(6, emp.getNum() );
			result = pstmt.executeUpdate();			
		}catch(Exception e) {
			System.out.println("수정 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//ㅣㅈㄱ원 삭제
	public int deleteEm(int num) {
		String sql = "DELETE EMPLOYEE WHERE NUM=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			delete = pstmt.executeUpdate();
			System.out.println("직원삭제 확인");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}

	public ArrayList<profit> profitlsit() {
		String sql = "SELECT * FROM PROFIT";
		ArrayList<profit> profitList = new ArrayList<profit>();
		profit po = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					po = new profit();
					po.setNum(rs.getInt("NUM"));
					po.setName1(rs.getString("NAME"));
					po.setMoney1(rs.getInt("MONEY"));
					po.setName2(rs.getString("NAMES"));
					po.setMoney2(rs.getInt("MONEYS"));
					po.setMoney3(rs.getInt("MONEYSUM"));
					po.setEtc(rs.getString("ETC"));
					po.setDate(rs.getDate("DATES"));
					profitList.add(po);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return profitList;

	}

	public int addprofit(profit pro) {
		String sql = "INSERT INTO PROFIT VALUES (?,?,?,?,?,?,?,SYSDATE)";
		int insertCount = 0;
		int num=0;
		String sql1 = "SELECT MAX(NUM) FROM PROFIT";
		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1; 
			}else {
				num=1; 
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2,pro.getName1() );
			pstmt.setInt(3,pro.getMoney1() );
			pstmt.setString(4,pro.getName2() );
			pstmt.setInt(5, pro.getMoney2());
			pstmt.setInt(6, pro.getMoney3());
			pstmt.setString(7, pro.getEtc());
			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public profit profitview(int num) {
		String sql = "SELECT * FROM PROFIT WHERE NUM=?";
		profit profit= null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					profit = new profit();
					profit.setDate(rs.getDate("DATES"));
					profit.setName1(rs.getString("NAME"));
					profit.setMoney1(rs.getInt("MONEY"));
					profit.setName2(rs.getString("NAMES"));
					profit.setMoney2(rs.getInt("MONEYS"));
					profit.setMoney3(rs.getInt("MONEYSUM"));
					profit.setEtc(rs.getString("ETC"));
					profit.setNum(rs.getInt("NUM"));
					
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return profit;
	}

	public int updateprofit(profit pro) {
		String sql = "UPDATE PROFIT SET NAME=?,MONEY=?,NAMES=?,MONEYS=?,MONEYSUM=?,ETC=? WHERE NUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro.getName1());
			pstmt.setInt(2, pro.getMoney1());
			pstmt.setString(3, pro.getName2());
			pstmt.setInt(4, pro.getMoney2());
			pstmt.setInt(5, pro.getMoney3());
			pstmt.setString(6,pro.getEtc());
			pstmt.setInt(7,pro.getNum());
			result = pstmt.executeUpdate();			
		}catch(Exception e) {
			System.out.println("수정 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int proDelete(int num) {
		String sql = "DELETE PROFIT WHERE NUM=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			delete = pstmt.executeUpdate();
			System.out.println("삭제 확인");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}

	public int adminUpdate(Member member) {
		String sql = "UPDATE MEMBERSS SET MEMBER_PASSWORD=?,MEMBER_NAME=?,MEMBER_YY=?,MEMBER_BIRTHDAY=?,MEMBER_PHONENUM=?,MRMBER_CHILD=?, MEMBER_EMAIL=?,MEMBER_GENDER=? WHERE MEMBER_ID=?";
		System.out.println(sql);
		int insertCount = 0;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getYy());
			pstmt.setString(4, member.getDirthday());
			pstmt.setString(5, member.getPhonenum());
			pstmt.setInt(6, member.getChild());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getId());
			insertCount = pstmt.executeUpdate();

			// executeQuery : select 문만
			// executeUpdate : insert

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	public int resWrite(reservation res) {
		String sql = "INSERT INTO RESERVATION VALUES (?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
		int result = 0;	
		String sql1 = "SELECT MAX(DAYNUM) FROM RESERVATION WHERE DDAY=?";
		int num =0;
		String sql2 = "SELECT MAX(NUM) FROM RESERVATION";
		int resnum=0;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, res.getDday());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1; 
			}else {
				num=1; 
			}
			//날짜별 글번호 처리
			
			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resnum = rs.getInt(1)+1; 
			}else {
				resnum=1; 
			}
			//날짜별 글번호 처리
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, resnum);
			pstmt.setString(2, res.getName());
			pstmt.setString(3, res.getDday());
			pstmt.setString(4, res.getTeacher());
			pstmt.setInt(5, res.getChild());
			pstmt.setString(6, res.getTime());
			pstmt.setString(7, res.getContents());
			pstmt.setInt(8, 0);
			pstmt.setString(9, res.getId());
			pstmt.setString(10, res.getPhone());
			pstmt.setInt(11, num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("예약 오류");
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
	//결제안함
	public int reslistCount1(String date) {
		int listCount = 0;
		
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=? AND CASH=0";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	
	public ArrayList<reservation> reservationtList1(String date,int page,int limit) {
		String sql = "select * from (select rownum t1, t2.* from ( select * from RESERVATION where DDAY=? and cash=0 order by daynum desc)t2) where t1 between ? and ?";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		int start = (page-1)*limit+1;
		int end = start+limit-1;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex.getStackTrace());
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}
	
	
	public int reslistCount2(String date) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=? AND CASH=1";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	
	
	public ArrayList<reservation> reservationtList2(String date,int page,int limit) {
		//String sql = "SELECT * FROM RESERVATION WHERE DDAY=? AND ROWNUM <= ? AND DAYNUM <=? AND CASH=1 ORDER BY NUM DESC";
		String sql = "select * from (select rownum t1, t2.* from ( select * from RESERVATION where DDAY=? and cash=1 order by daynum desc)t2) where t1 between ? and ?";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		
		int start = (page-1)*limit+1;
		int end = start+limit-1;
		
		try {
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex.getStackTrace());
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;

	}
	
	
	public int reslistCount(String date) {
		int listCount = 0;
		
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
						}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	public ArrayList<reservation> reservationtList(String date,int page,int limit) {
		String sql = "SELECT * FROM RESERVATION WHERE DDAY=? AND ROWNUM < = ? AND DAYNUM <=? ORDER BY NUM DESC";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		String sql1 = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=?";
		int num =0;
		
		try {
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1); 
			}else {
				num=1; 
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setInt(2, limit);
			pstmt.setInt(3, num - (page -1)*10);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex.getStackTrace());
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;

	}
	
	/* 예약을할때는 예약 번호 (NUM)과 날짜별 예약번호(DAYNUM)가 입력 되게 에 설정 한다
	 * 리스트 조회시 
	 * 1.쿼리문을 이용 하여 날짜컬럼의 값이 같은 데이터의 갯수를 조회하여 1을 더한다  
	 * 2.쿼리문을 이용 날짜가 같은 데이터 , 날짜별예약번호가 페이지 출력 게시물 계산법을 이용 (pstmt.setInt(2, num - (page -1)*10); 하여 그수보다 작은 것들중 아래부터 ROWNUM 으로 제한
	 * 3. 출력!!
	 * */
	
	
	
	
	
	
	public reservation detailres(int num) {
		String sql = "SELECT * FROM RESERVATION WHERE NUM=?";
		reservation res = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return res;

	}

	public int updateres(reservation res) {
		String sql = "UPDATE RESERVATION SET NAME=?,DDAY=?,TEACHER=?,CHILD=?,TIME=?,CONTENT=?,CASH=?, ID=? WHERE NUM=?";
		System.out.println(sql);
		int insertCount = 0;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, res.getName() );
			pstmt.setString(2, res.getDday());
			pstmt.setString(3, res.getTeacher());
			pstmt.setInt(4, res.getChild());
			pstmt.setString(5, res.getTime());
			pstmt.setString(6, res.getContents());
			pstmt.setInt(7, res.getChsh());
			pstmt.setString(8, res.getId());
			pstmt.setInt(9, res.getNum());
			insertCount = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				close(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	public int resDelete(int num) {
		String sql = "DELETE RESERVATION WHERE NUM=?";
		int delete =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			delete = pstmt.executeUpdate();
			System.out.println("삭제 확인");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return delete;
	}

	public int chshyes(int num) {
		String sql = "SELECT CASH FROM RESERVATION WHERE NUM=?";
		String sql1 = "UPDATE RESERVATION SET CASH=? WHERE NUM=?";
		int cash =0;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cash = rs.getInt(1)+1;
			}else {
				
			}
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, cash);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	

	public int idcount(String id) {
		String sql = "SELECT MAX(MEMBER_RESERVATION) FROM MEMBERSS WHERE MEMBER_ID=?";
		String sql1 = "UPDATE MEMBERSS SET MEMBER_RESERVATION=? WHERE MEMBER_ID=?";
		int res =0;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1)+1;
			}else {
				
			}
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, res);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int chshno(int num) {
		String sql = "SELECT CASH FROM RESERVATION WHERE NUM=?";
		String sql1 = "UPDATE RESERVATION SET CASH=? WHERE NUM=?";
		int cash =0;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cash = rs.getInt(1)-1;
			}else {
				
			}
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, cash);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int idnocount(String id) {
		String sql = "SELECT MAX(MEMBER_RESERVATION) FROM MEMBERSS WHERE MEMBER_ID=?";
		String sql1 = "UPDATE MEMBERSS SET MEMBER_RESERVATION=? WHERE MEMBER_ID=?";
		int res =0;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1)-1;
			}else {
				
			}
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, res);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류" + e.getStackTrace());
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	
	
	
	public int reslistCount3(String date) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	public ArrayList<reservation> daysearch(String search,int page, int limit) {
		String sql = "SELECT * FROM RESERVATION WHERE DDAY=? AND ROWNUM < = ? AND DAYNUM <=? ORDER BY NUM DESC";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		String sql1 = "SELECT COUNT(*) FROM RESERVATION WHERE DDAY=?";
		int num =0;
		
		try {
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1); 
			}else {
				num=1; 
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, limit);
			pstmt.setInt(3, num - (page -1)*10);
			rs = pstmt.executeQuery();	
			
			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}
	

	public int reslistCount4(String search) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE ID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	public ArrayList<reservation> idsearch(String search,int page,int limit) {
		String sql = "SELECT * FROM RESERVATION WHERE ID=? AND ROWNUM < = ? AND NUM <=? ORDER BY NUM DESC";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		String sql1 = "SELECT COUNT(*) FROM RESERVATION WHERE ID=?";
		int num =0;
		
		try {
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1); 
			}else {
				num=1; 
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, limit);
			pstmt.setInt(3, num - (page -1)*10);
			rs = pstmt.executeQuery();	
			
			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
					System.out.println("rhnhnhnhnhnhnhn");
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	public int reslistCount5(String search) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE NAME=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	
	public ArrayList<reservation> namesearch(String search,int page, int limit) {
		String sql = "SELECT * FROM RESERVATION WHERE NAME=? AND ROWNUM < = ? AND NUM <=? ORDER BY NUM DESC";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		String sql1 = "SELECT COUNT(*) FROM RESERVATION WHERE NAME=?";
		int num =0;
		
		try {
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1); 
			}else {
				num=1; 
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, limit);
			pstmt.setInt(3, num - (page -1)*10);
			rs = pstmt.executeQuery();	
			
			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	public int reslistCount6(String search) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE TEACHER=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			}catch(Exception e) {
				
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	public ArrayList<reservation> ressearch(String search,int page,int limit) {
		String sql = "SELECT * FROM RESERVATION WHERE TEACHER=? AND ROWNUM < = ? AND NUM <=? ORDER BY NUM DESC";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		String sql1 = "SELECT COUNT(*) FROM RESERVATION WHERE TEACHER=?";
		int num =0;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1); 
			}else {
				num=1; 
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, limit);
			pstmt.setInt(3, num - (page -1)*10);
			rs = pstmt.executeQuery();	
	
			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	public ArrayList<reservation> memberreservationtList(String id) {
		String sql = "SELECT * FROM RESERVATION WHERE ID=? ORDER BY DDAY";
		ArrayList<reservation> reservationList = new ArrayList<reservation>();
		reservation res = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					res = new reservation();
					res.setNum(rs.getInt("NUM"));
					res.setName(rs.getString("NAME"));
					res.setDday(rs.getString("DDAY"));
					res.setTime(rs.getString("TIME"));
					res.setTeacher(rs.getString("TEACHER"));
					res.setChild(rs.getInt("CHILD"));
					res.setDates(rs.getDate("DATES"));
					res.setContents(rs.getString("CONTENT"));
					res.setChsh(rs.getInt("CASH"));
					res.setId(rs.getString("ID"));
					res.setPhone(rs.getString("PHONE"));
					System.out.println(res.toString());
					reservationList.add(res);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 오류: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
