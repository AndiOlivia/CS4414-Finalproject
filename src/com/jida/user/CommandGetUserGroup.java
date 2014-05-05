package com.jida.user;

import java.util.Date;


import java.util.List;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.gui.JFrameGuiSuper;
import com.jida.server.Command;
import com.jida.server.IOThread;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.server.data.MonitorLog;
import com.jida.server.data.Workstation;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandGetUserGroup extends Command {
	static Logger logger=Logger.getLogger(CommandGetUserGroup.class);

	private User user;
	private User userItem;
//	private String cond;
	private List<Group> list;
//	private List<MonitorLog> listMon;
	//	private List<Payment> listPayment;
	public CommandGetUserGroup(User user,User userItem){
		this.user=user;
		this.userItem=userItem;
//		this.cond=cond;
		//		this.list=list;

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
		try{
			System.out.println("CommandGetUserGroup:execute:user="+user);
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//工作站列表

			list=model.get(user);
			return;


		}
		catch(Exception e){
			logger.error("User getting:",e);
			throw e;
		}

			
	}
	

	public List<Group> getList() {
		return list;
	}
	
	public User getUser(){
		return user;
	}
}
