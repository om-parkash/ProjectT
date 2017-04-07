<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session" />
<c:set var="cart" value="${cart}" scope="session" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="languageHeader.jsp"></jsp:include>
	<table width="100%">
		<tr>
			<td align="left">
				<%-- <img
				src="<c:url value='/images/shoping_cart.png'/>" class="logo_image" /> --%>
			</td>
			<td align="center"><b><spring:message code="welcome" />,
					${userMaster.userName}</b></td>
			<td align="right"><a href="logout.do"><spring:message
						code="logout" /></a></td>
		</tr>
		<tr>
			<td colspan="3"><hr /></td>
		</tr>
		<tr>
			<td align="left"><a href="getOrders.do"><spring:message
						code="show_all_orders" /></a></td>
			<%-- <c:forEach var="entry" items="${cart.shoppingItemWithQuantity.size}">

			</c:forEach> --%>
			<td align="center"></td>
			<td align="right" style="border-right: 2px"><img
				src="<c:url value='/images/shoping_cart.png'/>" class="logo_image" />
				<a href="showCart.do">${cart.noOfItems} </a>
			<spring:message code="items" /></td>
		</tr>
	</table>
</body>
</html>