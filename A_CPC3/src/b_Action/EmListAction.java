package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.EmployeeListService;
import f_vo.ActionForward;
import f_vo.Employee;

public class EmListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;

		forward = new ActionForward();
		EmployeeListService employeeListService = new EmployeeListService();
		ArrayList<Employee> employeeList = employeeListService.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		forward.setPath("./employeeList.jsp");

		return forward;
	}

}
