package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.profitAddService;
import f_vo.ActionForward;
import f_vo.profit;

public class profitaddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		profit pro = new profit ();
		boolean add = false;
		ActionForward forward = null;
		
		
		String name = request.getParameter("name");
		int money = Integer.parseInt(request.getParameter("money"));
		String names = request.getParameter("names");
		int moneys = Integer.parseInt(request.getParameter("moneys"));
		int moneyss = money-moneys;
		String etc = request.getParameter("etc");
		
		pro.setName1(name);
		pro.setMoney1(money);
		pro.setName2(names);
		pro.setMoney2(moneys);
		pro.setMoney3(moneyss);
		pro.setEtc(etc);
		
		
		profitAddService profitAddService = new profitAddService();
		add = profitAddService.profitAdd(pro);
		
		if(add) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("profitAction.ac");
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
