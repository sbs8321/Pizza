<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.Employee"%>
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
	<%
		ArrayList<Employee> emList = (ArrayList<Employee>)request.getAttribute("employeeList");
	%>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;"> 직원 정보 관리 </strong>
            </h1>
          </div>
        </div>
      </div>
    </section>
    
    <div align="center">
    <table style="border-style: double; width:1200px;">
    <thead align="center">
    <tr>
    <td style="width:150px;">직원 번호</td>
    <td style="width:150px;">이름 </td>
    <td style="width:150px;">나이</td>
    <td style="width:150px;">전화 번호</td>
    <td style="width:150px;">비상연락망</td>
    <td style="width:150px;border-right-style: double;" >주소</td>
    <td style="width:150px;border-bottom-style: double;" >&nbsp;</td>
    <td style="width:150px;border-right-style: hidden;  border-bottom-style: double;" >&nbsp;</td>
    </tr>
    </thead>
    
    <tbody align="center">
    <%for (int i = 0; i < emList.size(); i++) {
		%>
    <tr>
			<td style="width:150px;"><%=emList.get(i).getNum()%></td>
			<td style="width:150px;"><%=emList.get(i).getName()%></td>
			<td style="width:150px;"><%=emList.get(i).getAge()%></td>
			<td style="width:150px;"><%=emList.get(i).getPhone()%></td>
			<td style="width:150px;"><%=emList.get(i).getPhonenumber2()%></td>
			<td style="width:150px; border-right-style: double; "><%=emList.get(i).getAddress()%></td>
			<td style="width:150px; border-right-style: double;"><a href="EmUpdateAction.ac?num=<%=emList.get(i).getNum()%>">수정</a></td>
			<td style="width:150px; border-right-style: double;"><a href="EmDeleteAction.ac?num=<%=emList.get(i).getNum()%>">삭제</a></td>
			</tr>
			<% }%>
    </tbody>
    
    </table>
    <a href="Em_add.ac">등록</a>
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