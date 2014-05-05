package com.jida.server;

import java.util.HashMap;


import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jida.View;
import com.jida.client.Main;
import com.jida.fee.ModelFeeDBImpl;
import com.jida.fee.ModelFee;
import com.jida.fee.ViewFee;
import com.jida.fee.ViewFeeImpl;
import com.jida.gui.JFrameGuiSuper;
//import com.jida.Main;
//import com.jida.gui.JFrameGui;
import com.jida.user.ControllerPrivilegeImpl;
import com.jida.user.ViewUser;
import com.jida.user.ViewUserImpl;
import com.jida.user.ViewPrivilegeImpl;
import com.jida.user.db.ModelDBImplPrivilege;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.gui.JSplashScreen;
//import com.jida.user.gui.Login;
import com.jida.user.gui.LoginSR4000;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ModelUser;
import com.jida.user.intf.ViewPrivilege;
//import com.jy.db.ModelBusinessRemindDBImpl;
//import com.jy.db.ModelFeedBackDBImpl;
//import com.jy.db.ModelBusinessRemindDBImpl;
//import com.jy.db.ModelFeedBackDBImpl;
//import com.jy.db.ModelInvoiceDBImpl;
//import com.jy.intf.ModelPrivilege;
//import com.jy.intf.ModelUser;
//import com.jy.db.ModelProductDBImpl;
//import com.jy.db.ModelReturnToVisitDBImpl;
/**
 * 鑫源集中供热系统管理服务器，无GUI
 */
public class MainServer { 
	public static  Map models=new HashMap();
//	public static JFrameGuiServer gui;

//	ViewHistoryTemp viewHistoryTem;

	private transient ChangeListener cl = null;

	public static void main(String argv[]){
		try {
			new MainServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void init() throws Exception {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
//		JSplashScreen.strDisplay="服务器建立...";
		
		//S1 
//		try {
//			JFrameGuiSuper.gui=JFrameGuiServer.getGui();
//		} catch (RuntimeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JSplashScreen.strDisplay="加载系统配置信息";
		//S1
		try { 
//			ModelTemCon model=ModelDBImplTemCon.getInstance();
//			MainServer.models.put("TemCon", model);
			//Delete 20130907
//			ViewTemCon viewTemCon=new ViewWorkstationImpl(modelServer);
//			ViewTemCon viewCenter=new ViewCenterImpl(modelServer);
//			new ControllerTemConImpl(modelTemCon,viewTemCon);
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//S2
		try { 
			ModelServer modelServer=ModelServerImpl.getInstance();
			MainServer.models.put("Server", modelServer);
			//Delete 20130907
//			ViewTemCon viewTemCon=new ViewWorkstationImpl(modelServer);
//			ViewTemCon viewCenter=new ViewCenterImpl(modelServer);
//			new ControllerTemConImpl(modelTemCon,viewTemCon);
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//S3
		try {
//			ModelWorkstation model=ModelDBImplWorkStation.getInstance();
			IoStrategy brokerServer=new BrokerServer((ModelServerImpl)models.get("Server"));
			IoStrategy ioPoolManager=new IOThreadPoolManager(brokerServer);
			new Server(ioPoolManager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		JSplashScreen.strDisplay="加载安全管理功能模块";
		try {
			ModelPrivilege modelPrivilege=ModelDBImplPrivilege.getInstance();
			MainServer.models.put("Privilege", modelPrivilege);
			//Delete 20130907
//			ViewPrivilege viewPrivilege=new ViewPrivilegeImpl(modelPrivilege);
//			new ControllerPrivilegeImpl(modelPrivilege,viewPrivilege);
			
			ModelUser modelUser=ModelUserDBImpl.getInstance();
			//Delete 20130907
			MainServer.models.put("User", modelUser);
//			UserView viewUser=new UserViewImpl(modelUser);
			
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JSplashScreen.strDisplay="加载工作站注册管理模块";
		try {
//			ModelWksReg model=ModelWksRegDBImpl.getInstance();
//			MainServer.models.put("WksReg", model);
			//Delete 20130907
//			View view=new ViewWksRegImpl(model);
//			new ControllerWksRegImpl(model,view);
			//MainServer.models.put("TemCon", modelTemCon);
//			modelTemCon.createMap();
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JSplashScreen.strDisplay="加载客户厂商管理模块";
		try {
//			ModelCustomer model=ModelCustomerDBImpl.getInstance();
//			MainServer.models.put("Customer", model);
			//Delete 20130907
//			ViewCustomer view=new ViewCustomerImpl(model);
//			new ControllerCustomerImpl(model,view);
			//MainServer.models.put("TemCon", modelTemCon);
//			modelTemCon.createMap();
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JSplashScreen.strDisplay="加载工程管理模块";
		try {
//			ModelEngineer model=ModelEngineerDBImpl.getInstance();
//			MainServer.models.put("Engineer", model);
			//Delete 20130907
//			View view=new ViewEngineerImpl(model);
//			new ControllerEngineerImpl(model,view);
			//MainServer.models.put("TemCon", modelTemCon);
//			modelTemCon.createMap();
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JSplashScreen.strDisplay="加载TemConLog";
		try { 
//			ModelElectricityMeasure modelElectricityMeasure=ModelElectricityMeasureDBImpl.getInstance();
//			Main.models.put("ElectricityMeasure", modelElectricityMeasure);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Delete20120217　Add 20130909
		try { 
//			ModelHistoryTem modelHistoryTem=ModelDBImplHistoryTem.getInstance();
//			MainServer.models.put("HistoryTem", modelHistoryTem);
//			viewHistoryTem=new ViewHistoryTempImpl("实时温度",modelHistoryTem,true);
//			new ControllerHistoryTemImpl(modelHistoryTem,viewHistoryTem);
			
//			ViewHistoryTemp viewHistoryTem2=new ViewHistoryTempImpl("历史温度",modelHistoryTem,false);
			
//			new ControllerHistoryTemImpl(modelHistoryTem,viewHistoryTem2);
			
//			ViewHistoryTemD8D9 viewD8D9=new ViewHistoryTemD8D9Impl(modelHistoryTem);
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//End
//		System.out.println(models);

	}

	public MainServer() throws Exception {
		this.init();
	}


//	public static void main(String [] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new Main();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public static void initApplication(){
		try {
//			loginUI.setVisible(false);
			
			new MainServer();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

