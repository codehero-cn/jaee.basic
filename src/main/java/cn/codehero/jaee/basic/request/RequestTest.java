package cn.codehero.jaee.basic.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.codehero.jaee.basic.encoding.GetUtf8;

@WebServlet(name="RequestTest",urlPatterns={"/request/RequestTest"})
public class RequestTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		getheader(req, resp);
		
		getRemote(req, resp, out);
		
	}
	/**
	 * 获得客户机请求头内容
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	protected void getheader(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//getHeader获取用户浏览器Referer
		String referer=req.getHeader("Referer");
		//防盗链逻辑,要从http://localhost里的页面链接过来才行，直接访问http://localhost/request/RequestTest都不行
		if(referer==null||!referer.startsWith("http://localhost")){
			resp.sendRedirect("/request/Error");
			return;
		}		
		System.out.println("referer="+referer);
		
		//getHeader获取http请求的Host信息
		//取出Host
		String host = req.getHeader("Host");
		System.out.println("getHeader获取http请求的Host信息host="+host);	
		System.out.println("*********************");	
		
		//getHeaderNames方法,把整个http请求的消息全部获取
		//1.得到所有头
		Enumeration<String> headers = req.getHeaderNames();
		while(headers.hasMoreElements()){
			//取出消息头的名字
			String headername = headers.nextElement();
			System.out.println(headername+":"+req.getHeader(headername));
		}
	}
	
	/**
	 * 获取客户机信息
	 * @param req
	 * @param resp
	 * @param out
	 * @throws IOException
	 */
	protected void getRemote(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) throws IOException {
		//得到URL
		String url = req.getRequestURL().toString();
		System.out.println("url="+url);
		
		//得到URI
		String uri = req.getRequestURI().toString();
		System.out.println("uri="+uri);
		
		//QueryString
		//得到参数名和参数
		String queryString = req.getQueryString();
		System.out.println("queryString="+queryString);
		
		//getRemoteAddr函数可以获取请求方的ip
		String addr  = req.getRemoteAddr();
		System.out.println("addr="+addr);
		if(addr.equals("192.168.5.1")){
			resp.sendRedirect("/Error");
			return;
		}
		
		//getRemoteHost返回请求方的主机名,此处是ip地址,主机名要在dns上注册才生效.
		String rhost =  req.getRemoteHost();
		System.out.println("rhost="+rhost);
		
		//获取客户机使用的端口
		int port = req.getRemotePort();
		int serverport = req.getLocalPort();
		System.out.println("客户机使用的端口port="+port);
		System.out.println("服务器使用的端口serverport="+serverport);
		
		//给浏览器回送:浏览器发送的具体内容,不同浏览器发送内容是不一样的.
		//FIXME 中文乱码没解决
		//ie中文后台正常,前端有问题.firefox中%**%类型的乱码
		String queryStrings[] = queryString.split("&");
		out.println("本浏览器发送的具体内容是"+url+queryString);
		for(String s:queryStrings){
			//out.println(s+"="+GetUtf8.get(req.getParameter(s)));
			//System.out.println(s);
			String[] name_val = s.split("=");
			System.out.println(name_val[0]+"="+GetUtf8.get(name_val[1]));
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		//获取用户提交的内容（通过表单提交的内容）
		String u = req.getParameter("username");
		String p = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		System.out.println("用户名"+u+"密码"+p+"性别"+sex);
		
		//如果接受复选框的内容,则使用getParameterValues
		String[] hobbies = req.getParameterValues("hobby");
		if(hobbies!=null){
			for(int i=0;i<hobbies.length;i++){
				System.out.println("爱好:"+hobbies[i]);
			}
		}else
			System.out.println("你没有爱好");
		
		//下拉列表
		String city = req.getParameter("city");
		System.out.println("城市"+city);
		
		//文本域
		String intro =req.getParameter("intro");
		System.out.println("个人介绍"+intro);

		//hidden数据
		String hidden1=req.getParameter("hidden1");
		System.out.println("hidden控件数据"+hidden1);

		
	}
}
