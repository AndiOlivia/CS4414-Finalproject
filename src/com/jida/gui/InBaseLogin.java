package com.jida.gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

//import com.jy.client.user.AuthModel;




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

public class InBaseLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JButton OKBButton = new JButton();
	private JButton cancelButton = new JButton();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JLabel jLabel3 = new JLabel();
	private JPasswordField password = new JPasswordField();
	private JComboBox ComboBox;
	private Toolkit tk = this.getToolkit();
	private Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

	public InBaseLogin() throws HeadlessException {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws HeadlessException {
		new InBaseLogin();
	}

	private void jbInit() throws Exception {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("用  户");
		jLabel1.setBounds(new Rectangle(269, 128, 50, 34));
		this.getContentPane().setLayout(null);
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("口  令");
		jLabel2.setBounds(new Rectangle(269, 171, 50, 34));
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
		this.setTitle("请登陆");
		jPanel1.setBackground(new Color(184, 203, 158));
		jPanel1.setForeground(Color.blue);
		jPanel1.setBounds(new Rectangle(-1, 0, 505, 352));
		jPanel1.setLayout(null);
		jPanel2.setBackground(new Color(144, 184, 118));
		jPanel2.setBounds(new Rectangle(1, 0, 206, 352));
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel3.setForeground(new Color(118, 131, 46));
		jLabel3.setText("请输入用户名和口令");
		jLabel3.setBounds(new Rectangle(227, 24, 249, 26));
		password.setBorder(this.bevelBorder);
		password.setText("000000");
		password.setBounds(new Rectangle(322, 176, 128, 25));
		jPanel1.add(OKBButton, null);
		jPanel1.add(cancelButton, null);
		jPanel1.add(jPanel2, null);
		jPanel1.add(jLabel3, null);
		jPanel1.add(password, null);
		jPanel1.add(jLabel1, null);
		jPanel1.add(jLabel2, null);
		{
			ComboBoxModel ComboBoxModel = new DefaultComboBoxModel(
//					AuthModel.getDBUser()
					);
			ComboBox = new JComboBox();
			jPanel1.add(ComboBox);
			ComboBox.setModel(ComboBoxModel);
			ComboBox.setBounds(322, 126, 126, 28);
		}
		this.setSize(500, 340);
		int screenWidth = this.tk.getScreenSize().width;
		int screenHeight = this.tk.getScreenSize().height;
		int loginWidth = this.getSize().width;
		int loginHeight = this.getSize().height;
		int positionX = (screenWidth - loginWidth) / 2;
		int positionY = (screenHeight - loginHeight) / 2;
		this.setLocation(positionX, positionY);
		this.getRootPane().setDefaultButton(this.OKBButton);
		this.setVisible(false);
	}

	public void register(ActionListener al[]) {
		OKBButton.addActionListener(al[0]);
		cancelButton.addActionListener(al[1]);
	}

	public String[] getUser() {
		String[] s = new String[2];
		s[0] = this.ComboBox.getSelectedItem().toString();
		s[1] = String.copyValueOf(this.password.getPassword());
		return s;
	}
	


	public void setRepeat() {
		this.jLabel3.setText("用户名或口令错误,请再试一下");
	}
	public void setRepeat(String s) {
		this.jLabel3.setText(s);
	}
	public void showMessageBox(String message, String title, int messageType) {
		JOptionPane.showMessageDialog(this, message, title, messageType);
	}

	public void setLoginName(String name) {
		this.ComboBox.setSelectedItem(name);
	}

	public void setPassword(String pwd) {
		this.password.setText(pwd);
	}
	public String getUserName(){
		return ComboBox.getSelectedItem().toString();
		
	}
}