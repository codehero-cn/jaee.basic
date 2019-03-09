package cn.codehero.jaee.basic.uc.usermanager.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.codehero.jaee.basic.uc.domain.User;
import cn.codehero.jaee.basic.uc.service.UsersService;

@WebServlet(name="LoginCheck",urlPatterns={"/LoginCheck"})
public class LoginCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html charset=utf-8");
		//接收用户提交的用户名和密码
		String id=req.getParameter("id");
		String password=req.getParameter("password");
		
		//创建UsersService对象,完成到数据库的验证
		UsersService  usersService= new UsersService();
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setPwd(password);
		
		//这里看看接到没?
		//这里我们先简单验证
		/*
		if("user".equals(username)&&"pass".equals(password)){							
			resp.sendRedirect("/MainFrame?uname="+username+"&"+"pwd="+password);
		}else
			//跳回
			resp.sendRedirect("/LoginServlet");
		*/
		if(usersService.checkUser(user)){
			
			req.getRequestDispatcher("/MainFrame").forward(req, resp);
		}else {
			
			System.out.println(""+user.getId()+user.getPwd());
			req.setAttribute("err", "用户id或者密码有误");
			req.getRequestDispatcher("/LoginServlet").forward(req, resp);
		}
	}
		
}
