<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error occurred</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td height="100px">
				<div id="errorPage">
					<table>
						<tr>
							<td><jsp:include page="back.jsp" /></td>
						</tr>
						<tr>
							<td colspan="2" align="left"><h3>
									<spring:message code="generic_error_message" />
								</h3></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>