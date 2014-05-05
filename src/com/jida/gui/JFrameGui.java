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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JComponent;
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

import com.jida.MvcProperties;
import com.jida.fee.gui.PanelFee;
import com.jida.gui.panel.ToolBarable;
import com.jida.product.gui.PanelProduct;
import com.jida.user.gui.PanelGroupPrivilege;
import com.jida.user.gui.PanelPrivilege;
import com.jida.user.gui.PanelUser;
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
public class JFrameGui extends JFrameGuiSuper {
	private JMenuBar jMenuBar1;
	
	private static JFrameGui gui;
	
	static{
		gui=new JFrameGui();
	}
	public static JFrameGui getGui(){
		return gui;
	}
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
//		JFrameGui inst = JFrameGui.getGui();//new JFrameGui();
//		inst.setVisible(true); 
	}
	
	private  JFrameGui() {
		
	}
	public void initGUI() {
		super.initGUI();
		try {

			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				
				{
					String name="Product";
					JMenu jMenu = new JMenu(name);
					jMenuBar1.add(jMenu);
					jMenu.setPreferredSize(new java.awt.Dimension(100, 19));
					
					//Update 20130527
					String ss[]=null;
					JComponent pp[]=null;
					ss=new String[]{
							PanelProduct.name,null,	"Exit"};
					pp=new JComponent[]{
							new PanelProduct(),null,null};

					yPanelDef=new YPanelDef(name,this);
					
					for(int i=0;i<ss.length;i++){
						if(ss[i]==null){
							jMenu.add(new JSeparator());
							continue;
						}
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenu.add(jMenuItem);
						
						if(pp[i] instanceof JPanel){
							this.mapPanel.put(ss[i],(JPanel) pp[i]);
							
							jMenuItem.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									activeCommand=e.getActionCommand();
									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
								}
							});
							yPanelDef.add(ss[i], (JPanel)pp[i]);
							this.mapTabbedPanel.put(ss[i], yPanelDef);
						}
						else{
							this.mapMenu.put(ss[i],jMenuItem);
							
						}
					}
				}
				
				
				{
					String name="Home Manager";
					JMenu jMenu = new JMenu(name);
					jMenuBar1.add(jMenu);
					jMenu.setPreferredSize(new java.awt.Dimension(100, 19));
					String ss[]={PanelFee.name};
					JPanel pp[]={new PanelFee()};//,new PanelPlanTaskLog()};
					yPanelDef=new YPanelDef(name,this);
					
					for(int i=0;i<ss.length;i++){
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenuItem.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								activeCommand=e.getActionCommand();
								mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
							}
						});
												
						jMenu.add(jMenuItem);
						
						this.mapPanel.put(ss[i], pp[i]);
						
						yPanelDef.add(ss[i], pp[i]);
						this.mapTabbedPanel.put(ss[i], yPanelDef);
					}
				}
				if(false)				
				{
					String name="Data Operation";
					JMenu jMenu = new JMenu(name);
					jMenu.setPreferredSize(new java.awt.Dimension(100, 19));
					jMenuBar1.add(jMenu);

					String ss[]={JFrameGuiSuper.DBBackup,JFrameGuiSuper.DBRestore
					};
					JPanel pp[]={null,null,null,null};
					yPanelDef=new YPanelDef(name,this);
					
					for(int i=0;i<ss.length;i++){
						if(ss[i]==null){
							jMenu.add(new JSeparator());
							continue;
						}
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenu.add(jMenuItem);

						if(pp[i] instanceof JPanel){
							this.mapPanel.put(ss[i],(JPanel) pp[i]);

							jMenuItem.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									activeCommand=e.getActionCommand();
									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
								}
							});
							yPanelDef.add(ss[i], (JPanel)pp[i]);
							this.mapTabbedPanel.put(ss[i], yPanelDef);
						}
						else{
							this.mapMenu.put(ss[i],jMenuItem);

						}
					}
				}

