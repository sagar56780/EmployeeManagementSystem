package employeManagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import employeManagement.model.dao.EmployeeDao;
import employeManagement.model.dto.Employee;
@WebServlet(value="/view_detail")
public class ViewDetails extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		ArrayList<Employee> emp=new ArrayList<>();
		
		EmployeeDao dao=new EmployeeDao();
		Employee e=dao.viewallDetail(id);
		emp.add(e);
		req.setAttribute("employee", emp);
		RequestDispatcher rd=req.getRequestDispatcher("view_Employee.jsp");
		rd.forward(req, resp);
	}

}
