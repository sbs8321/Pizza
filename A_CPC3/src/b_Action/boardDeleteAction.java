package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardDeleteService;
import f_vo.ActionForward;
import f_vo.Board;

public class boardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o 글 삭제 
		HttpSession session = request.getSession();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = (String)request.getParameter("page");
		boolean delete = false;
		ActionForward forward = null;
		
		System.out.print("delete"+page);
		
		BoardDeleteService boardDeleteService = new BoardDeleteService();
		
		delete = boardDeleteService.deleteService(num);
		
		if(delete) {
			System.out.println("글삭제 여긴데");
			forward = new ActionForward();
			forward.setPath("bordList.ac?page="+page);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
