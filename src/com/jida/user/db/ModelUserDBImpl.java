package com.jida.user.db;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.ViewUser;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class ModelUserDBImpl implements ModelUser {
	private List<User> users=null;
	private List<Group> groups=null;
	private ConnectionPool connectionPool=ConnectionPool.getInstance(MvcProperties.dbName);
	private ViewUser view;
	private boolean dirty=true;
	private boolean dirtyGroup=true;
	private String cond=null;
	private String condGroup=null; 
	private String condBasic;
	//Singleton
	private static ModelUserDBImpl inst=new ModelUserDBImpl();
	public static ModelUser getInstance(){
		return inst;
	}
	private ModelUserDBImpl(){
		
	}
	public void changePassword(User user,String passwordNew) throws Exception {
		if(user.getState() == 0) {
			throw new Exception("被冻结用户不能修改密码");
		}
		if(!this.check(user)){
			throw new Exception("用户密码错误");
		}
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="update user set password='"+
			passwordNew+"' where username='"+user.getName()+"'";
//			System.out.println("ModelUserDBImpl:changePassword:sql:"+sql);
			stmt.executeUpdate(sql);
			System.out.println("ModelUserDBImpl:changePassword:sql:"+sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
	}

	
	public boolean check(User user) throws Exception {
		System.out.println("ModelUserDBImpl:check user:"+user);
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
		String cond="username='"+user.getName()+"' and password='"+
			user.getPassword()+"'";
		this.dirty=true;
		List<User> l=this.getUser(cond);
//		check=false;
		if(l!=null && l.size()>0){
			user.copy(l.get(0));
			
			return true;
		}
		return false;
	}

	
	public void delete(User user) throws Exception {
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="delete from user where username='"+user.getName()+"'";
		
//		if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where username = '" + AuthSession.getInstance().getUser().getName() + "'";
//		}
		try{
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
		users=this.getUser(cond);
		this.fireModelChange(users);
	}
	public void delete(Group group) throws Exception {
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="delete from grouptable where groupname='"+group.getName()+"'";

//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where username = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirtyGroup=true;
		groups=this.getGroup(condGroup);
//	System.out.println(groups);
		this.fireModelChange(groups);
	}

	
	public int getState(User user) throws Exception {
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select * from user where username='"+user.getName()+"'";
			
		ResultSet rs=stmt.executeQuery(sql);
		
		connectionPool.releaseConnection(conn);
		if(rs.next())
			return rs.getInt("state");
		return -1;
	}
	public void setState(User user) throws Exception{
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="update user set state="+user.getState()+" where username='"+user.getName()+"'";

//			if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
		users=this.getUser(cond);
		this.fireModelChange(users);
	}
	public void update(User user) throws Exception{
		Connection conn=connectionPool.getConnection();
		String sql="update user set state=?,province=?,city=?,addr=?,tel=?,mobile=?,postCode=?,password=? where username=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setByte(1,user.getState());
		stmt.setString(2, user.getProvince());
		stmt.setString(3, user.getCity());
		stmt.setString(4, user.getAddr());
		stmt.setString(5, user.getTel());
		stmt.setString(6, user.getMobile());
		stmt.setString(7, user.getPostCode());
		stmt.setString(8, user.getPassword());
		stmt.setString(9, user.getName());
		
//		if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//		}
		try{
			stmt.executeUpdate();
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
		users=this.getUser(cond);
		this.fireModelChange(users);	
	}
	
	public void delete(User user,Group group)throws Exception{
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="delete from userGroup where username='"+user.getName()+
			"' and groupname='"+group.getName()+"'";

//			if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			if(stmt.executeUpdate(sql)==0){
				connectionPool.releaseConnection(conn);
				throw new Exception("删除失败,不属于该组："+group);
			}
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		user.removeGroup(group.getName());
		this.fireModelChange(users);
	}
	public void delete(Group group,Privilege pri)throws Exception{
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="delete from groupPrivilege where groupname='"+group.getName()+
			"' and privilegename='"+pri.getPriName()+"'";

//			if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			System.out.println("ModelUserDBImpl:delete:"+sql);
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}

		System.out.println("ModelUserDBImpl:delete:group="+group+"---"+pri);
		group.removePrivilege(pri.getPriName());
		this.fireModelChange(groups);
	}
	
 	public List<Group> get(User user)throws Exception{		
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from userGroup inner join grouptable on userGroup.groupname=grouptable.groupname where userGroup.username='"
				+user.getName()+"'";

//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		user.setGroups(new ArrayList<Group>());/////
		while(rs.next()){
			Group group=new Group();
			group.setName(rs.getString("groupname").trim());
			group.setDesc(rs.getString("groupdesc"));
			get(group);
			user.addGroup(group);
		}
		return user.getGroups();
	}
 	public List<Privilege> get(Group group)throws Exception{		
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from groupPrivilege inner join privilege on groupPrivilege.privilegename=privilege.privilegename where groupPrivilege.groupname='"
				+group.getName()+"'";

//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		group.setprivileges(new ArrayList<Privilege>());/////
		while(rs.next()){
			Privilege pri=new Privilege();
			pri.setPriName(rs.getString("privilegename").trim());
			pri.setPriDesc(rs.getString("privilegedesc"));
			group.addPrivilege(pri);
		}
		return group.getprivileges();
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
		System.out.println("ModelUserDBImpl:getUser:"+cond+" dirty="+dirty);
//		if(! dirty && (cond==this.cond || this.cond !=null && this.cond .equalsIgnoreCase(cond))){
//			return users;
//		}
		//New 20130513
		boolean check=(cond!=null) && cond.indexOf("password")>0;
		
		if(condBasic==null && !check){
			condBasic="";
			//Delete 20131107
//			User user=AuthModel.getInstance().getUser();
//			if(user!=null && !user.hasPrivilege("SuperPrivilege")){
//				condBasic="t1='"+user.getT1()+"' ";
//			}
//			System.out.println("ModelUserDBImpl:getUser:"+condBasic);
		}
		
		
		
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			StringBuilder sql=new StringBuilder("select * from user ");
//			String sql="select distinct user.name,* from [userGroup] inner join [group] on userGroup.group_group_name=[group].group_name";
			if(cond!=null || condBasic!=null && !condBasic.equals("")){
				sql.append(" where ");
				if(cond!=null)
					sql.append(cond);
				if(!check){
					if(cond!=null && !condBasic.equals("")){
						sql.append(" and ");
					}
					if(!condBasic.equals(""))
						sql.append(condBasic);
				}
			}
			
//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			sql.append( " order by t1 ASC,username ASC");
			
//			this.cond=sql.toString();
			System.out.println("ModelUserDBImpl:getUser:"+sql);
			rs=stmt.executeQuery(sql.toString());
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		if(users==null)
			users=new ArrayList<User>();/////
		else 
			users.clear();
		 
		String s;
		while(rs.next()){
			User user=new User();
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
			get(user);//
			this.users.add(user);

		}
//		System.out.println("ModelUserDBImpl:getUser:"+users);
		this.cond=cond;
		dirty=false;
		
		rs.close();
		
		return this.users;
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
//		if(! dirtyGroup && (condGroup==this.condGroup  ||
//				this.condGroup!=null && this.condGroup.equalsIgnoreCase(condGroup))){
//				return groups;
//		}
		
		this.condGroup=condGroup;
		
		dirtyGroup=false;
		
		
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			//String sql="select grouptable.groupname,grouptable.groupdesc,privilege.privilegename,privilege.privilegedesc from grouptable inner join groupprivilege on grouptable.groupname=groupprivilege.groupname inner join privilege on groupprivilege.privilegename=privilege.privilegename ";
			String sql="select groupname,groupdesc from grouptable ";
			if(condGroup!=null){
				sql+=" where "+condGroup;
			}
			sql+=" order by groupname ASC";
//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		groups=new ArrayList<Group>();/////
		
		while(rs.next()){
			Group group=new Group();
			group.setName(rs.getString("groupname"));
			group.setDesc(rs.getString("groupdesc"));
			this.groups.add(group);
			get(group);
		}
		
		System.out.println("ModelUserDBImpl:getGroup:"+groups);
		return this.groups;
	}
	public void update(Group group)throws Exception{
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="update grouptable set groupdesc='"+group.getDesc()+"' where groupname='"+group.getName()+"'";

//			if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
//			sql += " where username = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
//		dirtyGroup=true;
//		groups=this.getGroup(condGroup);
//	System.out.println(groups);
		this.fireModelChange(groups);

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
		Connection conn=connectionPool.getConnection();
		String sql="insert into user(username,password,state,tel,mobile,addr,id,province,city,postCode,t1,t2) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setByte(3, user.getState());
			stmt.setString(4, user.getTel());
			stmt.setString(5, user.getMobile());
			stmt.setString(6, user.getAddr());
			stmt.setString(7, user.getId());
			stmt.setString(8, user.getProvince());
			stmt.setString(9, user.getCity());
			stmt.setString(10, user.getPostCode());
			stmt.setString(11, user.getT1());
			stmt.setString(12, user.getT2());
//			stmt.setString(10, user.getName());
//			System.out.println(sql);
			stmt.executeUpdate();
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
		users=this.getUser(cond);
		this.fireModelChange(users);
		
	}
	
	public void insert(Group group) throws Exception {
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="insert into grouptable values ('"+
			group.getName()+"','"+
			group.getDesc()+"')";

//			if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//			}
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirtyGroup=true;
		groups=this.getGroup(condGroup);
//	System.out.println("ModelUserDBImpl:insert:"+groups);
		this.fireModelChange(groups);
	}
	public void insert(User user,Group group) throws Exception {
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="insert into userGroup values ('"+
				user.getName()+"','"+
				group.getName()+"')";
		
//		if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//		}
		try{
			stmt.executeUpdate(sql);
		}
		catch(Exception e){
			throw e;
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		user.addGroup(group);
		this.fireModelChange(users);
		
	}
	public void insert(Group group,Privilege pri) throws Exception {
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="insert into groupPrivilege values ('"+
				group.getName()+"','"+
				pri.getPriName()+
				"')";
		
//		if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
//		}
		try{
			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		group.addPrivilege(pri);
		this.fireModelChange(groups);
		
	}
	public static void main(String s[])throws Exception{
		ModelUserDBImpl model=new ModelUserDBImpl();
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
			ModelUserDBImpl userModel=new ModelUserDBImpl();
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
