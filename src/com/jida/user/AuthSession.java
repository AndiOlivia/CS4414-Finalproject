package com.jida.user;

import javax.swing.JOptionPane;

import com.jida.user.domObject.User;


public class AuthSession {
	public static String[] loginType={"Client","Client","Client","Client"};
	private User user;
	private User userRemote;
//	private int type;
	private static AuthSession session;
	public static final  int LOGINNORMAL=0;
	public static final  int LOGINALONE=1;
	public static final int SERVER=2;
	public static final int MONITORCENTER=3;
//	public static final  int PROCESSSMAN=1;
	private int objective; //one of the two values above

	static {
		session = new AuthSession();
	}

	private AuthSession() {
		this.user = null;
	}

	public static AuthSession getInstance() {
		return session;
	}

	public void login(User user) {
//		System.out.println("AuthSession:login:"+user);
		if(this.user == null) {
			this.user = user;
		}
		//Delete 20140412
//		else {
//			JOptionPane.showMessageDialog(null,"先注销再登录！");
//			return;
//		}
	}

	public void logout() {
		user = null;
	}

	public boolean isSessionActive() {
		return (user != null);
	}

	public User getUser() {
		//New 20101224　若有远程用户，取远程用户信息 
		return this.userRemote!=null?this.userRemote:this.user;
	}
	public String toString(){
		return "Auth session: "+user;
	}

	public int getObjective() {
		return objective;
	}

	public void setObjective(int objective) {
		this.objective = objective;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserRemote() {
		return userRemote;
	}
	public boolean  isRemote(){
		return this.userRemote!=null;
	}

	public void setUserRemote(User userRemote) {
		this.userRemote = userRemote;
	}
}
