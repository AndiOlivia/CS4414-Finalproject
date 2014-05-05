package com.jida.gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jy.print.JidaProperties;


public class DBConfigDialog extends JDialog {
	JLabel jLabel1 = new JLabel();
	  JTextField user = new JTextField();
	  JLabel jLabel2 = new JLabel();
	  JButton OKBButton = new JButton();
	  JButton cancelButton = new JButton();
	  JPanel jPanel1 = new JPanel();
	  JPanel jPanel2 = new JPanel();
	  JLabel jLabel3 = new JLabel();
	  JPasswordField password = new JPasswordField();

	  public DBConfigDialog() throws HeadlessException {
	    try {
	      jbInit();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	    
	    this.setLocation(((int)((float)1024-this.getWidth())/2),(int)((768-this.getHeight())/2));
	      this.setVisible(true);
	  }
	  public static void main(String[] args) throws HeadlessException {
		  new DBConfigDialog();
	  }
	  private void jbInit() throws Exception {
	    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel1.setText("用  户");
	    jLabel1.setBounds(new Rectangle(269, 128, 50, 34));
	    this.getContentPane().setLayout(null);
	    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel2.setText("口  令");
	    jLabel2.setBounds(new Rectangle(277, 181, 34, 16));
	    user.setText("");
	    user.setBounds(new Rectangle(322, 132, 125, 25));
	    OKBButton.setBackground(new Color(144, 138, 79));
	    OKBButton.setBounds(new Rectangle(230, 261, 107, 30));
	    OKBButton.setEnabled(true);
	    OKBButton.setForeground(Color.black);
	    OKBButton.setDebugGraphicsOptions(0);
	    OKBButton.setDoubleBuffered(false);
	    OKBButton.setBorderPainted(true);
	    OKBButton.setContentAreaFilled(true);
	    OKBButton.setText("确定");
	    cancelButton.setBackground(new Color(144, 138, 72));
	    cancelButton.setBounds(new Rectangle(365, 262, 115, 29));
	    cancelButton.setText("取消");

	    this.setContentPane(jPanel1);
	    this.setResizable(false);
	    this.setTitle("DB设置");
	    jPanel1.setBackground(new Color(184, 203, 158));
	    jPanel1.setForeground(Color.blue);
	    jPanel1.setBounds(new Rectangle(-1, 0, 505, 352));
	    jPanel1.setLayout(null);
	    jPanel2.setBackground(new Color(144, 184, 118));
	    jPanel2.setBounds(new Rectangle(1, 0, 206, 352));
	    jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
	    jLabel3.setForeground(new Color(118, 131, 46));
	    jLabel3.setText("请输入用户和口令");
	    jLabel3.setBounds(new Rectangle(227, 24, 249, 26));
	    password.setText("");
	    password.setBounds(new Rectangle(324, 176, 94, 26));
	    jPanel1.add(OKBButton, null);
	    jPanel1.add(cancelButton, null);
	    //this.getContentPane().add(jPanel1, null);
	    jPanel1.add(jPanel2, null);
	    jPanel1.add(jLabel3, null);
	    jPanel1.add(password, null);
	    jPanel1.add(jLabel1, null);
	    jPanel1.add(user, null);
	    jPanel1.add(jLabel2, null);
	    this.setSize(500,340) ;
	    this.register(loginl);
	    
	    this.user.setText(JidaProperties.m_user);
	    this.password.setText(JidaProperties.m_password);
	    
	  }
	  public void register(ActionListener al[]){
	    OKBButton.addActionListener(al[0]) ;
	    cancelButton.addActionListener(al[1]) ;
	  }
	  public String []getUser(){
	    String [] s=new String[2];
	    s[0]=this.user .getText() ;
	    s[1]=this.password .getText();
//	    s[1]=this.password.getPassword().toString();
	    return s;
	  }
	  public void setRepeat(){
	    this.jLabel3 .setText("用户名或口令错误,请再试一下") ;
	  }
	  private void end(){
		  this.setVisible(false);
		  this.dispose();
	  }
	  transient ActionListener okl=new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	JidaProperties.m_user=user.getText();
		    	JidaProperties.m_password=password.getText();
//		    	System.out.println(JidaProperties.m_user+"-"+JidaProperties.m_password);
		    	end();
		    	
		    }
		  };
		  transient ActionListener cancell=new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		      end();
		    }
		  };
		  transient ActionListener loginl[]={okl,cancell};
		
}
