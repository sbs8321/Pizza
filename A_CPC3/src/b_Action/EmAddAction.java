package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.EmAddService;
import f_vo.ActionForward;
import f_vo.Employee;

public class EmAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Employee employee = new Employee();
		boolean Result = false;

		employee.setName(request.getParameter("name"));
		employee.setAge(Integer.parseInt(request.getParameter("age")));
		employee.setAddress(request.getParameter("address"));
		employee.setPhone(request.getParameter("phone1")+request.getParameter("phone2"));
		employee.setPhonenumber2(request.getParameter("phone3")+request.getParameter("phone4"));

		EmAddService emAddService = new EmAddService();

		Result = emAddService.addEployee(employee);

		ActionForward forward = null;

		if (Result == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('직원 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("EmListAction.ac");
		}
		
		
		return forward;

	}

}
