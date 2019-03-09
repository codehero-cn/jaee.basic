package cn.codehero.jaee.basic.fsl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloFilter implements Filter {
	private Long seconds;
	
	public HelloFilter(){
		System.out.println("++++++Filter()构造函数++++++");
	}
	
	@Override
	//在filter被加载到service中的时候被container调用，Servlet container
	//实例化完filter以后立即调用Filter的init方法，init方法中的工作必须在执行过滤过滤任务之前正确的完成。
	public void init(FilterConfig config) throws ServletException{
		System.out.println("++++++Filter初始化++++++");
		this.seconds = Long.parseLong(config.getInitParameter("seconds"));
		TimerFilter.initTimer(seconds);
	}
	
	@Override
	public void doFilter(ServletRequest request,ServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		System.out.println("++++++doFilter()++++++");
		
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("拦截URI="+req.getRequestURI());
		
		//Filter处理后，将请求放行到目的地址
		chain.doFilter(request,response);
	}
	
	@Override
	//当filter从service中移除的时候，container调用destroy方法，通过调用这个方法，释放Filter所占有的系统资源。
	public void destroy(){
		this.seconds = null;
		System.out.println("Filter 结束");
	}
	
}
