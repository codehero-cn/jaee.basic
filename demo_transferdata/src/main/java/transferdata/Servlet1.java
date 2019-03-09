package javaee.basic.transferdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *
 */

@WebServlet(name="Servlet1",urlPatterns={"/transferdata/Servlet1"})
public class Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		//接收用户名
		String u = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		
		//把u放入req域对象
		req.setAttribute("username", u);
		System.out.println("Servlet1中u="+u);
		
		//表示使用转向的方法,把req和resp对象传递给下一个Servlet2
		//注意如果有web应用名称也不用写,只要写"/transferdata/Servlet2"部分
		//地址栏留在"/transferdataServlet1"位置,因为浏览器没重新访问
		req.getRequestDispatcher("/transferdata/Servlet2").forward(req,resp);
	}
}
