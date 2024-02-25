package employeManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeManagement.model.dao.EmployeeDao;
import employeManagement.model.dto.Employee;

@WebServlet(value="/add_employee")
public class AddEmployee extends HttpServlet{
	EmployeeDao n=new EmployeeDao();
	PrintWriter pw;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	double salary=Double.parseDouble(req.getParameter("salary"));
	long phone=Long.parseLong(req.getParameter("number"));
	String password=req.getParameter("password");
	String roll=req.getParameter("roll");
	Employee e=new Employee(id,name,salary,phone,password,roll);
	boolean res=n.addEmploye(e);
	System.out.println(res);
	RequestDispatcher rd=req.getRequestDispatcher("add_employee.jsp");
	resp.setContentType("text/html");
	pw=resp.getWriter();
	if(res)
	{
		rd.include(req, resp);
		pw.print("Data successfully entered");
		
		
	}
	else {
		pw.print("Please Enter a valid data ");
		rd.include(req, resp);
	}
	
}
}
