package cn.codehero.jaee.basic.thread;

public class SendEmailThread extends Thread{

	@Override
	public void run() {
		int i = 0; 
		try {
			while(true){
			//每休眠一分钟,就去扫表sendmail,看看哪份信件应当被发出
			Thread.sleep(10*1000);
			System.out.println("发出第"+ (++i) +"封邮件");//javamail
			}
		}catch (Exception e ){
			e.printStackTrace();
		}
	}
}
