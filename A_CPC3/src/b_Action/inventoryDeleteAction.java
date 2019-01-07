package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.itemDeleteService;
import f_vo.ActionForward;

public class inventoryDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		int code = Integer.parseInt(request.getParameter("code"));
		boolean delete = false;
		
		itemDeleteService itemDeleteService = new itemDeleteService();
		delete = itemDeleteService.deleteService(code);
		
		if(delete) {
			System.out.println("목록삭제 여긴데");
			forward = new ActionForward();
			forward.setPath("inventory.ac");
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
