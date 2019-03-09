package cn.codehero.jaee.basic.initservlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//测试时启用以下注解
@WebServlet(loadOnStartup=1,name="MyInitServlet",urlPatterns={"/MyInitServlet"})
public class MyInitServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		
		//实验init()函数
		super.init();
		System.out.println("cn.codehero.jaee.basic.initservlet.MyInitServlet的init被调用...");
		
		//通过ServletContext.getRealPath,获得web项目根目录
		ServletContext s1=this.getServletContext(); 
		String webpath1=s1.getRealPath("/");
		String webpath2=s1.getRealPath("");
		System.out.println(webpath1);
		System.out.println(webpath2);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		//super.doGet(req, resp);
		//通过request.getSession().getServletContext.getRealPath("/"),获得web项目根目录
		String webpath3=req.getSession().getServletContext().getRealPath("/");
		System.out.println(webpath3);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		
		super.destroy();
	}
	
}