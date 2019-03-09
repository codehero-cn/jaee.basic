package javaee.basic.fsl;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {
	public HelloListener(){
		System.out.println("------Listener()构造函数------");
	}
		
	public void contextInitialized(ServletContextEvent arg0){
		System.out.println("------Listener contextInitialized()初始化------");
		Timer timer = new Timer();
		timer.schedule(new TimerListener(),0,4000L);
	}
	
	public void contextDestroyed(ServletContextEvent arg0){
		System.out.println("------Listener contextDestroyed()------");		
	}
	

}
