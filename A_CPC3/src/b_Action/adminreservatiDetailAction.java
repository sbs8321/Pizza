package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationDetailService;
import f_vo.ActionForward;
import f_vo.reservation;

public class adminreservatiDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String pages = request.getParameter("pages");
		reservation res = null;
		ActionForward forward = null;
		
		reservationDetailService reservationdetailservice = new reservationDetailService();
		res = reservationdetailservice.resdetail(num);
		
		
		forward = new ActionForward();
		
		request.setAttribute("page",page);
		request.setAttribute("pages",pages);
		request.setAttribute("res", res);
		forward.setPath("/info/adminreservationDetail.jsp");
		
		
		
		
		return forward;
	}

}
