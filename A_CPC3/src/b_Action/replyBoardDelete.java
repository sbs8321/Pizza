package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardDeleteService;
import c_Service.reBoardDeleteService;
import f_vo.ActionForward;
import f_vo.Board;

public class replyBoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//o 글 삭제 
				int bnum =  Integer.parseInt(request.getParameter("bnum"));
				String page = request.getParameter("page");
				String num = request.getParameter("num");
				
				System.out.println("페이지"+page);
				System.out.println("글번호"+num);
				System.out.println("댓글번호"+num);
				boolean delete = false;
				ActionForward forward = null;
				
				reBoardDeleteService reboardDeleteService = new reBoardDeleteService();
				delete = reboardDeleteService.deleteService(bnum);
				
				if(delete) {
					System.out.println("글삭제 여긴데");
					forward = new ActionForward();
					forward.setPath("boardViewAction.ac?num="+num+"&page="+page);
					
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
