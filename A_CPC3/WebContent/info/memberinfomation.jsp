<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.Member"%>
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
              <strong style="color: white;">회원정보</strong>
            </h1>
        </div>
      </div>
    </section>
    <% Member member = (Member)session.getAttribute("loginMember"); %>

		<div class="col-lg-8 mx-auto"align="center">
          
          <div style="height: 15px"></div>
          
            <div><h4><strong>아이디 :<%=member.getId()%></strong></h4></div>
            <div style="height: 10px"></div>
            
           <div><h4><strong>이름 :<%=member.getName()%></strong></h4></div>
           <div style="height: 10px"></div>
            
           <div><h4><strong>생년월일 :<%=member.getYy()%>년<%=member.getDirthday()%></strong></h4></div>
           <div style="height: 10px"></div>
           
           <div><h4><strong>전화번호 :<%=member.getPhonenum()%></strong></h4></div>
            <div style="height: 10px"></div>
            
           <div><h4><strong>이메일 :<%=member.getEmail()%></strong></h4></div>
           <div style="height: 10px"></div>   
           
		   <div>       
           <a type="submit" href="memberUpdate.ac" class="btn btn-primary btn-xl js-scroll-trigger" >정보수정"</a>
           </div>  
           <div style="height: 15px"></div>
             
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