//				{
//					String name="\u8fdc\u7a0b\u670d\u52a1";
//					JMenu jMenu = new JMenu(name);
//					
//					jMenu.setEnabled(false);
//					
//					jMenuBar1.add(jMenu);
//					jMenu.setPreferredSize(new java.awt.Dimension(60, 19));
//
//					String ss[]={"\u6570\u636e\u4e0a\u4f20",
//							"\u6267\u884c\u6307\u4ee4",
//					};
//					JPanel pp[]={null,null,new PanelPrivilege()};
//					yPanelDef=new YPanelDef(name,this);
//					
//					for(int i=0;i<ss.length;i++){
//						JMenuItem jMenuItem = new JMenuItem(ss[i]);
//						jMenuItem.addActionListener(new ActionListener(){
//							public void actionPerformed(ActionEvent e){
//								activeCommand=e.getActionCommand();
//								mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
//							}
//						});
//												
//						jMenu.add(jMenuItem);
//						
//						this.mapPanel.put(ss[i], pp[i]);
//						
//						yPanelDef.add(ss[i], pp[i]);
//						this.mapTabbedPanel.put(ss[i], yPanelDef);
//					}
//				}
//				
//				{
//					String name="\u76d1\u63a7\u4e2d\u5fc3";
//					JMenu jMenu = new JMenu(name);
//					
//					jMenu.setEnabled(false);
//					
//					jMenuBar1.add(jMenu);
//					
//					
//					jMenu.setPreferredSize(new java.awt.Dimension(60, 19));
//
//					{
//						name="\u76d1\u63a7\u670d\u52a1";
//						JMenu jMenuSub = new JMenu(name);
//						jMenu.add(jMenuSub);
//						{
//							final String ss[]={
//									"\u6570\u636e\u5b58\u50a8\u4e0e\u5907\u4efd",
//									"\u8fdc\u7a0b\u76d1\u63a7",
//									"\u5165\u7f51\u8ba4\u8bc1",
//									"\u62a5\u8868",
//									"\u64cd\u4f5c\u65e5\u5fd7\u8bb0\u5f55",
//							};
//							JPanel pp[]={null,null,null,
//									null,null,
//									
//							};
//							yPanelDef=new YPanelDef(name,this);
//
//							for(int i=0;i<ss.length;i++){
//								JMenuItem jMenuItem = new JMenuItem(ss[i]);
//								jMenuItem.addActionListener(new ActionListener(){
//									public void actionPerformed(ActionEvent e){
//										activeCommand=e.getActionCommand();
//										mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
//									}
//								});
//
//								jMenuSub.add(jMenuItem);
//
//								this.mapPanel.put(ss[i], pp[i]);
//
//								yPanelDef.add(ss[i], pp[i]);
//								this.mapTabbedPanel.put(ss[i], yPanelDef);
//							}
//						}
//					}
//
//
//					{
//						name="\u76d1\u63a7\u6307\u6325";
//						JMenu jMenuSub = new JMenu(name);
//						jMenu.add(jMenuSub);
//
//						{
//							final String ss[]={
//									"\u6388\u6743\u7533\u8bf7",
//									"\u8fdc\u7a0b\u76d1\u63a7",
//									"\u8fdc\u7a0b\u63a7\u5236",
//									"\u62a5\u8868",
//							};
//							JPanel pp[]={null,null,null,null,};
//							yPanelDef=new YPanelDef(name,this);
//
//							for(int i=0;i<ss.length;i++){
//								JMenuItem jMenuItem = new JMenuItem(ss[i]);
//								jMenuItem.addActionListener(new ActionListener(){
//									public void actionPerformed(ActionEvent e){
//										activeCommand=e.getActionCommand();
//										mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
//									}
//								});
//
//								jMenuSub.add(jMenuItem);
//
//								this.mapPanel.put(ss[i], pp[i]);
//
//								yPanelDef.add(ss[i], pp[i]);
//								this.mapTabbedPanel.put(ss[i], yPanelDef);
//							}
//						}
//
//					}
//
//				}
				
//				{
//					String name="数据采集";
//					JMenu jMenu = new JMenu(name);
//					jMenu.setEnabled(false);
//					jMenuBar1.add(jMenu);
//					jMenu.setPreferredSize(new java.awt.Dimension(60, 19));
//					
//					String ss[]={"\u5cf0\u8c37\u7535\u80fd\u8868\u6570\u636e\u91c7\u96c6",
//							null,"\u53d8\u538b\u5668\u529f\u7387\u8868\u6570\u636e\u91c7\u96c6"};
//					JComponent pp[]={new JPanel(),null,new JPanel()};
//					yPanelDef=new YPanelDef(name,this);
//
//					for(int i=0;i<ss.length;i++){
//						if(ss[i]==null){
//							jMenu.add(new JSeparator());
//							continue;
//						}
//						JMenuItem jMenuItem = new JMenuItem(ss[i]);
//						jMenu.add(jMenuItem);
//						
//						if(pp[i] instanceof JPanel){
//							this.mapPanel.put(ss[i],(JPanel) pp[i]);
//							
//							jMenuItem.addActionListener(new ActionListener(){
//								public void actionPerformed(ActionEvent e){
//									activeCommand=e.getActionCommand();
//									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
//								}
//							});
//							yPanelDef.add(ss[i], (JPanel)pp[i]);
//							this.mapTabbedPanel.put(ss[i], yPanelDef);
//						}
//						else{
//							this.mapMenu.put(ss[i],jMenuItem);
//							
//						}
//					}
//				}
				{ 
					String name="Setting";
					JMenu jMenu = new JMenu(name);
					jMenu.setPreferredSize(new java.awt.Dimension(80, 19));
					jMenuBar1.add(jMenu);
					//Delete 20120210
					final String ss[]={
							"System Setting"
//							null,
//							"\u8ba1\u5212\u4efb\u52a1\u8bbe\u7f6e",
													
							/*null,"峰谷平时间段设置",null*//*,"设置报警温度",null,*/
													
//							MvcProperties.outDoorTitle
							};
					
					JPanel pp[]={
							null,
					};
					//End
					yPanelDef=new YPanelDef(name,this);
					
					for(int i=0;i<ss.length;i++){
						if(ss[i]==null){
							jMenu.add(new JSeparator());
							continue;
						}
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenu.add(jMenuItem);
						
						if(pp[i] instanceof JPanel){
							this.mapPanel.put(ss[i],(JPanel) pp[i]);
							
							jMenuItem.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									activeCommand=e.getActionCommand();
									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
								}
							});
							yPanelDef.add(ss[i], (JPanel)pp[i]);
							this.mapTabbedPanel.put(ss[i], yPanelDef);
						}
						else{
							this.mapMenu.put(ss[i],jMenuItem);
							
						}
					}
				}
