package com.jida.user;

import java.sql.Connection;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jida.MvcProperties;
import com.jida.client.Client;
import com.jida.server.Command;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.ViewUser;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;
//import com.jy.db.ConnectionPool;
//import com.jy.intf.ModelUser;

public class ModelUserNetImpl implements ModelUser {
	private List<User> users=null;
	private List<Group> groups=null;
//	private ConnectionPool connectionPool=ConnectionPool.getInstance();
	private Client client;
	private ViewUser view;
	private boolean dirty=true;
	private boolean dirtyGroup=true;
	private String cond=null;
	private String condGroup=null; 
	private String condBasic;
	//Singleton
	private static ModelUserNetImpl inst=new ModelUserNetImpl();
	public static ModelUser getInstance(){
		return inst;
	}
	private ModelUserNetImpl(){
		client=Client.getInstance();
	}
	public void changePassword(User user,String passwordNew) throws Exception {
		if(user.getState() == 0) {
			throw new Exception("被冻结用户不能修改密码");
		}
		
		CommandChangePwd com=new CommandChangePwd(user,passwordNew);
		client.write(com);
		Object obj=client.read();
		if(obj instanceof CommandChangePwd){
//			user.setPassword(passwordNew);
//			System.out.println("ModelUserNetImpl.changePassword() user="+user);
			return;
		}
		throw new Exception(obj.toString());

	}

	
	public boolean check(User user) throws Exception {
//		Connection conn=connectionPool.getConnection();
//		Statement stmt=conn.createStatement();
//		String sql="select * from user where username='"+user.getName()+"' and password='"+
//				user.getPassword()+"'";
//		
//		
//		ResultSet rs=stmt.executeQuery(sql);
//		
//		connectionPool.releaseConnection(conn);
//		if(rs.next()){
//			byte type=rs.getByte("state");
//			user.setState(type);
//			return true;
//		}
//		check=true;
//		String cond="username='"+user.getName()+"' and password='"+
//			user.getPassword()+"'";
//		List<User> l=this.getUser(cond);
////		check=false;
//		if(l!=null && l.size()>0){
//			user.copy(l.get(0));
//			System.out.println("ModelUserDBImpl:check user:"+user);
//			return true;
//		}
		return false;
	}

	
	public void delete(User user) throws Exception {
		CommandDeleteUser com=new CommandDeleteUser(AuthModel.getInstance().getUser(),user);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			users=this.getUser(cond);
			this.fireModelChange(users);
			return ;
		}
		throw new Exception("Delete  failed..."+user);
	}
	public void delete(Group group) throws Exception {
		CommandDeleteGroup com=new CommandDeleteGroup(AuthModel.getInstance().getUser(),group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirtyGroup=true;
			groups=this.getGroup(condGroup);
			this.fireModelChange(groups);
			return ;
		}
		throw new Exception("Delete failed..."+group);
	}

	
	public int getState(User user) throws Exception {
		CommandGetState com=new CommandGetState(user);
		
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			return ((CommandGetState)obj).getState();
		}
		throw new Exception("Get state failed:"+user);
	}
	public void setState(User user) throws Exception{
		CommandSetState com=new CommandSetState(user);

		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			return ;//((CommandGetState)obj).getState();
		}
		throw new Exception("Set state failed:"+user);	
	}
	public void update(User user) throws Exception{
		CommandUpdateUser com=new CommandUpdateUser(AuthModel.getInstance().getUser(),user);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			users=this.getUser(cond);
			this.fireModelChange(users);
			return ;
		}
		throw new Exception("Delete Customer failed..."+user);
	}
	
	public void delete(User user,Group group)throws Exception{
		CommandDeleteUserGroup com=new CommandDeleteUserGroup(AuthModel.getInstance().getUser(),user,group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			user.removeGroup(group.getName());
			this.fireModelChange(users);
			return ;
		}
		throw new Exception("Delete  failed..."+user+","+group);
	}
	public void delete(Group group,Privilege pri)throws Exception{
		CommandDeleteGroupPri com=new CommandDeleteGroupPri(AuthModel.getInstance().getUser(),group,pri);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
//			dirty=true;
//			groups=this.getGroup(condGroup);
			group.removePrivilege(pri.getPriName());
			this.fireModelChange(groups);
			return ;
		}
		throw new Exception("Delete  failed..."+group+pri);
	}
	
 	public List<Group> get(User user)throws Exception{		
 		CommandGetGroup com=new CommandGetGroup(user);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			return ((CommandGetGroup)obj).getList();
		}
		throw new Exception("Get by user  failed..."+user);
	}
 	
 	public List<Privilege> get(Group group)throws Exception{		
 		CommandGetPrivilege com=new CommandGetPrivilege(group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			return ((CommandGetPrivilege)obj).getList();
		}
		throw new Exception("Get privilege by group  failed..."+group);
	}
	public List<User> getUserByGroup(String groupName)throws Exception{
		//String cond="group_name='Agent'";
		List<User> users=getUser();
		List<User> ss=new ArrayList();
		for(User user:users){
			for(Group group:user.getGroups()){
				if(group.getName().equalsIgnoreCase(groupName)){
					ss.add(user);
					break;
				}
			}
		}
		return ss;
	}

	
	public List<User> getUser(boolean refresh) throws Exception {
		dirty=refresh && this.users!=null;
//		if(refresh || users==null){
			users=this.getUser(cond);
//		}
		return users;
	}
		
	public List<User> getUser(String cond) throws Exception {
		CommandGetUser com=new CommandGetUser(AuthModel.getInstance().getUser(),cond);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			users=((CommandGetUser)obj).getList();
//			this.fireModelChange(users);
			return users;
		}
		throw new Exception("Get users  failed..."+cond);
	}
	public List<Group> getGroup() throws Exception {
		return getGroup(null);
	}
	
	public List<Group> getGroup(boolean refresh) throws Exception {
		dirtyGroup=(refresh || this.groups==null);
//		if(refresh || users==null){
			groups=this.getGroup(this.condGroup);
//		}
		return groups;
	}
	
	public List<Group> getGroup(String condGroup) throws Exception {
		if(! dirtyGroup && (condGroup==this.condGroup  ||
				this.condGroup!=null && this.condGroup.equalsIgnoreCase(condGroup))){
				return groups;
		}
		
		this.condGroup=condGroup;
		
		dirtyGroup=false;
		
		
		CommandGetGroup com=new CommandGetGroup(condGroup);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			return ((CommandGetGroup)obj).getList();
		}
		throw new Exception("Get group  failed..."+condGroup);
	}
	public void update(Group group)throws Exception{
		CommandUpdateGroup com=new CommandUpdateGroup(group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
//			return ((CommandGetGroup)obj).getList();
			dirtyGroup=true;
			groups=this.getGroup(condGroup);
			this.fireModelChange(groups);
			return;
		}
		throw new Exception("Update group  failed..."+obj);
		

	}

