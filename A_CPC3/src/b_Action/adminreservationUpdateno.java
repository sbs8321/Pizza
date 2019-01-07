package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.adminreservationUpdatenoService;
import f_vo.ActionForward;

public class adminreservationUpdateno implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String id =request.getParameter("id");
		String date=request.getParameter("date");
		String pages = request.getParameter("pages");
		boolean Result = false;
		
		adminreservationUpdatenoService adminreservationupdateno = new adminreservationUpdatenoService();
		
		Result = adminreservationupdateno.no(num,id);
		
		if(Result == false) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}else {
			if(pages.equals("nameSearch")){
				forward = new ActionForward();
				forward.setPath("/info/reservationserchname.ac?date="+date+"&pages="+pages);
				
			}else if(pages.equals("idSearch")) {
				forward = new ActionForward();
				forward.setPath("/info/reservationserhid.ac?date="+date+"&pages="+pages);
				
			}else if(pages.equals("teacherSearch")){
				forward = new ActionForward();
				forward.setPath("/info/reservationserchres.ac?date="+date+"&pages="+pages);
				
			}else if(pages.equals("daySearch")){
				forward = new ActionForward();
				forward.setPath("/info/reservationserchday.ac?date="+date+"&pages="+pages);
				
			}else if(pages.equals("CashYes")) {
				forward = new ActionForward();
				forward.setPath("/info/adminreservationYes.ac?date="+date+"&pages="+pages);
				
			}else if(pages.equals("CashNo")) {
				forward = new ActionForward();
				forward.setPath("/info/adminreservationCashNo.ac?date="+date+"&pages="+pages);
			}
		}
		
		return forward;
	}

}
