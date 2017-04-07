<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session"></c:set>
<c:set var="orderList" value="${orderList}" scope="request"></c:set>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="orders_page" /></title>
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
			<td>

				<table width="500px" align="center" cellspacing="2" cellpadding="2"
					border="1" style="border-collapse: collapse; margin-top: 50px;">
					<tr>
					</tr>
					<tr>
						<td colspan="5" align="center"><h3>
								<spring:message code="orders" />
							</h3></td>
					</tr>

					<c:if test="${not empty orderList}">
						<c:forEach var="order" items="${orderList}">
							<tr>
								<td colspan="5"><spring:message code="order_id" />
									:${order.orderId} <spring:message code="date" /> :<fmt:formatDate
										type="date" value="${order.orderDate}" /> <spring:message
										code="amount" /> : Rs. ${order.amount}</td>

							</tr>
							<tr>
								<th><spring:message code="sr_no" /></th>
								<th><spring:message code="item_name" /></th>
								<th><spring:message code="order_quantity" /></th>
							</tr>
							<c:if test="${not empty order.shoppingItemsWithQuantity}">
								<%
									int srNo = 1;
								%>
								<c:forEach var="entry"
									items="${order.shoppingItemsWithQuantity}">
									<tr>

										<td><%=srNo++%></td>

										<td>${entry.key.itemName}</td>
										<td align="center">${entry.value}</td>

									</tr>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:if>
				</table>

			</td>
		</tr>
	</table>
</body>
</html>