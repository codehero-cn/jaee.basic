package cn.codehero.jaee.basic.httpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MyHttpServlet",urlPatterns={"/httpservlet/MyHttpServlet"})
public class MyHttpServlet extends HttpServlet {

	//成员变量
	int i = 0; 
	//用于测试Servlet单例,如何实现线程安全
	int ticket = 3;
	
	//在HttpServlet中,设计者对post提交和get提交分别处理
	//回忆<form action="提交给?" mothod = "post|get"/>,默认是get
	//其实doGet()/doPost()最终也去调用service方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp); //一定要注释掉这句
		
		//局部变量
		int j=0;
		
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		resp.getWriter().println("i am httpServlet doGet()  中文:乱码测试");
		resp.getWriter().println("i与j的区别"+ "i=" + i++ +"j=" + j++);
		
		//线程安全简单的解决方法
		synchronized (this) {
			if(ticket>0){
				resp.getWriter().println("你买到票");
				//休眠
				try{
					Thread.sleep(10*1000);
				}catch (InterruptedException e ){
					e.printStackTrace();
				}
				ticket--;
				resp.getWriter().println("现在还有票ticket =" + ticket +"张");
			}else{
				resp.getWriter().println("你没有买到票");
			}
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doPost(req, resp); //一定要注释掉这句
		resp.getWriter().println("i am httpServlet doPost() post name = " + req.getParameter("username"));
		
		//一般开发人员习惯把doGet()和doPost()二合为一
		//this.doGet(req,resp);
		
	}
	
}
