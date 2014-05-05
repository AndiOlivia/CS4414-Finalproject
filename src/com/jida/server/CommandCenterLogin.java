package com.jida.server;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import com.jida.server.data.MonitorLog;
import com.jida.server.data.Workstation;
import com.jida.user.domObject.User;
import com.jida.util.ToolKit;
//import com.jy.client.user.domObject.User;
/**
 * 控制指挥中心登录命令
 * @author YY
 *
 */
public class CommandCenterLogin extends Command {
//	private User user;
	private boolean re;
	private String wksName;
	private List<Workstation> list;
	private List<MonitorLog> listMon;
	public CommandCenterLogin(User user,String wksName){
		this.user=user;
		this.wksName=wksName;
	}
	public CommandCenterLogin(User user){
		this.user=user;
//		this.wksName=wksName;
	}
	/**
	 * 控制指挥中心登录实现：首次登录时，出现对话框加入；否则在服务器的控制指挥中心面板上显示登录信息
	 */
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		model=(ModelServerImpl)MainServer.models.get("Server");
		System.out.println("CommandCenterLogin:execute:"+user);
		re=model.validateCenter(user);
		
		if(!re)
			return ;
		
		//登录成功，显示在服务器上的监控列表上
		MonitorLog w=null;
		if((w=model.existsCenter(user.getHostId()))==null){
			w=new MonitorLog();
			w.setDate(new Date());
			w.setHostId(user.getHostId());
			w.setName(user.getName());
			w.setIp(this.getSkt().getInetAddress().getHostAddress());
			w.setSkt(this.getSkt());
			w.setTh(((IOThread)(Thread.currentThread())));
			w.setWksName(wksName);
			model.insert(w);
		}
		else{
			w.setDate(new Date());
			w.setHostId(user.getHostId());
			w.setName(user.getName());
			w.setIp(this.getSkt().getInetAddress().getHostAddress());
			w.setSkt(this.getSkt());
			w.setWksName(wksName);
			w.setTh(((IOThread)(Thread.currentThread())));
//			model.insert(w);
		}
		
		//Update 20131114
		listMon=model.getCenter(user);
		if(user.hasPrivilege("SuperPrivilege")){
			list=model.getWorkstationsCurr(0);
			return;
		}
		list=model.get(user.getT1());
	}
	public boolean get(){
		return re;
	}
	public List<Workstation> getList(){
		return list;
	}
	public User getUser(){
		return user;
	}
	public List<MonitorLog> getListMon(){
		return listMon;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//192.168.21.150
