package com.jida.server;

import java.net.Socket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//import javax.swing.JOptionPane;

import com.jida.MvcProperties;
import com.jida.View;
import com.jida.gui.panel.ShowMessageDialog;
import com.jida.server.data.MonitorLog;
import com.jida.server.data.Workstation;
import com.jida.user.AuthModel;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public interface ModelServer {
	/**
	 * 用户登录验证：验证通过时，加入工作站列表，并刷新工作站显示列表
	 * @param user　来自工作站的用户
	 * @return
	 */
	public boolean validate(User user);
	/**
	 * 用户登录验证：验证通过时，返回
	 * @param user　来自控制中心的用户
	 * @return
	 */
	public boolean validateCenter(User user);
	public boolean validateServer(User user);
	
	
	//工作站操作
		
	public  Map<String,List<Workstation>> get()throws Exception;
	public List<Workstation> get(User user)throws Exception;
	public List<Workstation> get(String t1)throws Exception;
	public Workstation getWks(String skt);
	
	public void addViewListener(View view);
	/**
	 * get workstation name by mac. New 20110107
	 * @param mac
	 * @return
	 */
	public String getWksName(String mac);
	public List<MonitorLog> getCenter(String t1)throws Exception;
	public List<MonitorLog> getCenter(User user)throws Exception;

//	public List<Workstation> get(String cond){
//		
//	}
	public void delete(Workstation wks) throws Exception;
	
	public void update(Workstation user)throws Exception;

	/**
	 * 插入工作站信息
	 * @param item
	 * @throws Exception
	 */
	public void insert(Workstation item)throws Exception;
	
	
	public int getIndex(Workstation user);
	
	/**
	 * 检测工作站是否存在
	 * @param hostId：工作站ID（邮政编码＋编号）
	 * @return
	 */
	public Workstation exists(String hostId);
	/**
	 * 检测控制指挥中心是否已存在
	 * @param hostId ：指挥中心ID
	 * @return
	 */
	public MonitorLog existsCenter(String hostId);
	public void insert(MonitorLog item) throws Exception;
	
	
	public void processExportWorkstation(String path);
	public void processExportCenter(String path);
	
	/**
	 * 获取当前显示状态下的工作站列表
	 * @param showState 显示状态   0：全部； 1：网站 ； 2：独立
	 * @return 工作站列表
	 */
	public List<Workstation> getWorkstationsCurr(int showState);
	
	public Workstation getByIndex(int index);
	public void addViewListenerCenter(View view);

	
}
