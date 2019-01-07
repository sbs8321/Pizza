package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c_Service.BoardListService;
import f_vo.ActionForward;
import f_vo.Board;
import f_vo.PageInfo;


public class boardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o 글 목록 
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();
		BoardListService boardListService = new BoardListService();
		
		//o 내가 머문 페이지의 번호를 들고다녀야 한다
		int page =1; //o 페이지 번호를 받기 위해 사용 하는 변수
		//한 페이지에 보여주는 글갯수 제한
		int limit = 10;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 전체 글에 대한 페이지의 갯수를 표시해줘야함
		int listCount = boardListService.listCount();
		
		//범위를 지정하여 글을 가져 오자
		//ArrayList<Board> boardlist = boardListService.boardList();
		ArrayList<Board> boardlist = boardListService.boardList(page);
		
		//페이지 계산
		int maxPage = (int)((double)listCount/limit+1);
		
		
		//시작 페이지 계산
		int startPage = (((int)((double)page/10+0.9))-1) * 10 + 1;
	
		// 페이지의 갯수가 필요가 없다면 페이지의 갯수를 제한 한다
		int endPage = startPage +10 -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		PageInfo pageinfo = new PageInfo();
		pageinfo.setEndPage(endPage);
		pageinfo.setListCount(listCount);
		pageinfo.setMaxPage(maxPage);
		pageinfo.setPage(page);
		pageinfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("boardList", boardlist);	
		forward.setPath("/reviewBoard/reviewList.jsp");
	
		return forward;
	}

}
