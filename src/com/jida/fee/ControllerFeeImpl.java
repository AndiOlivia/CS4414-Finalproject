package com.jida.fee;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jida.Controller;
import com.jida.client.Main;
import com.jida.fee.data.Fee;
import com.jida.gui.JFrameGui;
import com.jida.product.data.Product;
import com.jida.user.AuthModel;

public class ControllerFeeImpl implements Controller<Fee> {

	private ModelFee model;
	private ViewFee view; 
	public ControllerFeeImpl(ModelFee model,ViewFee view){
		this.model=model;
		this.view=view;
		this.view.addControllerListener(this);
	}


	public void processDelete(Fee pro) {
		// TODO Auto-generated method stub

		try {
			model.delete(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//				Main.gui.showStatus(e);
			return;
		}
		//S3 select view
		JFrameGui.getGui().showStatus("deleted "+pro);


	}


	public void processInsert(Fee pro) {
		// TODO Auto-generated method stub
		try {
			model.insert(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrameGui.getGui().showStatus(e);
			return;
		}
		//S3 select view
		JFrameGui.getGui().showStatus("Inserted "+pro);

	}


	public void processUpdate(Fee pro) {
		// TODO Auto-generated method stub
		try {
			model.update(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrameGui.getGui().showStatus(e);
			return;
		}
		//S3 select view
		JFrameGui.getGui().showStatus("updated "+pro);

	}
	public void processExport(){

		AuthModel aModel=AuthModel.getInstance();
		if(!aModel.isValidOperation("SuperPrivilege")){
			JOptionPane.showMessageDialog(null, "当前用户无更改权限!");
			return;
		}

		try{
			JFileChooser jfc = new JFileChooser();
			FileNameExtensionFilter ff = new
			javax.swing.filechooser.FileNameExtensionFilter(".xls", "xls");
			jfc.setFileFilter(ff);
			int result = jfc.showSaveDialog(null);
			if (result != 0) return ;
			File file = jfc.getSelectedFile();
			model.exportExcel(file.getAbsolutePath() + ".xls");
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Export failed");
			JFrameGui.getGui().showStatus("Export failed");
			return;
		}
		JOptionPane.showMessageDialog(null, "导出成功");
		JFrameGui.getGui().showStatus("导出成功");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


