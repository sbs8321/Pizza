package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardUpdateService;
import f_vo.ActionForward;
import f_vo.Board;

public class boardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//o 리뷰 게시판 글 수정
		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String nowpage = (String) request.getParameter("page");
		
		System.out.println("업데이트"+num);
		System.out.println("업데이트"+nowpage);
		Board board= new Board();
		board.setBoard_num(num);
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_content(request.getParameter("board_content"));
		
		ActionForward forward = new ActionForward();
		BoardUpdateService boardUpdateService = new BoardUpdateService();
		boolean update = false;
		update = boardUpdateService.boardUpdate(board);
		System.out.println(board.toString());
		
		
		if (update) {
			System.out.println("수정됬어");
			forward = new ActionForward();
			request.setAttribute("board", board);
			forward.setPath("/boardViewAction.ac?num="+board.getBoard_num()+"&page="+nowpage);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
