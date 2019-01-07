package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.memberListService;
import f_vo.ActionForward;
import f_vo.Member;

public class listAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o 회원목록
		ActionForward forward = new ActionForward();
		memberListService memberListService = new memberListService();
		ArrayList<Member> memberlist = memberListService.memberList();
		request.setAttribute("memberList", memberlist);
		forward.setRedirect(false);
		forward.setPath("../info/list.jsp");

		return forward;
	}

}
