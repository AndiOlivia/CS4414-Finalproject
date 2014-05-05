package com.jida.user.gui;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.client.Main;
//import com.jida.client.Main;
import com.jida.gui.JFrameGuiSuper;
import com.jida.server.MainServer;
import com.jida.user.AuthSession;
import com.jida.user.domObject.User;


/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * <p>Title: Direct Sale Management System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Jida</p>
 * <p>Modified by: Jianjie Zhou
 * @author Yang Ying
 * @version 2.0
 */

public class LoginSR4000 extends JFrame {
	Logger logger=Logger.getLogger(LoginSR4000.class);

	{
//		//Set Look & Feel
//		try {
//		javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//		} catch(Exception e) {
//		e.printStackTrace();
//		}
	}

	Image img = Toolkit.getDefaultToolkit().createImage(MvcProperties.imagePath);
	BufferedImage bImg;
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1 = new JLabel();
	private JTextField user = new JTextField();
	private JLabel jLabel2 = new JLabel();
	private JButton OKBButton = new JButton();
	private JButton cancelButton = new JButton();
	private JPanel jPanel1; //= new JPanel();
//	private JPanel jPanel2 ;
	private JLabel jLabel3 = new JLabel();
	private JPasswordField password = new JPasswordField();
	private Toolkit tk = this.getToolkit();
	private Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	private int mode;

	public LoginSR4000(Image img, BufferedImage img2, JLabel label1, JTextField user,
			JLabel label2, JButton button, JButton cancelButton, JPanel panel1,
			JLabel label3, JPasswordField password, Toolkit tk,
			Border bevelBorder) throws HeadlessException {
		super();
		this.img = img;
		bImg = img2;
		jLabel1 = label1;
		this.user = user;
		jLabel2 = label2;
		OKBButton = button;
		this.cancelButton = cancelButton;
		jPanel1 = panel1;
		jLabel3 = label3;
		this.password = password;
		this.tk = tk;
		this.bevelBorder = bevelBorder;
	}

