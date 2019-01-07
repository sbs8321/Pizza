<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="f_vo.Member"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/creative.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./mainform.ac">이린이 피자 교실</a>
        </div></nav>


    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">회원 목록</strong>
            </h1>
            
            
           
          </div>
        </div>
      </div>
    </section>
	<%
		ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 	Date date = new Date();
 	String day = sdf.format(date);
	%>
	
	
	<div align="center">
	
	
	<table>
	<tr>
	<td>
	
	</td>
	</tr>
	
	<tr>
	<%for(int i =0; i< memberList.size(); i++){
		if(memberList.get(i).getDay().equals(day)){%>
	<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>
	<%}} %>
	</tr>
	</table>
	
	<div style="height: 20px;"></div>
	<table>
	<tr><td><h1><strong> 회원 연령별 리스트</strong> </h1></td></tr>
	</table>
	<div style="height: 15px;"></div>
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>20대 여성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1999 && memberList.get(i).getYy() >=1989){
				if(memberList.get(i).getGender().equals("여")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
			
		<% }}}%>
	</table>
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>30대 여성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1989 && memberList.get(i).getYy() >=1979){
				if(memberList.get(i).getGender().equals("여")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
			
		<% }}}%>
	</table>
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>40대이상 여성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1979){
				if(memberList.get(i).getGender().equals("여")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
			
		<% }}}%>
	</table>
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>20대 남성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1999 && memberList.get(i).getYy() >=1989){
				if(memberList.get(i).getGender().equals("남")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
			
		<% }}}%>
	</table>
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>30대 남성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1989 && memberList.get(i).getYy() >= 1979){
				if(memberList.get(i).getGender().equals("남")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
		
		<% }}}%>
	</table>
	
	<div style="height: 15px;"></div>
	<table style="border-style: solid; width: 600px;">
		<tr>
			<td colspan="2"><h4>40대이상 남성</h4></td>
		</tr>
		<%for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getYy() < 1979){
				if(memberList.get(i).getGender().equals("남")){
		%>
					
		<tr>
			<td><a href="memberViewAction.ac?id=<%=memberList.get(i).getId()%>"> <%=memberList.get(i).getId()%></a></td>

			<td><a href="memberDeleteAction.ac?id=<%=memberList.get(i).getId()%>">삭제</a></td>
		
		<% }}}%>
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