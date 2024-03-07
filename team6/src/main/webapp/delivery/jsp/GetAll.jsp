<%@page import="com.team6.bean.DeliveryBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>所有外送訂單資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}
</style>
</head>
<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>所有外送訂單資料</h2>
		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>訂單編號</th>
				<th>顧客姓名</th>
				<th>電話</th>
				<th>產品</th>
				<th>地址</th>
				<th>外送時間</th>
				<%
				List<DeliveryBean> deliveryBeans = (ArrayList<DeliveryBean>) request.getAttribute("deliveryBeans");
				for (DeliveryBean delivery: deliveryBeans) {
				%>
			
			<tr>
				<td><%=delivery.getId()%></td>
				<td><%=delivery.getCname()%></td>
				<td><%=delivery.getPhone()%></td>
				<td><%=delivery.getProduct()%></td>
				<td><%=delivery.getAddress()%></td>
				<td><%=delivery.getTime()%></td>
			</tr>
		<%}%>
		</table>
		<button id="home">回首頁</button>
	</div>
		
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(document).ready(function(){
		
	$("#home").click(function(){
	    let homeURL = "/team6/delivery/html/index.html";
	    window.location.href = homeURL;
	});
});
</script>
</body>
</html>