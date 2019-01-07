package b_Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardUpdateService;
import c_Service.BoardViewService;
import c_Service.reBoardListService;
import f_vo.ActionForward;
import f_vo.Board;
import f_vo.re_Board;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o 리뷰 게시판 글 상세보기 및 댓글 목록 보기
		HttpSession session = request.getSession();
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("글번호는"+num);
		String nowPage = (String)request.getParameter("page");
		System.out.println("dsddsdsdpage" + nowPage);
		//o 글정보용
		ActionForward forward= null;
		BoardViewService boardviewServiece = new BoardViewService();
		Board board = boardviewServiece.boardview(num);
		
		
		
		
		//o 댓글용
		reBoardListService reboardlistservice  = new reBoardListService();
		ArrayList<re_Board> reboardList = null;
		reboardList = reboardlistservice.reboardList(num);
		
		
	
		if(board !=null) {
			forward = new ActionForward();
			request.setAttribute("page", nowPage);
			request.setAttribute("board", board);
			request.setAttribute("reboardList", reboardList);
			forward.setPath("/reviewBoard/reviewview.jsp");
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글불러오기 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
