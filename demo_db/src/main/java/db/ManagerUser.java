package javaee.basic.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		out.println("欢迎XX登录&nbsp&nbsp&nbsp<a href='/MainFrame'>返回主界面</a>&nbsp&nbsp&nbsp安全退出&nbsp&nbsp&nbsp欢迎您<hr/>");
		
		out.println("<h1>管理用户</h1>");
		
		//从数据库中取出用户数据,并显示
		Connection ct = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		//分页思路
		//1.定义四个分页变量 
		//pageNow 表示第几页,该变量是由用户来决定,因此变化的
		//pageSize 表示每页显示几条记录,由程序指定,也可以由用户定制
		//pageCount 表示共有多少页,该变量是计算出来的->思考,怎样确定
		//rowCount 共有多少条记录,该变量是查询数据库得到的
		//定义分页需要的变量
		int pageNow = 1;//当前面
		//接受用户的pageNow
		String spageNow = req.getParameter("pageNow"); 
		if(spageNow!=null){
			pageNow = Integer.parseInt(spageNow);
		}
		
		int pageSize = 3; //指定每页显示3条记录
		int pageCount = 1; //该值是计算出来的
		int rowCount = 1; //该值表示共有多少记录,从数据库查询的
		
		
		
		//如何确定pageCount
		//验证数据eg
		//比如user表9条记录     pageSize =3   => pageCount=3
		//比如user表10条记录	   pageSize =3   => pageCount=3
		//方法1：
		/*
		if(rowCount%pageSize==0){
			pageCount=rowCount/pageSize;          
		}else{
			pageCount=rowCount/pageSize+1;        
		}
			
		//方法2：三目运算
		pageCount=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
		//方法3：更简单的算法是
		pageCount=(rowCount-1)/pageSize+1;
		*/
		
		try{
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.得到连接
			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/jaeebasicdb","root","123456");
			//算出共有多少页
			//1).查询rowCount
			ps=ct.prepareStatement("select count(*) from users");
			rs=ps.executeQuery();
			rs.next();//把游标下移
			rowCount=rs.getInt(1);
			
			pageCount = rowCount%pageSize==0 ? rowCount/pageSize : rowCount/pageSize+1;
			
			//3.创建PreparedSatement
			//ps=ct.prepareStatement("select * from users");
			//请大家思考,如果给出的条件  pageNow=2  pageSize=3;
			ps=ct.prepareStatement("select * from users order by id LIMIT ?,?");
			ps.setInt(1, (pageNow-1)*pageSize);
			ps.setInt(2, pageSize); 
			
			//4.执行操作
			rs=ps.executeQuery();
			//5.根据结果作处理
			out.println("<table border=1px bordercolor=green cellspacing=0 width=500px>");
			out.println("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getInt(1)+
						"</td><td>"+rs.getString(2)+
						"</td><td>"+rs.getString(3)+
						"</td><td>"+rs.getInt(4)+
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
		}finally{
			//关闭资源 
			if(rs!=null){
				try{
					rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
				rs=null;
			}
			if(ps!=null){
				try{
				ps.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
				ps=null;
			}	
			if(ct!=null);{
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				ct=null;
			}
		}
		
		
		
		out.println("<hr/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	}
}
