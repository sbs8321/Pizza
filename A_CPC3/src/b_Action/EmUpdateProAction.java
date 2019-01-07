package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.EmployeeUpdateProService;
import f_vo.ActionForward;
import f_vo.Employee;

public class EmUpdateProAction implements Action  {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		boolean up = false;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String phone1 = request.getParameter("phone1")+request.getParameter("phone2");
		String phone2 = request.getParameter("phone3")+request.getParameter("phone4");
		
		Employee emp = new Employee();
		emp.setNum(num);
		emp.setName(name);
		emp.setAge(age);
		emp.setAddress(address);
		emp.setPhone(phone1);
		emp.setPhonenumber2(phone2);
		
		
		
		EmployeeUpdateProService employeeUpdateproservice = new EmployeeUpdateProService();
		up = employeeUpdateproservice.emproupdate(emp);
		
		if(up) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("EmListAction.ac");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('직원 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
