package com.jida.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.jida.MvcProperties;
import com.jida.user.domObject.User;

public class AuthDialog extends JDialog {
	private JTextField jTextFieldUser;
	private JPasswordField jPasswordField;
	private JButton jButtonOK;
	private JButton jButtonCancel;
	private JLabel jLabelIcon;
	private User user;
	public AuthDialog(String str,JFrameGui gui){
		this.setModal(true);
		setTitle(str);
		if(gui!=null)
			this.setLocationRelativeTo(gui);
		initGUI();
		this.setVisible(true);
	}
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {20, 20, 20, 20, 15};
			thisLayout.columnWeights = new double[] {0.0,0.0, 0.0, 0.0, 0.0, 0.0};
			thisLayout.columnWidths = new int[] {0, 30, 30, 30, 30,0};
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				JLabel jLabel = new JLabel("");
				getContentPane().add(jLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel.setIcon(new ImageIcon(
						getClass()
						.getClassLoader()
						.getResource(
						"images/superuser.png")));
			}
			{
				JLabel jLabel = new JLabel("用户");
				getContentPane().add(jLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jTextFieldUser = new JTextField();
				getContentPane().add(jTextFieldUser, new GridBagConstraints(3, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				JLabel jLabel = new JLabel("密码");
				getContentPane().add(jLabel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jPasswordField = new JPasswordField();
				getContentPane().add(jPasswordField, new GridBagConstraints(3, 3, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jButtonOK = new JButton("确定");
				getContentPane().add(jButtonOK, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jButtonCancel = new JButton("取消");
				getContentPane().add(jButtonCancel, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			this.setSize(300,200);
		}
		catch(Exception e){
			MvcProperties.toLog(e);
			e.printStackTrace();
		}
		register();
	}
	public User getUser(){
		return user;
	}
	
	public transient ActionListener alOk=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			user=new User();
			user.setName(jTextFieldUser.getText());
			user.setPassword(new String(jPasswordField.getPassword()));
			setVisible(false);
			dispose();
		}
	};
	public transient ActionListener alCancel=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			user=null;
			setVisible(false);
			dispose();
		}
	};
	public void register(){
		this.jButtonOK.addActionListener(this.alOk);
		this.jButtonCancel.addActionListener(this.alCancel);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthDialog dia=new AuthDialog("授权",null);
		System.out.println(dia.getUser());
	}
}
