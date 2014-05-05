package com.jida.main;

import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.AuthView;

/**
 * 原服务器，现已改，远程服务器管理器：com.jida.remoteManagement.main.ProgramEntrance,此已不用
 * @author Administrator
 *
 */
public class ProgramEntrance {

	private AuthModel model;
//	private AuthView view;

	public ProgramEntrance() {
		this.model = AuthModel.getInstance();
		new AuthView(model,AuthSession.SERVER);
//		this.view.toString(); 
	}
//	public ProgramEntrance(int objective) {
//		this.model = AuthModel.getInstance();
//		new UserLoginViewImpl(model);
////		this.view.toString();
//	}

	public static void main(String[] args) {
//		if(args.length>0  && "user".equalsIgnoreCase(args[0]))
			new ProgramEntrance();
		
//		else{
//			new ProgramEntrance();
//		}
	}
}
