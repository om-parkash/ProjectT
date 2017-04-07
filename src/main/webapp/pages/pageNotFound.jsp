<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Not Found</title>
</head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table width="100%" align="center">
		<tr>
		<tr>
			<td><jsp:include page="header.jsp"></jsp:include></td>
		<tr>
			<td><jsp:include page="back.jsp" /></td>
		</tr>


		<td height="100px">
			<div id="errorPage">
				<table>
					<tr>
						<td colspan="2" align="left"><h3>Ooops! Something went
								wrong. We apologize for the inconvenience. Please try again
								later.</h3></td>
					</tr>
				</table>
			</div>
		</td>
		</tr>
	</table>
</body>