package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.itemAddService;
import f_vo.ActionForward;
import f_vo.item;

public class inventoryAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 *o 1. itemUpdate.jsp 으로 부터 전송받은 데이터 를 가져옴
		 *o 2. 데이터를 item 타입 객체에 필드값으로 세팅
		 *o 3. Service 클래스의  메소드 호출
		 *o 4. 호출결과를 넘겨 받아서 품목 추가 성공, 실패 여부 판단
		 *o   - 성공하면 inventory.jsp 으로 이동
		 *o   - 실패하면 경고창  뒤로가기
		*/
		
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
		
		itemAddService itemAddService = new itemAddService();
		add = itemAddService.itemAdd(item);
		
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
