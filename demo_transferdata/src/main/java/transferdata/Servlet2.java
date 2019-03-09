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

@WebServlet(name="Servlet2",urlPatterns={"/transferdata/Servlet2"})
public class Servlet2 extends HttpServlet{

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
		PrintWriter out = resp.getWriter();
		
		//接收用户名
		String u = (String)req.getAttribute("username");
		out.println("用户名username="+u);
	}
}
