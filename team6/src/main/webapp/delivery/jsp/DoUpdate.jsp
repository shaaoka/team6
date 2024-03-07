<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改員工資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}

button {
	margin: 0 20px 0 35px;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">

		<h2>修改訂單資料</h2>
		<jsp:useBean id="deliveryBean" scope="request"
			class="com.team6.bean.DeliveryBean" />
		<form method="post" action="/team6/DeliveryServlet">
			<table>
				<tr>
					<td>訂單編號</td>
					<td><input type="text" name="id"
						value="<%=deliveryBean.getId()%>"></td>
				</tr>
				<tr>
					<td>顧客姓名</td>
					<td><input type="text" name="cname"
						value="<%=deliveryBean.getCname()%>"></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><input type="text" name="phone"
						value="<%=deliveryBean.getPhone()%>"></td>
				</tr>
				<tr>
					<td>產品</td>
					<td><input type="text" name="product"
						value="<%=deliveryBean.getProduct()%>"></td>
				</tr>
				<tr>
					<td>價格</td>
					<td><input type="text" name="price"
						value="<%=deliveryBean.getPrice()%>"></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="address"
						value="<%=deliveryBean.getAddress()%>"></td>
				</tr>
			</table>
			<button type="submit" name="message" value="Update">更新</button>
			<a href="/team6/delivery/html/index.html">回首頁</a>
		</form>
	</div>
</body>

</html>