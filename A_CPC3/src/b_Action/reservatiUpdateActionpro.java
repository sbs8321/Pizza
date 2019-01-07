package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationUpdatproService;
import f_vo.ActionForward;
import f_vo.reservation;

public class reservatiUpdateActionpro implements Action{

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
		int num = Integer.parseInt(request.getParameter("num"));
		
		res.setNum(num);
		res.setDday(dday);
		res.setTime(time);
		res.setName(name);
		res.setChild(child);
		res.setTeacher(teacher);
		res.setContents(content);
		res.setId(id);
		
		
		ActionForward forward =null;
		boolean Result = false;
		
		
		reservationUpdatproService reservationUpdatproService = new reservationUpdatproService();
		Result = reservationUpdatproService.resupWrite(res);
		
		if(Result) {
			forward = new ActionForward();
			forward.setPath("reservationDetail.ac?num="+num);
		}else {
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
