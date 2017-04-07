<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session"></c:set>
<c:set var="cart" value="${cart}" scope="session"></c:set>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="cart_page" /></title>
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
		<!-- body area -->
		<tr>
			<td><c:if test="${empty cart.shoppingItemWithQuantity}">
					<h2 align="center">
						<spring:message code="empty_cart" />
					</h2>
				</c:if> <c:if test="${not empty cart.shoppingItemWithQuantity}">
					<table width="500px" align="center" cellspacing="2" cellpadding="2"
						border="1" style="border-collapse: collapse; margin-top: 50px;">
						<tr>
						</tr>
						<tr>
							<td colspan="5" align="center"><h3>
									<spring:message code="cart" />
								</h3></td>
						</tr>


						<tr>
							<th><spring:message code="sr_no" /></th>
							<th><spring:message code="item_name" /></th>
							<th><spring:message code="item_price" /></th>
							<th><spring:message code="item_quantity" /></th>
							<th><spring:message code="action" /></th>
						</tr>
						<%
							int srNo = 1;
						%>
						<c:forEach var="entry" items="${cart.shoppingItemWithQuantity}">

							<tr>
								<td align="center"><%=srNo++%></td>

								<td>${entry.key.itemName}</td>
								<td align="center">${entry.key.itemPrice}</td>
								<td align="center">
									<form name="updateItemInCart" action="updateItemInCart.do"
										method="post">
										<input type="hidden" name="id" value="${entry.key.itemId}" />
										<input type="number" min="1" max="1000" value="${entry.value}"
											name="quantity" property="quantity" /> <input type="submit"
											value="<spring:message code="update" />">
									</form>
								</td>
								<td align="center">
									<form name="removeItemFromCart" action="removeItemFromCart.do"
										method="post">
										<input type="hidden" name="id" value="${entry.key.itemId}" />
										<input type="submit"
											value="<spring:message code="remove_item" />">
									</form>
								</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="5" align="center">
								<form name="orderItems" action="orderItems.do" method="post">
									<input type="submit"
										value="<spring:message code="proceed_to_checkout" />"
										align="right">
							</td>
						</tr>

						</form>
					</table>
				</c:if></td>
		</tr>
	</table>

</body>
</html>