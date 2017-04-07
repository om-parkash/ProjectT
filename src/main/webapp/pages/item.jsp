<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session"></c:set>
<c:set var="item" value="${item}" scope="request"></c:set>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="item_page" /></title>
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

				<form name="addToCart" action="addToCart.do" method="post">

					<table width="500px" align="center" cellspacing="2" cellpadding="2"
						border="1" style="border-collapse: collapse; margin-top: 50px;">
						<tr>
						</tr>
						<tr>
							<td colspan="5" align="center"><h3>
									<spring:message code="item" />
								</h3></td>
						</tr>
						<tr>
							<th><spring:message code="sr_no" /></th>
							<th><spring:message code="item_name" /></th>
							<th><spring:message code="item_price" /></th>
							<th><spring:message code="quantity" /></th>
							<th><spring:message code="action" /></th>
						</tr>
						<tr>
							<td align="center">1<input type="hidden" name="id"
								value="${item.itemId}" /></td>

							<td>${item.itemName}</td>
							<td align="center">${item.itemPrice}</td>
							<td align="center"><input type="number" min="1" max="1000"
								value="1" name="quantity"></td>
							<td colspan="2" align="center"><input type="submit"
								value="<spring:message code="add_to_cart" />"></td>
						</tr>
					</table>

				</form>
			</td>
		</tr>
	</table>
</body>
</html>