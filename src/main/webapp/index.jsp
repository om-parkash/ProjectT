<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<html>
<body>
<center>
<h2>Hello World!</h2>
<table>
<tr>
	<th>System Property</th>
	<th>Value</th>
</tr>
<%
	Set<Entry<Object, Object>> entrySet = System.getProperties().entrySet();
	
	for(Entry<Object, Object> entry : entrySet){
		
%>
<tr>
	<td>
		<%= entry.getKey() %>
	</td>
	<td>
		<%= entry.getValue() %>
	</td>
</tr>
	
<%		
	}
 %>
 </table>
 </center>
</body>
</html>
