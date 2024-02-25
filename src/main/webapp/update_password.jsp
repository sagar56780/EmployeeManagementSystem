<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="update_password" method="get">
			<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
			
			Enter your current Password: <input type="password" name="cur_password"><br><br> 
			Enter your new Password:<input type="password" name="new_password"><br><br>
			Conform your password: <input type="password" name="con_password"><br><br>
			<input type="submit">
		
		</form>

</body>
</html>