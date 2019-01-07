<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*"%>
	<%@ page import="f_vo.Board"%>
	<%@ page import="f_vo.PageInfo"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">

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

<body>
	<%
		ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
		PageInfo pageinfo = (PageInfo)request.getAttribute("pageInfo");
		int nowPage = pageinfo.getPage();
		int startPage = pageinfo.getStartPage();
		int endPage = pageinfo.getEndPage();
		int maxPage = pageinfo.getMaxPage();
		int listPage = pageinfo.getListCount();	
	%>
	
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./mainform.ac">이린이 피자 교실</a>
        </div></nav>


    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">어린이 피자교실 후기 게시판</strong>
            </h1>
        </div>
      </div>
    </section>
	<div class="container">

		<div class="row">

			<table class="table table-striped"
				style="text-align: center; border: 1px;">
				<thead>
					<tr align="center"> 
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
					<%for (int i = 0; i < boardList.size(); i++) {%>
		<tr align="center">
			<td align="center"><%=boardList.get(i).getBoard_num()%></td>

			<td align="center"><a href="boardViewAction.ac?num=<%=boardList.get(i).getBoard_num()%>&page=<%=nowPage%>"><%=boardList.get(i).getBoard_subject()%></a></td>
			<td align="center"><%=boardList.get(i).getBoard_name()%></td>
			<td align="center"><%=boardList.get(i).getBoard_date()%></td>
			</tr>
		<% } %>
				</thead>
				<tbody>
					<tr>
					<td></td>
					</tr>
				</tbody>

			</table>


			<a href="boardWriteForm.ac" class="btn btn-primary pull-right">글쓰기</a>

		</div>

	</div>
	
	<div align="center">
	<table>
	<tr>
	<td>
	<a href="bordList.ac?page=<%=1%>"> [처음] </a>
	</td>
	<%if(nowPage <= 1){
		
	}else{%>
	<td>
	<a href="bordList.ac?page=<%=nowPage -1%>"> << </a>
	</td>
	<%} %>
	<%for(int i =startPage; i <=endPage; i++) {
	if(i == nowPage){%>
	<td>
	[<%=i %>]
	</td>
	<%}else{%>
	<td>
	<a href="bordList.ac?page=<%=i%>"> [<%=i %>] </a>
	</td>
	<%}}%>
	<%if(nowPage >= maxPage){
	}else{%>
	<td>
	<a href="bordList.ac?page=<%=nowPage +1%>"> >> </a>
	</td>
	<%} %>
	<td>
	<a href="bordList.ac?page=<%=endPage%>"> [끝] </a>
	</td>
	</tr>
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