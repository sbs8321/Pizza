package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.EmployeeListService;
import c_Service.ProfitService;
import f_vo.ActionForward;
import f_vo.Employee;
import f_vo.profit;

public class ProfitAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		forward = new ActionForward();
		
		ProfitService profitService = new ProfitService();
		ArrayList<profit> profitList = profitService.profitList();
		
		request.setAttribute("profitList", profitList);
		forward.setPath("./profit.jsp");

		return forward;
	}

}
