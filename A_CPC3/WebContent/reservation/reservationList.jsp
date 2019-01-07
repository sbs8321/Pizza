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
 	<% Member member = (Member)session.getAttribute("loginMember");
    		int ch = 0;
    		%>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">예약을 해보아요!!</strong>
            </h1>
            
            <h5 class="text-uppercase">
              <strong style="color: white;">1.일자 선택&nbsp;&nbsp;2.시간선택&nbsp;&nbsp;3.선생님 선택&nbsp;&nbsp;4.인원선택&nbsp;&nbsp;5.예약!!</strong>
            </h5>
            
            <h5 class="text-uppercase">
              <strong style="color: white;">예약후 무통장 선결제를 해주세요!그래야 예약이 완료 됩니다!!</strong>      
            </h5>
        </div>
      </div>
    </section>
    
   
 	<div align="center">
 	
 	<table>
 	<tr>
 	<td>예약 가능 날짜 :</td>
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
 	<td><a href="reservationList.ac?date=<%=sdf.format(date)%>&page=1">[<%=sdf.format(date)%>]</a></td>
 	<%date.setDate(date.getDate()+1); %>
 	<%} %>
 	<tr>
 	</table>
 	
 	<%String dday = request.getParameter("date"); %>
 	<%
		ArrayList<reservation> reservationList = (ArrayList<reservation>)request.getAttribute("reservationList");
	%>
 	<div align="center" >
 	
 	<h1><strong><%=dday%>일 예약 현황 </strong> </h1>
 	</div>
 	<table style="width: 1000px; border-color: black;">
 	<tr style="border-style: none;">
 	<td colspan="7">
 	<div style="float: right;">
 	<a href="reservationList.ac?date=<%=dday%>&page=<%=1%>&limit=50">50개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="reservationList.ac?date=<%=dday%>&page=<%=1%>&limit=20">20개씩 보기</a>
 	</div>
 	<div style="float: right; margin-right: 10px;">
 	<a href="reservationList.ac?date=<%=dday%>&page=<%=1%>&limit=10">10개씩 보기</a>
 	</div>
 	</td>
 	</tr>
 	<tr align="center" style="border-style: solid;">
 	<td style="width: 100px; border-right-style: solid;"> 예약 번호</td><td style="width: 150px; border-right-style: solid;"> 예약 시간 </td><td style="width: 150px;border-right-style: solid;"> 예약 인원 </td><td style="width: 400px;border-right-style: solid;"> 예약 내용</td><td style="width: 200px;border-right-style: solid;"> 결제여부 </td>
 	</tr>
 	
 	<%for(int i=0; i<reservationList.size(); i++){ 
 	ch=+reservationList.get(i).getChild();
 	%>

	<tr align="center" style="border-style: solid;">
	<%if(member.getId().equals(reservationList.get(i).getId())||member.getId().equals("sbs")){ %>
 	<td style="width: 100px; border-right-style: solid;"><a href="reservationDetail.ac?num=<%=reservationList.get(i).getNum()%>&pages=lists"><%=reservationList.get(i).getNum()%></a></td>
 	<%}else{ %>
 	<td style="width: 100px; border-right-style: solid;"><%=reservationList.get(i).getNum()%></td>
 	<%} %>
 	<td style="width: 150px; border-right-style: solid;"><%=reservationList.get(i).getTime()%></td>
 	<td style="width: 150px;border-right-style: solid;"><%=reservationList.get(i).getChild()%></td>
 	<td style="width: 400px;border-right-style: solid;">선생님 :<%=reservationList.get(i).getTeacher()%></td>
 	<%if(reservationList.get(i).getChsh() == 0){ %>
 	<td style="width: 200px;border-right-style: solid;color: red;"> 결제안함 </td>
 	<%} else{%>
 	<td style="width: 200px;border-right-style: solid;color: blue;"> 결제완료 </td>
 	<%} %>
 	</tr>
 	<%} %>
 	</table>
 
 	
 	<div align="center">
	<table>
	<tr>
	<td>
	<a href="reservationList.ac?date=<%=dday%>&page=<%=1%>&limit=<%=limit%>"> [처음] </a>
	</td>
	<%if(nowPage <= 1){
		
	}else{%>
	<td>
	<a href="reservationList.ac?date=<%=dday%>&page=<%=nowPage -1%>&limit=<%=limit%>"> << </a>
	</td>
	<%} %>
	<%for(int i =startPage; i <= endPage; i++) {
	if(i == nowPage){%>
	<td>
	[<%=i %>]
	</td>
	<%}else{%>
	<td>
	<a href="reservationList.ac?date=<%=dday%>&page=<%=i%>&limit=<%=limit%>"> [<%=i %>] </a>
	</td>
	<%}}%>
	<%if(nowPage < maxPage){%>
	<td>
	<a href="reservationList.ac?date=<%=dday%>&page=<%=nowPage +1%>&limit=<%=limit%>"> >> </a>
	</td>
	<% }else{%>
	
	<%} %>
	<td>
	<a href="reservationList.ac?date=<%=dday%>&page=<%=endPage%>&limit=<%=limit%>"> [끝] </a>
	</td>
	</tr>
	</table>
 </div>
 	
 	
 	
 	
 	
 	
 	
 	<form action="reservationWrite.ac" method="post">
 	<input type="submit" value="예약">
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