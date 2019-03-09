##项目介绍:
javaee基础模块使用，不使用框架，用纯servlet来完成

## 技术列表
javaee gradle多项目管理

##项目结构
|--demo_webserver  测试javaweb server /test/用于测试jsp是否能正常运行 
|--demo_mywebserver 1.一个简单的web服务器山寨版 2.run as java application
|--tool-swagger 使用swagger来显示接口，对所有的项目进行测试。


###cn.codehero.jaee.basic.servlet
[/servlet/MyFirstServlet](/servlet/MyFirstServlet):1.实现接口servlet的方式,开发一个Servlet  
配置:web.xml

###cn.codehero.jaee.basic.genericservlet  功能:实现GenericServlet的方式，开发一个Servlet
[/genericservlet/MyGenericServlet](/genericservlet/MyGenericServlet)

###cn.codehero.jaee.basic.httpservlet
[/httpservlet/myhttpservlet.html](/httpservlet/myhttpservlet.html)   显示页面myhttpservlet.html 点“测试”后进行post提交  
webapp/httpservlet/myhttpservlet.html  
   
[/httpservlet/MyHttpServlet](/httpservlet/MyHttpServlet)  get提交  
功能:servlet继承Httpservlet,实现HttpServlet的方法,开发一个Servlet,显示helloword和当前日期.测试Servlet单例.  

src/main/webapp    webapp文件夹
/test/index.jsp  测试web服务器能否正常工作
/jsp/   用于测试jsp
/script/  放脚本

##db使用说明
每个项目都可以独立运行操作。
  
##refence：
1.J2EE视频教程之细说Servlet【韩顺平】 http://edu.51cto.com/course/course_id-267.html
2.网络收集

## todo 
demo_db要调通。

