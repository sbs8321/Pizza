<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="./mainform.ac">이린이 피자 교실</a>
        </div></nav>


    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
         	<h1 class="text-uppercase">
              <strong style="color: white;">관리자 정보 수정</strong>
            </h1>
        </div>
      </div>
    </section>
<div class="container">
<table class="table table-bordered">
    <thead>
        <caption><h1 align="center">답변 글 쓰기</h1></caption>
    </thead>
    <tbody>
        <form name="boardform"  action="replyboardWritePro.ac" method="post"  >
            <tr>
                <th><p align="center"> 제목:</p> </th>
                <td><input type="text" placeholder="제목을 입력하세요." id="board_subject" name="board_subject" class="form-control" required/></td>
            </tr> 
            <tr>
                <th><p align="center"> 작성자:</p> </th>
                <td><input type="text" placeholder="작성자 를  입력하세요." id="board_name" name="board_name" class="form-control" required/></td>
            </tr> 
            <tr>
                <th><p align="center"> 비밀번호:</p></th>
                <td><input type="password" placeholder="비밀번호를 입력하세요" id="board_pass" name="board_pass" class="form-control" required/></td>
            </tr>
            <tr>
                <th><p align="center"> 글 내용:</p></th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. " id="board_content" name="board_content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th><p align="center"> 첨부파일:</p></th>
                <td><input type="file" placeholder="파일을 선택하세요. " id="board_file" name="board_file" class="form-control"/></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="등록" class="pull-right"/>
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