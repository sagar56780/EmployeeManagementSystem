package employeManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeManagement.model.dao.EmployeeDao;
import employeManagement.model.dto.Employee;
@WebServlet(value="/remove_empoloyee")
public class RemoveEmployee extends HttpServlet {
	EmployeeDao edo=new EmployeeDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
	
		RequestDispatcher rd=req.getRequestDispatcher("view_Employee.jsp");
		RequestDispatcher rd1=req.getRequestDispatcher("view_all_Employee");
		PrintWriter pw=resp.getWriter();
		
		if(edo.removeEmployee(id))
		{
			
			
			rd1.forward(req, resp);
			
		}
		else
		{
			rd.include(req, resp);
			pw.print("something went wrong remove not working");
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
