package com.jida.gui;
import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.user.AuthSession;
import com.jida.user.CommandUpdateUser;
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
public class JDialogExit extends javax.swing.JDialog {
	static Logger logger=Logger.getLogger(JDialogExit.class);
	private JLabel jLabel1;
	private JTextField jTextFieldUser;
	private JLabel jLabel2;
	private JButton jButtonCancel;
	private JButton jButton;
	private JPasswordField jTextFieldPassword;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JDialogExit inst = new JDialogExit(frame);
		inst.setVisible(true);
	}
	
	public JDialogExit(JFrame frame) {
		super(frame,true);
		initGUI();
		this.register();
//		this.setModal(true);
				
		this.setLocationRelativeTo(frame);
		this.setResizable(false);
		this.setTitle("退出验证");
//		this.setAlwaysOnTop(true);
		this.setVisible(true);
			
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0, 0, 0};
			thisLayout.rowHeights = new int[] {40, 40, 40};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0};
			thisLayout.columnWidths = new int[] {87, 150, 70};
			getContentPane().setLayout(thisLayout);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setText("用户");
				jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextFieldUser = new JTextField();
				getContentPane().add(jTextFieldUser, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextFieldPassword = new JPasswordField();
				getContentPane().add(jTextFieldPassword, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jButton = new JButton();
				getContentPane().add(jButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButton.setText("\u9a8c\u8bc1");
				jButton.setFocusable(true);
			}
			{
				jButtonCancel = new JButton();
				getContentPane().add(jButtonCancel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonCancel.setText("\u53d6\u6d88");
			}
			this.setSize(242, 174);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private int count;
	private boolean success;
	public void register(){
		this.jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String user=jTextFieldUser.getText();
				String password=jTextFieldPassword.getText();
				User us=new User();
				us.setName(user);
				us.setPassword(password);
				
//				AuthModel model=AuthModel.getInstance();
//				if(model.isUserValid(us)){
				AuthSession session=AuthSession.getInstance();
				if(session.getUser().getName().equalsIgnoreCase(user) && 
						session.getUser().getPassword().equals(password) 
//						&&
//						session.getUser().hasPrivilege("close")
						){
					JDialogExit.this.setVisible(false);
					JDialogExit.this.dispose();
//					JFrameGui.getGui().close();
					success=true;
//					System.out.println("JDialogExit:"+success);
					
					return;
				}
				count++;
				if(count>3){
					JOptionPane.showMessageDialog(null, "Too many attempts!");
					JDialogExit.this.setVisible(false);
					JDialogExit.this.dispose();
				}
			}
		});
		this.jButtonCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialogExit.this.setVisible(false);
//				JDialogExit.this.dispose();
			}
		});
	}

	public boolean isSuccess() {
		return success;
	}

	
}
