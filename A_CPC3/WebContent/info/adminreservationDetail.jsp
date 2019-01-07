<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
 	<% Member member = (Member)session.getAttribute("loginMember"); %>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">예약 상세정보</strong>
            </h1>
        </div>
      </div>
    </section>
    <%
 	reservation res = (reservation)request.getAttribute("res");
    String pag = (String)request.getAttribute("page");
    String pages = (String)request.getAttribute("pages");
 	%>
   
   	<div style="height: 20px;">
   	
   	</div>
   <%
   String href = null;
   if(res.getChsh() == 0){
   		href = "adminreservationCashNo.ac";
   }else{
  		href = "adminreservationYes.ac";
   } 
   %>
   
 	<div align="center">
 	<form action="<%=href%>?date=<%=res.getDday()%>&page=<%=pag%>&pages=<%=pages%>" method="post">
 	<table style="width: 700px; border-style: solid; border-color: black;">
 	
 	
 	<tr>
 	<td>예약일자 :</td>
 	<td>
 	<h4><strong><%=res.getDday()%></strong> </h4>
 	</td>
 	<td>예약시간 :</td>
 	<td style="border-right-style: solid;">
 	<h4><strong><%=res.getTime()%></strong> </h4>
 	</td>
 	</tr>
 	
 	<tr>
 	<td>예약자명 :</td>
 	<td>
 	<h4><strong><%=res.getName()%></strong> </h4>
 	</td>
 	<td >예약인원 :</td><td style="border-right-style: solid;"><h4><strong><%=res.getChild()%></strong> </h4>
 	</tr>
 	
 	<tr>
 	<td>선생님 :</td>
 	<td>
 	<h4><strong><%=res.getTeacher()%></strong> </h4>
 	</td>
 	<td>결제여부 :</td>
 	<%if(res.getChsh() == 0) { %>
 	<td style="border-right-style: solid;"><h3> <strong style="color: red;"> 결제 안함 </strong> </h3></td>
 	<%}else{ %>
 	<td style="border-right-style: solid;"><h3> <strong style="color: blue;"> 결제 완료 </strong> </h3></td>
 	<%} %>
 	</tr>
 	
 	<tr>
 	<td colspan="4"> 상세 내용 :</td>
 	<td>
 	</tr>
 	
 	<tr>
 	<td colspan="4"><h4><strong><%=res.getContents() %></strong> </h4></td>
 	<td>
 	</tr>
 	
 	<tr>
 	<td> 예약자 아이디 :</td>
 	<td><h4><strong><%=res.getId()%></strong> </h4></td>
 	<td> 예약자 전화번호 :</td>
 	<td><h4><strong><%=res.getPhone()%></strong> </h4></td>
 	</tr>
 	
 	
 	
 		
 	</table>
 	<input type="submit" value="뒤로가기">
 	</form>
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