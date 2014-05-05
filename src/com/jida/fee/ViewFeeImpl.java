package com.jida.fee;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.jida.Controller;
import com.jida.MvcProperties;
import com.jida.client.Main;
import com.jida.fee.data.Fee;
import com.jida.fee.data.FeeDetails;
import com.jida.fee.gui.PanelFee;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
import com.jida.gui.JFramePrivilegeTest;
import com.jida.product.ModelProduct;
import com.jida.product.ModelProductDBImpl;
import com.jida.product.ModelProductType;
import com.jida.product.ModelProductTypeDBImpl;
import com.jida.product.ViewProductImpl;
import com.jida.product.data.Product;
import com.jida.product.data.ProductType;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.util.ToolKit;

public class ViewFeeImpl implements ViewFee {
	private ModelFee model;
	private Controller con;
	private String cond;
//	private JFramePrivilegeTest gui;
	PanelFee panel;
//	PanelFeeDetails panelDetails;
	String name=PanelFee.name;
	private List<Fee> listFee;
	TableModelFee tableModel;
	TableModelFeeDetails tableModelDetails;
	public ViewFeeImpl(ModelFee model){
		this.model=model;
		this.model.addViewListener(this);


		panel=(PanelFee)JFrameGuiSuper.gui.getPanel(name);

		panel.register(als);
//		panel.setTemConAddrCodes(ModelDBImplTemCon.getInstance().toTemConString().toArray());
//		if(AuthModel.getInstance().getUser().getType()==AuthSession.MONITORCENTER){
//			panel.setTemConAddrCodes(ModelNetImplTemCon.getInstance().toTemConString().toArray());
//		}
//		else{
//			panel.setTemConAddrCodes(ModelDBImplTemCon.getInstance().toTemConString().toArray());
//		}
		tableModel=new TableModelFee(model,panel.getTable());
		panel.registerTable(tableModel,lsl);

		ModelProduct modelProduct=ModelProductDBImpl.getInstance();
		try {
			List<Product> listPro=modelProduct.get();
			System.out.println("ViewFeeImpl.constructor:"+listPro);
			panel.setJLabelSelection(listPro, Product.titlesSelection, Product.fieldsSelection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelProductType modelProductType=ModelProductTypeDBImpl.getInstance();
		try {
			List<String> listPT=modelProductType.getTypeName();
			panel.setTypes(listPT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		tableModelDetails=new TableModelFeeDetails(null);
//		panel.registerTableDetails(tableModelDetails,lslDetails);

//		processModelChange(null);
	}

	public void addControllerListener(Controller con) {
	// TODO Auto-generated method stub
		this.con=con;
	}


	public void processModelChange(Object obj) {
		// TODO Auto-generated method stub
//		List<TempretureController> list=null;
//		try{
//		list=this.model.get();
//		}
//		catch(Exception e){
//		e.printStackTrace();
//		return;
//		}
//		if(tableModel.getList()==null){
		if(obj instanceof List){
			tableModel.setList((List)obj);
		}
		else{

			List<Fee> list=null;
			try{
				listFee=this.model.get(cond);
				tableModel.setList(listFee);
			}
			catch(Exception e){
				e.printStackTrace();
				return;
			}
		}
//		}
		panel.setContent();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		ModelTemCon model=ModelDBImplTemCon.getInstance();//new ModelTemConImpl();
//		ViewTemCon view=new ViewTemConImpl(model);
//		new ControllerTemConImpl(model,view);
	}
	transient ActionListener alExport=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(!AuthSession.getInstance().getUser().hasPrivilege("ComputeFeePrivilege")){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "No privilege");
				return;
			}
			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(JFrameGuiSuper.gui, "Confirm to export", "Export", 0)){
//				Date date1=gui.getProcessDateStart();
//				Date date2=gui.getProcessDateEnd();
				try{
					JFileChooser jfc = new JFileChooser();
					FileFilter ff = new FileNameExtensionFilter("xls", "xls");
					jfc.setFileFilter(ff);
					int result = jfc.showSaveDialog(null);
					if (result != 0) return ;
					File file = jfc.getSelectedFile();
					model.exportExcel(file.getAbsolutePath() + ".xls");
				}
				catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null, "Export failed");
					JFrameGuiSuper.gui.showStatus("Export failed");
					return;
				}
				JOptionPane.showMessageDialog(null, "Succeeding exporting");
				JFrameGuiSuper.gui.showStatus("Succeding exporting");

			}
			else{
				return;
			}
		}
	};
	transient ActionListener alInsert=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//S1 get  data from panel
			Fee pd=panel.get();
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
			Fee pd=panel.get();
			int index=model.getIndex(pd,cond);
			if(pd==null){
				return;
			}
			if(index<0){
				JOptionPane.showMessageDialog(panel,"Not exist:"+pd);
				return;
			}
			ViewFeeImpl.this.con.processDelete(pd);
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
			Fee pd=panel.get();
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
			String type=panel.getCategory();
			cond=String.format("pdtType='%s'", type);
			System.out.println("ViewFeeImpl.alSearch:"+cond);
			processModelChange(null);
//			String cond;
//			String value=panel.getValue();
//			if(value==null || value.equals("")){
//				cond=null;
//			}
//			else{
//				String item=panel.getItem();
//				item=ToolKit.getCorresponding(item, Product.titles,Product.fields);
//				int mode=panel.getJComboBoxMode();
//				if(item==null){
//					System.out.println("item=null");
//					return;
//				}
//				else{
//					if(mode==0){
//						cond=item+"= '"+value+"'";
//					}
//					else{
//						cond=item+" like '%"+value+"%'";
//					}
//				}
//			}
//
//			try {
//				tableModel.setList(model.get(cond));
//				panel.setContent();
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				JFrameGui.getGui().showStatus(e1);
//			}
//
////			System.out.println("ViewTemconImplo:"+cond);
//			processModelChange(null);
		}
	};
	transient ActionListener alSearch3=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Date startDate=MvcProperties.getCurrentDayBegin(panel.getDateStart());
			Date endDate=MvcProperties.getNextDayBegin(panel.getDateEnd());
			cond=String.format("feeDate>='%s' and feeDate<='%s'",MvcProperties.sdfTime.format(startDate),MvcProperties.sdfTime.format(endDate));
			System.out.println("ViewFeeImpl.alSearch3:"+cond);
			processModelChange(null);
		}
	};

	transient ActionListener als[]={
//			this.alInsert,this.alDelete,this.alUpdate,
			this.alRefresh,
			this.alExport,
			this.alInsert,this.alDelete,this.alUpdate,
//			this.alButtonSettingAll,
			this.alSearch,this.alSearch3,
			
	};
	transient ListSelectionListener lslDetails=new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e){
		}
	};
	transient ListSelectionListener lsl=new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e){
			//get selected index
			int index=panel.getSelectedIndex();
			if(index<0){
				return ;
			}
			Fee fee=model.getByIndex(index);
			if(fee==null)
				return;
			
			panel.set(fee);
//			//refresh panel
//			TempretureController pri=null;
//			try {
//			List<Fee> list=model.get(cond);
//			pri=list.get(index);
//			} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			return ;
//			}

//			panel.setCommunity(pri.getTemConAddr1());
//			panel.setBuilding(pri.getTemConAddr2());
//			panel.setRoom(pri.getTemConAddr3());
//			panel.setPlace(pri.getSetAddr());
//			panel.setAddrCode(pri.getTemConAddrCode());
//			panel.setTemConNo(pri.getTemConName());
//			panel.setPower(pri.getPowers());
		}
	};

}
