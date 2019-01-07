package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.LoginService;
import f_vo.ActionForward;
import f_vo.Member;

public class loginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//o 로그인
		Member member = new Member();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		member.setId(id);
		member.setPassword(password);
		
		System.out.println(id);
		System.out.println(password);
		LoginService loginService = new LoginService();
		Member loginMember = loginService.memberLogin(member);
		
		ActionForward forward = null; 
		HttpSession session = null;
		
		if (loginMember !=null) {
			System.out.println("뭐야");
			System.out.println("ac"+loginMember.toString());
			if (!id.equals("sbs")) {
				forward = new ActionForward();
				session = request.getSession();
				session.setAttribute("loginMember", loginMember);
				forward.setRedirect(true);
				forward.setPath("../mainhome.jsp");	
				
				Member member2 = (Member)session.getAttribute("loginMember");
				
				System.out.println(member2.toString());
			}else {
				forward = new ActionForward();
				session = request.getSession();
				session.setAttribute("loginMember", loginMember);
				forward.setRedirect(true);
				forward.setPath("../mainhome.jsp");	
			}
		}else {
			System.out.println("안되잖아");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}
	
		return forward;
	}

}
