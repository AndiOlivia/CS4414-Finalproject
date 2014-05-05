package com.jida.user;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.jida.client.InvalidUserException;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.domObject.User;
//import com.jida.user.gui.Login;
import com.jida.user.gui.LoginSR4000;
import com.jida.user.intf.ModelUser;


public class UserLoginViewImpl {
	Logger logger=Logger.getLogger(UserLoginViewImpl.class);


	//Start of Variable Declarations
	public static final int MAX_TRIES = 3;
//	private ModelUserDBImpl model;
	private AuthModel authModel;
	private ModelUser modelUser;
	private LoginSR4000 loginUI;
	
	public UserLoginViewImpl(AuthModel authModel) {
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
		this.authModel = authModel;
		this.modelUser=ModelUserDBImpl.getInstance();
//		this.model.addViewListener(this);
		this.loginUI = new LoginSR4000(0);
		this.loginUI.register(this.loginListeners);
		this.loginUI.setVisible(true);
	}

	//End of Variable Declarations

	//Start of Listener Declarations
	private transient ActionListener loginOKListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent ae) {
			User user = new User();
			user.setName(loginUI.getUser()[0]);
			user.setPassword(loginUI.getUser()[1]);

			try {
//				if (!model.check(user)) {
//					loginUI.setRepeat();
//					return;
//				} 
				authModel.login(user);
				if(!AuthModel.isValidOperation("super")){
//					loginUI.setRepeat("对不起,您输入的用户无使用权限");
					authModel.logout();
					return;
				}
				 ModelUser model=ModelUserDBImpl.getInstance();
				 ViewUser view=new ViewUserImpl(model);
//				 ControllerUser con=new ControllerUser
				
			}catch (InvalidUserException e) {
				loginUI.setRepeat();
				return;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			loginUI.dispose();
		}

	};

	private transient ActionListener loginCancelListener = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if (JOptionPane.showOptionDialog(loginUI, "确定要退出吗？", "确定？",
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

	

	public void showMessageBox(String message, String title, int messageType) {
		loginUI.showMessageBox(message, title, messageType);
	}

//	public static void main(String[] args) {
//		ModelUser model = new ModelUserDBImpl();
//		new UserLoginViewImpl(model);
//	}





}
