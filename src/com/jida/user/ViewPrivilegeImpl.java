package com.jida.user;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
//import com.jida.client.Main;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
import com.jida.gui.JFramePrivilegeTest;
import com.jida.server.MainServer;
import com.jida.user.db.ModelDBImplPrivilege;
import com.jida.user.domObject.Privilege;
import com.jida.user.gui.PanelGroupPrivilege;
import com.jida.user.gui.PanelPrivilege;
import com.jida.user.intf.ControllerPrivilege;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ViewPrivilege;
public class ViewPrivilegeImpl implements ViewPrivilege {
	Logger logger=Logger.getLogger(ViewPrivilegeImpl.class);
	private ModelPrivilege modelPrivilege;
	private ControllerPrivilege conPrivilege;
	
//	private JFramePrivilegeTest gui;
	PanelPrivilege panel;
	PanelGroupPrivilege panelGP;
	String name=PanelPrivilege.name;
	TableModelPrivilege tableModel;
	public ViewPrivilegeImpl(ModelPrivilege model){
		this.modelPrivilege=model;
		this.modelPrivilege.addViewListener(this);
		
		
		panel=(PanelPrivilege)JFrameGuiSuper.gui.getPanel(name);
		if(panel!=null){
			panel.register(als);

			tableModel=new TableModelPrivilege();
			panel.registerTable(tableModel,lslPrivilege);
			PanelGroupPrivilege panelGP=(PanelGroupPrivilege)JFrameGuiSuper.gui.getPanel(PanelGroupPrivilege.name);
			try {
				panelGP.setPrivileges(modelPrivilege.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e);

			}
		}
//		processModelChange(null);		
	}
	
	public void addControllerListener(ControllerPrivilege con) {
		// TODO Auto-generated method stub
		this.conPrivilege=con;
	}

	
	public void processModelChange(Object obj) {
		// TODO Auto-generated method stub
		if(!ViewUserImpl.valid())
			return;
		
		List<Privilege> list=null;
		try{
			list=this.modelPrivilege.get();
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}
		this.tableModel.setList(list);
		panel.setContent(list);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ModelPrivilege model=ModelDBImplPrivilege.getInstance();
		ViewPrivilege view=new ViewPrivilegeImpl(model);
		new ControllerPrivilegeImpl(model,view);
	}
	
	transient ActionListener alInsert=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!ViewUserImpl.valid())
				return;
			
			//get data from gui
			String pri=panel.getPrivilege();
			String desc=panel.getDesc();
			Privilege privilege=new Privilege();
			privilege.setPriDesc(desc);
			privilege.setPriName(pri);
			//insert by controller
			conPrivilege.processInsert(privilege);
			
			int index=modelPrivilege.getIndex(privilege);
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alDelete=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!ViewUserImpl.valid())
				return;
			
			//get data from gui
			String pri=panel.getPrivilege();
			String desc=panel.getDesc();
			Privilege privilege=new Privilege();
			privilege.setPriDesc(desc);
			privilege.setPriName(pri);
			int index=modelPrivilege.getIndex(privilege);
			if(index<0)
				return;
			//insert by controller
			conPrivilege.processDelete(privilege);
			
			if(index==modelPrivilege.getCount()){
				index--;
				if(index<0){
					return;
				}
			}
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alUpdate=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!ViewUserImpl.valid())
				return;
			
			//get data from gui
			String pri=panel.getPrivilege();
			String desc=panel.getDesc();
			Privilege privilege=new Privilege();
			privilege.setPriDesc(desc);
			privilege.setPriName(pri);
			//insert by controller
			conPrivilege.processUpdate(privilege);
			
			int index=modelPrivilege.getIndex(privilege);
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alSearch=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//get data from gui
			String pri=panel.getPrivilege();
			String desc=panel.getDesc();
			Privilege privilege=new Privilege();
			privilege.setPriDesc(desc);
			privilege.setPriName(pri);
			//insert by controller
			conPrivilege.processUpdate(privilege);
			
			int index=modelPrivilege.getIndex(privilege);
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alRefresh=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//get data from gui
			processModelChange(null);
		}
	};
	transient ActionListener als[]={
//			this.alInsert,this.alDelete,
			this.alUpdate,
			this.alSearch,this.alRefresh};
	
	transient ListSelectionListener lslPrivilege=new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e){
			//get selected index
			int index=panel.getSelectedIndex();
			if(index<0){
				return ;
			}
			//refresh panel
			Privilege pri=null;
			try {
				List<Privilege> list=modelPrivilege.get();
				pri=list.get(index);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				return ;
			}
			panel.setPrivilege(pri.getPriName());
			panel.setDesc(pri.getPriDesc());
		}
	};

}
