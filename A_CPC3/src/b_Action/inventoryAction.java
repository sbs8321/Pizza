package b_Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.ItemListService;
import f_vo.ActionForward;
import f_vo.item;


public class inventoryAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ActionForward forward = new ActionForward();
		ItemListService itemListService = new ItemListService();
		ArrayList<item> itemlist = itemListService.itemList();
		request.setAttribute("itemList", itemlist);
		forward.setPath("../info/inventory.jsp");

		return forward;
	}

}
