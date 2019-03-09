package javaee.basic.fsl;

import java.util.TimerTask;

class TimerListener extends TimerTask{
	private static int i = 0;
	
	@Override
	public void run(){
		System.out.println("Listener refreshed:"+ ++i +"times");
	}

}
