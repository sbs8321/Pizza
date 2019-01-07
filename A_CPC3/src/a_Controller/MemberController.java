package a_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b_Action.*;
import b_Action.BoardCheckAction;
import b_Action.BoardViewAction;
import b_Action.EmAddAction;
import b_Action.EmDeleteAction;
import b_Action.EmListAction;
import b_Action.EmUpdateAction;
import b_Action.EmUpdateProAction;
import b_Action.ReBoardwriteAction;
import b_Action.boardDeleteAction;
import b_Action.boardListAction;
import b_Action.boardUpdateAction;
import b_Action.boardWriteProAction;
import b_Action.inventoryAction;
import b_Action.inventoryAddAction;
import b_Action.inventoryDeleteAction;
import b_Action.inventoryUpdateAction;
import b_Action.inventoryUpdateProAction;
import b_Action.joinAction;
import b_Action.listAction;
import b_Action.loginAction;
import b_Action.replyBoardDelete;
import b_Action.replyBoardWrite;
import b_Action.viewAction;
import f_vo.ActionForward;

@WebServlet("*.ac") // .ac 로 끝나는것을 다받아오겠다
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// o 주소값 추출

		// o 회원가입 요청 : http://localhost:9090/MemberProject/memberJoinAction.me
		String RequestURI = request.getRequestURI();
		// RequestURI = /memberProject.memberJoinAction.me
		String contextPath = request.getContextPath();
		// contextPath = /MemverProject
		String command = RequestURI.substring(contextPath.length());
		// command = /memberJoinAction.me

		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		
		
		
		if (command.equals("/loginForm.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login/loginForm.jsp");
		}
		
		else if (command.equals("/login/mainform.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../mainhome.jsp");
		}
		else if (command.equals("/info/mainform.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../mainhome.jsp");
		}
		
		
		else if (command.equals("/join/mainform.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../mainhome.jsp");
		}
		
		else if (command.equals("/mainform.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./mainhome.jsp");
		}
		
		else if (command.equals("/login/LoginAction.ac")) {
			action = (Action) new loginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/login/joinForm.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../join/join.jsp");
		}
		
		else if (command.equals("/join/joinAction.ac")) {
			action = (Action) new joinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/adminListForm.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./info/adminList.jsp");
		}
		else if (command.equals("/memberListForm.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./info/memberinfo.jsp");
		}
		else if (command.equals("/info/listAction.ac")) {
			action = (Action) new listAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//직원 리스트
		else if (command.equals("/info/EmListAction.ac")) {
			action = new EmListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//직원 추가 페이지
		else if (command.equals("/info/Em_add.ac")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/info/emadd.jsp");
		} 
		
		else if (command.equals("/info/Em_addAction.ac")) {
			action = new EmAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// 직원 수정
		else if (command.equals("/info/EmUpdateAction.ac")) {
			action = new EmUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if (command.equals("/info/EmupdatePro.ac")) {
			action = new EmUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//직원 삭제
		else if (command.equals("/info/EmDeleteAction.ac")) {
			action = new EmDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		// 재고 관리 
		else if (command.equals("/info/inventory.ac")) {
			action = new inventoryAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 재고 수정
		else if (command.equals("/info/itemUpdate.ac")) {
			action = new inventoryUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/itemUpdatePro.ac")) {
			action = new inventoryUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//재고 추가
		else if (command.equals("/info/itemAdd.ac")) {
			forward = new ActionForward();
			forward.setPath("/info/itemAdd.jsp");

		}
		else if (command.equals("/info/itemadd.ac")) {
			action = new inventoryAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 재고 삭제
		else if (command.equals("/info/itemDelete.ac")) {
			action = new inventoryDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 매출
		else if (command.equals("/info/profitAction.ac")) {
			action = new ProfitAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/profitaddAction.ac")) {
			action = new profitaddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/profitUpdate.ac")) {
			action = new profitUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/profitUpdatePro.ac")) {
			action = new profitUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/profitDelete.ac")) {
			action = new profitDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/memberViewAction.ac")) {
			action = new viewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/adminUpdateAction.ac")) {
			action = new adminUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/info/adminUpdate.ac")) {
			forward = new ActionForward();
			forward.setPath("/info/admininfo.jsp");

		}
		else if (command.equals("/info/adminview.ac")) {
			forward = new ActionForward();
			forward.setPath("/info/admininfoo.jsp");

		}
		
		
		//회원정보 수
		else if (command.equals("/info/memberUpdateAction.ac")) {
			action = new memberUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/info/memberUpdate.ac")) {
			forward = new ActionForward();
			forward.setPath("/info/memberinfomationUpdate.jsp");

		}
		else if (command.equals("/info/memberview.ac")) {
			forward = new ActionForward();
			forward.setPath("/info/memberinfomation.jsp");

		}
		
		
		else if (command.equals("/reviewBorad/boardWritePro.ac")) {
			action = new boardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/reviewBorad/bordList.ac")) {
			action = new boardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/boardWriteForm.ac")) {
			forward = new ActionForward();
			forward.setPath("/reviewBoard/revieWrite.jsp");

		}
		
		else if (command.equals("/reviewBoard/boardWriteForm.ac")) {
			forward = new ActionForward();
			forward.setPath("/reviewBoard/revieWrite.jsp");

		}
		
		else if (command.equals("/boardListForm.ac")) {
			forward = new ActionForward();
			forward.setPath("/reviewBoard/reviewList.jsp");

		}
		
		else if (command.equals("/reviewBorad/boardViewAction.ac")) {
			action = new BoardViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reviewBorad/boardUpdate.ac")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			//forward.setRedirect(t);
			forward.setPath("./reviewBoard/reviewUpdate.jsp");

		}
		
		else if (command.equals("/reviewBoard/boardUpdateAction.ac")) {
			action = new boardUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reviewBoard/bordList.ac")) {
			action = new boardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reviewBoard/boardViewAction.ac")) {
			action = new BoardViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/bordList.ac")) {
			action = new boardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/boardViewAction.ac")) {
			action = new BoardViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/boardUpdateAction.ac")) {
			action = new boardUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/boardUpdate.ac")) {
			forward = new ActionForward();
			forward.setPath("./reviewBoard/reviewBoardCheck.jsp");
		}
		
		else if (command.equals("/reviewBoard/boardChack.ac")) {
			action = new BoardCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/boardChack.ac")) {
			action = new BoardCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/boardWritePro.ac")) {
			action = new boardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reviewBoard/boardUpdate.ac")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reviewBoard/reviewBoardCheck.jsp");
		}
		else if (command.equals("/reviewBoard/bordDelete.ac")) {
			action = new boardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/bordDelete.ac")) {
			action = new boardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reviewBoard/boardList.ac")) {
			action = new boardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//로그아웃
		else if (command.equals("/info/logout.ac")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("../login/logout.jsp");
		}
		
		//리플용
		else if (command.equals("/replyWrite.ac")) {
			action = new ReBoardwriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//답변용
		else if (command.equals("/boardreply.ac")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("../reviewBoard/replyBoard.jsp");
		}
		
		else if (command.equals("/reviewBorad/replyboardWritePro.ac")) {
			action = new replyBoardWrite();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/rebordDelete.ac")) {
			action = new replyBoardDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reservationList.ac")) {
			action = new resservationListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		
		
		
		
		
		
		else if (command.equals("/reservationWrite.ac")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reservation/reservationwrite.jsp");
			
		}
		else if (command.equals("/reservationDetailpro.ac")) {
			forward = new ActionForward();
			forward.setPath("./reservation/reservationDetail.jsp");
			
		}
		
		else if (command.equals("/reservationWritAction.ac")) {
			action = new reservationwriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reservationDetail.ac")) {
			action = new reservatiDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reservationUpdate.ac")) {
			action = new reservatiUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reservationUpdatepro.ac")) {
			action = new reservatiUpdateActionpro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/reservationDelete.ac")) {
			action = new reservationDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		else if (command.equals("/info/adminreservationDetail.ac")) {
			action = new adminreservatiDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/info/adminreservationUpdateyes.ac")) {
			action = new adminreservationUpdateyes();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/adminreservationUpdateno.ac")) {
			action = new adminreservationUpdateno();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/reservationserch.ac")) {
			action = new reservationserchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/reservationserchname.ac")) {
			action = new reservationnamesearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/info/reservationserhid.ac")) {
			action = new reservationidSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/reservationserchres.ac")) {
			action = new reservationresSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/reservationserchday.ac")) {
			action = new reservationdaySearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/memberReservation.ac")) {
			action = new memberReservationAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		else if (command.equals("/info/adminreservationCashNo.ac")) {
			action = new adminresservationListActionNO();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/adminreservationYes.ac")) {
			action = new adminresservationListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/info/adminreservation.ac")) {
			forward = new ActionForward();
			forward.setPath("./adminreservation.jsp");
			
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		//첨부파일 다운로드
		/*else if (command.equals("/boardFileDown.ac")) {
			action = new boardFileDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		
		
		
		
		
		/*if (command.equals("/memberJoinAction.me")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberLoginAction.me")) {
			action = (Action) new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./loginForm.jsp");

		} else if (command.equals("/memberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./joinForm.jsp");
		} else if (command.equals("/MemberListAction.me")) {
			
			 * forward = new ActionForward(); forward.setRedirect(true);
			 * forward.setPath("./list.jsp");
			 
			// o redircet 값으로 옮겨서 request에 담긴 값이 날라가버렸기 때문에

			action = (Action) new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (command.equals("/memberViewAction.me")) {
			action = new MemberViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/memberDeleteAction.me")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/memberDeleteAction.me") ) {
			action = (Action) new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/memberJoinCheckAction.me") ) {
			action = (Action) new MemberJoinCheckAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/memberUpdate.me") ) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberUpdate.jsp");
		}else if (command.equals("/memberUdateAction.me") ) {
			action = (Action) new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/
		
		
		

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
				// redirect 포워딩
				// request 영역에 있는 값이 유지 되지 않음
			} else {
				// dispatcher 포워딩
				// request 영역에 값이 유지되어 넘어감
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

}
