##项目介绍:
javaee基础模块使用，不使用框架，用纯servlet来完成

## 技术列表
javaee gradle多项目管理

##项目结构
### demo_webserver  测试javaweb server /test/用于测试jsp是否能正常运行 
### demo_mywebserver 1.一个简单的web服务器山寨版 2.run as java application
### demo_servlet_xml 使用xml配置servlet
###子项目cn.codehero.jaee.basic.fsl  功能:1.Filter,Listener,Servlet启动的先后顺序2.通过web.xml给servlet赋值
配置:/META-INF/web-fragment.xml  子项目打成jar包，被主项目依赖    

###cn.codehero.jaee.basic.servlet
[/servlet/MyFirstServlet](/servlet/MyFirstServlet):1.实现接口servlet的方式,开发一个Servlet  
配置:web.xml
cn.codehero.jaee.basic.servletconfig  功能:servletconfig的使用,获取web.xml中设置的参数  
[/ServletConfigTest](/ServletConfigTest)   
Webapp:/WEB-INF/web.xml  


###cn.codehero.jaee.basic.request request用法  
[/request/index.html](/request/index.html)   
[/request/login.jsp](/request/login.jsp)     
webapp:/request/index.html  
webapp:/request/login.jsp  
1.功能:request对象用法,如防盗链等用法   2.功能:登录举例  


###cn.codehero.jaee.basic.genericservlet  功能:实现GenericServlet的方式，开发一个Servlet
[/genericservlet/MyGenericServlet](/genericservlet/MyGenericServlet)

###cn.codehero.jaee.basic.httpservlet
[/httpservlet/myhttpservlet.html](/httpservlet/myhttpservlet.html)   显示页面myhttpservlet.html 点“测试”后进行post提交  
webapp/httpservlet/myhttpservlet.html  
   
[/httpservlet/MyHttpServlet](/httpservlet/MyHttpServlet)  get提交  
功能:servlet继承Httpservlet,实现HttpServlet的方法,开发一个Servlet,显示helloword和当前日期.测试Servlet单例.  
###cn.codehero.jaee.basic.response response用法1.演示回送内容2.演示下载文件  
[/response/测试.zip](/response/测试.zip)  
webapp:/response/测试.zip   
webapp:/imgs/1.jpg  2.jpg  

###cn.codehero.jaee.basic.transferdata 页面之间传递数据用法  
[/transferdata/Index](/transferdata/Index)  用于测试的目录页    

###cn.codehero.jaee.basic.encoding  字符编码专题  
[/encoding/myform.html](/encoding/myform.html)    
webapp:/encoding/myform.html  

###cn.codehero.jaee.basic.db 数据库实验,简单的用户管理系统  
[/MainFrame](/MainFrame)  
包下/db/jaeebasicdb.sql  生成数据库
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

