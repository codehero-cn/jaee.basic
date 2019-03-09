package encoding;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="GetInfoServlet",urlPatterns={"/encoding/GetInfoServlet"})
public class GetInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//super.doGet(req, resp);		
				
		String u = req.getParameter("username");
		if(u.equals("get提交")){
			System.out.println("get提交 u="+u);
		}
		
		//tomcat7的url是iso-8859-1编码,要转码
		String uu = new String(req.getParameter("username").getBytes("iso8859-1"),"utf-8");
		if(uu.equals("tomcat7中get提交")){
			System.out.println("tomcat7中才能正确解码,使用get方法,iso-8859-1转utf-8后,uu="+uu);
		}
		//使用工具类也可以
		//没使用
		//String uu = req.getParameter("username"); 
		//System.out.println("使用get方法+工具类的uu="+GetUtf8.get(uu));
			
		//超链接测试
		String ulink = req.getParameter("username");
		if(ulink.equals("超链接测试")){
			System.out.println("超链接的ulink="+ulink);
		}
		
		//sendRedirect测试,把它接收到的数据传递给下一页面
		//FIXME不成功,怀疑是sendRedirect时转了码
		String usend = req.getParameter("username");
		if ( usend.equals("sendRedirect测试")){
			resp.sendRedirect("http://localhost/encoding/Welcome?yy="+usend);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		
		//post提交设置编码,浏览器是什么编码就设什么编码,否则u打印出来可能是乱码
		//当前端是gbk时   req.setCharacterEncoding("gbk");
		req.setCharacterEncoding("utf-8");
		String u= req.getParameter("username");
		System.out.println("使用post方法的u="+u);	
	}
}
