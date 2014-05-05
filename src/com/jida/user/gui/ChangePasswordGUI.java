package com.jida.user.gui;

import java.awt.Color;


import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.client.Client;
import com.jida.client.InvalidUserException;
import com.jida.client.Main;
import com.jida.gui.JFrameGuiSuper;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.ModelUserNetImpl;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

/**
 * <p>Title: Direct Sale Management System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Jida</p>
 * @author Yang Ying
 * @version 2.0
 */

public class ChangePasswordGUI extends JDialog {
	Logger logger=Logger.getLogger(ChangePasswordGUI.class);
	private static final long serialVersionUID = 1L;
		private JLabel jLabel1 = new JLabel();
		private JPasswordField passwordOld = new JPasswordField();
		private JLabel jLabel2 = new JLabel();
		private JButton OKBButton = new JButton();
		private JButton cancelButton = new JButton();
		private JPanel jPanel1 = new JPanel();
		private JPanel jPanel2 = new JPanel();
		private JLabel jLabel3 = new JLabel();
		private JLabel jLabelOld = new JLabel("原密码");
		
		private JPasswordField passwordNew = new JPasswordField();
		private JPasswordField passwordConfirm = new JPasswordField();
		private Toolkit tk = this.getToolkit();
		private Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

		public ChangePasswordGUI() throws HeadlessException {
			try {
				jbInit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.register(this.loginListeners);
		}

		public static void main(String[] args) throws HeadlessException {
			new ChangePasswordGUI().setVisible(true);
			
		}

		private void jbInit() throws Exception {
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelOld.setBounds(new Rectangle(269, 80, 50, 34));  
			jLabel1.setText("New Password");
			jLabel1.setBounds(new Rectangle(269, 128, 50, 34));
			this.getContentPane().setLayout(null);
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel2.setText("OK");
			jLabel2.setBounds(new Rectangle(269, 171, 50, 34));
			OKBButton.setBackground(new Color(144, 138, 79));
			OKBButton.setBounds(new Rectangle(230, 261, 107, 30));
			OKBButton.setEnabled(true);
			OKBButton.setForeground(Color.black);
			OKBButton.setDebugGraphicsOptions(0);
			OKBButton.setDoubleBuffered(false);
			OKBButton.setBorderPainted(true);
			OKBButton.setContentAreaFilled(true);
			OKBButton.setText("OK");
			cancelButton.setBackground(new Color(144, 138, 72));
			cancelButton.setBounds(new Rectangle(365, 262, 115, 29));
			cancelButton.setText("Cancel");

			this.setContentPane(jPanel1);
			this.setResizable(false);
			this.setTitle("更改密码");
			jPanel1.setBackground(new Color(184, 203, 158));
			jPanel1.setForeground(Color.blue);
			jPanel1.setBounds(new Rectangle(-1, 0, 505, 352));
			jPanel1.setLayout(null);
			jPanel2.setBackground(new Color(144, 184, 118));
			jPanel2.setBounds(new Rectangle(1, 0, 206, 352));
			jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
			jLabel3.setForeground(new Color(118, 131, 46));
			jLabel3.setText("输入原密码和新密码");
			jLabel3.setBounds(new Rectangle(227, 24, 249, 26));
			
			passwordOld.setBorder(this.bevelBorder);
			passwordOld.setText("");
			passwordOld.setBounds(new Rectangle(322, 82, 125, 25));
			
			passwordNew.setBorder(this.bevelBorder);
			passwordNew.setText("");
			passwordNew.setBounds(new Rectangle(322, 132, 128, 25));
			
			passwordConfirm.setBorder(this.bevelBorder);
			passwordConfirm.setText("");
			passwordConfirm.setBounds(new Rectangle(322, 176, 128, 25));
			
			jPanel1.add(OKBButton, null);
			jPanel1.add(cancelButton, null);
			jPanel1.add(jPanel2, null);
			jPanel1.add(jLabel3, null);
			jPanel1.add(jLabelOld, null);
			
			jPanel1.add(passwordNew, null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(passwordOld, null);
			jPanel1.add(passwordNew, null);
			jPanel1.add(passwordConfirm, null);
			
			
			jPanel1.add(jLabel2, null);
			this.setSize(500, 340);
			int screenWidth = this.tk.getScreenSize().width;
			int screenHeight = this.tk.getScreenSize().height;
			int loginWidth = this.getSize().width;
			int loginHeight = this.getSize().height;
			int positionX = (screenWidth - loginWidth) / 2;
			int positionY = (screenHeight - loginHeight) / 2;
			this.setLocation(positionX, positionY);
			this.getRootPane().setDefaultButton(this.OKBButton);
			this.setVisible(true);
		}

		public void register(ActionListener al[]) {
			OKBButton.addActionListener(al[0]);
			cancelButton.addActionListener(al[1]);
		}

//		public String[] getUser() {
//			String[] s = new String[2];
//			s[0] = this.user.getText();
//			s[1] = String.copyValueOf(this.password.getPassword());
//			return s;
//		}

		public void setRepeat() {
			this.jLabel3.setText("Error user name or password,Try again please!");
		}
		public void setRepeat(String prompt) {
			this.jLabel3.setText(prompt);
		}

		public void showMessageBox(String message, String title, int messageType) {
			JOptionPane.showMessageDialog(this, message, title, messageType);
		}
		public String getPasswordOld(){
			return this.passwordOld.getText();
		}
		public String getPasswordNew(){
			return this.passwordNew.getText();
		}
		public String getPasswordConfirm(){
			return this.passwordConfirm.getText();
		}

//		public void setLoginName(String name) {
//			this.user.setText(name);
//		}

//		public void setPassword(String pwd) {
//			this.password.setText(pwd);
//		}
		private transient ActionListener loginOKListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AuthModel model=AuthModel.getInstance();
				if(!model.isAreadyLoggedIn()) {
					ChangePasswordGUI.this.showMessageBox("请用其它用户登录", "匿名用户不能更改密码", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
//				User user=new User();
//				user.setName(model.getUser().getName());
				User user=AuthModel.getInstance().getUser();
				
				if(!user.getPassword().equals(getPasswordOld())){
					JOptionPane.showMessageDialog(null, "原密码不正确");
					return;
				}
				
//				user.setPassword(getPasswordOld());
				String newP=passwordNew.getText();
				String newPC=passwordConfirm.getText();
				if(!newP.equals(newPC)){
					ChangePasswordGUI.this.setRepeat("新密码不一致");
					return;
				}
				
				//New 20110205 从中心更改密码，
//				ModelUser modelUser=new ModelUserDBImpl();
//				try {
//					modelUser.changePassword(user, getPasswordNew());
//				} catch (Exception iue) {
//					ChangePasswordGUI.this.setRepeat(iue.toString());
//					return;
//				}
				if(model.getUser().getType()==AuthSession.SERVER || model.getUser().getType()==AuthSession.LOGINALONE){
					ModelUser modelUser=ModelUserNetImpl.getInstance();
					try {
						modelUser.changePassword(user, newP);
						AuthModel.getInstance().getUser().setPassword(newP);
					
						System.out.println("ChangePasswordGUI.loginOKListener:"+AuthModel.getInstance().getUser());
						ChangePasswordGUI.this.setVisible(false);
						ChangePasswordGUI.this.dispose();
						JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "Succeeding to change password！");
					
					} catch (Exception iue) {
						logger.error("CommandChangePassword",iue);
						ChangePasswordGUI.this.setVisible(false);
						ChangePasswordGUI.this.dispose();
						JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "Fail to change password:"+iue);
						
					
					}
					return;
				}
				
				ChangePasswordGUI.this.setVisible(false);
				ChangePasswordGUI.this.dispose();
//				JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "密码更改"+(ccp!=null?"成功":"失败"));
				
			}
		};

		private transient ActionListener loginCancelListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				if (JOptionPane.showOptionDialog(ChangePasswordGUI.this, "确定要退出吗？", "确定？",
//						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
//						null, null, null) == 0) {
//					ChangePasswordGUI.this.dispose();
//				}
//				else {
//					return;
//				}
				ChangePasswordGUI.this.setModal(false);
				ChangePasswordGUI.this.setVisible(false);
				ChangePasswordGUI.this.dispose();
			}
		};

		private transient ActionListener[] loginListeners = new ActionListener[] {
				this.loginOKListener, this.loginCancelListener
		};

	}
