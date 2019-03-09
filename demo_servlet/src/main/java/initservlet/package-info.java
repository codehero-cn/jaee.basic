/**
 * initservlet  功能:load-on-startup的使用,获得web项目根目录
 * [/MyInitServlet](/MyInitServlet)    观察web服务器后台的输出  
 * 功能:  
 * 1.实验<load-on-startup>在后台加载,init()函数  
 * 2.通过ServletContext.getRealPath,获得web项目根目录  
 * 3.通过request.getSession().getServletContext.getRealPath("/"),获得web项目根目录  
 */
/**
 * 1.实验<load-on-startup>在后台加载,init()函数  
 * 2.通过ServletContext.getRealPath,获得web项目根目录
 * 3.通过request.getSession().getServletContext.getRealPath("/"),获得web项目根目录
 * MyInitServlet.java  使用注解映射,现注释掉了.
 * 
 * 用法:在后台观察输出
 * 参考: J2EE视频教程之细说Servlet【韩顺平】第13讲.知识回顾.servlet开发细节②.ServletConfig详解
 * @author eleven
 *
 */
package javaee.basic.initservlet;