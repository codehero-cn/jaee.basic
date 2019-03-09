/**
 * 
 */
/**
 * 从一个页面传递数据到另一个页面的方法.
 * 使用注解映射
 * |--Index.java 目录页
 * |--UrlPage.java  通过url来传递数据
 * |--MyData.java MyDataPage.java   使用类静态变量传递数据
 * |--SendRedirectPage.java    sendRdirect()传递数据 
 * |--User.java SessionPage.java   session传递普通数据和对象
 * |--Servlet1.java Servlet2.java  forward()传递数据 

 * 用法：浏览器:http://localhost/transferdata/IndexPage
 * 参考: J2EE视频教程之细说Servlet【韩顺平】第19讲.HttpServletResponse详解②  
 * @author eleven
 * 
 */
package cn.codehero.jaee.basic.transferdata;