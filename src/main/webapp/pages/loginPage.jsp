<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript" language="javascript"
	src="js/validation.js"></script>
<script type="text/javascript" language="javascript"
	src="js/jquery-1.11.0.min.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="languageHeader.jsp"></jsp:include>
	<table width="80%" height="40%" align="center">
		<tr>
			<td height="600px">
				<div id="loginform">
					<form name="login" action="login.do" method="post"
						onSubmit="return new ValidateLogin(document.login.username.value,document.login.password.value).validateUser();">
						<table cellspacing="2" cellpadding="2"
							style="postion: absolute; margin-left: 80px;">
							<tr>
								<td colspan="2" align="center"><h3>
										<spring:message code="login_form" />
									</h3></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><span style="color: red;">${error}</span>

								</td>
							</tr>

							<tr>
								<td><spring:message code="username" />:</td>
								<td><input type="text" name="username"></td>
							</tr>
							<tr>
								<td><spring:message code="password" />:</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="submit"
									value="Login"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>