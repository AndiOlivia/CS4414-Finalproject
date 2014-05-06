﻿package com.jida.user;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;



import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.client.Client;
import com.jida.client.InvalidUserException;
import com.jida.gui.JFrameGui;
import com.jida.server.CommandLogin;
//import com.jida.server.CommandPayment;
import com.jida.server.data.Workstation;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class AuthModel {
	Logger logger=Logger.getLogger(AuthModel.class);
	private AuthView view;
	private AuthSession session;
	private  ConnectionPool connectionPool;
	private  List<Workstation> list;/*brandi*/
	private static AuthModel inst;
	//New 20111108 by Brandi
	private int dllType;
	private Client client;
	public static AuthModel getInstance() {
		return inst==null?(inst=new AuthModel()):inst;
	}

	private AuthModel() {
		this.startSession();
	}
	public AuthModel(int objective) {
		this.startSession();
		this.session.setObjective(objective);
	}
	public void addViewListener(AuthView view) {
		this.view = view;
	}
//	public void addViewListener(InBaseLevelAuthView inbaseview) {
//	this.view = inbaseview;
//	}
//	public void addViewListener(InBaseWeightAuthView inbaseview) {
//	this.view = inbaseview;
//	}

//	public static String[] getDBUser() throws Exception{
//	ConnectionPool connectionPool=ConnectionPool.getInstance();
//	Connection conn=connectionPool.getConnection();
//	Statement stmt=conn.createStatement();
//	String sql = "SELECT [user_name] FROM [UserGroup] WHERE [group_group_name] = 'InBase'";
//	ResultSet rs=stmt.executeQuery(sql);
//	connectionPool.releaseConnection(conn);
////	int n=rs.getFetchSize();
////	int n=10;
////	int i=0;
//	List list=new ArrayList();

////	String[] s=new String[n];
//	while(rs.next()){
//	list.add(rs.getString("user_name"));
////	i++;
//	}
//	String[] s=new String[list.size()];
//	for(int i=0;i<list.size();i++){
////	list.add(rs.getString("user_name"));
//	s[i]=(String)list.get(i);
////	i++;
//	}
//	return s;
//	}
		/**
	 * 服务器登录
	 */
	public boolean isUserValid2(User user) throws Exception {
		ConnectionPool connectionPool=ConnectionPool.getInstance(MvcProperties.dbName);
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql =String.format("SELECT * FROM user WHERE username = '%s' and password='%s' and state=1",
		user.getName() ,user.getPassword());

//		if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//		sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//		}
		ResultSet rs=null;
		try{
			rs=stmt.executeQuery(sql);

		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		
		ModelUser modelUser=ModelUserDBImpl.getInstance();
		//users=new ArrayList<User>();/////
		String s;
		if(rs.next()){
			//User user=new User();
			user.setName(rs.getString("username"));
			user.setPassword((s=rs.getString("password"))!=null?s.trim():null);
			user.setId((s=rs.getString("id"))!=null?s.trim():null);
			user.setTel((s=rs.getString("tel"))!=null?s.trim():null);
			user.setMobile((s=rs.getString("mobile"))!=null?s.trim():null);
			user.setProvince((s=rs.getString("province"))!=null?s.trim():null);
			user.setCity((s=rs.getString("city"))!=null?s.trim():null);
			user.setAddr((s=rs.getString("addr"))!=null?s.trim():null);
			user.setPostCode((s=rs.getString("postCode"))!=null?s.trim():null);
			user.setState(rs.getByte("state"));
			user.setT1(rs.getString("t1"));
			user.setT2(rs.getString("t2"));

//			sql="select userGroup.username,userGroup.groupname,groupprivilege.privilegename from userGroup inner join grouptable on userGroup.groupname=grouptable.groupname inner join groupPrivilege on groupPrivilege.groupname=grouptable.groupname where userGroup.username='"
//				+user.getName()+"' order by usergroup.groupname ASC";

//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
//			rs=stmt.executeQuery(sql);

//			connectionPool.releaseConnection(conn);

//			user.setGroups(new ArrayList<Group>());/////
//			Group old=null;
//			while(rs.next()){
//				Group group=new Group();
//				group.setName(rs.getString("groupname"));
//				Privilege pri=new Privilege();
//				pri.setPriName(rs.getString("privilegename"));
//				if(old!=null && old.equals(group)){
//					old.addPrivilege(pri);
//				}
//				else{
//					group.addPrivilege(pri);
//					user.addGroup(group);
//					old=group;
//				}
////				group.setDesc(rs.getString("groupdesc"));
//
//			}
			//this.users.add(user);
			modelUser.get(user);
			System.out.println("AuthModel:isUserValid2:"+user);
			//--------------------------------export to csv-------------------------------
			String dir = System.getProperty("user.dir") + "\\Expenses.csv"; //get the current working directory
			try
			{
				FileWriter writer = new FileWriter(dir);
				String qqq = "select * from product";
				String fff = "select * from Fee";
				Statement ststst = conn.createStatement();
				Statement sss = conn.createStatement();
				ResultSet rsrsrs = ststst.executeQuery(qqq);
				ResultSet rfrfrf = sss.executeQuery(fff);
				writer.append("Products:");
				writer.append('\n');
				while (rsrsrs.next())
				{
					writer.append(rsrsrs.getString(1));
					writer.append(',');
					writer.append(rsrsrs.getString(2));
					writer.append(',');
					writer.append(rsrsrs.getString(3));
					writer.append('\n');
				}
				
				writer.append('\n');
				writer.append("Fees:");
				writer.append('\n');
				while (rfrfrf.next())
				{
					writer.append(rfrfrf.getString(1));
					writer.append(',');
					writer.append(rfrfrf.getString(2));
					writer.append(',');
					writer.append(rfrfrf.getString(3));
					writer.append(',');
					writer.append(rfrfrf.getString(4));
					writer.append(',');
					writer.append(rfrfrf.getString(5));
					writer.append(',');
					writer.append(rfrfrf.getString(6));
					writer.append(',');
					writer.append(rfrfrf.getString(7));
					writer.append(',');
					writer.append(rfrfrf.getString(8));
					writer.append('\n');
				}
				writer.flush();
				writer.close();
			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			} 
			//----------------------------------------------------------------------------
//			if(user.getType()==AuthSession.SERVER && (user.hasPrivilege("ServerOp")))
//				return true;
			//New 20130201
//			if(user.getType()==AuthSession.LOGINALONE && (user.hasPrivilege("ClientOp,SuperPrivilege"))	)
			return true;
		}
		return false;
	}

	public void startSession() {
		if(session != null) {
			JOptionPane.showMessageDialog(view.getLoginUI(),"用户SESSION已经开始。", "SESSION ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			this.session = AuthSession.getInstance();
		}
	}
	/**
	 * 网络客户登录
	 * @param user
	 * @return
	 */
	public boolean isUserValid(User user){
//		user.setHostId(UserGenerate.getMac());
//		User us=UserGenerate.generatePassword(user.getName(), UserGenerate.getMac());
//		return user.getName().equals(us.getName()) && user.getPassword().equals(us.getPassword());
//		user.setHostId(UserGenerate.getMacOnWindow());//getMac());
//		System.out.println("AuthModel:isUserValid:"+user);
//		Client client=Client.getInstance();
//		
//		CommandLogin comLogin=null;
		
				return false;
	}
	/**
	 * 单机客户登录
	 * @param user
	 * @return
	 */
	public boolean isUserValid1(User user){
//		User us=UserGenerate.generatePassword(user.getName(), UserGenerate.getMacOnWindow());
//		return user.getName().equals(us.getName()) && user.getPassword().equals(us.getPassword());
//		return UserGenerate.valid(user.getName(), user.getPassword());
		return false;
	}
	
	public void login(User user) throws Exception {
		switch(user.getType()){
		case 0://网络客户
			//System.out.println("AuthModel:login:client network login:"+user);
			if (this.isUserValid2(user)) {
//				user.setType((short)session.LOGINNORMAL);
//				System.out.println("AuthModel:login:net user:"+user+"--session="+this.session);
				this.session.login(user);
				
//				System.out.println("AuthModel:login:session user:"+session.getUser());
			}
			else {
				throw new InvalidUserException("Invalid User " + user.getName());
			}
			break;
		case 3://控制指挥中心
			//System.out.println("AuthModel:login:center login:"+user);
//			if (this.isUserValid3(user)) {
			//	user.setType((short)session.MONITORCENTER);
				
//				this.session.login(user);
//			}
//			else {
//				throw new InvalidUserException("Invalid User " + user.getName());
//			}
			break;
		case 1://单机客户
			//System.out.println("AuthModel:login:client alone login:"+user);
			if (this.isUserValid2(user)) {
//			if (this.isUserValid2(user)) {//Update 20111012 单机工作方式在本地校验身份
				//user.setType((short)session.LOGINALONE);
				this.session.login(user);
			}
			else {
				throw new InvalidUserException("Invalid User " + user.getName());
			}
			break;
		case 2://服务器
			//System.out.println("AuthModel:login:Server login:"+user);
			if (this.isUserValid2(user)) {
			//	user.setType((short)session.SERVER);
//				this.session.login(user);
				
			}
			else {
				throw new InvalidUserException(user.getName()+"用户无效或无服务器登录权限");
			}
			break;
		}
	}

	public void logout() {
		this.session.logout();
	}

	public boolean isAreadyLoggedIn() {
		return this.session.isSessionActive();
	}

	public User getUser() {
		return this.session.getUser();
	}

	public  static final int GET=1;
	public static final int INSERT=2;
	public static final int DELETE=3;
	public static final int UPDATE=4;
	public static final int USERMAN=5;

	public static final int ALL=1;
	public static final int READ=2;
	public static final int READBYCOND=3;
	public static final int PRODUCTREAD=4;

	/**
	 * to decide if the user have a right to op
	 * 
	 * @param user
	 * @param op
	 * @return
	 */	
	public static boolean isValidOperation(String op){
		User user=AuthSession.getInstance().getUser();
		return user.hasPrivilege(op);
	}
	/**
	 * user有权限op吗？
	 * @param user
	 * @param op
	 * @return
	 */
	public static boolean isValidOperation(User user,String op){
//		User user=AuthSession.getInstance().getUser();
//		String ss[]=op.split(",");
//		List<Group> list=user.getGroups();
//		for(Group g:list){
//			for(String s:ss){
//				if(g.getName().equalsIgnoreCase(s)){
//					return true;
//				}
//				if(g.getprivileges()==null){
//					continue;
//				}
//				//New 20130120
//				for(Privilege ps:g.getprivileges()){
//					if(ps.getPriName().equalsIgnoreCase(s))
//						return true;
//				}
//			}
//		}
//		return false;
		return user.hasPrivilege(op);
	}
	/**
	 * to get the query condition for user.Note the product-get is not controlled  
	 * @param user
	 * @param op
	 * @return
	 */
	public static String getCond(int op){
		User user=AuthSession.getInstance().getUser();
//		switch(user.getType()){
//		case 0:
//		return "";
//		case 1:
//		case 2:
//		return "employee='"+user.getName()+"'";
//		default:
//		return null;

//		}
		return "";
	}
	public List<Workstation> getList(){
		return list;
	}
	
	public static void main(String s[]){
		User user=new User();
		user.setName("wangming");
		user.setPassword("0000");
		try {
			System.out.println(new AuthModel().isUserValid2(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setList(List<Workstation> list) {
		this.list = list;
	}
	
	
	public void setDll(int dllType){
		this.dllType=dllType;
	}
	public int getDll(){
		return dllType;
	}
}
