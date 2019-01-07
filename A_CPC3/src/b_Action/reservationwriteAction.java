package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationService;
import f_vo.ActionForward;
import f_vo.reservation;

public class reservationwriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		reservation res = new reservation();
		String dday = request.getParameter("dday");
		String time = request.getParameter("time");
		String name = request.getParameter("name");
		int child = Integer.parseInt(request.getParameter("child"));
		String teacher = request.getParameter("teacher");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		
		res.setDday(dday);
		res.setTime(time);
		res.setName(name);
		res.setChild(child);
		res.setTeacher(teacher);
		res.setContents(content);
		res.setId(id);
		res.setPhone(phone);
		
		ActionForward forward =null;
		boolean Result = false;
		reservationService reservationService = new reservationService();
		Result = reservationService.resWrite(res);
		
		if(Result) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("reservationList.ac?date="+dday);
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
