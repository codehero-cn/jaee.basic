package cn.codehero.jaee.basic.uc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;

/**这是一个操作数据库的工具类
 * 韩顺平写的类,拷贝自:http://blog.sina.com.cn/s/blog_65f22a0501016phi.html进行了修改
 * @author eleven
 *
 */
public class SqlHelper
{
    //定义需要的变量
    private static Connection ct = null;
    //大多数情况下用preparedstatement替代statement
    //这样可以防止sql注入
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
   
    //连接数据库的参数
    private static String url = "";
    private static String username = "";
    private static String driver = "";
    private static String password = "";
    
    //用于存储过程
    private static CallableStatement cs = null;
    public static CallableStatement getCs()
    {
        return cs;
    }
    
    //读配置文件
    private static Properties  pp = null;
    private static InputStream fis = null;  
    //加载驱动，只需要一次，用静态代码块
    static
    {
        try
        {
            //从dbinfo.properties文件中读取配置信息
            pp = new Properties();
            
            //java web的使用,读取文件要使用类加载器,类加载器去读取资源的时候,默认的主目录是src
            //tomcat默认的主目录在哪里?tomcat的安装目录的/bin
            fis=SqlHelper.class.getClassLoader().getResourceAsStream("config/mysqldbinfo.properties");
            System.out.println("test:SqlHelper.java的fis="+fis);
            //javase时使用
            //要import java.io.FileInputStream;
            //要private static InputStream fis = null; 
            //fis = new FileInputStream("mysqldbinfo.properties");
            
            pp.load(fis);
            url = pp.getProperty("url");
            username = pp.getProperty("username");
            driver = pp.getProperty("driver");
            password = pp.getProperty("password");
           
            Class.forName(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            { fis.close();}
            catch(IOException e) {e.printStackTrace();}
            fis = null;//垃圾回收站上收拾
        }
       
    }
    //得到连接
    public static Connection getConnection()
        {
            try
            {ct = DriverManager.getConnection(url,username,password);}
            catch(Exception e) {e.printStackTrace();}
            return ct;
        }
   
   
//*************callPro1存储过程函数1*************   
    public static CallableStatement callPro1(String sql,String[] parameters)
    {
        try{
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if(parameters!=null){
                for(int i=0;i<parameters.length;i++){
                 cs.setObject(i+1,parameters[i]);
                }
            }   
            cs.execute();
        }
        catch(Exception e) { e.printStackTrace(); throw new RuntimeException(e.getMessage());}
        finally
        { close(rs,cs,ct);}
        return cs;
    }
   
//*******************callpro2存储过程2************************
public static CallableStatement callPro2(String sql,String[] inparameters,
Integer[] outparameters)
{
    try
    {
        ct = getConnection();
        cs = ct.prepareCall(sql);
        if(inparameters!=null)
        {
            for(int i=0;i<inparameters.length;i++)
            {
                cs.setObject(i+1,inparameters[i]);
            }
        }
    //cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
        if(outparameters!=null)
        {
            for(int i=0;i<outparameters.length;i++)
            {
                cs.registerOutParameter(inparameters.length+1+i,outparameters[i]);
            }
        }
        cs.execute();
    }
    catch(Exception e) {
        e.printStackTrace(); throw new RuntimeException(e.getMessage());
    }
    finally
    {
       
    }
    return cs;
}
	//统一的select
	//ResultSet->ArrayList
    public static ResultSet executeQuery(String sql,String[] parameters)
    {
        try
        {
            ct=getConnection();
            ps=ct.prepareStatement(sql);
            if(parameters!=null)
            {
                for(int i=0;i<parameters.length;i++)
                {
                    ps.setString(i+1,parameters[i]);
                }
            }
            rs = ps.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        finally
        {
           
        }
        return rs;
    }
   
   
    public static Connection getCt()
    {
        return ct;
    }

    public static PreparedStatement getPs()
    {
        return ps;
    }

    public static ResultSet getRs()
    {
        return rs;
    }

   
    //如果有多个update/delete/insert[需要考虑事务]
    public static void executeUpdate2(String[] sql,String[][] parameters)
    {
        try
        {
            ct = getConnection();
            ct.setAutoCommit(false);
           
            for(int i=0;i<sql.length;i++)
            {
               
                if(null!=parameters[i])
                {
                    ps = ct.prepareStatement(sql[i]);
                    for(int j=0;j<parameters[i].length;j++)
                    {
                        ps.setString(j+1,parameters[i][j]);
                    }
                    ps.executeUpdate();
                }
               
            }
           
           
            ct.commit();
           
           
        }catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                ct.rollback();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            throw  new RuntimeException(e.getMessage());
        }finally
        {
            close(rs,ps,ct);
        }
       
    }
   
    //先写一个update、delete、insert
    //sql格式：update 表名 set 字段名 =？where 字段=？
    //parameter神应该是（”abc“,23）
    public static void executeUpdate(String sql,String[] parameters)
    {
        try
        {
            ct=getConnection();
            ps = ct.prepareStatement(sql);
            if(parameters!=null)
            {
                for(int i=0;i<parameters.length;i++)
                {
                    ps.setString(i+1,parameters[i]);
                }
                           
            }
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();//开发阶段
            //抛出异常
            //可以处理，也可以不处理
            throw new RuntimeException(e.getMessage());
        }
        finally
        {
            close(rs,ps,ct);
        }
    }
   
    //关闭资源的函数
    public static void close(ResultSet rs,Statement ps,Connection ct)
    {
        //关闭资源(先开后关)
        if(rs!=null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            rs=null;
        }
        if(ps!=null)
        {
            try
            {
                ps.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ps=null;//使用垃圾回收
        }
        if(null!=ct)
        {
            try
            {
                ct.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ct=null;
        }
    }
}