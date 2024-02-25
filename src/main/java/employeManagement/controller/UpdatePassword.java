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

@WebServlet(value="/update_password")
public class UpdatePassword extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		String cur_password=req.getParameter("cur_password");
		String new_password=req.getParameter("new_password");
		String confirmPassword=req.getParameter("con_password");
		EmployeeDao edo=new EmployeeDao();
		PrintWriter pw=resp.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("update_password.jsp");
		rd.include(req, resp);
		if(new_password.equals(confirmPassword))
		{
			boolean result=edo.updatePassword(id,cur_password,new_password,confirmPassword);
			if(result)
			{
				
				pw.print("Password updated Succesfully");
			}
			else
			{
				pw.print("current password is worng");
			}
		
		}
		else {
			pw.print("new password and confirm password are mismatch");
		}
		
		
		
	}

}
