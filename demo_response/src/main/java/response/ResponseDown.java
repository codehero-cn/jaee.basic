package javaee.basic.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseDown",urlPatterns={"/response/ResponseDown"})
public class ResponseDown extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);
		resp.setContentType("text/html charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//PrintWriter out = resp.getWriter();
		
		//实验:演示下载文件
		//下载提示框:ie中正常,firefox下载时保存中文名乱码
		String temp = java.net.URLEncoder.encode("测试.zip","utf-8");
		resp.setHeader("Content-Disposition", "attachment;filename="+temp);
		//打开文件,注意web站点下载文件的原理.
		//1).获取到要下载文件的全路径
		String path=this.getServletContext().getRealPath("/response/测试.zip");
		System.out.println("path="+path);
		//2).创建文件输入流
		FileInputStream fis=new FileInputStream(path);
		//3).做一个缓冲字节数组
		byte buff[]=new byte[1024];
		int len=0;//表示实际每次读取了多少个字节
		OutputStream os = resp.getOutputStream();
		while((len=fis.read(buff))>0){
			os.write(buff,0,len);
		}
		//4).关闭
		os.close();
		fis.close();	
		//缺点:没有进度条,图标
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

}
