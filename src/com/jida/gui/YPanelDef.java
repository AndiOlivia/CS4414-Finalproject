package com.jida.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.gui.panel.ToolBarable;
import com.jida.user.CommandUpdateUser;

public class YPanelDef extends JPanel {
	static Logger logger=Logger.getLogger(YPanelDef.class);
	private String name;
	
//	private JToolBar jToolBar;
	private List<JPanel> listPanel;
	private int nActivePanel;
	private JFrameGuiSuper jFrame;
	private JTabbedPane jTabbedPane;
	private Component component;

	public YPanelDef(String name,JFrameGuiSuper jFrame){
		this.jFrame=jFrame;
		this.name=name;

		jTabbedPane=new JTabbedPane();
		jTabbedPane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				if(YPanelDef.this.jFrame!=null){
					int i=jTabbedPane.getSelectedIndex();
					if(i<0)
						return;
					String title=jTabbedPane.getTitleAt(i);
					YPanelDef.this.jFrame.showStatus1(title);
					
						setCurrent(title);
					
//					System.out.println(i+","+title);
				}
			}
		});
		listPanel=new ArrayList();
	}
//	public void setCurrent(){
//		
//		for(int i=1;i<jFrame.getContentPane().getComponentCount();){
////			System.out.println(jFrame.getContentPane().getComponent(i));
//			jFrame.getContentPane().remove(jFrame.getContentPane().getComponent(i));
//		}
//		if(component !=null){
//			if(component instanceof JPanel){
//				jFrame.getContentPane().add(component);
//				component.repaint();
//				return;
//			}
//			else { 
//				component.setVisible(true);
//				return;
//			}
//		}
//
////		if(this.jToolBar!=null){
////			this.jFrame.getContentPane().add("North",jToolBar);
////		}
//		if(jFrame!=null && jTabbedPane!=null){
//			jFrame.getContentPane().add(jTabbedPane);
//			jTabbedPane.setSelectedIndex(this.nActivePanel);
//			jTabbedPane.repaint();
//		}
//
//	}
	public void setCurrent(String nameSel){
//		System.out.println("YPanelDef:setCurrent:"+nameSel);
//		for(int i=0;i<jTabbedPane.getTabCount();i++){
//				System.out.println("YPanelDef:setCurrent:"+this.jTabbedPane.getTitleAt(i));
//		}
		
		jFrame.currName=nameSel;
		(jFrame).showStatus1(nameSel);
		for(int i=1;jFrame.getContentPane().getComponentCount()>1;){
//			System.out.println("Remove "+jFrame.getContentPane().getComponent(i));
			jFrame.getContentPane().remove(jFrame.getContentPane().getComponent(i));
		}
		jFrame.getContentPane().validate();

		if(component !=null){
			if(component instanceof JPanel){
//				System.out.println("Show "+component);
				jFrame.getContentPane().add(component);
				((JPanel)component).paintImmediately(0,0,jFrame.getContentPane().getWidth(),
						jFrame.getContentPane().getHeight());
//				jFrame.getContentPane().repaint();
				return;
			}
			else {
				component.setVisible(true);
				return;
			} 
		}

		else if(jFrame!=null && jTabbedPane!=null){
			try{
				jFrame.getContentPane().add(jTabbedPane);


				if(jFrame!=null){
					JPanel panel=jFrame.getPanel(nameSel);
					if(panel!=null){
						JToolBar jToolBar=null;
						if(panel instanceof ToolBarable){
							jToolBar=((ToolBarable)panel).getJToolBar();
						}

						if(jToolBar!=null){
							jToolBar.setPreferredSize(new Dimension(jFrame.getWidth(),30));
							this.jFrame.getContentPane().add("North",jToolBar);
							this.jFrame.getContentPane().validate();
							jToolBar.paintImmediately(0,0, jFrame.getWidth(),30);
						}
						jTabbedPane.setSelectedComponent(panel);
//						panel.paintImmediately(0, 0, panel.getWidth(), panel.getHeight());
					}
				}

				jFrame.getContentPane().validate();
				jTabbedPane.paintImmediately(0,0, jTabbedPane.getWidth(),jTabbedPane.getHeight());
//				jFrame.getContentPane().repaint();
//				jTabbedPane.paintImmediately(0,0, jTabbedPane.getWidth(),jTabbedPane.getHeight());


				for(int i=0;i<jTabbedPane.getTabCount();i++){
					if(jTabbedPane.getTitleAt(i).equals(nameSel)){
						nActivePanel=i;
						jTabbedPane.setSelectedIndex(i);
						break;
					}
				}
			}
			catch(Exception e){
				logger.error(e);
			}
		}
//		for(int i=0;i<jFrame.getContentPane().getComponentCount();i++){
//		System.out.println(jFrame.getContentPane().getComponent(i));
////		jFrame.getContentPane().remove(jFrame.getContentPane().getComponent(i));
//		}
	}
	public void register(){
		this.jTabbedPane.addChangeListener(cl);
	}

	transient ChangeListener cl=new ChangeListener(){
		public void stateChanged(ChangeEvent e){
			nActivePanel=0;
			for(int i=0;i<listPanel.size();i++){
				nActivePanel=jTabbedPane.getSelectedIndex();
			}
		}
	};

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public JToolBar getJToolBar() {
//		return jToolBar;
//	}
//	public void setJToolBar(JToolBar toolBar) {
////		this.jToolBar.setName(name);
//		jToolBar = toolBar;
//	}

	public void add(String nameTab,JPanel jPanel){
		this.jTabbedPane.addTab(nameTab,jPanel);
		this.listPanel.add(jPanel);
	}
	public Component getComponent() {
		return this.component;
	}
	public void setComponent(JComponent component) {
		this.component=component;
	}
}
