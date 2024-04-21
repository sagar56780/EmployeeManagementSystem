<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1> this is your id</h1>
<%request.getCookies(); %>
<h1><%request.getAttribute("id"); %></h1>
<form action="menu" method="post"> 
		
   menu<input type="text" name="menu"> <br><br>
   <input type="submit">


</form>


</body>
</html>