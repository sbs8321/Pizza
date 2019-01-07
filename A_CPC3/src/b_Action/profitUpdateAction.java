package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.profitUpdateService;
import f_vo.ActionForward;
import f_vo.profit;

public class profitUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ActionForward forward = new ActionForward();
		int num = Integer.parseInt(request.getParameter("num"));
		
		profitUpdateService profitUpdateService = new profitUpdateService();
		profit pro = profitUpdateService.proupdate(num);
		
		
		request.setAttribute("profit", pro);
		forward.setPath("../info/proUpdate.jsp");

		return forward;
	}

}
