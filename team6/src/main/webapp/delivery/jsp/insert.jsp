<%@page import="com.team6.bean.DeliveryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新增狀態</title>
<style>
a,a:visited {
	text-decoration: none;
	color:blue;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">

	<h2>新增成功</h2>
	<jsp:useBean id="delivery" scope="request"
		class="com.team6.bean.DeliveryBean" />
	<table>
		<tr>
			<td>訂單編號</td>
			<td><input type="text" disabled value="<%=delivery.getId()%>"></td>
		</tr>
		<tr>
			<td>顧客姓名</td>
			<td><input type="text" disabled value="<%=delivery.getCname()%>"></td>
		</tr>
		<tr>
			<td>電話</td>
			<td><input type="text" disabled
				value="<%=delivery.getPhone()%>"></td>
		</tr>
		<tr>
			<td>產品</td>
			<td><input type="text" disabled
				value="<%=delivery.getProduct()%>"></td>
		</tr>
		<tr>
			<td>價格</td>
			<td><input type="text" disabled
				value="<%=delivery.getId()%>"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" disabled value="<%=delivery.getAddress()%>"></td>
		</tr>

	</table>
	<p>
		<a href="/team6/delivery/html/index.html">回首頁</a>
	</div>
</body>

</html>