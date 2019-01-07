package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardCheckService;
import f_vo.ActionForward;
import f_vo.Board;

public class BoardCheckAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o 글 수정 삭제시 비밀번호 체크
		HttpSession session = request.getSession();
		String pass = request.getParameter("pass");
		int num = Integer.parseInt(request.getParameter("num"));
		String nowpage = (String)request.getParameter("page");
		
		BoardCheckService boardCheckService = new BoardCheckService();
		ActionForward forward =null;
		
		String check = boardCheckService.checkService(num);
		Board board = boardCheckService.viewBoard(num);
		
		
		System.out.println(pass);
		System.out.println(check);
		
		System.out.println("체크"+num);
		System.out.println("체크"+nowpage);
		
		if(pass.equals(check)) {
			request.setAttribute("board", board);
			request.setAttribute("page", nowpage);
			forward = new ActionForward();
			forward.setPath("/reviewBoard/reviewUpdate.jsp");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		return forward;
	}

}
