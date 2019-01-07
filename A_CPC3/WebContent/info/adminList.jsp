<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.Member"%>
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

	<% Member member = (Member)session.getAttribute("loginMember"); %>
          	 


    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">관리자 메뉴</strong>
            </h1>
            <hr class="light my-4">
            <p class="text-faded mb-4">피자교실 관리 프로그램</p>
            <%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 						Date date = new Date();
 							%> 			
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./adminreservationCashNo.ac?date=<%=sdf.format(date)%>&page=1">예약관리</a> &nbsp;&nbsp;
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./listAction.ac">회원관리</a> &nbsp;&nbsp;
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./profitAction.ac">매출관리</a> &nbsp;&nbsp;
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./inventory.ac">재고관리</a> &nbsp;&nbsp;
            <div style="height: 15px;"></div>
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./EmListAction.ac">직원정보</a> &nbsp;&nbsp;
            <a class="btn btn-light btn-xl js-scroll-trigger" href="logout.ac">로그아웃</a> &nbsp;&nbsp;
            <a class="btn btn-light btn-xl js-scroll-trigger" href="./adminview.ac">관리자정보수정</a>
          </div>
        </div>
      </div>
    </section>

 

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