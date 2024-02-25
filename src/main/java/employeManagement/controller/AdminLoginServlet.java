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
@WebServlet(value="/admin")
public class AdminLoginServlet extends HttpServlet {

	PrintWriter pw;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao edao=new EmployeeDao();
		Employee emp=new Employee();
		int id=Integer.parseInt(req.getParameter("id"));
		String password=req.getParameter("password");
		emp.setId(id);
		emp.setPassword(password);
		PrintWriter pw=resp.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("admin_login.jsp");
		
		boolean result=edao.adminloginValidate(emp);
		if(result)
		
		{	HttpSession session=req.getSession();
			session.setAttribute("admin", id);
			pw=resp.getWriter();
			pw.print(result);
			resp.sendRedirect("admin_operation.jsp");
			
			
		}
		else
		{ 
			System.out.println(result);
			
			
			
			
		}
		
		
	}

}
