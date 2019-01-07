package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationDetailService;
import f_vo.ActionForward;
import f_vo.reservation;

public class reservatiUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		reservation res = null;
		ActionForward forward = null;
		
		reservationDetailService reservationdetailservice = new reservationDetailService();
		res = reservationdetailservice.resdetail(num);
		
		
		forward = new ActionForward();
		
		
		request.setAttribute("res", res);
		forward.setPath("/reservation/reservationUpdate.jsp");
		
		
		
		
		return forward;
	}

}
