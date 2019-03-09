package cn.codehero.jaee.basic.uc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.codehero.jaee.basic.uc.utils.SqlHelper;
import cn.codehero.jaee.basic.uc.domain.User;

public class UsersService {
	Connection ct = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	
	//获取pageCount
	public int getPageCount(int pageSize){
		
		String sql="select count(*) from users";
		ResultSet rs = SqlHelper.executeQuery(sql,null);
		int pageCount =0;
		int rowCount = 0;
		try {
			rs.next();//把游标下移
			rowCount = rs.getInt(1);
			pageCount=(rowCount-1)/pageSize+1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return  pageCount;
	}
	
	//按照分页来获取用户
	//公司 把ResultSet->User对象->ArrayList(集合)
	public ArrayList<User> getUserByPage(int pageNow ,int pageSize){
		
		ArrayList<User> al=new ArrayList<User>();
		
		try {
			//查询sql 和韩顺平的不一样,他用的是orical数据库
			ps = SqlHelper.getConnection().prepareStatement("select * from users order by id LIMIT ?,?");
			ps.setInt(1, (pageNow - 1) * pageSize);
			ps.setInt(2, pageSize);
			
			rs=ps.executeQuery();
			//二次封装 把ResultSet->User对象->ArrayList(集合)
		
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setGrade(rs.getInt(4));
				//千万不要忘记u->arraylist
				al.add(u);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return al;
	}
	
	//添加用户
	//修改用户
	//删除用户
	
	
	
	// 写一个验证用户是否合法的函数
	public boolean checkUser(User user) {
		
		boolean b = false;
		
		//使用SqlHelper来完成查询任务
		String sql="select * from users where id=? and passwd=?";
		String[] parameters={user.getId()+"",user.getPwd()};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		try {
			//根据rs来判断该用户是否存在
			if (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return b;
	}
}
