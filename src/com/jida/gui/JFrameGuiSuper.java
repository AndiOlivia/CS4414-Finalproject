package com.jida.gui;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar; 
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.plaf.nimbus.NimbusLookAndFeelAddons;

import com.jida.MvcProperties;
import com.jida.client.Client;
import com.jida.client.Main;
import com.jida.fee.gui.PanelFee;
import com.jida.gui.panel.ToolBarable;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.CommandUpdateUser;
import com.jida.user.domObject.User;
import com.jida.user.gui.ChangePasswordGUI;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;


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
public class JFrameGuiSuper extends javax.swing.JFrame {
	public static String DBBackup="DB Backup";
	public static String DBRestore="DB Restore";
	static Logger logger=Logger.getLogger(JFrameGuiSuper.class);
	public static  JFrameGuiSuper gui;
//	private JMenuBar jMenuBar1;
	private JLabel jLabelStatus1;
	private JLabel jLabelStatus2;
	private JProgressBar jProgressBar;
//	private static  Color Blue;

	protected YPanelDef yPanelDef;

	protected Map<String,YPanelDef> mapTabbedPanel=new HashMap();
	protected Map<String,JPanel> mapPanel=new HashMap();
	protected Map<String,JMenuItem> mapMenu=new HashMap();
	protected String activeCommand="";
	private JLabel jLabelStatus3;
	private JLabel jLabelStatus4;
	public static String currName;

//	private static JFrameGui gui;

//	static{
//	gui=new JFrameGui();
//	}
//	private JSeparator jSeparator1;
//	protected JToolBar jToolBar1;
//	public static JFrameGui getGui(){
//	return gui;
//	}
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
//		JFrameGui inst = JFrameGui.getGui();//new JFrameGui();
//		inst.setVisible(true); 
	}

	protected  JFrameGuiSuper() {
		super();
		init();
		initGUI();
//		System.out.println(this.mapPanel);
//		this.setVisible(true);
		this.progressStart();
		
//		repaint();
		//New 20131110
		this.setSize(this.getSize());
		this.repaint();
	}
	public void initPanel(){
		activeCommand=PanelFee.name;
		mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
	}
	public void initPanel(String command){
		activeCommand=command;
		mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
	}
	private void init(){
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
//				close();
				System.exit(0);
			}
		});
		String lookandfeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//		String lookandfeel="com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
//		String lookandfeel="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//		String lookandfeel="javax.swing.plaf.metal.MetalLookAndFeel";
		try{
			UIManager.setLookAndFeel(lookandfeel);
		}
		catch(Exception e){
			e.printStackTrace();
		}
//		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		SwingUtilities.updateComponentTreeUI(this);

		Image image=Toolkit.getDefaultToolkit().createImage(MvcProperties.iconPath);
		this.setIconImage(image);

		this.setTitle(MvcProperties.host);

