<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="f_vo.Board"%>
<%@ page import="f_vo.re_Board"%>
<%@ page import="f_vo.Member"%>
<%@ page import="java.util.*"%>

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
    <style>
    td{
    
    border-style: solid;
    text-align: center;
    }
    </style>
</head>
<body>


<% Board board = (Board) request.getAttribute("board");
   Member member = (Member)session.getAttribute("loginMember"); 
   String nowpage = (String)request.getAttribute("page");
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
              <strong style="color: white;">글이름 : <%=board.getBoard_subject() %></strong>
            </h1>
        </div>
      </div>
    </section>
    
    	<div style="height: 20px;"></div>
    	
		<div align="center">
		<table style="border-style: solid; width: 1000px;">
		<tr style="border-style: solid;">
		<td style="width: 250px;">글쓴이 :</td>
		<td style="width: 250px;"><%=board.getBoard_name()%></td>
		<td style="width: 250px;">작성시간:</td>
		<td style="width: 250px;"><%=board.getBoard_date()%></td>
		<td style="width: 500px;">조회수:</td>
		<td style="width: 500px;"><%=board.getBoard_readcount()%></td>
		</tr>
		<tr style="border-style: solid;">
		<td colspan="6" style="width: 1000px; height: 100px;"><%=board.getBoard_content()%></td>
		</tr>
		<tr style="border-style: solid;">
		
		<td colspan="6">
		<input type="button" value="글 목록 " class="pull-right" onclick="javascript:location.href='bordList.ac'"/>
		<input type="button" value="글 수정 " class="pull-right" onclick="javascript:location.href='boardUpdate.ac?num=<%=board.getBoard_num()%>&page=<%=nowpage%>'"/></td>
		</tr>
		</table>
		</div>


<form action="replyWrite.ac">
<%ArrayList<re_Board> reBoardList = (ArrayList<re_Board>) request.getAttribute("reboardList"); %>
<table>
<%if(reBoardList == null){ %>

<%}else{ 
	for(int i = 0; i<reBoardList.size(); i++){%>
	<tr><td><%=reBoardList.get(i).getRe_board_name()%>:</td> 
		<td><%=reBoardList.get(i).getRe_board_content()%></td> 
		<td><%=reBoardList.get(i).getRe_board_date()%></td>
		<!-- <td><input type="button" value="답글"  onclick="javascript:location.href=replyRebord.ac'"/></td>  대댓글 달기용 -->
		<%if(reBoardList.get(i).getRe_board_name().equals(member.getId())){ %>
		<td><a href="rebordDelete.ac?bnum=<%=reBoardList.get(i).getRe_board_num()%>&page=<%=nowpage%>>&num=<%=board.getBoard_num()%>">삭제</a></td>
		<%} %>
	</tr>
	<%}
	} %>
<tr>
<td><h1><%=member.getId()%>:</h1></td><td><input type="text" name="re_board_content" style="height: 50px;" ></td>
</tr>
<tr>
<td>
<input type="hidden" value="<%=board.getBoard_num()%>" name ="num"/>
<input type="hidden" value="<%=nowpage%>" name ="page"/>
<input type="submit" value="등록"/>
</td>
</tr>
</table>

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