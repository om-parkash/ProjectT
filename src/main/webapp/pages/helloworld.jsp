<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World - JSP tutorial</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	document.onmousemove = function(e) {
		var pageCoords = "( " + e.pageX + ", " + e.pageY + " )";
		console.log(pageCoords);
		
		$.post(
	             "HelloWorld", 
	             {name : "Message from jsp"} //meaasge you want to send
	             );
	};
</script>
<body>
	<%="Hello World!"%>
</body>
</html>