<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.*"%>
<%@ page import="java.util.*"%>
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

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./mainform.ac">이린이 피자 교실</a>
        </div></nav>
 	<% Member member = (Member)session.getAttribute("loginMember");
    		int ch = 0;
    		%>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">예약</strong>
            </h1>
            
            
            </h5>
        </div>
      </div>
    </section>
    
   
 	<div align="center">
 	
 	<table>
 	<tr>
 	<td>예약:</td>
 	<%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 	Date date = new Date();
 	int limit=(int)request.getAttribute("limit");
 	PageInfo pageinfo = (PageInfo)request.getAttribute("pageInfo");
	int nowPage = pageinfo.getPage();
	int startPage = pageinfo.getStartPage();
	int endPage = pageinfo.getEndPage();
	int maxPage = pageinfo.getMaxPage();
	int listPage = pageinfo.getListCount();
 	%>
 	<% for(int i=1; i <=5; i++){ %>
 	<td><a href="adminreservation.ac?date=<%=sdf.format(date)%>&page=1">[<%=sdf.format(date)%>]</a></td>
 	<%date.setDate(date.getDate()+1); %>
 	<%} %>
 	<tr>
 	</table>
 	
 	<%String dday = request.getParameter("date"); %>
 	<%
		ArrayList<reservation> reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList1");
		ArrayList<reservation> reservationList2 = (ArrayList<reservation>)request.getAttribute("reservationList2");
	%>
 	<div align="center">
 	<h1><strong ><%=dday%></strong> </h1>
 	<h1><strong style="color: red;">미결제 예약 현황 </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-color: black;">
 	<tr style="border-style: none;">
 	<td colspan="7">
 	<div style="float: right;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=50">50개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=20">20개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=10">10개씩 보기</a>
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
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList1.get(i).getNum()%>"><%=reservationList1.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList1.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList1.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList1.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList1.get(i).getTeacher()%></td>
 	<%if(reservationList1.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: red" href="adminreservationUpdateyes.ac?num=<%=reservationList1.get(i).getNum()%>&id=<%=reservationList1.get(i).getId()%>&date=<%=reservationList1.get(i).getDday()%>">결제안함</a></td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: blue" href="adminreservationUpdateno.ac?num=<%=reservationList1.get(i).getNum()%>&id=<%=reservationList1.get(i).getId()%>&date=<%=reservationList1.get(i).getDday()%>">결제완료</a></td>
 	<%} %>
 	</tr>
 	<%} %>
 	</table>
 	
 
<div align="center">
	<table>
	<tr>
	<td>
	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=<%=limit%>"> [처음] </a>
	</td>
	<%if(nowPage <= 1){
		
	}else{%>
	<td>
	<a href="adminreservation.ac?date=<%=dday%>&page=<%=nowPage -1%>&limit=<%=limit%>"> << </a>
	</td>
	<%} %>
	<%for(int i =startPage; i <= endPage; i++) {
	if(i == nowPage){%>
	<td>
	[<%=i %>]
	</td>
	<%}else{%>
	<td>
	<a href="adminreservation.ac?date=<%=dday%>&page=<%=i%>&limit=<%=limit%>"> [<%=i %>] </a>
	</td>
	<%}}%>
	<%if(nowPage < maxPage){%>
	<td>
	<a href="adminreservation.ac?date=<%=dday%>&page=<%=nowPage +1%>&limit=<%=limit%>"> >> </a>
	</td>
	<% }else{%>
	
	<%} %>
	<td>
	<a href="adminreservation.ac?date=<%=dday%>&page=<%=endPage%>&limit=<%=limit%>"> [끝] </a>
	</td>
	</tr>
	</table>
 </div>
 
 
 
 
 <div align="center">
 	<h1><strong style="color: blue;">결제 예약 현황 </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-style: solid; border-color: black;">
 	<tr style="border-style: none;">
 	<td colspan="7">
 	<div style="float: right;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=50">50개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=20">20개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="adminreservation.ac?date=<%=dday%>&page=<%=1%>&limit=10">10개씩 보기</a>
 	</div>
 	</td>
 	</tr>
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList2.size(); i++){ 
 		
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList2.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList2.get(i).getNum()%>"><%=reservationList2.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList2.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList2.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList2.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList2.get(i).getTeacher()%></td>
 	<%if(reservationList2.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: red" href="adminreservationUpdateyes.ac?num=<%=reservationList2.get(i).getNum()%>&id=<%=reservationList2.get(i).getId()%>&date=<%=reservationList2.get(i).getDday()%>">결제안함</a></td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: blue" href="adminreservationUpdateno.ac?num=<%=reservationList2.get(i).getNum()%>&id=<%=reservationList2.get(i).getId()%>&date=<%=reservationList2.get(i).getDday()%>">결제완료</a></td>
 	<%} %>
 	</tr>
 	<%} %>
 	</table>
 </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 	<div style="height: 30px;">
 	</div>
 	<div align="center">
 	<%String href=null; %>
 	<form action="reservationserch.ac" method="post">
 	<table>
 	<tr>
 	<td>
 	<select name="herf">
 	<option value="reservationserchname.ac">이름</option>
 	<option value="reservationserhid.ac">아이디</option>
 	<option value="reservationserchres.ac">선생님</option>
 	<option value="reservationserchday.ac">날짜</option>
 	</select>
 	</td>
 	<td>
 	<input type="text" name="serch" id="serch" placeholder="검색"style="width: 200px; height: 30px;"required="required"> 
 	</td>
 	<td>
 	<input type="submit" value="검색">
 	</td>
 	</tr>
 	</table>
 	</form>
 	</div>

	<div align="center">
	<div align="center" style="height: 15px;">

 	</div>
 	<table style="width: 1000px; border-style: solid; border-color: black;">
 	<%
 	ArrayList<reservation> resList = (ArrayList<reservation>)request.getAttribute("resList");
 	if(resList == null){
 		
 	}else{
 	for(int i=0; i<resList.size(); i++){ 
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(resList.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=resList.get(i).getNum()%>"><%=resList.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=resList.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=resList.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=resList.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=resList.get(i).getTeacher()%></td>
 	<%if(resList.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: red" href="adminreservationUpdateyes.ac?num=<%=resList.get(i).getNum()%>&id=<%=resList.get(i).getId()%>&date=<%=resList.get(i).getDday()%>">결제안함</a></td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;"><a style="color: blue" href="adminreservationUpdateno.ac?num=<%=resList.get(i).getNum()%>&id=<%=resList.get(i).getId()%>&date=<%=resList.get(i).getDday()%>">결제완료</a></td>
 	<%} %>
 	</tr>
 	<%}} %>
 	</table>
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