package cn.codehero.jaee.basic.uc.usermanager.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		//返回一个界面(html技术)
		out.println("<img src='imgs/1.jpg'/><hr/>");
		out.println("<h1>用户登录</h1>");
		//action 应该这样写  /web应用名/Servlet的url
		out.println("<form action='/LoginCheck' method='post'>");
		out.println("用户账号:<input type='text' name='id'/> <br/>");
		out.println("密　码:<input type='password' name='password'/> <br/>");
		out.println("<input type='submit' value='登录'/> <br/>");
		out.println("</form>");
		String errInfo = (String) req.getAttribute("err");
		if(errInfo!=null){
		out.println("<font color='red'>"+errInfo+"</font>");
		}
		out.println("<hr/><img src='imgs/2.jpg'/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doPost(req, resp);
		this.doGet(req, resp);
	}

}
