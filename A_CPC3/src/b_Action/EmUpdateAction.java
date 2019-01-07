package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.EmployeeUpdateService;
import f_vo.ActionForward;
import f_vo.Employee;

public class EmUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		ActionForward forward = new ActionForward();

		EmployeeUpdateService employeeupdateService = new EmployeeUpdateService();
		Employee emp = employeeupdateService.empUpdte(num);
		
		request.setAttribute("emp", emp);
		forward.setPath("../info/EmUpdate.jsp");
		
		return forward;
	}

}
