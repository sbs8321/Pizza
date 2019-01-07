package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationDetailService;
import f_vo.ActionForward;
import f_vo.reservation;

public class reservationserchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String herf = request.getParameter("herf");
		String serch = request.getParameter("serch");
		
		ActionForward forward = null;
		forward = new ActionForward();
		
		forward.setPath(herf+"&serch="+serch);	
		return forward;
	}

}
