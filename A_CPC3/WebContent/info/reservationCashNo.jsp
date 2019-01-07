<%@page import="sun.rmi.server.Dispatcher"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <title>이테리 장인과 함께 하는 피자교실</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="../vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/creative.min.css" rel="stylesheet">

  </head>
  
	<%  
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String dday = request.getParameter("date");
 		String pages = request.getParameter("pages");
		ArrayList<reservation> reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList1");	
    	int limit=(int)request.getAttribute("limit");
        PageInfo pageinfo = (PageInfo)request.getAttribute("pageInfo");
        
        
    	int nowPage = pageinfo.getPage();
    	int startPage = pageinfo.getStartPage();
    	int endPage = pageinfo.getEndPage();
    	int maxPage = pageinfo.getMaxPage();
    	int listPage = pageinfo.getListCount();
	%>

  	<body id="page-top">
   
 	<% Member member = (Member)session.getAttribute("loginMember");
       int ch = 0;
    %>
 	<div align="center">
 	
 	<table style=" width: 500px; border-style: none;">
 	<tr>
 	<td>예약:</td>
 	<% for(int i=1; i <=5; i++){ %>
 	<td><a href="adminreservationCashNo.ac?date=<%=sdf.format(date)%>&page=1&pages=<%=pages%>">[<%=sdf.format(date)%>]</a></td>
 	<%date.setDate(date.getDate()+1); %>
 	<%} %>
 	<tr>
 	</table>
 	
 	<div align="center">
 	<h1><strong ><%=dday%></strong> </h1>
 	<h1><strong style="color: red;">미결제 예약 현황 </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-color: black; border-style: none;">
 	<tr style="border-style: none;">
 	<td colspan="7">
 	<div style="float: right;">
 	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=1%>&limit=50&pages=<%=pages%>">50개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=1%>&limit=20&pages=<%=pages%>">20개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=1%>&limit=10&pages=<%=pages%>">10개씩 보기</a>
 	</div>
 	</td>
 	</tr>
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList1.size(); i++){ 
 		
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList1.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList1.get(i).getNum()%>&pages=<%=pages%>&page=<%=nowPage%>"><%=reservationList1.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList1.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList1.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList1.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList1.get(i).getTeacher()%></td>
 	<%if(reservationList1.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: red" href="adminreservationUpdateyes.ac?num=<%=reservationList1.get(i).getNum()%>&id=<%=reservationList1.get(i).getId()%>&date=<%=reservationList1.get(i).getDday()%>&pages=<%=pages%>">결제안함</a></td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: blue" href="adminreservationUpdateno.ac?num=<%=reservationList1.get(i).getNum()%>&id=<%=reservationList1.get(i).getId()%>&date=<%=reservationList1.get(i).getDday()%>&pages=<%=pages%>">결제완료</a></td>
 	<%} %>
 	</tr>
 	<%} %>
 	</table>
 	
 
<div align="center">
	<table style="width: 100%; border-style: none; text-align: center;">
	<tr>
	<td>
	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=1%>&limit=<%=limit%>&pages=<%=pages%>"> [처음] </a>
	<%if(nowPage <= 1){
		
	}else{%>
	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=nowPage -1%>&limit=<%=limit%>&pages=<%=pages%>"> << </a>
	<%} %>
	<%for(int i =startPage; i <= endPage; i++) {
	if(i == nowPage){%>
	[<%=i %>]
	<%}else{%>
	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=i%>&limit=<%=limit%>&pages=<%=pages%>"> [<%=i %>] </a>
	<%}}%>
	<%if(nowPage < maxPage){%>
	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=nowPage +1%>&limit=<%=limit%>&pages=<%=pages%>"> >> </a>
	<% }else{%>
	
	<%} %>
	<a href="adminreservationCashNo.ac?date=<%=dday%>&page=<%=endPage%>&limit=<%=limit%>&pages=<%=pages%>"> [끝] </a>
	</td>
	</tr>
	</table>
 </div>
 </div>
 
 
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>

  </body>

</html>