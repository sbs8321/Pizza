package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.JoinService;
import f_vo.ActionForward;
import f_vo.Member;

public class joinAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * o 1. joinForm.jsp 으로 부터 전송받은 데이터 를 가져옴
		 *o 2. 데이터를 Member 타입 객체에 필드값으로 세팅
		 *o 3. Service 클래스의 회원가입 메소드 호출
		 *o 4. 호출결과를 넘겨 받아서 회워가입 성공, 실패 여부 판단
		 *o   - 성공하면 loginForm 으로 이동
		 *o   - 실패하면 경고창  뒤로가기
		 *o 5. 결과를 MemberController 로 리턴
		*/
		
		//o 회원가입
		Member member = new Member();
		
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
		
		
		
		boolean joinResult = false;
		JoinService JoinService = new JoinService();
		joinResult = JoinService.memberJoin(member);
		
		
		ActionForward forward = null;
		if(joinResult == false) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../loginForm.ac");
			
		}
		
		return forward;
	}

}
