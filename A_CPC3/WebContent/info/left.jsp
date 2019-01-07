<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
 Date date = new Date();
%>
<center>

 	
 	<form action="reservationserch.ac" method="post">
 	<table style="width: 200px; border-style: none;">
 	<tr>
 	<td>
 	<select name="herf" style="width: 50px;">
 	<option value="reservationserchname.ac?pages=nameSearch">이름</option>
 	<option value="reservationserhid.ac?pages=idSearch">아이디</option>
 	<option value="reservationserchres.ac?pages=teacherSearch">선생님</option>
 	<option value="reservationserchday.ac?pages=daySearch">날짜</option>
 	</select>
 	</td>
 	<td>
 	<input type="text" name="search" id="search" placeholder="검색"style="width: 100px; height: 30px;"required="required"> 
 	</td>
 	<td>
 	<input type="submit" value="검색">
 	</td>
 	</tr>
 	</table>
 	</form>
 	

<a href="./adminreservationCashNo.ac?pages=CashNo&date=<%=sdf.format(date)%>&page=1&pages=CashNo">미 결제 예약</a><br><br>
<a href="./adminreservationYes.ac?pages=CashYes&date=<%=sdf.format(date)%>&page=1&pages=CashYes">결제 완료 예약</a><br><br>
</center>
