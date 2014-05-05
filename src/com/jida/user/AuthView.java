package com.jida.user;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jida.MvcProperties;
import com.jida.client.InvalidUserException;
import com.jida.user.domObject.User;
//import com.jida.user.gui.Login;
import com.jida.user.gui.LoginSR4000;

public class AuthView {

	//Start of Variable Declarations
	public static final int MAX_TRIES = 3;
	private AuthModel model;
	private LoginSR4000 loginUI;
	//End of Variable Declarations

	//New 20131110 
	public LoginSR4000 getLoginUI() {
		return loginUI;
	}

	//Start of Listener Declarations
	private transient ActionListener loginOKListener = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {	
			//New 20111108 by Brandi
			model.setDll(loginUI.getLoginMode());
			
			if(model.isAreadyLoggedIn()) {
				loginUI.showMessageBox("User already logged in. Please log out and try again!。", "Login Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			User user = new User();
			user.setName(loginUI.getUser()[0]);
			user.setPassword(loginUI.getUser()[1]);
			user.setType((short)loginUI.getLoginMode());

			try {
				model.login(user);//修改为支持服务器登录
			} catch (InvalidUserException iue) {
				loginUI.setRepeat();
				model.logout();
				//New 20110515
				return;
				//End 20110515
			} catch (Exception e) {
				loginUI.setRepeat();
				model.logout();
				e.printStackTrace();
				return;
			}
			System.out.println("authview:login:"+model.isAreadyLoggedIn());
			if (model.isAreadyLoggedIn()) {
//				loginUI.dispose();
//				loginUI=null;
//				JSplashScreen jss = new JSplashScreen(JSplashScreen.SPLASH_MODE);
				loginUI.changePanel();
			}
			else {
				return;
			}
		}
	};

	private transient ActionListener loginCancelListener = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if (JOptionPane.showOptionDialog(loginUI, "Are you sure to exit?", "Exit?",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, null, null) == 0) {
				System.exit(0);
			}
			else {
				return;
			}
		}
	};

	private transient ActionListener[] loginListeners = new ActionListener[] {
			this.loginOKListener, this.loginCancelListener
	};

	//End of Listener Declarations

//	public AuthView(AuthModel model) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
//		this.model = model;
//		this.model.addViewListener(this);
//		this.loginUI = new LoginSR4000(0);
//		this.loginUI.register(this.loginListeners);
//		this.loginUI.setVisible(true);
//		//软件锁定时检测
////		startLiveTask();
//	}
	/**
	 * 20130201
	 * @param model
	 * @param mode 0："网络工作站",1："单机工作站",2："服务器",3："监控中心"
	 */
	public AuthView(AuthModel model,int mode) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.model = model;
		this.model.addViewListener(this);
		this.loginUI = new LoginSR4000(mode);
		this.loginUI.register(this.loginListeners);
		this.loginUI.setVisible(true);
		//软件锁定时检测
//		startLiveTask();
	}
	public void showMessageBox(String message, String title, int messageType) {
		loginUI.showMessageBox(message, title, messageType);
	}

	public static void main(String[] args) {
		AuthModel model = AuthModel.getInstance();
		new AuthView(model,0);
	}
	//New20111107
//	public void startLiveTask(){
//	Timer timer=new Timer();
//	timer.schedule(new TimerT8sk(){
//	public void run(){
//	if(!model.isValidSoft()){
//	JOptionPane.showMessageDialog(loginUI, "检测到软件锁设备移除,无法使用本软件,确认后将退出本系统", "提示", JOptionPane.ERROR_MESSAGE);
//	System.exit(1);
//	return;
//	}
//	}
//	}, new Date(), 30000);
//	}

}
