package cn.codehero.jaee.basic.fsl;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerFilter {
	private static int i = 0;
	
	public static void initTimer(Long seconds){
		TimerFilter.schedule(new TimerTask(){
			public void run(){
				callUsers();
			}
		},0,seconds*1000);
	}
	
	public static void callUsers(){
		System.out.println("Filter refreshed:"+ ++i + "times.");
	}
	
	public static void schedule(TimerTask task ,long delay, long period){
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(task, delay, period, TimeUnit.MILLISECONDS);
	}
}
