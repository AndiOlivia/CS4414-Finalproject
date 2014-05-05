package com.jida.client;

import java.util.HashMap;



import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.UIManager; 
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;
  
import com.jida.MvcProperties;
import com.jida.fee.ControllerFeeImpl;
import com.jida.fee.ModelFee;
import com.jida.fee.ModelFeeDBImpl;
import com.jida.fee.ViewFee;
import com.jida.fee.ViewFeeImpl;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
import com.jida.product.ControllerProductImpl;
import com.jida.product.ModelProduct;
import com.jida.product.ModelProductDBImpl;
import com.jida.product.ViewProduct;
import com.jida.product.ViewProductImpl;
import com.jida.server.MainServer;
import com.jida.user.CommandUpdateUser;
import com.jida.user.ControllerPrivilegeImpl;
import com.jida.user.ViewUser;
import com.jida.user.ViewUserImpl;
import com.jida.user.ViewPrivilegeImpl;
import com.jida.user.db.ModelDBImplPrivilege;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.gui.JSplashScreen;
import com.jida.user.gui.LoginSR4000;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ModelUser;
import com.jida.user.intf.ViewPrivilege;

public class Main{
//	static Logger logger=Logger.getLogger(Main.class);

	
	public static Map models=new HashMap();

	private transient ChangeListener cl = null;

	private void init() throws Exception { 
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		try {
			JFrameGuiSuper.gui=JFrameGui.getGui();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		JSplashScreen.strDisplay="Loading Safety Module...";
		try {
			ModelPrivilege modelPrivilege=ModelDBImplPrivilege.getInstance();
//			MainServer.models.put("Privilege", modelPrivilege);
			ViewPrivilege viewPrivilege=new ViewPrivilegeImpl(modelPrivilege);
			new ControllerPrivilegeImpl(modelPrivilege,viewPrivilege);
			
			ModelUser modelUser=ModelUserDBImpl.getInstance();
//			MainServer.models.put("User", modelUser);
			ViewUser viewUser=new ViewUserImpl(modelUser);
			
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSplashScreen.strDisplay="Loading Safety Module...";
 		try {
			ModelProduct modelProduct=ModelProductDBImpl.getInstance(); 
//			MainServer.models.put("Privilege", modelPrivilege);
			ViewProduct viewProduct=new ViewProductImpl(modelProduct);
			new ControllerProductImpl(modelProduct,viewProduct);
			
			ModelUser modelUser=ModelUserDBImpl.getInstance();
//			MainServer.models.put("User", modelUser);
			ViewUser viewUser=new ViewUserImpl(modelUser);
			
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSplashScreen.strDisplay="Loading Fee Module...";
 		try {
			ModelFee modelFee=ModelFeeDBImpl.getInstance(); 
//			MainServer.models.put("Privilege", modelPrivilege);
			ViewFee viewFee=new ViewFeeImpl(modelFee);
			new ControllerFeeImpl(modelFee,viewFee);
			
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSplashScreen.strDisplay="User and prililege...";
		try {
			ModelPrivilege modelPrivilege=ModelDBImplPrivilege.getInstance();
//			MainRemote.models.put("Privilege", modelPrivilege);
			//Delete 20130907
			ViewPrivilege viewPrivilege=new ViewPrivilegeImpl(modelPrivilege);
			new ControllerPrivilegeImpl(modelPrivilege,viewPrivilege);
			
			ModelUser modelUser=ModelUserDBImpl.getInstance();
			//Delete 20130907
//			MainRemote.models.put("User", modelUser);
			ViewUser viewUser=new ViewUserImpl(modelUser);
//			new ControllerUserImpl(modelUser,viewUser);
			
//			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginSR4000.progressValue=100; 
//		Thread.sleep(1000);
		
		JFrameGuiSuper.gui.setVisible(true);
//		Thread.sleep(1000);
		
		JFrameGuiSuper.gui.progressEnd();
	}

	public Main() throws Exception {
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
			
			new Main();
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

