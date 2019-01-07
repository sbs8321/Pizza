<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.item"%>
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
		ArrayList<item> itemList = (ArrayList<item>)request.getAttribute("itemList");
	%>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">재고    목록</strong><br>
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
            <td style="width:250px; border-style: double;"><h3>코드 번호 </h3></td> 
            <td style="width:250px; border-style: double;"><h3>품 명  </h3></td> 
            <td style="width:250px; border-style: double;"><h3>수 량 </h3></td> 
            <td style="width:250px; border-style: double;"><h3>유효 기간 </h3></td> 
            <td style="width:200px; border-style: double;"><h3>제 조 사 </h3></td> 
            </tr>
          	
    		<%for(int i =0; i<itemList.size(); i++) {%>
            <tr align="center">
            <td style="width:250px;border-style: double;"><h3><%=itemList.get(i).getCode()%></h3></td> 
            <td style="width:250px;border-style: double;"><h3><%=itemList.get(i).getName()%>  </h3></td> 
            <td style="width:250px;border-style: double;"><h3><%=itemList.get(i).getAmount()%></h3></td> 
            <td style="width:250px;border-style: double;"><h3> <%=itemList.get(i).getSdate()%> </h3></td> 
            <td style="width:200px;border-style: double;"><h3> <%=itemList.get(i).getSupplier()%></h3></td>
            <td><a class="btn btn-light btn-xl js-scroll-trigger" href="itemUpdate.ac?code=<%=itemList.get(i).getCode()%>">수정</a></td>
            <td><a class="btn btn-light btn-xl js-scroll-trigger" href="itemDelete.ac?code=<%=itemList.get(i).getCode()%>">삭제</a></td>
           	</tr> 
            <%} %>  
		</table>
		
			
            <a class="btn btn-light btn-xl js-scroll-trigger" href="itemAdd.ac">품목 추가</a>  
            
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