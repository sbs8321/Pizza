package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.reBoardWriteService;
import f_vo.ActionForward;
import f_vo.Board;
import f_vo.Member;
import f_vo.re_Board;

public class ReBoardwriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//o댓글 쓰기
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		Member loginmember = (Member) session.getAttribute("loginMember");		
		
		
		int boardnum = Integer.parseInt(request.getParameter("num"));
		String name = loginmember.getId();
		String content = request.getParameter("re_board_content");
		String page = request.getParameter("page");
		
		System.out.println("go"+page);
		System.out.println("goo"+boardnum);
		
		
		re_Board reboard = new re_Board();
		reboard.setBoard_num(boardnum);
		reboard.setRe_board_name(name);
		reboard.setRe_board_content(content);
		
		reBoardWriteService reboardwriteService = new reBoardWriteService();
		
		boolean reboardwrite = false;
		reboardwrite = reboardwriteService.reWirte(reboard);
		
		if (reboardwrite) {
			System.out.println("뭐야댓글이");
			forward = new ActionForward();
			forward.setPath("boardViewAction.ac?num="+boardnum+"&page="+page);	
		}else {
			System.out.println("안되잖아");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 달기 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}

		return forward;
	}

	}
