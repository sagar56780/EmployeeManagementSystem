package controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entity.Users;
import service.LoginService;

@Controller
public class LoginController {
	@Autowired
	Users user;
	
	@Autowired
	LoginService lserv;
	
	@PostMapping("/login_validate")
	public void loginValidate(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		String password=req.getParameter("password");
		user.setId(id);
		user.setPassword(password);
		Users result=lserv.LoginValidate(user);
		
		RequestDispatcher fail=req.getRequestDispatcher("index.jsp");
		PrintWriter pw=resp.getWriter();
	
		if(result!=null)
		{
			if(result.getRole().equals("manager")) {
				HttpSession session=req.getSession();
				session.setAttribute("user", result);
				
	
			RequestDispatcher manager=req.getRequestDispatcher("manager_operations.jsp");
			try {
				Cookie cookies=new Cookie("Id", id+"");
				resp.addCookie(cookies);
				req.setAttribute("id", id);
				manager.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			try {
				fail.include(req, resp);
				pw.print("Invalid Id or password");
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			try {
				fail.include(req, resp);
				pw.print("Invalid Id or password");
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

	}

}
