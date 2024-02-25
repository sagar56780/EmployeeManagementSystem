package employeManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeManagement.model.dao.EmployeeDao;
import employeManagement.model.dto.Employee;
@WebServlet(value="/employee_view")
public class EmployeeView extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeDao edo=new EmployeeDao();
		Employee e=edo.viewEmployee(id);
		ArrayList<Employee> li=new ArrayList<>();
		li.add(e);
 		RequestDispatcher rd=req.getRequestDispatcher("view_Employee.jsp");
 		RequestDispatcher rd1=req.getRequestDispatcher("employee_view.jsp");
 		PrintWriter pw=resp.getWriter();
		if(e!=null)
		{
			req.setAttribute("employee", li);
			rd.forward(req, resp);
		}
		else {
			rd1.include(req, resp);
			pw.print("Id is not present in data");
		
			
		}
		
		
	}

}
