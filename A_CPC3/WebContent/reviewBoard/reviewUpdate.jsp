<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.Board"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<% Board board = (Board) request.getAttribute("board"); 
   String nowpage = (String)request.getAttribute("page");
%>
<div style="height: 100px">

</div>

<div class="container">
<table class="table table-bordered">
    <thead>
        <caption><h1 align="center">글 수정</h1></caption>
    </thead>
    <tbody>
        <form name="boardform"  action="boardUpdateAction.ac" method="post">
            
            <input type="hidden" value="<%=board.getBoard_num()%>" name="num">
            <input type="hidden" value="<%=nowpage%>" name="page">
            <tr>
                <th><p align="center"> 제목:</p> </th>
                <td><input type="text"  id="board_subject" name="board_subject" class="form-control" required value="<%=board.getBoard_subject()%>"/></td>
            </tr> 
            <tr>
                <th><p align="center"> 작성자:</p> </th>
                <td><input type="text"  id="board_name" name="board_name" class="form-control" required value="<%=board.getBoard_name()%>"/></td>
            </tr> 
            <tr>
                <th><p align="center"> 비밀번호:</p></th>
                <td><input type="password" placeholder="비밀번호를 입력하세요" id="board_pass" name="board_pass" class="form-control" required/></td>
            </tr>
            <tr>
                <th><p align="center"> 글 내용:</p></th>
                <td><textarea cols="10" id="board_content" name="board_content" class="form-control"><%=board.getBoard_content()%></textarea></td>
            </tr>
            <tr>
                <th><p align="center"> 첨부파일:</p></th>
                <td><input type="file" placeholder="파일을 선택하세요. " id="board_file" name="board_file" class="form-control"/></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정" class="pull-right"/>
                    <input type="button" value="삭제" class="pull-right" onclick="javascript:location.href='bordDelete.ac?num=<%=board.getBoard_num()%>&page=<%=nowpage%>'"/>
                    <input type="reset" value="다시작성" class="pull-left"/>
                    <input type="button" value="글 목록 " class="pull-right" onclick="javascript:location.href='bordList.ac'"/>
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
        </form>
    </tbody>
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