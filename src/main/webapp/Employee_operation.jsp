<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Operation</title>
</head>
<body>
	 
  	<h1> <a href="view_detail?id=<%=request.getParameter("id")%>"> veiw your detail</a> </h1>
  	<h1> <a href="update_password.jsp?id=<%=request.getParameter("id")%>">update password</a></h1>
  
	  

</body>
</html>