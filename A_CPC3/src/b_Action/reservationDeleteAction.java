package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationDeleteService;
import f_vo.ActionForward;

public class reservationDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		String day = request.getParameter("day");
		ActionForward forward = new ActionForward();
		boolean delete = false; 
		
		reservationDeleteService resdelteService = new reservationDeleteService (); 
		delete = resdelteService.resdelete(num);
		
		if(delete) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("reservationList.ac?date="+day);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('예약 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
