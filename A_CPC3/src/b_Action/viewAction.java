package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.MemberViewService;
import f_vo.ActionForward;
import f_vo.Member;

public class viewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//o회원 상세 보기
		String id = request.getParameter("id");
		ActionForward forward = new ActionForward();
		MemberViewService memberViewService = new MemberViewService();
		Member member = memberViewService.viewService(id);
		request.setAttribute("memberView", member);
		forward.setRedirect(false);
		forward.setPath("../info/memberview.jsp");
		
		
		return forward;
	}

}
