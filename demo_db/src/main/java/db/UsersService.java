package javaee.basic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {
	Connection ct = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	//添加用户
	//修改用户
	//删除用户
	
	// 写一个验证用户是否合法的函数
	public boolean checkUser(User user) {
		boolean b = false;
		// 连接数据库
		// 到数据库中取验证
		
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.得到连接
			ct = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jaeebasicdb", "root", "123456");
			// 3.创建PreparedSatement
			ps = ct.prepareStatement("select * from users where id=? and passwd=?");
			// 给?赋值
			ps.setObject(1, user.getId());
			ps.setObject(2, user.getPwd());

			// 4.执行操作
			rs = ps.executeQuery();
			// 5.根据结果作处理
			if (rs.next()) {
				// 说明该用户合法
				b = true;
				// System.out.println("哈哈");
			} 
		} catch (Exception e) {
			//req.setAttribute("err", "您的输入id不是数字");
			//req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			//e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (ct != null)
				;
			{
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				ct = null;
			}
		}
		return b;
	}
}
