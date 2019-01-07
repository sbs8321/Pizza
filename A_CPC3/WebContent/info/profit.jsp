	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.profit"%>
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
		ArrayList<profit> proList = (ArrayList<profit>)request.getAttribute("profitList");
	%>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">매출 관리</strong><br>
              <strong style="color: white;">--------------</strong>
            </h1>
          </div>
          </div>
         
         </div>
        </div>
      </div>
    </section>
     <div align="center">
           <table style="border-style: double; width: 1200px;border-color: white;">
            <tr align="center">
            <td style="width:250px; border-style: double;"><h4>날 짜  </h4></td> 
            <td style="width:250px; border-style: double;"><h4>수 입 </h4></td> 
            <td style="width:250px; border-style: double;"><h4>금 액  </h4></td> 
            <td style="width:250px; border-style: double;"><h4>지 출 </h4></td> 
            <td style="width:200px; border-style: double;"><h4>금 액 </h4></td> 
            <td style="width:250px; border-style: double;"><h4>순수익  </h4></td> 
            <td style="width:250px; border-style: double;"><h4>비 고 </h4></td> 
            </tr>
          	
    		<%for(int i =0; i< proList.size(); i++) {%>
            <tr align="center">
            <td style="width:250px;border-style: double;"><h4><%=proList.get(i).getDate()%></h4></td> 
            <td style="width:250px;border-style: double;"><h4><%=proList.get(i).getName1()%></h4></td> 
            <td style="width:250px;border-style: double;"><h4><%=proList.get(i).getMoney1()%></h4></td> 
            <td style="width:250px;border-style: double;"><h4><%=proList.get(i).getName2()%> </h4></td> 
            <td style="width:200px;border-style: double;"><h4><%=proList.get(i).getMoney2()%></h4></td>
            <td style="width:250px;border-style: double;"><h4><%=proList.get(i).getMoney3()%></h4></td> 
            <td style="width:200px;border-style: double;"><h4><%=proList.get(i).getEtc()%></h4></td>
            
            
            <td><a class="btn btn-light btn-xl js-scroll-trigger" href="profitUpdate.ac?num=<%=proList.get(i).getNum()%>">수정</a></td>
            <td><a class="btn btn-light btn-xl js-scroll-trigger" href="profitDelete.ac?num=<%=proList.get(i).getNum()%>">삭제</a></td>
           	</tr> 
            <%} %>  
          
		</table>
		  <div style="height: 50px;">
            &nbsp;
            </div>
	<form action="profitaddAction.ac" method="post">
	<table style="width: 1200px;">
	 		<tr align="center"> 
            <td style="width:100px; border-style: double;"><input type="text" id="name" name="name" placeholder="수입" style="width: 200px; height: 30px;"/></td> 
            <td style="width:100px; border-style: double;"><input type="text" id="money" name="money" placeholder="수입금액" style="width: 200px; height: 30px;"/></td> 
            <td style="width:100px; border-style: double;"><input type="text" id="names" name="names" placeholder="지출" style="width: 200px; height: 30px;"/></td> 
            <td style="width:100px; border-style: double;"><input type="text" id="moneys" name="moneys" placeholder="지출금액" style="width: 200px; height: 30px;"/></td> 
            <td style="width:100px; border-style: double;"><input type="text" id="etc" name="etc" placeholder="비고" style="width: 200px; height: 30px;"/></td> 
            </tr>
            
	</table>
	 <input type="submit" value="작성"/>
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