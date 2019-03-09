package javaee.basic.transferdata;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *数据传递方法:使用跳转时带上数据 
 */

@WebServlet(name="SendRedirectPage",urlPatterns={"/transferdata/SendRedirectPage"})
public class SendRedirectPage extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//PrintWriter out = resp.getWriter();
	
		//跳转到下一个页面[servlet提供了两种:Sendredirct转向   forward转发]
		//sendRedirect的url应该这样写  /web应用名/servlet的url
		resp.sendRedirect("http://localhost?secodeusername=2name&secoondpassword=2password");
			
	}
}


		
