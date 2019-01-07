package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.BoardWriteProService;
import f_vo.ActionForward;
import f_vo.Board;
public class boardWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//o 리뷰 게시판 글쓰기
		Board board = new Board();
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_content(request.getParameter("board_content"));
		
		ActionForward forward =null;
		boolean WriteResult = false;
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		WriteResult = boardWriteProService.boaedWrite(board);
		
		if(WriteResult) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bordList.ac");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글쓰기 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}
	

}
