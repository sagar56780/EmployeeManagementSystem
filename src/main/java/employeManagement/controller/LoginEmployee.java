package employeManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeManagement.model.dao.EmployeeDao;
@WebServlet(value="/employeelogin")
public class LoginEmployee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 String password=req.getParameter("password");
		 EmployeeDao edo=new EmployeeDao();
		 
		 boolean result=edo.loginEmployee(id, password);
		 RequestDispatcher rd1=req.getRequestDispatcher("Employee_login.jsp");
		 RequestDispatcher rd2=req.getRequestDispatcher("Employee_operation.jsp");
		 req.setAttribute("id", id);
		 PrintWriter pw=resp.getWriter();
		 if(result)
		 {
			 rd2.forward(req, resp);
		 }
		 else {
			 rd1.include(req, resp);
			 pw.print("your have enter wrong cridentials");
		 }
		
		
		
		 
		 
	
	}

}
