<%@page import="employeManagement.model.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%//scriplet tag
		List<Employee> employee=(List<Employee>) request.getAttribute("employee");
	%>
	<table style="border:2px  solid ;">
	<tr style="border:2px  solid ;">
		<th>id</th>
		<th>name</th>
		<th>salary</th>
		<th>phone</th>
		<th>password</th>
		<th>Role</th>
		<th>Remove</th>
	</tr>
		

	<%
		for(Employee emp: employee)
		{
		%>

	<tr>
		<td><%=emp.getId()%></td>  <%-- expression tag--%>
		<td><%=emp.getName()%></td>
		<td><%=emp.getSalary()%></td>
		<td><%=emp.getNumber()%></td>
		<td><%=emp.getPassword()%></td>
		<td><%=emp.getRoll()%></td>
		<td><a href="remove_empoloyee?id=<%=emp.getId()%>"> Remove </a></td>
		<td><a href="employee_update.jsp?id=<%=emp.getId() %>&name=<%=emp.getName()%>&
		salary=<%=emp.getSalary()%>&number=<%=emp.getNumber()%>&password=<%=emp.getPassword()%>&roll=<%=emp.getPassword()%>">Update</a></td>
	</tr>
	 
	
	<%

	}
	
	%>
	</table>

</body>
</html>