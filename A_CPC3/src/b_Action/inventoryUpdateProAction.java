package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.itemAddService;
import c_Service.itemUpdateServicepro;
import f_vo.ActionForward;
import f_vo.item;

public class inventoryUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		item item = new item();
		boolean add = false;
		ActionForward forward = null;
		
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String amount = request.getParameter("amount");
		String sdate = request.getParameter("sdate");
		String supp = request.getParameter("supp");
		
		item.setCode(code);
		item.setName(name);
		item.setAmount(amount);
		item.setSdate(sdate);
		item.setSupplier(supp);
		
		itemUpdateServicepro itemupdatService = new itemUpdateServicepro();
		add = itemupdatService.itemUpdate(item);
		
		if(add) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("inventory.ac");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('품목 추가 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
