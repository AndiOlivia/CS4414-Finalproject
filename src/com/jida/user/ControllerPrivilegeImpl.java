package com.jida.user;

import javax.swing.JOptionPane;

import com.jida.user.domObject.Privilege;
import com.jida.user.intf.ControllerPrivilege;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ViewPrivilege;
//import com.jy.intf.ControllerPrivilege;
//import com.jy.intf.ModelPrivilege;

public class ControllerPrivilegeImpl implements ControllerPrivilege {
	private ModelPrivilege model;
	private ViewPrivilege view;
	public ControllerPrivilegeImpl(ModelPrivilege model,ViewPrivilege view){
		this.model=model;
		this.view=view;
		this.view.addControllerListener(this);
	}
	
	public void processDelete(Privilege pri)  {
		// TODO Auto-generated method stub
		//validate
		AuthModel aModel=AuthModel.getInstance();
		if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(null, "确定删除"+pri+"吗？")){
			return ;
		}
		
		if(!aModel.isValidOperation("SuperPrivilege")){
			JOptionPane.showMessageDialog(null, "当前用户无操作权限!");
			return;
		}
		//delete by model
		try {
			model.delete(pri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void processInsert(Privilege pri)  {
		// TODO Auto-generated method stub
		//validate
		AuthModel aModel=AuthModel.getInstance();
		if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(null, "确定删除"+pri+"吗？")){
			return ;
		}
		
		if(!aModel.isValidOperation("SuperPrivilege")){
			JOptionPane.showMessageDialog(null, "当前用户无操作权限!");
			return;
		}
		//delete by model
		try{
			model.insert(pri);
		}
		catch(Exception e){
			
		}
	}

	
	public void processUpdate(Privilege pri)  {
		// TODO Auto-generated method stub
		//validate
		AuthModel aModel=AuthModel.getInstance();
		
		if(!aModel.isValidOperation("SuperPrivilege")){
			JOptionPane.showMessageDialog(null, "当前用户无操作权限!");
			return;
		}
		//delete by model
		
		try {
			model.update(pri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