//	public List<Privilege> get(Group g)throws Exception{
//		Connection conn=connectionPool.getConnection();
//		Statement stmt=conn.createStatement();
//		String sql="select privilege.privilegename,privilege.privilegedesc from groupprivilege inner join privilege on groupprivilege.privilegename=privilege.privilegename where groupPrivilege.groupname='"+g.getName()+"'";
//////		String sql="select groupname,groupdesc from grouptable ";
////		if(condGroup!=null){
////			sql+=" where "+condGroup;
////		}
////		sql+=" order by groupname ASC";
////		if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
////			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
////		}
//		ResultSet rs=stmt.executeQuery(sql);
//		
//		connectionPool.releaseConnection(conn);
//		List<Privilege> list=new ArrayList<Privilege>();/////
//		
//		while(rs.next()){
//			Privilege p=new Privilege();
//			p.setPriName(rs.getString("privilegename"));
//			p.setPriDesc(rs.getString("privilegedesc"));
//			list.add(p);
//			
//		}
//		
//		System.out.println("ModelUserDBImpl:getPrivilegeByGroup:"+list);
//		return list;
//	}
	
	public List<User> getUser() throws Exception {
		return getUser(null);
	}

	public void insert(User user) throws Exception {
		CommandInsertUser com=new CommandInsertUser(AuthModel.getInstance().getUser(),user);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			users=this.getUser(cond);
			this.fireModelChange(users);
			return ;
		}
		throw new Exception("Insert user failed..."+user);
		
	}
	/**
	 * 插入组  Update 20140322
	 */
	public void insert(Group group) throws Exception {
		CommandInsertGroup com=new CommandInsertGroup(group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirtyGroup=true;
			groups=this.getGroup(condGroup);
			this.fireModelChange(groups);
			return ;
		}
		throw new Exception(String.format("Inser group failed...%s:%s",group.toString(),obj.toString()));
	}
	public void insert(User user,Group group) throws Exception {
		CommandInsertUserGroup com=new CommandInsertUserGroup(user,group);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
//			dirty=true;
			user.addGroup(group);
			this.fireModelChange(users);
			return ;
		}
		throw new Exception("Insert user-group failed..."+user);	
	}
	public void insert(Group group,Privilege pri) throws Exception {
		CommandInsertGroupPri com=new CommandInsertGroupPri(group,pri);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
//			dirty=true;
			group.addPrivilege(pri);
			this.fireModelChange(groups);
			return ;
		}
		throw new Exception("Insert group-privilege failed..."+group+pri);	
	}
	public static void main(String s[])throws Exception{
		ModelUserNetImpl model=new ModelUserNetImpl();
//		System.out.println(model.getUserByGroup("Agents"));
//		User user=new User();
//		user.setName("wangming");
//		user.setPassword("0000");
//		user.setState((byte)1);
//		model.insert(user);
		
//		System.out.println(model.check(user));
//		user.setPassword("0000");
//		model.changePassword(user,"1111");
		System.out.println(model.getUser());
	}
	public int getIndex(User user){
		if(this.users==null){
			return -1;
		}
		for(int i=0;i<users.size();i++){
			if(users.get(i).equals(user)){
				return i;
			}
		}
		return -1;
	}
	public int getIndex(Group group){
		if(this.groups==null){
			return -1;
		}
		for(int i=0;i<groups.size();i++){
			if(groups.get(i).equals(group)){
				return i;
			}
		}
		return -1;
	}
	
	public void addViewListener(ViewUser view){
		this.view=view;
	}
	public void fireModelChange(Object obj){
//		this.dirty=true;
		if(view!=null){
			if(obj==groups)
				view.processModelChangeGroups(obj);
			else if(obj==users){
				view.processModelChange(obj);
			}
		}		
	}
//	public static String [] getAgents(){
//		String ss[]=null;
//		try{
//			ModelUserDBImpl userModel=new ModelUserDBImpl();
//			List<User> users=userModel.getUserByGroup("Agents");
//			ss=new String[users.size()];
//			for(int i=0;i<ss.length;i++){
//				ss[i]=users.get(i).getName();
//			}
//		}
//		catch(Exception excp){
//			MvcProperties.toLog(excp);
//		}
//		return ss;
//	}
	public static String [] getUserArrayByGroup(String groupName){
		String ss[]=null;
		try{
			ModelUserNetImpl userModel=new ModelUserNetImpl();
			List<User> users=userModel.getUserByGroup(groupName);
			ss=new String[users.size()];
			for(int i=0;i<ss.length;i++){
				ss[i]=users.get(i).getName();
			}
		}
		catch(Exception excp){
			MvcProperties.toLog(excp);
		}
		return ss;
	}
}
