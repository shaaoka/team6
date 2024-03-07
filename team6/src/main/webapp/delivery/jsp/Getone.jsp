<%@page import="com.team6.bean.DeliveryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>單筆訂單資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
	margin-right: 20px;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>外送訂單</h2>
		<jsp:useBean id="deliveryBean" scope="request"
			class="com.team6.bean.DeliveryBean" />
		<table>
			<tr>
				<td>外送編號</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getId()%>"></td>
			</tr>
			<tr>
				<td>顧客姓名</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getCname()%>"></td>
			</tr>
			<tr>
				<td>電話</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getPhone()%>"></td>
			</tr>
			<tr>
				<td>商品</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getProduct()%>"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getAddress()%>"></td>
			</tr>
			<tr>
				<td>時間</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getTime()%>"></td>
			</tr>
		</table>
		<p>
			<a href="/team6/delivery/html/index.html">回首頁</a>
	</div>
</body>

</html>