package com.jida.product;

import java.awt.event.ActionEvent;




import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jida.product.gui.PanelProduct;
//import com.jida.client.Main;
import com.jida.gui.JFrameGui;
import com.jida.product.data.Product;
import com.jida.product.data.ProductType;
import com.jida.util.ToolKit;

public class ViewProductImpl implements ViewProduct {
	private ModelProduct model;
	private ControllerProduct con;
	private PanelProduct panel; 
	private String name=PanelProduct.name;
	private TableModelProduct tableModel;
//	private TableModelKCWZ tableModelKCWZ;
	private String cond;

	public ViewProductImpl(ModelProduct model){
		this.model=model;
		this.model.addViewListener(this);

		panel=(PanelProduct)JFrameGui.getGui().getPanel(name);
		panel.register(als);
//		System.out.println(als);
		tableModel=new TableModelProduct(this.model,panel.getTable());
		panel.registerTable(tableModel,lsl);
		ModelProductType modelProductType=ModelProductTypeDBImpl.getInstance();
		try {
			List<String> listPT=modelProductType.getTypeName();
			panel.setTypes(listPT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		tableModelProduct=new TableModelKCWZ(null);
//		panel.registerKCWZ(tableModelKCWZ);
		this.processModelChange(null);
		//		panel.setSpinnerFromHourModel();//New20110504 brandi
		//		panel.setSpinnerFromMinuteModel();//New20110504 brandi
		//		panel.setLeaveTimeModel(model.getLeaveTimes());//ModelDBImplPriceDefinition.getInstance().getLeaveTimes());

	}

	public void addControllerListener(ControllerProduct con) {
		// TODO Auto-generated method stub
		this.con=con;
	}

	public void processModelChange(Object obj) {
//		// TODO Auto-generated method stub

		
		if(obj instanceof Product){
			return;
		}
//		
		else if(obj instanceof List){
			tableModel.setList(((List)obj));
//			tableModel1.setList(((List)obj));
		}
		else{

			List<Product> list=null;
			
			try{
				list=this.model.get(cond);
//				
				tableModel.setList(list);
//				
			}
			catch(Exception e){
				e.printStackTrace();
			//	return;
			}
		}
//		}
		panel.setContent();
//		
	}
	
	transient ActionListener alInsert=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//S1 get  data from panel
			Product pd=panel.get();
			//S2 insert by controller
			//			
			if(pd==null){
				return;
			}
			con.processInsert(pd);
			
			int index=model.getIndex(pd,cond);

			panel.setSelectedIndex(index);
//			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};

	transient ActionListener alDelete=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(panel, "Confirm to delete?")){
				return;
			}
			Product pd=panel.get();
			int index=model.getIndex(pd,cond);
			if(pd==null){
				return;
			}
			if(index<0){
				JOptionPane.showMessageDialog(panel,"Not exist:"+pd);
				return;
			}
			ViewProductImpl.this.con.processDelete(pd);
			con.processDelete(pd);
//			index--;
			int total=0;
			try {
				total = model.get(cond).size();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(index>=total){
				index--;
				if(index<0)
					return;
			}
			
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
		}
	};

	transient ActionListener alUpdate=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//S1 get user data from panel
			Product pd=panel.get();
			con.processUpdate(pd);
			
			int index=model.getIndex(pd, cond);
			if(index<0){
				return;
			}
			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex()<0){
				panel.setSelectedIndex(index);
			}
//			processModelChange(null);

		}
	};
	transient ActionListener alRefresh=new ActionListener(){
		public void actionPerformed(ActionEvent e){
				//get data from gui
				processModelChange(null);
			
		}
	};
	transient ActionListener alSearch=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//get data from gui
//			String cond;
			String value=panel.getValue();
			if(value==null || value.equals("")){
				cond=null;
			}
			else{
				String item=panel.getItem();
				item=ToolKit.getCorresponding(item, Product.titles,Product.fields);
				int mode=panel.getJComboBoxMode();
				if(item==null){
					System.out.println("item=null");
					return;
				}
				else{
					if(mode==0){
						cond=item+"= '"+value+"'";
					}
					else{
						cond=item+" like '%"+value+"%'";
					}
				}
			}

			try {
				tableModel.setList(model.get(cond));
				panel.setContent();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JFrameGui.getGui().showStatus(e1);
			}

//			System.out.println("ViewTemconImplo:"+cond);
			processModelChange(null);
		}
	};
	
		transient ActionListener alExport=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(panel, "确定导出吗？", "导出对话框", 0)){
					
					con.processExport();
				}
			}
		};

	transient ActionListener als[]={this.alInsert,this.alDelete,this.alUpdate,
			this.alRefresh,this.alSearch,
			this.alExport,};

	transient ListSelectionListener lsl=new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e){
			//取出选项
			int index=panel.getSelectedIndex();
			if(index<0)
				return;
			//获取data
			Product data=model.getByIndex(index);
			if(data==null){
				return;
			}
//			List<KuCunWuZi> list=ModelDBImplKuFang.mapKF2KCWZ.get(new Integer(data.getKFID()));
//			System.out.println("ViewKuFangImpl+lsl:"+ModelDBImplKuFang.mapKF2KCWZ);
//			System.out.println("ViewKuFangImpl+lsl:"+data.getKFID()+"=="+list);
			//设置GUI
			panel.set(data);
			
//			if(list!=null){
////				tableModelKCWZ.setList(list);
////				panel.setTableKCWZ();
//			}
		} 
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelProduct model=ModelProductDBImpl.getInstance();//ModelImplUser();
		ViewProduct view=new ViewProductImpl(model);
		new ControllerProductImpl(model,view);
	}
}
