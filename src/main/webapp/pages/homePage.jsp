<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="userMaster" value="${userMaster}" scope="session"></c:set>
<c:set var="itemList" value="${itemList}" scope="request"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
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

		<!-- body area -->
		<tr>
			<td>
				<table width="500px" align="center" cellspacing="2" cellpadding="2"
					border="1" style="border-collapse: collapse; margin-top: 50px;">
					<tr>
						<td colspan="4" align="center"><h3>
								<spring:message code="items_list" />
							</h3></td>
					</tr>
					<tr>
						<th><spring:message code="sr_no" /></th>
						<th><spring:message code="item_name" /></th>
						<th><spring:message code="item_price" /></th>
						<th><spring:message code="action" /></th>
					</tr>
					<c:if test="${not empty itemList}">
						<%
							int srNo = 1;
						%>
						<c:forEach var="item" items="${itemList}">
							<tr>
								<td align="center"><%=srNo++%></td>
								<td>${item.itemName}</td>
								<td align="center">${item.itemPrice}</td>
								<td align="center">
									<form name="item" action="item.do" method="post">
										<input type="hidden" name="id" value="${item.itemId}" /> <input
											type="submit" value="<spring:message code="buy" />">
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>

				</table>
			</td>
		</tr>
	</table>

</body>
</html>