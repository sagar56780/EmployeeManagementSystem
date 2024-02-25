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
import employeManagement.model.dto.Employee;
@WebServlet(value="/employee_update_serv")
public class EmployeeUpdate  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao edo=new EmployeeDao();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double salary=Double.parseDouble(req.getParameter("salary"));
		long phone=Long.parseLong(req.getParameter("number"));
		String password=req.getParameter("password");
		String roll=req.getParameter("roll");
		Employee e=new Employee(id,name,salary,phone,password,roll);
		boolean result=edo.updateAll(e);
		RequestDispatcher rd=req.getRequestDispatcher("view_Employee.jsp");
		RequestDispatcher rd1=req.getRequestDispatcher("view_all_Employee");
		PrintWriter pw=resp.getWriter();
		pw.print(result);
		if(result)
		{	
			rd1.forward(req, resp);
		}
		else
		{   
		
			rd.include(req, resp);
			pw.print("something wrong during the updation");
			
		}
		
	}
	
	

}
