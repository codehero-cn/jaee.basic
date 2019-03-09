package javaee.basic.transferdata;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SessionPage",urlPatterns={"/transferdata/SessionPage"})
public class SessionPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		//获取session中普通数据
		String username=(String) req.getSession().getAttribute("loginuser");	
		//获取Session中对象
		User user=(User) req.getSession().getAttribute("userobj");
		
		out.println("session传递普通数据_用户名:"+username);
		out.println("</br>");
		out.println("session传递对象_用户名:"+user.getName());
		out.println("</br>");
		out.println("session传递对象_密码是:"+user.getPwd());
	}
}
