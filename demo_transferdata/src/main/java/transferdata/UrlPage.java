package javaee.basic.transferdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UrlPage",urlPatterns={"/transferdata/UrlPage"})
public class UrlPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
		//数据传递方法:url传数据,使用getParamter()得到数据
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		String firstusername=req.getParameter("firstusername");
		String firstpassword=req.getParameter("firstpassword");
		out.println("用户名"+firstusername+"密码"+firstpassword);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
