package com.jida.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.jida.user.gui.PanelPrivilege;

//import com.jy.client.user.gui.PanelPrivilege;

public class JFramePrivilegeTest extends JFrame {
	public PanelPrivilege panelPrivilege;
	public JFramePrivilegeTest(){
		initGUI();
		this.setSize(800,600);
		this.setVisible(true);
	}
	public void initGUI(){
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		{
			this.panelPrivilege=new PanelPrivilege();
			this.getContentPane().add(this.panelPrivilege);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFramePrivilegeTest();
	}

}
