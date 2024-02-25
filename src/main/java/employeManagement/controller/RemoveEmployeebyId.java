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
@WebServlet(value="/remove")
public class RemoveEmployeebyId extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeDao edo=new EmployeeDao();
		boolean result=edo.removeEmployee(id);
		RequestDispatcher rd=req.getRequestDispatcher("remove_employee.jsp");
		PrintWriter pw=resp.getWriter();
		if(result)
		{
			pw.print("Employee removed Sucessfully");
			
		}
		else
		{	rd.include(req, resp);
			pw.print("Employee is not present in data ");
		}
		
	}
	

}
