package javaee.basic.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet{
	
	@Override
	public ServletConfig getServletConfig() {
		
		return super.getServletConfig();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);//一定要注释掉
		resp.setContentType("text/html");
		String encoding = this.getServletConfig().getInitParameter("encoding");
		resp.setCharacterEncoding(encoding);		
		PrintWriter out = resp.getWriter();
		out.println("编码是"+encoding);
		
		//在后台看到,一次取出所有参数
		Enumeration<String> names = this.getServletConfig().getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(this.getServletConfig().getInitParameter(name));
		}
		
	}

}
