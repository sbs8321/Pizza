<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<style >
table {
border-style:  double;
}
</style>
<meta charset="UTF-8">
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
<body>

<body id="page-top">
<% Member member = (Member) request.getAttribute("memberView"); %>
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
              <strong style="color: white;"><%=member.getName()%>님의 상세 정보</strong><br>
            </h1>
          </div>
          </div>
         
         </div>
        </div>
      </div>
    </section>
    
    
    <div align="center" >
<table style="width: 500px;">
<tr>
<td>회원 아이디 :</td> <td> <%=member.getId()%></td>
</tr>
<tr>
<td>회원 생년월일 : </td> <td><%=member.getDirthday()%></td>
</tr>
<tr>
<td>회원 연락처 : </td> <td><%=member.getPhonenum()%></td>
</tr>
<tr>
<td>회원 전자우편 :</td> <td> <%=member.getEmail()%></td>
</tr>
<tr>
<td>회원 년도 : </td> <td><%=member.getYy()%></td>
</tr>
<tr>
<td>회원 성별 :</td> <td> <%=member.getGender()%></td>
</tr>
<tr>
<td colspan="2"><a href="./listAction.ac">리스트 돌아가기</a></td>
</tr>
</table>
</div>


</body>
</html>