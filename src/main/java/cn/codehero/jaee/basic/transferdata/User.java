package cn.codehero.jaee.basic.transferdata;

public class User {
	private String name;
	private String pwd;
	
	void setName(String name){
		this.name = name;
	}
	
	void setPwd(String pwd){
		this.pwd = pwd;
	}

	String getName() {
		return name;
	}

	String getPwd() {
		return pwd;
	}
}