//				if(false)
				{
					String name="User Management";
					JMenu jMenu = new JMenu(name);
					
//					jMenu.setEnabled(false);

					jMenuBar1.add(jMenu);
					jMenu.setPreferredSize(new java.awt.Dimension(100, 19));
					String ss[]={PanelUser.name,PanelGroupPrivilege.name,PanelPrivilege.name,
//							null,"Change Password",
							};
					JPanel pp[]={
							new PanelUser(),new PanelGroupPrivilege(),new PanelPrivilege(),
//							null,null,
//							null,null
							};
					yPanelDef=new YPanelDef(name,this);
//					
//					for(int i=0;i<ss.length;i++){
//						if(ss[i]==null){
//							jMenu.add(new JSeparator());
//							continue;
//						}
//						JMenuItem jMenuItem = new JMenuItem(ss[i]);
//						jMenuItem.addActionListener(new ActionListener(){
//							public void actionPerformed(ActionEvent e){
//								activeCommand=e.getActionCommand();
//								mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
//							}
//						});
//												
//						jMenu.add(jMenuItem);
//						
//						this.mapPanel.put(ss[i], pp[i]);
//						
//						yPanelDef.add(ss[i], pp[i]);
////						if(pp[i]!=null && pp[i] instanceof ToolBarable)
////							yPanelDef.setJToolBar(((ToolBarable)pp[i]).getJToolBar());
//						
//						this.mapTabbedPanel.put(ss[i], yPanelDef);
//					}yPanelDef=new YPanelDef(name,this);
					//brandi new 02.13
					for(int i=0;i<ss.length;i++){
						if(ss[i]==null){
							jMenu.add(new JSeparator());
							continue;
						}
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenu.add(jMenuItem);
						
						if(pp[i] instanceof JPanel){
							this.mapPanel.put(ss[i],(JPanel) pp[i]);
							
							jMenuItem.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									activeCommand=e.getActionCommand();
									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
								}
							});
							yPanelDef.add(ss[i], (JPanel)pp[i]);
							this.mapTabbedPanel.put(ss[i], yPanelDef);
						}
						else{
							this.mapMenu.put(ss[i],jMenuItem);
							
						}
					}
				}
				{
					String name="Help";
					JMenu jMenu = new JMenu(name);
					jMenuBar1.add(jMenu);
					jMenu.setPreferredSize(new java.awt.Dimension(100, 19));
					String ss[]={"About"};
					JPanel pp[]={null};
					yPanelDef=new YPanelDef(name,this);
					
					for(int i=0;i<ss.length;i++){
						if(ss[i]==null){
							jMenu.add(new JSeparator());
							continue;
						}
						JMenuItem jMenuItem = new JMenuItem(ss[i]);
						jMenu.add(jMenuItem);
						
						if(pp[i] instanceof JPanel){
							this.mapPanel.put(ss[i],(JPanel) pp[i]);
							
							jMenuItem.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									activeCommand=e.getActionCommand();
									mapTabbedPanel.get(activeCommand).setCurrent(activeCommand);
								}
							});
							yPanelDef.add(ss[i], (JPanel)pp[i]);
							this.mapTabbedPanel.put(ss[i], yPanelDef);
						}
						else{
							this.mapMenu.put(ss[i],jMenuItem);
							
						}
					}
				}
								
			}
//			pack();
//			this.setSize(962, 643);
		} catch (Exception e) {
			e.printStackTrace();
		}
		register();
	}
//	public void prompt(String s){
//		JOptionPane.showMessageDialog(this, s);
//	}
//	public void showStatus1(Object obj){
//		this.jLabelStatus1.setText(obj==null?"无":obj.toString());
//	}
//	public void showStatus(Object obj){
//		this.jLabelStatus2.setText(obj==null?"无":obj.toString());
//	}
	
