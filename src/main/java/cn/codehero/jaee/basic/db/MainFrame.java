package cn.codehero.jaee.basic.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MainFrame",urlPatterns={"/MainFrame"})
public class MainFrame extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		out.println("欢迎XX登录<a href='/LoginServlet'>返回重新登录</a><hr/>");
		
		out.println("<h3>请选择您要进行的操作</h3>");
		out.println("<a href='/ManagerUser'>管理用户</a><br/>");
		out.println("<a href=''>添加用户</a><br/>");
		out.println("<a href=''>查找用户</a><br/>");
		out.println("<a href=''>退出系统</a><br/>");
		out.println("<hr/>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doPost(req, resp);
		this.doGet(req, resp);
	}

}
