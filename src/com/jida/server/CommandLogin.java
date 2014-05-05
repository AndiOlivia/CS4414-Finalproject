package com.jida.server;

import java.io.File;


import java.util.Date;
import java.util.List;

import com.jida.MvcProperties;
import com.jida.client.Main;
import com.jida.gui.JFrameGuiSuper;
import com.jida.server.data.Workstation;
import com.jida.util.ToolKit;
import com.jida.user.domObject.User;

/**
 * 工作站登录命令
 * @author YY
 *
 */
public class CommandLogin extends Command {
	private User user;
	private boolean re;
//	private String cause;
	public CommandLogin(User user){
		this.user=user;


		
//		this.listPayment=listPayment;
//		System.out.println("CommangLogin:CommandLogin:"+list);
		
	}
//	public CommandLogin(User user){
//		this.user=user;
////		this.list=list;
//	}
	/**
	 * 工作站登录实现：首次登录时，出现对话框加入；否则在服务器的工作站面板上显示登录信息
	 */
	@Override
	public void execute() throws Exception {
		model=(ModelServerImpl)MainServer.models.get("Server");
//		System.out.println("CommandLogin:execute:bmap="+TempretureController.map);
//		System.out.println("CommandLogin:execute:bmapWKS="+TempretureController.mapWKS);
		// TODO Auto-generated method stub
//		System.out.println("CommandLogin:execute:"+user);
		re=model.validate(user);
//		System.out.println("CommandLogin:execute:list=:"+list);
		if(!re)
			return ;
		Workstation w=null;
		if((w=model.exists(user.getHostId()))==null){
			//Delete 20131015
//			DialogWks dialog=new DialogWks("新增工作站",user.getHostId());
//			dialog.setModal(true);
//			
//			w=dialog.wks;
//			w.setName(user.getName());
//			w.setDate(new Date());
//			w.setSkt(this.getSkt());
//			if(this.getSkt()!=null)
//				w.setIp(this.getSkt().getInetAddress().getHostAddress());
//			//System.out.println("CommandLogin:execute:"+w.getIp());
//			if(w!=null){
//				model.insert(w);
//			}
//			dialog=null;
//			
//			try{
//				ModelHistoryTem model=(ModelHistoryTem)MainServer.models.get("HistoryTem");
//				model.createTableHistoryTem("tem"+w.getPostCode());
//				
//				//New 20110314 在历史温度面板，重置工作站列表
////				PanelHistoryTem panel=(PanelHistoryTem)Main.gui.getPanel("历史温度");
////				
////				panel.setJComboBoxWk(((com.jida.server.ModelServer)(MainServer.models.get("Server"))).get());
//			}
//			catch(Exception e){
//				MvcProperties.write("createTableHistoryTem:",e);
//			}
//			w.setTh(((IOThread)(Thread.currentThread())));
			
			user.setResult("工作站未注册，请先注册工作站！");
			re=false;
		}
		else{
			
			w.setName(user.getName());
			w.setDate(new Date());
			w.setIp(this.getSkt().getInetAddress().toString());
			//New 20110104
			w.setSkt(this.getSkt());
			w.setTh(((IOThread)(Thread.currentThread())));
			
			if(model instanceof ModelServerImpl)
				((ModelServerImpl)model).fireModelChange();
//			System.out.println("CommandLogin:execute:"+w.getPostCode()+w.getIp()+new Date());
		}
	
	}
	public boolean get(){
		return re;
	}
	public User getUser(){
		return user;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
