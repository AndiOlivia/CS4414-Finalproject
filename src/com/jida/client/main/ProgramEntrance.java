package com.jida.client.main;


import java.io.File;


//import com.jida.client.MachineCode;
import com.jida.user.AuthModel;
import com.jida.user.AuthView;

public class ProgramEntrance {
	private AuthModel model;
//	private AuthView view;

	public ProgramEntrance() {
		this.model = AuthModel.getInstance();
//		int mode=Integer.parseInt(MachineCode.getInstance().getMode());
		new AuthView(model,0);//login as normal client, previously as server
//		this.view.toString();
	}
//	public ProgramEntrance(int objective) {
//		this.model = AuthModel.getInstance();
//		new UserLoginViewImpl(model);
////		this.view.toString();
//	}

	public static void main(String[] args) {
//		if(args.length>0  && "user".equalsIgnoreCase(args[0]))
//			MachineCode mc=MachineCode.getInstance();
//			if(mc.isFirst()){
//				mc.getRCFromServer();
//				return;
//			}
			new ProgramEntrance();
		
//		else{
//			new ProgramEntrance();
//		}
	}
	
	
	
	
	
}
