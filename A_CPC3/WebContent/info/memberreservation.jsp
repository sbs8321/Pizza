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
              <strong style="color: white;"><%=member.getId()%>님 예약내역</strong>
            </h1>
            
            
        </div>
      </div>
    </section>
    
    <%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 	Date date = new Date();
 	String allday=sdf.format(date);
 	%>
   
   
   <%String dday = request.getParameter("date"); %>
 	<%
		ArrayList<reservation> reservationList = (ArrayList<reservation>)request.getAttribute("reservationList");
		
	%>
 	
 	<div align="center">
 	
 	
 	
 	
 	
 	<div align="center">
 	<h1><strong style="color: blak;"><%=sdf.format(date)%> 예약</strong> </h1>
 	</div>
 	<table style="width: 1000px; border-style: solid; border-color: black;">
 	
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 날짜 </td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList.size(); i++){ 
 		if(sdf.format(date).equals(reservationList.get(i).getDday())){
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList.get(i).getNum()%>"><%=reservationList.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getDday()%></td>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList.get(i).getTeacher()%></td>
 	<%if(reservationList.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid; color: red;">결제안함</td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid; color: blue;">결제완료</td>
 	<%} %>
 	</tr>
 	<%}} %>
 	</table>
 	
 	
 	
 	<div style="height: 20px;">
 	</div>
 	
 	
 	<div align="center">
 	<h1><strong style="color: red;">예약 내역 </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-style: solid; border-color: black;">
 	
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 날짜 </td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList.size(); i++){ 
 		if(member.getId().equals(reservationList.get(i).getId())){
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="adminreservationDetail.ac?num=<%=reservationList.get(i).getNum()%>"><%=reservationList.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getDday()%></td>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList.get(i).getTeacher()%></td>
 	<%if(reservationList.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid; color: red;">결제안함</td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid; color: blue;">결제완료</td>
 	<%} %>
 	</tr>
 	<%}} %>
 	</table>
 	
 	
 	<div style="height: 20px;">
 	</div>
 	
 		
 	<div align="center">
 	
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