package cn.codehero.jaee.basic.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirstServlet implements Servlet{
	/*
	 * 该函数用于初始化servlet,就是把该servlet装载到内存中
	 * 该函数只会被调用一次
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init函数被调用...");
		
	}
	/*
	 * 得到ServletConfig对象
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}
	
	/*
	 * 该函数是服务函数,我们的业务逻辑代码就是写在这里
	 * 该函数每次都会被调用
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//在控制台输出
		System.out.println("hello world"+new java.util.Date());
		//在浏览器返回
		res.setCharacterEncoding("utf-8");
		res.getWriter().println("<h1>北京你好</h1>");
		//res.getWriter().println("<h1>北京你好</h1>"+ new java.util.Date().toLocaleString() +req.getRemoteHost());
	}
	
	/*
	 * 该函数是得到servlet配置信息
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		
		return null;
	}

	/*
	 * 销毁该servlet,从内存中清除,该函数被调用一次
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		
		System.out.println("destroy函数被调用...");
	}	
}
