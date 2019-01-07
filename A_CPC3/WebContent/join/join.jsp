<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>이테리 장인과 함께 하는 피자교실</title>
   
    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="../vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/creative.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./mainform.ac">이린이 피자 교실</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
    </nav>

    <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <h1 class="text-uppercase">
              <strong>아이에게 멋진 경험을 선물 하세요</strong>
            </h1>
            <hr>
          </div>
          
          <div class="col-lg-8 mx-auto">
          <form action="./joinAction.ac" method="post" style="border-style: double;">
          <div style="height: 15px"></div>
            <div><input type="text" id="id" name="id" placeholder="아이디" required="required" style="width: 400px; height: 40px;"/></div>
            <div style="height: 10px"></div>
           <div> <input type="password" id="password1" name="password1" placeholder="비밀번호 입력" required="required" style="width: 400px; height: 40px; "/></div>
           <div style="height: 10px"></div>
            <div><input type="password" id="password2" name="password2" placeholder="비밀번호 확인" required="required" style="width: 400px; height: 40px;"/></div>
            <div style="height: 10px"></div>
           <div> <input type="text" id="name" name="name" placeholder="이름" required="required" style="width: 400px; height: 40px; "/></div>
           <div style="height: 10px"></div>
            <div>
            <input name="bir1" placeholder="년(4자리)" style="height: 40px;width: 190px;">
      		<input name="bir2" placeholder="월" style="height: 40px;width: 100px;">
    		<input name="bir3" placeholder="일" style="height: 40px;width: 100px;">
    		</div>
    		 <div style="height: 10px"></div>
		  	<div> <input type="text" id="child" name="child" placeholder="자녀수를 입력해주세요" required="required" style="width: 400px; height: 40px; "/></div>	
            <div style="height: 10px"></div>
            <div> <input type="text" id="gender" name="gender" placeholder="성별 입력" required="required" style="width: 400px; height: 40px; "/></div>	
            <div style="height: 10px"></div>
           <div>
           <select  name="phone1" style="height: 40px;width: 120px;">
      		<option value="010">010</option>
      		<option value="011">011</option>
      		<option value="017">017</option>
      		</select>
            <input type="text" id="phone2" name="phone2" placeholder="전화번호(-없이)" required="required" style="width: 280px; height: 40px; "/>
            </div>
           <div style="height: 10px"></div>
            <div>
            <input type="text" id="email1" name="email1" placeholder="email" required="required" style="width: 150px; height: 40px;"/>
            <select name="email2" style="height: 40px;width: 250px;">
      		<option value="@naver.com">naver.com</option>
      		<option value="@gmail.com">gmail.com</option>
      		</select>
            </div>
            <div style="height: 10px"></div>
            
             <input type="reset" class="btn btn-primary btn-xl js-scroll-trigger" value="다시작성">
             <input type="submit" class="btn btn-primary btn-xl js-scroll-trigger" value="회원가입"/>
              <div style="height: 15px"></div>
             </form>
          </div>
        </div>
      </div>
    </header>

   

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