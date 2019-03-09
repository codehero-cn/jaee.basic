package cn.codehero.jaee.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseTest",urlPatterns={"/response/ResponseTest"})
public class ResponseTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//实验1：使用PrintWriter对象回送字符
		//PrintWriter和OutputStream不能同时使用
		PrintWriter out = resp.getWriter();
		out.println("<img src='/imgs/1.jpg'/><hr/>");
		out.write("hello,world!");
		out.println("<hr/><img src='/imgs/2.jpg'/>");
		
		//实验2：使用OutputStream对象回送字符
		//OutputStream os=resp.getOutputStream();
		//os.write("hello,world!!".getBytes());
		
		//实验3:演示状态码302
		//resp.setStatus(302);
		//resp.setHeader("Location", "http://localhost");
		//等效下面
		//resp.sendRedirect("http://localhost");
		
		//实验4:演示状态码500
		//下面会报500错误
		//int i = 900/0;
		
		//实验5:Refresh,url转向自己的话，就是本页刷新
		//resp.setHeader("Refresh", "5;url=http://localhost");
			
		//实验抽取到了testCache()中
		//testCache(resp);
	}
/*
	//TODO 此方法中的实验在IE中没有成功
	private void testCache(HttpServletResponse resp) throws IOException {
		//实验6:指定该页面不缓存
		//resp.setDateHeader("Expires", -1); //IE用
		//为了保证其他浏览器兼容
		//resp.setHeader("Cache-Control", "no-cache");
		//resp.setHeader("Pragma", "no-cache");
		
		//实验7:指定该页面缓存时间
		resp.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24);
		
		PrintWriter out = resp.getWriter();
		out.println("hello,world!"+new java.util.Date().toString());
	}
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

}
