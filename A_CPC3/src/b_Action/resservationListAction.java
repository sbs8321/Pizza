package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationListService;
import f_vo.ActionForward;
import f_vo.PageInfo;
import f_vo.reservation;

public class resservationListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date = request.getParameter("date");
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		// 첫 페이지는 1 그다음 파라미터값이 있으면 파라미터값으로 대체
		
		int limit = 10;
		if(request.getParameter("limit")!=null) {
		limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		int listCount = reservationListService.listCount(date);
		
		
		int maxPage = (int)((double)listCount/limit)+1;
		
		
		int startPage = (((int)((double)page/10+0.9))-1) * 10 + 1;
		
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
		
		ActionForward forward = null;
		forward = new ActionForward();
		
		/* 패이징 방법 매개값을 날짜와 페이지 넘버를 받는다
		 * 날짜는 해당 컬럼의 날짜가 같은것만 조회 를 하게 하기위해
		 * 패이지 넘버는 범위를 정해주기 위해서  
		 * */
		
		
		reservationListService reservationListService = new reservationListService();
		ArrayList<reservation> reservationList = reservationListService.reservationList(date,page,limit);
		request.setAttribute("limit", limit);
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("reservationList", reservationList);
		forward.setPath("/reservation/reservationList.jsp");

		return forward;
	}

}
