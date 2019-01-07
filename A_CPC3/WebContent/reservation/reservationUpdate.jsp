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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">

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
              <strong style="color: white;">예약 수정을 해보아요~~</strong>
            </h1>
           
            <h5 class="text-uppercase">
              <strong style="color: white;">예약후 결제 버튼을 누르고 선결제를 해주세요!그래야 예약이 완료 됩니다!!</strong>
            </h5>
        </div>
      </div>
    </section>
    <%
 	reservation res = (reservation)request.getAttribute("res");
 	%>
   
   	<div style="height: 20px;">
   	
   	</div>
   
 	<div align="center">
 	
 	<form action="reservationUpdatepro.ac" method="post">
 	<table style="width: 700px; border-style: solid; border-color: black;">
 	
 	
 	<tr>
 	<td>예약일자 :</td>
 	<td>
 	<select name="dday"style="width: 210px;">
 	<option value="<%=res.getDday()%>"selected="selected"><%=res.getDday()%></option>
 	<%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 	Date date = new Date();
 	%>
 	<% for(int i=1; i <=5; i++){ %>
 	<option value="<%=sdf.format(date)%>"><%=sdf.format(date)%></option>
 	<%date.setDate(date.getDate()+1); %>
 	<%} %>
 	</select>
 	</td>
 	
 	<td>예약시간 :</td>
 	<td>
 	<select name="time" style="width: 210px;">
 	<option value="<%=res.getTime() %>" selected="selected"><%=res.getTime() %></option>
 	<option value="13:00">13:00</option>
 	<option value="15:00">15:00</option>
 	<option value="17:00">17:00</option>
 	</select>
 	</td>
 	</tr>
 	
 	<tr>
 	<td>예약자명 :</td><td><input type="text" id="name" name="name" value="<%=res.getName()%>" required="required"/></td>
 	<td>예약인원 :</td><td><input type="text" id="child" name="child" value="<%=res.getChild()%>" required="required"/></td>
 	</tr>
 	
 	<tr>
 	<td>선생님 :</td>
 	<td>
 	<select name="teacher" style="width: 210px;">
 	<option value="<%=res.getTeacher() %>" selected="selected"><%=res.getTeacher()%></option>
 	<option value="김자반">김자반 선생님</option>
 	<option value="헛개수">헛개수 선생님</option>
 	<option value="밀키스">밀키스 선생님</option>
 	</select>
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
 	<td colspan="4">
 	<textarea rows="5" cols="600" id="content" name="content" placeholder="<%=res.getContents()%>"></textarea>
 	</td>
 	</tr>
 	
 	
 	<tr>
 	<td colspan="4" style="border-right-style: solid;">
    	*  아이는 48개월 이상 10살 이하 까지 가능 합니다 <br>
 	    *  예약후 무통장 선결제를 하셔야 예약이 완료 됩니다 <strong style="color: red;">(*신한은행 110-000-0000 SBS)</strong><br>
     	*  결제시 예약자 성합을 필히 명시 해주시고 완료되면 문자를 보내 확인 시켜드립니다                        
 	
 	</td>
 	</tr>
 		
 	</table>
 	<input type="hidden" name="id" value="<%=res.getId()%>">
 	<input type="hidden" name="num" value="<%=res.getNum()%>">
 	<input type="submit" value="수정하기">
 	<a href="reservationDetail.ac?num=<%=res.getNum()%>">뒤로가기</a>
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