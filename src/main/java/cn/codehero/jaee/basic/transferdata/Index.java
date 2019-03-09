package cn.codehero.jaee.basic.transferdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *用于测试的目录页 
 */

@WebServlet(name="Index",urlPatterns={"/transferdata/Index"})
public class Index extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<a href=http://localhost/transferdata/UrlPage?firstusername=1name&firstpassword=1pass>url数据传递实验</a>");
		out.println("</br>");
		out.println("<a href=http://localhost/transferdata/SendRedirectPage>sendRedirect数据传递实验</a>");		
		out.println("</br>");
		out.println("<a href=http://localhost/transferdata/MyDataPage>MyData数据传递实验</a>");		
		out.println("</br>");
		
		//方法：使用session来传递数据给下个页面
		String username= "gege";
		String password= "wuwu";
		//session传递普通数据
		req.getSession().setAttribute("loginuser", username);
		//session可以传递对象
		User user = new User();
		user.setName(username);
		user.setPwd(password);
		req.getSession().setAttribute("userobj", user);
		out.println("<a href=http://localhost/transferdata/SessionPage>Session数据传递实验</a>");
		
		//request转发:数据从Servlet1传递到Servlet2
		out.println("<form action='/transferdata/Servlet1' method='post'>");
		out.println("用户名:<input type='text' name='username' value='马大哈'/><br/>");
		out.println("密码:<input type='password' name='pwd' vlaue='123'/><br/>");
		out.println("<input type='submit' vlaue='登录'/><br/>");
		out.println("</form>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
