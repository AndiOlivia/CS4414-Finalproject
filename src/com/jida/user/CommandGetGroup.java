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

public class CommandGetGroup extends Command {
	static Logger logger=Logger.getLogger(CommandGetGroup.class);

	private User user;
//	private User userItem;
	private String cond;
	private List<Group> list;
//	private List<MonitorLog> listMon;
	//	private List<Payment> listPayment;
	public CommandGetGroup(User user){
		this.user=user;
//		this.cond=cond;
	}
	
	public CommandGetGroup(String cond){
//		this.user=user;
		this.cond=cond;
	}
	
	/**
	 * 工作站登录实现：首次登录时，出现对话框加入；否则在服务器的工作站面板上显示登录信息
	 */
	@Override
	public void execute() throws Exception {	
		try{
			System.out.println("CommandGetGroup:execute:cond="+cond);
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//工作站列表
			if(user==null){
				list=model.getGroup(cond);
			}
			else{
				list=model.get(user);
			}
		}
		catch(Exception e){
			logger.error("User getting:",e);
			throw e;
		}

			
	}
	

	public List<Group> getList() {
		return list;
	}
//	public void setList(List<User> list) {
//		this.list = list;
//	}


	public User getUser(){
		return user;
	}
}
