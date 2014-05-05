package com.jida.product; 

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
//import com.jida.client.Main;
import com.jida.product.gui.PanelProductType;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
import com.jida.product.data.ProductType;
//import com.jida.gui.JFramePrivilegeTest;
public class ViewProductTypeImpl implements ViewProductType {
	private ModelProductType modelProductType;
	private ControllerProductType conProductType;
	
//	private JFrameProductTypeTest gui;
	PanelProductType panel;
	String name=PanelProductType.name;//"权限管理";
	TableModelProductType tableModel;
	public ViewProductTypeImpl(ModelProductType model){
		this.modelProductType=model;
		this.modelProductType.addViewListener(this);
		
		
		panel=(PanelProductType)JFrameGuiSuper.gui.getPanel(name);
		if(panel !=null)
			panel.register(als);
		
		tableModel=new TableModelProductType();
		panel.registerTable(tableModel,lslProductType);
//		PanelGroup panelGP=(PanelGroupProductType)JFrameGuiSuper.gui.getPanel(PanelGroupProductType.name);
//		try {
//			panelGP.setProductTypes(modelProductType.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			MvcProperties.write(e);
//		}
//		processModelChange(null);		
	}
	
	public void addControllerListener(ControllerProductType con) {
		// TODO Auto-generated method stub
		this.conProductType=con;
	}

	
	public void processModelChange(Object obj) {
		// TODO Auto-generated method stub
//		if(!UserViewImpl.valid())
//			return;
		
		List<ProductType> list=null;
		try{
			list=this.modelProductType.get();
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}
		this.tableModel.setList(list);
		panel.setContent();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ModelProductType model=ModelProductTypeDBImpl.getInstance();
		ViewProductType view=new ViewProductTypeImpl(model);
		new ControllerProductTypeImpl(model,view);
	}
	
	transient ActionListener alInsert=new ActionListener(){
		public void actionPerformed(ActionEvent e){
//			if(!UserViewImpl.valid())
//				return;
			
			//get data from gui
			String pri=panel.getProductType();
			String desc=panel.getDesc();
			ProductType ProductType=new ProductType();
			ProductType.setPtBrief(desc);
			ProductType.setPtName(pri);
			//insert by controller
			conProductType.insert(ProductType);
			
			int index=modelProductType.getIndex(ProductType);
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alDelete=new ActionListener(){
		public void actionPerformed(ActionEvent e){
//			if(!UserViewImpl.valid())
//				return;
			
			//get data from gui
			String pri=panel.getProductType();
			String desc=panel.getDesc();
			ProductType ProductType=new ProductType();
			ProductType.setPtBrief(desc);
			ProductType.setPtName(pri);
			int index=modelProductType.getIndex(ProductType);
			if(index<0)
				return;
			//insert by controller
			conProductType.delete(ProductType);
			
			if(index==modelProductType.getCount()){
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
//			if(!UserViewImpl.valid())
//				return;
			
			//get data from gui
			String pri=panel.getProductType();
			String desc=panel.getDesc();
			ProductType ProductType=new ProductType();
			ProductType.setPtBrief(desc);
			ProductType.setPtName(pri);
			//insert by controller
			conProductType.update(ProductType);
			
			int index=modelProductType.getIndex(ProductType);
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};
	transient ActionListener alSearch=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//get data from gui
			String pri=panel.getProductType();
			String desc=panel.getDesc();
			ProductType ProductType=new ProductType();
			ProductType.setPtBrief(desc);
			ProductType.setPtName(pri);
			//insert by controller
			conProductType.update(ProductType);
			
			int index=modelProductType.getIndex(ProductType);
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
			this.alInsert,this.alDelete,
			this.alUpdate,
			this.alSearch,this.alRefresh};
	
	transient ListSelectionListener lslProductType=new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e){
			//get selected index
			int index=panel.getSelectedIndex();
			if(index<0){
				return ;
			}
			//refresh panel
			ProductType pri=null;
			try {
				List<ProductType> list=modelProductType.get();
				pri=list.get(index);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				return ;
			}
			panel.setProductType(pri.getPtName());
			panel.setDesc(pri.getPtBrief());
		}
	};

}