	public LoginSR4000(int mode) throws HeadlessException {
		this.mode=mode;
//		System.out.println(new Date());
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws HeadlessException {
		new LoginSR4000(2).setVisible(true);
	}

	private void jbInit() throws Exception {
		this.setSize(480, 250);
		this.setResizable(false);
//		System.out.println(this.getWidth());

//		bImg=new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_BYTE_INDEXED);
//		Graphics gImg=bImg.getGraphics();
//		gImg.drawImage(img, 0, 0, this.getWidth(),	this.getHeight(), this);


		jPanel1= new JPanel(){
			protected  void paintChildren(Graphics g) {
				//super.painChildren(g);
//				System.out.println("---"+new Date());
				while(!g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this));
				super.paintChildren(g);
//				System.out.println(new Date()+"---");
			}
		};
		this.getContentPane().add(jPanel1);
//		this.setContentPane(jPanel1);
		jPanel1.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Username");
		jLabel1.setBounds(287, 70, 49, 35);

		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("Password");
		jLabel2.setBounds(287, 105, 49, 35);
		user.setBorder(this.bevelBorder);
		user.setText("");
		user.setBounds(343, 77, 112, 21);
//		OKBButton.setBackground(new java.awt.Color(0,0,0));
		OKBButton.setBounds(294, 189, 70, 21);
		OKBButton.setForeground(Color.white);
		OKBButton.setDebugGraphicsOptions(0);
		OKBButton.setDoubleBuffered(false);
		OKBButton.setOpaque(false);//setBorderPainted(true);
		OKBButton.setContentAreaFilled(false);
		OKBButton.setText("OK");
		OKBButton.setBorder(BorderFactory.createLineBorder(Color.white));
		
//		cancelButton.setBackground(new java.awt.Color(0,0,0));
		cancelButton.setBounds(378, 189, 70, 21);
		cancelButton.setText("Cancel");
		cancelButton.setOpaque(false);
		cancelButton.setForeground(Color.white);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setBorder(BorderFactory.createLineBorder(Color.white));
		
		
//		jPanel2.setBounds(new Rectangle(1, 0, 206, 352));
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel3.setForeground(new java.awt.Color(255,255,255));
		jLabel3.setText("Input user and password:");
		jLabel3.setBounds(224, 35, 238, 28);
		password.setBorder(this.bevelBorder);
		password.setText("");
		password.setBounds(343, 112, 112, 21);
		jPanel1.add(OKBButton, null);
		OKBButton.setOpaque(false);
		OKBButton.setBorder(BorderFactory.createTitledBorder(""));
		jPanel1.add(cancelButton, null);
		cancelButton.setForeground(new java.awt.Color(255,255,255));
		cancelButton.setBorder(BorderFactory.createTitledBorder(""));

//		jPanel1.add(jPanel2, null);
//		jPanel2.setBackground(new java.awt.Color(0,128,192));
		jPanel1.add(jLabel3, null);
		jPanel1.add(password, null);
		password.setForeground(new java.awt.Color(255,255,255));
		password.setBackground(new java.awt.Color(0,0,0));
		password.setCaretColor(new java.awt.Color(255,255,255));
		jPanel1.add(jLabel1, null);
		jLabel1.setForeground(new java.awt.Color(255,255,255));
		jPanel1.add(user, null);
		user.setForeground(new java.awt.Color(255,255,255));
		user.setBackground(new java.awt.Color(0,0,0));
		user.setCaretColor(new java.awt.Color(255,255,255));
		jPanel1.add(jLabel2, null);
		jLabel2.setForeground(new java.awt.Color(255,255,255));
		{
			jLabel4 = new JLabel();
			jPanel1.add(jLabel4);
			jLabel4.setText("Login mode");
			jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel4.setForeground(new java.awt.Color(255,255,255));
			jLabel4.setBounds(250, 140, 80, 35);
//			jLabel4.setFont(new java.awt.Font("Tahoma",0,10));
		}
		{
			JLabel jLabel=new JLabel(AuthSession.loginType[mode]);
			
//			ComboBoxModel jComboBoxModeModel = new DefaultComboBoxModel(
//				AuthSession.loginType);
//			jComboBoxMode = new JComboBox();
			jPanel1.add(jLabel);
//			jComboBoxMode.setModel(jComboBoxModeModel);
			jLabel.setBounds(343, 147, 112, 21);
			jLabel.setForeground(new java.awt.Color(255,255,255));
			jLabel.setBackground(new java.awt.Color(0,0,0));
//			jLabel.setCaretColor(new java.awt.Color(255,255,255));
			
//			jComboBoxMode.setOpaque(false);
		}

		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.getRootPane().setDefaultButton(this.OKBButton);

		this.jPanel1.paintImmediately(0,0,this.jPanel1.getWidth(),this.jPanel1.getHeight());
		this.setVisible(true); 

	}
//	Image bufferImage;
	public void register(ActionListener al[]) {
		OKBButton.addActionListener(al[0]);
		cancelButton.addActionListener(al[1]);
	}

	public String[] getUser() {
		String[] s = new String[2];
		s[0] = this.user.getText();
		s[1] = String.copyValueOf(this.password.getPassword());
		return s;
	}

	public void setRepeat() {
		User user;
		if((user=AuthSession.getInstance().getUser())!=null && user.getResult()!=null ){
			this.jLabel3.setText(user.getResult());
		}
		else
			this.jLabel3.setText("Error user name or password,try again.");
	}
	public void setRepeat1(String s) {
		this.jLabel3.setText(s);
	}
	public void showMessageBox(String message, String title, int messageType) {
		JOptionPane.showMessageDialog(this, message, title, messageType);
	}

	public void setLoginName(String name) {
		this.user.setText(name);
	}

