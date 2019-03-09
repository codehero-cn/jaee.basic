package cn.codehero.jaee.basic.fsl;

import java.util.TimerTask;

class TimerServlet extends TimerTask {
	private static int i = 0;
	
	@Override
	public void run(){
		System.out.println("Servlet refreshed:"+ ++i + "times");
	}

}
