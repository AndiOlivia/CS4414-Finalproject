package com.jida.user;
import java.util.Date;

import java.util.List;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
//import com.jida.client.ModelServer;
import com.jida.gui.JFrameGuiSuper;
import com.jida.server.Command;
import com.jida.server.IOThread;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.server.data.MonitorLog;
import com.jida.server.data.Workstation;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandSetState extends Command{
	static Logger logger=Logger.getLogger(CommandGetState.class);
	private User user;
	
//	private String oldPassword;
//	private String passwordNew;
	private byte state;
	
	//	private List<Payment> listPayment;
	public CommandSetState(User user,byte state){
		this.user=user;
		this.state=state;
		user.setState(state);
//		this.passwordNew=passwordNew;
	}
	public CommandSetState(User user){
		this.user=user;
//		this.state=state;
//		user.setState(state);
//		this.passwordNew=passwordNew;
	}
	
	/**
	 * 工作站登录实现：首次登录时，出现对话框加入；否则在服务器的工作站面板上显示登录信息
	 */
	@Override
	public void execute() throws Exception {	
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.setState(user);
		
		}
		catch(Exception e){
			logger.error("CommandChangePwd:"+user,e);
			throw e;
		}

		//		System.out.println("CommandLogin:execute:map="+TempretureController.map);
		//		System.out.println("CommandLogin:execute:mapWKS="+TempretureController.mapWKS);
	}
	public int getState(){
		return user.getState();
	}
}
