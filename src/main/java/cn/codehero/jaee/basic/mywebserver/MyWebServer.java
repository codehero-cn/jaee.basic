package cn.codehero.jaee.basic.mywebserver;

import java.io.*;
import java.net.*;

/**
 * 访问网址:http://localhost:端口号/
 * @author eleven
 */
public class MyWebServer{

	public static void main(String[] args) throws Exception{
		
		//设置端口号
		int port = 9999;
		ServerSocket ss =  new ServerSocket(port);
		System.out.println(ss);
		while(true){
			Socket s = ss.accept();
			//提示一句话
			System.out.println("在"+port+"上等待连接...");
			OutputStream os = s.getOutputStream();
			
			//定位网页的位置,没调试出来
			//File filepath = new File((new MyWebServer()).getClass().getResource("").getPath());
			//String filepathtemp = filepath.toString()+"\\helloworld.html";
			//System.out.println(filepathtemp);
			
			BufferedReader br = new BufferedReader(new FileReader("F:/dropbox/pro_base/cn.codehero.jaee.basic/src/main/java/cn/codehero/jaee/basic/mywebserver/helloworld.html"));
			
			String buf = "";
			while( (buf=br.readLine())!=  null){
				os.write(buf.getBytes());
			}
		//关闭流
		br.close();
		os.close();
		s.close();
		ss.close();
		}
	}
}