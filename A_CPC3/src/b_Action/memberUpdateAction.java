package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.memberUpdateService;
import f_vo.ActionForward;
import f_vo.Member;

public class memberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member = new Member();
		HttpSession session = null;
		String id =  (String) request.getParameter("id");
		String password = (String) request.getParameter("password1");
		String name = (String) request.getParameter("name");
		int brith1 = Integer.parseInt(request.getParameter("bir1"));
		String brith2 = (String) request.getParameter("bir2");
		String brith3 = (String) request.getParameter("bir3");
		String brithday = brith2+brith3;
		String phone1 = (String) request.getParameter("phone1");
		String phone2 = (String) request.getParameter("phone2");
		String phonenum = phone1+phone2;
		int child = Integer.parseInt(request.getParameter("child"));
		String gender = request.getParameter("gender");
		String email1 = (String) request.getParameter("email1");
		String email2 = (String) request.getParameter("email2");
		String email = email1+email2;
		

		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setYy(brith1);
		member.setDirthday(brithday);
		member.setPhonenum(phonenum);
		member.setChild(child);
		member.setGender(gender);
		member.setEmail(email);
		
		
		
		boolean Result = false;
		
		memberUpdateService adminupdateService = new memberUpdateService();
		Result = adminupdateService.adminupdate(member);
		
		
		ActionForward forward = null;
		if(Result == false) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}else {
			forward = new ActionForward();
			session = request.getSession();
			session.setAttribute("loginMember", member);
			forward.setPath("./memberinfo.jsp");
			
		}
		
		return forward;
		
	}

}
