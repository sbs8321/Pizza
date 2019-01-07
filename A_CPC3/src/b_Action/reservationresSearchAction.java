package b_Action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.reservationListService;
import c_Service.searchresService;
import f_vo.ActionForward;
import f_vo.PageInfo;
import f_vo.reservation;

public class reservationresSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		forward = new ActionForward();
		String pages = request.getParameter("pages");
		String search = request.getParameter("search");
	
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;
		if(request.getParameter("limit")!=null) {
		limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		
		int listCount = reservationListService.listCount3(search);
	
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
		
		
		searchresService searchresservice = new searchresService();
		ArrayList<reservation> resList = searchresservice.search(search,page,limit);
		
		
		request.setAttribute("search", search);
		request.setAttribute("pages", pages);
		request.setAttribute("limit", limit);
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("reservationList", resList);
		forward.setPath("/info/adminreservation.ac");
		return forward;
	}

}
