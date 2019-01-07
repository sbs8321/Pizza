
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="f_vo.*"%>
<%@ page import="java.util.*"%>

<%@ page import="java.io.IOException"%>
<%@ page import="b_Action.*"%>


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
	<style>
	table{
	    margin : auto;
		width : 960px;
		color : gray;
		border : 1px solid gray;
	}
	</style>

	<!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="../vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/creative.min.css" rel="stylesheet">
    
    
    
	
  </head>

  <body id="page-top">
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
              <strong style="color: white;">예약</strong>
            </h1>
        </div>
      </div>
    </section>
<%
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		
		
		String pages = "CashNo";
				
		if(request.getParameter("pages")!= null){
			pages = request.getParameter("pages");
		}
 
		String dates = null;
    	int limit = 0;
    	PageInfo pageinfo = null;
    	ArrayList<reservation> reservationList1 = null;
    	String search =null;
%>   
    
			<table style="width: 100%; border-style: solid;" >
			<tr style=" border-style: solid;">
			
			
			
			
			<td style=" width: 17%;border-right-style: solid; ">
			<jsp:include page="left.jsp"/>
			</td>
			
			
			<td align=center style="border-style: solid;">
			<%if(pages.equals("CashNo")){ 
				dates = (String)request.getAttribute("dates");
		    	limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList1");
			%>
			<jsp:include page='reservationCashNo.jsp' flush="false">
			<jsp:param name="date" value="<%=dates%>" />
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList1" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			</jsp:include>
			<%}else if(pages.equals("CashYes")){ 
				dates = (String)request.getAttribute("dates");
		    	limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList1");
			%>
			<jsp:include page='reservationCashYes.jsp' flush="false">
			<jsp:param name="date" value="<%=dates%>" />
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList1" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			</jsp:include>
			<%}else if(pages.equals("daySearch")){
				limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList");
		    	search = (String)request.getAttribute("search");
			%>
			<jsp:include page='reservationSearchList.jsp' flush="false">
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			<jsp:param name="search" value="<%=search%>"/>
			</jsp:include>
			<%}else if(pages.equals("idSearch")){ 
				limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList");
		    	search = (String)request.getAttribute("search");
			%>
			<jsp:include page='reservationSearchList.jsp' flush="false">
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			<jsp:param name="search" value="<%=search%>"/>
			</jsp:include>
			<%}else if(pages.equals("nameSearch")) {
				limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList");
		    	search = (String)request.getAttribute("search");
			%>
			<jsp:include page='reservationSearchList.jsp' flush="false">
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			<jsp:param name="search" value="<%=search%>"/>
			</jsp:include>
			<%}else if(pages.equals("teacherSearch")){
				limit = (int)request.getAttribute("limit");
		    	pageinfo = (PageInfo)request.getAttribute("pageInfo");
		    	reservationList1 = (ArrayList<reservation>)request.getAttribute("reservationList");
		    	search = (String)request.getAttribute("search");
			%>
			<jsp:include page='reservationSearchList.jsp' flush="false">
			<jsp:param name="pages" value="<%=pages%>"/>
			<jsp:param name="reservationList" value="<%=reservationList1%>" />
			<jsp:param name="limit" value="<%=limit%>"/>	
			<jsp:param name="search" value="<%=search%>"/>
			</jsp:include>
			<%} %>
			</td>
			
			
			
			</tr>
			</table>
		    
    
    
    
    
    
    
    
    
  
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