//		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	protected void initGUI() {
		try {
//			getContentPane().setBackground(new java.awt.Color(200,200,255));
//			this.setSize(747, 53);
			{	
				JPanel jPanel=new JPanel();
				getContentPane().add(jPanel, BorderLayout.SOUTH);
				GridBagLayout gbl=new GridBagLayout();
				jPanel.setLayout(gbl);
				gbl.rowWeights=new double[]{0};
				gbl.rowHeights=new int []{20};
				gbl.columnWeights=new double[]{0,1,0,0,0};
				gbl.columnWidths=new int[]{120,90,80,80,150};
				jPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				{
					jLabelStatus1 = new JLabel();
					jPanel.add(jLabelStatus1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelStatus1.setText("Ready");
					jLabelStatus1.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, true));
					jLabelStatus1.setForeground(new java.awt.Color(50,50,50));
					jLabelStatus1.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					jLabelStatus2 = new JLabel();
					jPanel.add(jLabelStatus2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelStatus2.setText("运行中");
					jLabelStatus2.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, true));
					jLabelStatus2.setForeground(new java.awt.Color(80,80,80));
				}
				{
					jLabelStatus3 = new JLabel();
					jPanel.add(jLabelStatus3, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//					jLabelStatus3.setText("运行中");
					jLabelStatus3.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, true));
					jLabelStatus3.setForeground(new java.awt.Color(80,80,80));
				}
				{
					jLabelStatus4 = new JLabel();
					jPanel.add(jLabelStatus4, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//					jLabelStatus4.setText("运行中");
					jLabelStatus4.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, true));
					jLabelStatus4.setForeground(new java.awt.Color(80,80,80));
				}
				{
					this.jProgressBar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
					jPanel.add(jProgressBar,new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					jProgressBar.setForeground(new Color(0,255,0));
//					jProgressBar.set
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		register();
	}
	public void prompt(String s){
		JOptionPane.showMessageDialog(this, s);
	}
	public void showStatus1(Object obj){
		this.jLabelStatus1.setText(obj==null?"无":obj.toString());
	}
	public void showStatus(Object obj){
		this.jLabelStatus2.setText(obj==null?"无":obj.toString());
	}
	public void showStatusA1(Object obj){
		this.jLabelStatus3.setText(obj==null?"无":obj.toString());
	}
	public void showStatusA2(Object obj){
		this.jLabelStatus4.setText(obj==null?"无":obj.toString());
	}
	public JPanel getPanel(String name){
//		System.out.println(this.mapPanel);
		return this.mapPanel.get(name);
	}

	public void progressStart(){
		progressValue=5;
		//this.showStatus("处理开始，请等待...");
		new Thread(new Runnable(){
			public void run(){
				try{
					while(progressValue<100){
						jProgressBar.setValue(progressValue);
						//					jProgressBar.paintImmediately(jProgressBar.bounds());
						if(progressValue<95)
							progressValue+=5;
						try {
							Thread.sleep(1000-5*progressValue);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							showStatus(e);
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
	}
	public void progressEnd(){
		progressValue=100;
		jProgressBar.setValue(this.progressValue);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jProgressBar.setValue(0);
//		this.showStatus(promptString);
		System.out.println("JFrameGuiSuper:progressEnd");
	}
//	public static String defaultStatus="就绪";
	
	public void close(){
		System.exit(0);
		/*
		//验证退出
		JDialogExit dialog=new JDialogExit(null);
//		System.out.println("JFrameGui:success:"+dialog.isSuccess());
		if(dialog.isSuccess()){
//			System.out.println("JFrameGui:success");
			setVisible(false);
			//process before exit
			try {
				MvcProperties.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
//		else{
		System.out.println("JFrameGui:success:"+dialog.isSuccess()+","+this.isVisible());
		this.setVisible(true);
//		this.repaint();
//		}*/
	}
	public int progressValue;
	public void register(){
		JMenuItem item=null;
		String s="Exit";
		mapMenu.get(s).addActionListener(this.alExit);
		s="System Setting";
		//New 20120217
		if(mapMenu.get(s)!=null)
			mapMenu.get(s).addActionListener(this.alSystemSetting);

		s="System Reset";
		if(mapMenu.get(s)!=null)
			mapMenu.get(s).addActionListener(this.alSystemReset);
		s="Network Reset";
		if(mapMenu.get(s)!=null)
			mapMenu.get(s).addActionListener(this.alNetworkReset);
		s="About";
		mapMenu.get(s).addActionListener(this.alAbout);
		s=JFrameGuiSuper.DBBackup;
		if((item=mapMenu.get(s))!=null)
			item.addActionListener(this.alBackup);
		
//		mapMenu.get(s).addActionListener(this.alBackup);
		s=JFrameGuiSuper.DBRestore;
		if((item=mapMenu.get(s))!=null)
			item.addActionListener(this.alRestore);
//		mapMenu.get(s).addActionListener(this.alRestore);
//		s="NetWorkReset";
//		if(mapMenu.get(s)!=null)
//			mapMenu.get(s).addActionListener(this.alCenterReset);
		s="Change Password";
		if((item=mapMenu.get(s))!=null)
			item.addActionListener(this.alChangePassword);
		s="Logout";
		if((item=mapMenu.get(s))!=null)
			item.addActionListener(this.alLogout);
		
		
	}
	
	
	
	transient ActionListener alBackup=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			backup();
		}
	};
	
	public void backup(){
		if(!AuthSession.getInstance().getUser().hasPrivilege("DBBackupPrivilege,SuperPrivilege")){
			JOptionPane.showMessageDialog(JFrameGui.getGui(), "No setting!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "操作前请先确认MySQL命令路径已设置到path中，继续吗？")!=JOptionPane.OK_OPTION){
			return ;
		}
		
		JFrameGuiSuper gui=JFrameGuiSuper.this;
		gui.showStatus("数据库备份开始，请等待...");
//		System.out.println("数据库备份开始，请等待...");
		gui.progressStart();
		new Thread(){
			public void run(){
				JFrameGuiSuper gui=JFrameGuiSuper.this;
				try {
//					String path=JOptionPane.showInputDialog("确认数据库路径",MvcProperties.pathMySQL);
					JFileChooser jfc = new JFileChooser();
//					FileFilter ff = new FileNameExtensionFilter(".xls", "xls");
//					jfc.setFileFilter(ff);
					int result = jfc.showSaveDialog(null);
					if (result != 0) return ;
					File file = jfc.getSelectedFile();
					MvcProperties.backupDB(file.getAbsolutePath());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				gui.showStatus("数据库备份完成");
				gui.progressEnd();
			}
		}.start();
//		try {
//		Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//		}

//		gui.showStatus("数据库备份完成");
//		gui.progressEnd();

	}

	transient ActionListener alRestore=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			restore();
		}
	};
	public void restore(){
		if(!AuthSession.getInstance().getUser().hasPrivilege("DBRestorePrivilege,SuperPrivilege")){ 
			JOptionPane.showMessageDialog(JFrameGui.getGui(), "No privilege to do！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "操作前请先确认MySQL命令路径已设置到path中，继续吗？")!=JOptionPane.OK_OPTION){
			return ;
		}
		
		JFrameGuiSuper gui=JFrameGuiSuper.this;
		gui.showStatus("Database restoring，Wait please...");
		gui.progressStart();
		new Thread(){
			public void run(){
				JFrameGuiSuper gui=JFrameGuiSuper.this;
				try {
//					String path=JOptionPane.showInputDialog("确认数据库路径",MvcProperties.pathMySQL);
					JFileChooser jfc = new JFileChooser();
//					FileFilter ff = new FileNameExtensionFilter(".xls", "xls");
//					jfc.setFileFilter(ff);
					int result = jfc.showOpenDialog(null);
					
					if (result != 0) return ;
					File file = jfc.getSelectedFile();
					MvcProperties.restoreDB(file.getAbsolutePath());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				gui.showStatus("数据库恢复完成");
				gui.progressEnd();
			}
		}.start();

	}
	transient ActionListener alExit=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			close();
		}
	};
	
	
	transient ActionListener alChangePassword=new ActionListener(){
		public void actionPerformed(ActionEvent e){
//			更改密码
//			User user=AuthSession.getInstance().getUser();
//			if(user.getType()==AuthSession.LOGINALONE){
//				JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "独立工作站用户不能更改密码");
//				return;
//			}
			//new 20110215
//			if(!AuthSession.getInstance().getUser().hasPrivilege("UserMgrPrivilege")){
//				JOptionPane.showMessageDialog(JFrameGui.getGui(), "无设置权限！");
//				return;
//			}
			//New 20110205 
			ChangePasswordGUI cpGui=new ChangePasswordGUI();
			cpGui.setModal(true);
			
		}
	};
	transient ActionListener alLogout=new ActionListener(){
		public void actionPerformed(ActionEvent e){
//			再登录
			
		}
	};

	transient ActionListener alSystemSetting=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!AuthSession.getInstance().getUser().hasPrivilege("SystemSetPrivilege,SuperPrivilege")){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "No setting!");
				return;
			}
	
		}
	};
	
	transient ActionListener alSystemReset=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			systemReset();
		}
	};
	public void systemReset(){
		//New 20110209
		if(AuthSession.getInstance().getUser().getType()==AuthSession.LOGINNORMAL ||
				AuthSession.getInstance().getUser().getType()==AuthSession.LOGINALONE){
	
		}
	}
	transient ActionListener alNetworkReset=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			networkReset();
		}
	};
	
	public   void networkReset(){
		Client client=Client.getInstance();
		try {
			//close
			client.close();
			System.out.println("JFrameGuiSuper:alNetworkReset:network closed");
			//reconnect
			client.connect();
			System.out.println("JFrameGuiSuper:alNetworkReset:network reconnect");
			//login again
			AuthModel model=AuthModel.getInstance();
			model.isUserValid(AuthSession.getInstance().getUser());
			System.out.println("JFrameGuiSuper:alNetworkReset:network logined again");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("NetworkReset:",e1);
			return;
		}
	}
	transient ActionListener alAbout=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//
			JOptionPane.showMessageDialog(null, "Personal Expense Management System\nVersion: 1.0");
		}
	};
}
