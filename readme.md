##数据库使用说明
保留多个版本的sql文件，因为有的模块使用的是老的数据库sql文件。
要记录下来，等有空时再测试升级到最新版本数据库：

db-mybatis中users.name变成了users.username,要重新调通。
cn.codehero.jaee.basic.db要调通。


##项目介绍:实验javaee基础模块使用，不使用框架，用纯servlet来完成

##配置:
eclipse4.4.2 build使用gradle2.10

##参考：
1.J2EE视频教程之细说Servlet【韩顺平】 http://edu.51cto.com/course/course_id-267.html
2.网络收集

##源码文件夹(含webapp)及包的内容(具体包的详细见package-info文件)
src/main/webapp    webapp文件夹
/test/index.jsp  测试web服务器能否正常工作
/jsp/   用于测试jsp
/script/  放脚本
/script/strapdown/   文件:github下载strapdown-gh-pages\v\0.2\内容  
