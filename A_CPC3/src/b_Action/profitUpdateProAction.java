package b_Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_Service.profitUpdateServicepro;
import f_vo.ActionForward;
import f_vo.profit;

public class profitUpdateProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		profit pro = new profit();
		boolean add = false;
		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name1 = request.getParameter("name");
		int	money1 = Integer.parseInt(request.getParameter("money"));
		String name2 = request.getParameter("names");
		int	money2 = Integer.parseInt(request.getParameter("moneys"));
		String etc = request.getParameter("etc");
		int money3 = money1-money2;
		
		pro.setNum(num);
		pro.setName1(name1);
		pro.setMoney1(money1);
		pro.setName2(name2);
		pro.setMoney2(money2);
		pro.setMoney3(money3);
		pro.setEtc(etc);
		profitUpdateServicepro profitupdatService = new profitUpdateServicepro();
		add = profitupdatService.itemUpdate(pro);
		
		if(add) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("profitAction.ac");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
