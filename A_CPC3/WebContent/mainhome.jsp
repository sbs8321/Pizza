<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.Member"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>이테리 장인과 함께 하는 피자교실</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">이린이 피자 교실</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link jhttps://t1.daumcdn.net/cfile/tistory/261CF741575FBC4321s-scroll-trigger" href="#about">소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">예약</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">Photo</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">문의사항</a>
            </li>
            <li class="nav-item">           
          	<%Member member = (Member)session.getAttribute("loginMember"); 
          	 String href = null;
    		   String id = null;
          	
            if(member == null) {
            	href="loginForm.ac";
            	id ="로그인";
            }else{
            	if(member.getId().equals("sbs")){
            		href="adminListForm.ac";
                	id = "관리자";
            	}else{
            		href="memberListForm.ac";
                	id = member.getId();
            	}
            }
            %>
               <a class="nav-link js-scroll-trigger" href="<%=href%>"><%=id%></a>
              
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <h1 class="text-uppercase">
              <strong>어린이 피자교실에 오신걸 진심으로 환영합니다!</strong>
            </h1>
            <hr>
          </div>
          <div class="col-lg-8 mx-auto">
            <h3 class="text-faded mb-5" style="color:white;">이테리까지 피자를 배우러 유학 까지 다녀온 현지인도 극찬한 피자 장인! 장인의 기술을 배울수있는 기회를 놓치지 마세요</h3>
            <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about"><h5>피자교실 소개</h5></a>
          </div>
        </div>
      </div>
    </header>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">      
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-white">아이의 꿈을 위해 투자 하세요!</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">우리아이가 먹는다는 생각으로 재료를 준비합니다<br>
            							건강한 아이를 위해 건강한 피자를 만들겠습니다 <br>
            							엄마,아빠 가 안심하고 먹을수 있는 피자! 저희가 함께 하겠습니다</p>
            <a class="btn btn-light btn-xl js-scroll-trigger" href="#services">피자교실 예약 방법</a>
          </div>
        </div>
      </div>
    </section>

    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading">어린이 피자교실 예약 방법</h2>
            <hr class="my-4">
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fas fa-4x fa-gem text-primary mb-3 sr-icon-1"></i>
              <h3 class="mb-3">보석 같은 우리아이!</h3>
              <p class="text-muted mb-0">어린이 피자교실을 48개월 이상 부터 가능해요~</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fas fa-4x fa-paper-plane text-primary mb-3 sr-icon-2"></i>
              <h3 class="mb-3">아직 어린 우리아이!</h3>
              <p class="text-muted mb-0">2층 비행기 테이블에서 엄마 와 함께 참관만 가능합니다~</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fas fa-4x fa-code text-primary mb-3 sr-icon-3"></i>
              <h3 class="mb-3">날짜 와 시간 을  꼭꼭 확인 해주세요!</h3>
              <p class="text-muted mb-0">피자교실은 매일매일 있는게 아닙니다 날짜를 확인해주세요!</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fas fa-4x fa-heart text-primary mb-3 sr-icon-4"></i>
              <h3 class="mb-3">사랑하는 우리아이에게  멋진 경험을!</h3>
                     <%
               String reviews = null;
               if(member == null) { 
            	reviews = "loginForm.ac";
               }else {
        	   reviews="reservationList.ac";
               }
                     %>   
                     <%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 						Date date = new Date();
 							%> 
 							                                       
              <a href="<%=reviews%>?date=<%=sdf.format(date)%>&page=1" class="text-muted mb-0">예약 바로가기~~</a>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="p-0" id="portfolio">
      <div class="container-fluid p-0">
        <div class="row no-gutters popup-gallery">
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/1.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/1.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
               	     지친 어머니들의 휴식 공간
                  </div>
                  <div class="project-name">
                   	 아이가 체험할동안 잠깐이라도 쉬세요~
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/2.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/2.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                	   우리아이 피자 만드는 공간
                  </div>
                  <div class="project-name">
                 	   우리아이 가 피자 체험을 하는 곳입니다
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/3.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/3.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                 	   우리아이 놀이터
                  </div>
                  <div class="project-name">
                	   아이가 뛰어 놀수있는 공간이 마련되어있습니다
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/4.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/4.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
             	      아이가 체험을 하는 모습을 곁에서 봐주세요
                  </div>
                  <div class="project-name">
                   	 아이들은 부모님이 보고 있으면 더욱 빛을 냅니다
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/5.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/5.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                 	   어린이 피자교실
                  </div>
                  <div class="project-name">
                 	  어린이 피자 교실 입니다
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/6.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/6.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                 	  우리아이가 체험 하는 공간입니다
                  </div>
                  <div class="project-name">
                 	   우리 아이의 체험 공간
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>

    <section class="bg-dark text-white">
      <div class="container text-center">
        <h2 class="mb-4">어린이 피자교실 체험 후기를 남겨 주세요!!</h2>
              <%
        String review = null;
        if(member == null) { 
        	review = "loginForm.ac";
        }else {
        	review="bordList.ac";
        }
        %>
        <a class="btn btn-light btn-xl sr-button" href="<%=review%>?page=1">후기 남기러 가기~~</a>
 
      </div>
    </section>

    <section id="contact">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">궁금 하신 사항에 대해서 언제든지 말씀 하세요!!</h2>
            <hr class="my-4">
            <p class="mb-5">단체 문의나 궁금 하신 사항이 생기시면 언제든지 문의 하세요~~</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 ml-auto text-center">
            <i class="fas fa-phone fa-3x mb-3 sr-contact-1"></i>
            <p>010-8320-2137</p>
          </div>
          <div class="col-lg-4 mr-auto text-center">
            <i class="fas fa-envelope fa-3x mb-3 sr-contact-2"></i>
            <p>
              <a href="mailto:your-email@your-domain.com">sbs8321@naver.com</a>
            </p>
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

