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

public class adminresservationListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ActionForward forward = null;
		forward = new ActionForward();
		String pages = request.getParameter("pages");
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
		
		int listCount = reservationListService.listCount2(date);
		
		
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
		reservationListService reservationListService = new reservationListService();
		//결제완료
		ArrayList<reservation> reservationList = reservationListService.reservationList(date,page,limit);
		ArrayList<reservation> reservationList2 = reservationListService.reservationList2(date,page,limit);
		
		request.setAttribute("pages", pages);
		request.setAttribute("dates", date);
		request.setAttribute("limit", limit);
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("reservationList1", reservationList2);
		forward.setPath("/info/adminreservation.ac");

		return forward;
	}

}
