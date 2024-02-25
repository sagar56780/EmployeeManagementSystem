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
@WebServlet(value="/view_all_Employee")
public class ViewAllEmployee extends HttpServlet  {

	RequestDispatcher rd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		
		 EmployeeDao n=new EmployeeDao();
		 ArrayList<Employee> li;
		 li=(ArrayList<Employee>) n.viewAllEmployee();
       
		
		RequestDispatcher rd1=req.getRequestDispatcher("view_Employee.jsp");
		
//		
    	rd=req.getRequestDispatcher("admin_operation.jsp");
		
		if(li!=null)
		{
			
			req.setAttribute("employee", li);
 			rd1.forward(req, resp);
			
			
		}
		else {
			
			rd.include(req, resp);
			pw.print("No data present");
			
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
