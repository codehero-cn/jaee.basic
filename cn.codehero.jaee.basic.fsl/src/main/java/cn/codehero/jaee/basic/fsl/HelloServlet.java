package cn.codehero.jaee.basic.fsl;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = -769151351555555555L;
	
	public HelloServlet(){
		System.out.println("======Servlet()构造函数======");
	}
	
	public void init() throws ServletException{
		System.out.println("======Servlet Init()初始化======");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerServlet(),0,6000L);
	}
	
	public void destory(){
		System.out.println("======ServletDestory()======");
	}
	
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException, IOException{
		
	}
	
	public void doPost(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException,IOException{
		
	}
	
	//以下这句功能应是在页面上打印，eleven还没有搞清用法
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.getWriter().println("Hello World!");
	}
}
