package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.memberreservationService;
import f_vo.ActionForward;
import f_vo.reservation;

public class memberReservationAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		forward = new ActionForward();
		
		String id = request.getParameter("id");
		memberreservationService memberreservationservice = new memberreservationService();
		ArrayList<reservation> reservationList = memberreservationservice.memberreservationList(id);
		
		
		request.setAttribute("reservationList", reservationList);
		forward.setPath("/info/memberreservation.jsp");

		return forward;
	}

}