//	public JPanel getPanel(String name){
////		System.out.println(this.mapPanel);
//		return this.mapPanel.get(name);
//	}
//	
//	public void progressStart(){
//		progressValue=5;
//		this.showStatus("处理开始，请等待...");
//		new Thread(new Runnable(){
//			public void run(){
//				while(progressValue<100){
//					jProgressBar.setValue(progressValue);
//					if(progressValue<95)
//		 				progressValue+=5;
//					try {
//						Thread.sleep(1000-5*progressValue);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						showStatus(e);
//					}
//				}
//			}
//		}).start();
//	}
//	public void progressEnd(){
//		progressValue=100;
//		jProgressBar.setValue(this.progressValue);
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.jProgressBar.setValue(0);
//		this.showStatus("就绪");
//	}
//	
//	public void close(){
//		//验证退出
//		JDialogExit dialog=new JDialogExit(null);
////		System.out.println("JFrameGui:success:"+dialog.isSuccess());
//		if(dialog.isSuccess()){
////			System.out.println("JFrameGui:success");
//			setVisible(false);
//			//process before exit
//			if(MvcProperties.logOutputStream!=null)
//				try {
//					MvcProperties.logOutputStream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			System.exit(0);
//		}
////		else{
//		System.out.println("JFrameGui:success:"+dialog.isSuccess()+","+this.isVisible());
//		this.setVisible(true);
////		this.repaint();
////		}
//	}
//	public int progressValue;
//	public void register(){
//		String s="退出";
//		mapMenu.get(s).addActionListener(this.alExit);
//		s="系统设置";
//		mapMenu.get(s).addActionListener(this.alSystemSetting);
//		s="系统重置";
//		mapMenu.get(s).addActionListener(this.alSystemReset);
//		s="关于";
//		mapMenu.get(s).addActionListener(this.alAbout);
//		s="备份数据库";
//		mapMenu.get(s).addActionListener(this.alBackup);
//		s="恢复数据库";
//		mapMenu.get(s).addActionListener(this.alRestore);
//		s="密码更改";
//		mapMenu.get(s).addActionListener(this.alChangePassword);
//		s="注销";
//		mapMenu.get(s).addActionListener(this.alLogout);
//	}
//	
//	transient ActionListener alBackup=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			JFrameGui gui=JFrameGui.this;
//			gui.showStatus("数据库备份开始，请等待...");
////			System.out.println("数据库备份开始，请等待...");
//			gui.progressStart();
//			new Thread(){
//				public void run(){
//					JFrameGui gui=JFrameGui.this;
//					try {
//						MvcProperties.backupDB();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					gui.showStatus("数据库备份完成");
//					gui.progressEnd();
//				}
//			}.start();
////			try {
////				Thread.sleep(2000);
////			} catch (InterruptedException e1) {
////				// TODO Auto-generated catch block
////				e1.printStackTrace();
////			}
////			
////			gui.showStatus("数据库备份完成");
////			gui.progressEnd();
//		}
//	};
//	
//	transient ActionListener alRestore=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			JFrameGui gui=JFrameGui.this;
//			gui.showStatus("数据库恢复开始，请等待...");
//			gui.progressStart();
//			new Thread(){
//				public void run(){
//					JFrameGui gui=JFrameGui.this;
//					try {
//						
//						MvcProperties.restoreDB();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					gui.showStatus("数据库恢复完成");
//					gui.progressEnd();
//				}
//			}.start();
//		}
//	};
//	transient ActionListener alExit=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			close();
//		}
//	};
//	transient ActionListener alChangePassword=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
////			更改密码
//		}
//	};
//	transient ActionListener alLogout=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
////			再登录
//		}
//	};
//	
//	transient ActionListener alSystemSetting=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			SerialPortDialog dialog=new SerialPortDialog();
//			dialog.setVisible(true);
//			dialog.setAlwaysOnTop(true);
////			dialog.setModal(true);
//		}
//	};
//	transient ActionListener alSystemReset=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			SerialPortPoolManager.getInstance().close();
//			ModelDBImplHistoryTem.getInstance().close();
//			((PanelTemConTree)JFrameGui.this.getPanel("温控器布署")).close();
//			
//			RXTXPort.checkPort();
//	
//			//设置表中
//			ModelDBImplHistoryTem.getInstance().init();
//			ModelDBImplTemCon.getInstance().init();	
//		}
//	};
//	transient ActionListener alAbout=new ActionListener(){
//		public void actionPerformed(ActionEvent e){
//			//
//			JOptionPane.showMessageDialog(null, "SR5000电力集中供热控制系统\n\t版本：5.1\n\t研制单位：鑫源电器");
//		}
//	};
	
}
