package controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MenuControllerr {
	@PostMapping("/menu")
	public void menu(HttpServletRequest req,HttpServletResponse resp)
	{
		try {
			PrintWriter pw=resp.getWriter();
			pw.print(req.getCookies());
			pw.print("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
