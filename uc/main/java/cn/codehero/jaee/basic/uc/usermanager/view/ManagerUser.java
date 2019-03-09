package cn.codehero.jaee.basic.uc.usermanager.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.codehero.jaee.basic.uc.domain.User;
import cn.codehero.jaee.basic.uc.service.UsersService;

@WebServlet(name="ManagerUser",urlPatterns={"/ManagerUser"})
public class ManagerUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<script type='text/javascript' language='javascript'>");
		out.println("function gotoPageNow(){"
				+ "var pageNow=document.getElementById('pageNow');"
				+ "window.alert('pageNow'+pageNow.value);"
				+ "window.open('/ManagerUser?pageNow='+pageNow.value,'_self');}");
		out.println("</script>");
		
		out.println("<img src='imgs/1.jpg'/>欢迎XX登录&nbsp&nbsp&nbsp<a href='/MainFrame'>返回主界面</a>&nbsp&nbsp&nbsp安全退出&nbsp&nbsp&nbsp欢迎您<hr/>");
		
		out.println("<h1>管理用户</h1>");
		//1.定义分页需要的变量 
		int pageNow = 1;//当前面
		int pageCount=1;//页数
		//接受用户的pageNow
		String spageNow = req.getParameter("pageNow"); 
		if(spageNow!=null){
			pageNow = Integer.parseInt(spageNow);
		}
		
		int pageSize = 3; //指定每页显示3条记录
		try{
			UsersService usersService = new UsersService();
			pageCount=usersService.getPageCount(pageSize);
			
			ArrayList<User> al=usersService.getUserByPage(pageNow, pageSize);
			//5.根据结果作处理
			out.println("<table border=1px bordercolor=green cellspacing=0 width=500px>");
			out.println("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th><th>删除用户</th><th>修改用户</th></tr>");
			for(User u:al){
				out.println("<tr><td>"+u.getId()+
						"</td><td>"+u.getName()+
						"</td><td>"+u.getEmail()+
						"</td><td>"+u.getGrade()+
						"</td><td><a href='/ManagerUser?type=delete&userid="+u.getId()+"'>删除用户<a>"+
						"</td><td><a href='/ManagerUser?type=update&userid="+u.getId()+"'>修改用户<a>"+
						"</td><tr>");
			}
			out.println("</table><br/>");
			
			//显示上一页
			if(pageNow!=1){
				out.println("<a href='/ManagerUser?pageNow="+(pageNow-1)+"'>上一页<a>");
			}
			
			//显示分页
			for(int i=1;i<=pageCount;i++){
				out.println("<a href='/ManagerUser?pageNow="+i+"'><"+i+"></a>");
			}
			
			//显示下一页
			int pagenext=1;
			if(pageNow!=pageCount){
				out.println("<a href='/ManagerUser?pageNow="+(pageNow+1)+"'>下一页<a>");
			}
			
			//显示分页信息(当前?页/共?页)
			out.println("&nbsp;&nbsp;&nbsp;当前页"+pageNow+"/总页数"+pageCount+"<br/>");
			
			//跳转到多少页，servlet中使用js技术
			out.println("跳转到:<input type='text' id='pageNow' name='pageNow'/><input type='button' onClick='gotoPageNow()' value='跳'/>");
			
		} catch (Exception e){
		}
		
		out.println("<hr/><img src='imgs/2.jpg'/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
