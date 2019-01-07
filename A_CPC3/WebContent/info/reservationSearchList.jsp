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
 		String pages = request.getParameter("pages");
		ArrayList<reservation> reservationList = (ArrayList<reservation>)request.getAttribute("reservationList");	
    	int limit=(int)request.getAttribute("limit");
        PageInfo pageinfo = (PageInfo)request.getAttribute("pageInfo");
        String search = (String)request.getParameter("search");
        
    	int nowPage = pageinfo.getPage();
    	int startPage = pageinfo.getStartPage();
    	int endPage = pageinfo.getEndPage();
    	int maxPage = pageinfo.getMaxPage();
    	int listPage = pageinfo.getListCount();
	%>
	
	<%
	String href=null;
	if(pages.equals("nameSearch")){
		href = "reservationserchname.ac";
		
	}else if(pages.equals("idSearch")) {
		href = "reservationserhid.ac";
		
	}else if(pages.equals("teacherSearch")){
		href = "reservationserchres.ac";
		
	}else if(pages.equals("daySearch")){
		href = "reservationserchday.ac";
	}else{
		
	}
	
	%>

  	<body id="page-top">
   
 	<% Member member = (Member)session.getAttribute("loginMember");%>
 	
 	<div align="center">
 	<div align="center">
 	<h1><strong style="color: blue;">검색 결과(<%=search%>) </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-color: black; border-style: none;">
 	<tr style="border-style: none;">
 	<td colspan="7">
 	<div style="float: right;">
 	<a href="<%=href%>?page=<%=1%>&limit=50&pages=<%=pages%>&search=<%=search%>">50개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="<%=href%>?page=<%=1%>&limit=20&pages=<%=pages%>&search=<%=search%>">20개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="<%=href%>?page=<%=1%>&limit=10&pages=<%=pages%>&search=<%=search%>">10개씩 보기</a>
 	</div>
 	</td>
 	</tr>
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList.size(); i++){ 
 		
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList.get(i).getNum()%>&pages=<%=pages%>&page=<%=nowPage%>"><%=reservationList.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList.get(i).getTeacher()%></td>
 	<%if(reservationList.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: red" href="adminreservationUpdateyes.ac?num=<%=reservationList.get(i).getNum()%>&id=<%=reservationList.get(i).getId()%>&date=<%=reservationList.get(i).getDday()%>&pages=<%=pages%>&search=<%=search%>">결제안함</a></td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: blue" href="adminreservationUpdateno.ac?num=<%=reservationList.get(i).getNum()%>&id=<%=reservationList.get(i).getId()%>&date=<%=reservationList.get(i).getDday()%>&pages=<%=pages%>&search=<%=search%>">결제완료</a></td>
 	<%} %>
 	</tr>
 	<%} %>
 	</table>
 	
 
<div align="center">
	<table style="width: 100%; border-style: none; text-align: center;">
	<tr>
	<td>
	<a href="<%=href%>?page=<%=1%>&limit=<%=limit%>&pages=<%=pages%>&search=<%=search%>"> [처음] </a>
	<%if(nowPage <= 1){
		
	}else{%>
	<a href="<%=href%>?page=<%=nowPage -1%>&limit=<%=limit%>&pages=<%=pages%>&search=<%=search%>"> << </a>
	<%} %>
	<%for(int i =startPage; i <= endPage; i++) {
	if(i == nowPage){%>
	[<%=i %>]
	<%}else{%>
	<a href="<%=href%>?page=<%=i%>&limit=<%=limit%>&pages=<%=pages%>&search=<%=search%>"> [<%=i %>] </a>
	<%}}%>
	<%if(nowPage < maxPage){%>
	<a href="<%=href%>?page=<%=nowPage +1%>&limit=<%=limit%>&pages=<%=pages%>&search=<%=search%>"> >> </a>
	<% }else{%>
	
	<%} %>
	<a href="<%=href%>?page=<%=endPage%>&limit=<%=limit%>&pages=<%=pages%>&search=<%=search%>"> [끝] </a>
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