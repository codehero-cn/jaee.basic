package cn.codehero.jaee.basic.thread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import javax.servlet.annotation.WebServlet;

//@WebServlet(name="InitServlet",urlPatterns={"/InitServlet"},loadOnStartup=1)
public class InitServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		
		super.init();
		System.out.println("InitServlet的init被调用...");
		//完成一些初始化任务
		System.out.println("创建数据库,表,读取参数");
		//创建一个线程
		SendEmailThread sendEmailThread = new SendEmailThread();
		sendEmailThread.start();
	}
	
}