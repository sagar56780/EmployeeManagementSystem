<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		
		display: flex;
		justify-content: center;
		align-items: center;
	}
	div{
		display:inline-block;
		margin:5%;
		
		padding:10px;
	}
	form{
	height:50%;
	width:80%;
	
	border:5px solid black;
	padding: 20px;
	}
	
</style>
</head>

<body>
	 <form action="add_employee" method="post">
	  <div><label>Enter Id:</label for="id"><br>
	  <input type="number" name="id"><br><br>
	  <label>Name :</label><br>
	  <input type="text" name="name"><br><br>
	  <label>Salary :</label><br>
	  <input type="number" name="salary"><br><br>
	  </div>
	  <div><label>Number :</label><br>
	  <input type="number" name="number"><br><br>
	  <label>Password</label><br>
	  <input type="text" name="password"><br><br>
	  <label>Roll</label><br>
	  <input type="text" name="roll"> <br><br>
	  </div>
	  
	  <input type="submit">
	 
	 </form>

</body>
</html>