	public void setPassword(String pwd) {
		this.password.setText(pwd);
	}
	public void changePanel(){
		System.out.println("LoginSR4000:changePanel");
		this.getContentPane().remove(jPanel1);
		this.getContentPane().validate();
		jPanel1.setVisible(false);

		this.getContentPane().add(jPanelSplash);
		
		this.getContentPane().validate();
		this.setSize(width,height);
		this.setVisible(true);
		jPanelSplash.paintImmediately(0,0,width,height);
		
//		{
//			Graphics g=this.jPanelSplash.getGraphics();
//			jPanelSplash.paint(g);
//		}
//		while(!jPanelSplash.isVisible()){
//			jPanelSplash.setVisible(true);
//			System.out.println("show panelSplash");
//		}
		
		int w=width;
		
		jProgressBar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
		jProgressBar.setForeground(new Color(0,255,0));
//		jProgressBar.setValue(20);

		jFrame=new JDialog(LoginSR4000.this);
		jFrame.getContentPane().add(jProgressBar);
		jFrame.setBounds(LoginSR4000.this.getX(),LoginSR4000.this.getY()+height , w, hProgressBar);
		jFrame.setAlwaysOnTop(true);//????????????
		jFrame.setUndecorated(true);
//		jFrame.setModal(true);
		jFrame.setVisible(true);
		jProgressBar.paintImmediately(0,0,width,hProgressBar);
//		jFrame.setModal(false);
		
//		System.out.println("show progress bar");
		while(!jProgressBar.isVisible() || !jFrame.isVisible()){
//			if(jProgressBar!=null)
				jProgressBar.paintImmediately(0,0,width,hProgressBar);
//			System.out.println("show progress bar");
		}
//		System.out.println("end show progress bar");
		
		
		strDisplay="Loading...";
		logger.info(strDisplay);

//		this.setVisible(true);
		logger.info("progressThread start");

		progressThread.start();
		
//		System.out.println("main init app...");
		switch(AuthSession.getInstance().getUser().getType()){
		case 0:
		default:
			Main.initApplication();
			break;
		case 2:
//			MainServer.initApplication();
//			MainRemote.initApplication();
//			break;
		case 3:
//			MainCenter.initApplication();
//			break;
		}
	}

	
	private int width=550;
	private int height=330;
	private int hProgressBar=15;
	private Image image =  Toolkit.getDefaultToolkit().createImage(MvcProperties.imageSplash);
	private JProgressBar jProgressBar;
	private JLabel jLabel4;
//	private JComboBox jComboBoxMode;
	private JDialog jFrame;
	public static String strDisplay="";
	public static int progressValue;
	public JPanel jPanelSplash=new JPanel(){
		public void paint(Graphics g) {
//			System.out.println("paint...");
//			super.paint(g);
			while(!g.drawImage(image,0,0,width,height,null));

			this.setForeground(Color.white);
			Font font=g.getFont();
			g.setFont(new Font(font.getFontName(),Font.PLAIN,12));
			g.drawString(strDisplay, 50, height+this.getY()-30);
		}
	};

	transient Thread progressThread=new Thread(){
		public void run(){
//			try{
//			Thread.sleep(1000);
//			}
//			catch(Exception e){
//
//			}	
		
			int v=0,m=0;
			progressValue=0;
			while(progressValue<(m=jProgressBar.getMaximum())){
				try{
					Thread.sleep(200);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				if(progressValue<m-5)
					progressValue+=5;
				jProgressBar.setValue(progressValue);
				
				jProgressBar.paintImmediately(0,0,width,hProgressBar);
			}
			jFrame.setVisible(false);
			jFrame.dispose();
			LoginSR4000.this.setVisible(false);
			LoginSR4000.this.dispose();
			//Update 20130907
			if(JFrameGuiSuper.gui!=null){
				JFrameGuiSuper.gui.setVisible(true);
				JFrameGuiSuper.gui.initPanel();
			}
		}
	};
	public int getLoginMode(){
//		return this.jComboBoxMode.getSelectedIndex();
		return mode;
	}

}