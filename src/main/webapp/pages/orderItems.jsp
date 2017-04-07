<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session"></c:set>
<c:set var="order" value="${order}" scope="request"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table width="100%">
		<!-- header area -->
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><jsp:include page="header.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td><jsp:include page="back.jsp" /></td>
		</tr>
	</table>
	<p class="order_successful">
		Order successful for Rs <b>${order.amount}</b>. Your order id is <b>${order.orderId}</b>.
	</p>
</body>
</html>