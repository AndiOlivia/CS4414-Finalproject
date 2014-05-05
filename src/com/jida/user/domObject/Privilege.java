package com.jida.user.domObject;

public class Privilege implements java.io.Serializable{
	private String priName;
	private String priDesc;
	public static String titles[]={"Privilege","Desc"};
	public boolean equals(Object obj){
		if(obj instanceof Privilege){
			return priName.equals(((Privilege)obj).priName);
		}
		return false;
	}

	public String getPriName() {
		return priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public String getPriDesc() {
		return priDesc;
	}

	public void setPriDesc(String priDesc) {
		this.priDesc = priDesc;
	}
	public String toString(){
		return this.priName+":"+this.priDesc;
	}
}
