<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Employee </title>
</head>
<body>
	<form action="employee_update_serv" method="post">
	 <input type="hidden" name="id" value="<%=request.getParameter("id")%>"> 
	  name: <input type="text" name="name" value="<%=request.getParameter("name") %>"> <br><br>
	  salary: <input type="number" name="salary" value="<%=request.getParameter("salary") %>"><br><br>
	  number: <input type="number" name="number" value="<%=request.getParameter("number") %>"><br><br>
	  password: <input type="text" name="password" value="<%=request.getParameter("password") %>"><br><br>
	  roll:	<input type="text" name="roll" value="<%=request.getParameter("roll") %>"> 
	  <input type="submit">
	
	
	</form>
	

</body>
</html>