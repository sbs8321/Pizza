package b_Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.ItemUpdateService;
import f_vo.ActionForward;
import f_vo.item;

public class inventoryUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		ActionForward forward = new ActionForward();
		String code = request.getParameter("code");
		
		ItemUpdateService itemUpdateService = new ItemUpdateService();
		item item = itemUpdateService.itemview(code);
		
		
		request.setAttribute("item", item);
		forward.setPath("../info/itemUpdate.jsp");

		return forward;
	}

}
