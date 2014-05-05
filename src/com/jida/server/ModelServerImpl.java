package com.jida.server;

import java.net.Socket;

import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.View;
import com.jida.client.Client;
import com.jida.client.Main;
import com.jida.fee.ModelFeeDBImpl;
import com.jida.fee.ModelFee;
import com.jida.gui.panel.ShowMessageDialog;
import com.jida.server.data.MonitorLog;
import com.jida.server.data.Workstation;
import com.jida.user.AuthModel;
import com.jida.user.db.ModelUserDBImpl;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;
import com.jida.util.ToolKit;
//import com.jy.db.ConnectionPool;
/**
 * 服务器工作站，控制指挥中心管理模型
 * @author YY
 *
 */
public class ModelServerImpl implements ModelServer {
	private Logger logger=Logger.getLogger(ModelServerImpl.class);
	//Map: 施工方--->工作站列表　　终级用户--->工作站列表
	private Map<String ,List<Workstation>> workstations;
	//全部工作站列表
	private List<Workstation> workstationsList;
	
	private int showStateWks=0;
	//当前工作站列表
	private List<Workstation> workstationsCurr;
	//IP--->工作站列表
	private Map<String,Workstation> workstationSocket;

	private Map<String,List<MonitorLog>> centers;
//	private List<MonitorLog> centersList;  //New 20131115
	private Map<String ,MonitorLog> socketMonitorLog;

	private View view,viewCenter;
	private boolean dirty;
	private ConnectionPool connectionPool=ConnectionPool.getInstance(MvcProperties.dbName);

	private static ModelServer inst;
	static{
		inst=new ModelServerImpl();
	}
	public static ModelServer getInstance(){
		return inst;
	}
	private ModelServerImpl(){
		this.workstationsList=new ArrayList();
		this.workstationSocket=new HashMap();
		
		try {
			get();
			System.out.println("ModelServer.init.workstations="+workstations);
			this.centers=new HashMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
			logger.error(e);
		}

		this.startPingTask();
	}


	/**
	 * 用户登录验证：验证通过时，加入工作站列表，并刷新工作站显示列表
	 * @param user　来自工作站的用户
	 * @return
	 */
	public boolean validate(User user){
		ModelUser model=(ModelUserDBImpl)MainServer.models.get("User");
		if(model==null){
			logger.error(String.format("ModelServerImpl.validate:ModelUser is null %s",user));
//			MvcProperties.write(MainServer.models,user);
			return false;
		}
		try {
			if(model.check(user)){
				AuthModel aModel=AuthModel.getInstance();
				if(!aModel.isValidOperation(user,"ClientOp,SuperPrivilege")){
					//JOptionPane.showMessageDialog(null, "当前用户无监控中心登录权限!");
					logger.error("当前用户无登录权限!"+user);
					user.setT2("当前用户无登录权限!");
					return false;
				}
				//				System.out.println("ModelServer:validate:"+user);
				if(user.getState()==1){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			MvcProperties.write(e,user);
			logger.error(e);
			//			e.printStackTrace();
		}
//		MvcProperties.write("用户登录失败："+user);
		return false;
	}
	public boolean validateServer(User user){
		ModelUser model=(ModelUserDBImpl)MainServer.models.get("User");
		if(model==null){
//			MvcProperties.write(MainServer.models,user);
			return false;
		}
		try {
			if(model.check(user)){
				AuthModel aModel=AuthModel.getInstance();
				if(!aModel.isValidOperation(user,"ServerOp,SuperPrivilege")){
					//JOptionPane.showMessageDialog(null, "当前用户无监控中心登录权限!");
					logger.error("当前用户无登录权限!"+user);
					user.setT2("当前用户无登录权限!");
					return false;
				}
				//				System.out.println("ModelServer:validate:"+user);
				if(user.getState()==1){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			MvcProperties.write(e,user);
			logger.error(e);
			//			e.printStackTrace();
		}
//		MvcProperties.write("用户登录失败："+user);
		return false;
	}
	/**
	 * 用户登录验证：验证通过时，返回
	 * @param user　来自控制中心的用户
	 * @return
	 */
	public boolean validateCenter(User user){
		ModelUser model=(ModelUserDBImpl)MainServer.models.get("User");
		if(model==null){
//			MvcProperties.write(MainServer.models,user);
			return false;
		}
		try {
			if(model.check(user)){

				//New 20120215 判定是否有登录权限  Run on Server
				AuthModel aModel=AuthModel.getInstance();
				if(!user.hasPrivilege("SuperPrivilege,MCLoginPrivilege")){
					//JOptionPane.showMessageDialog(null, "当前用户无监控中心登录权限!");
					logger.error("当前用户无监控中心登录权限!"+user);
					user.setT2("当前用户无监控中心登录权限!");
					return false;
				}

				//加入工作站列表
				//				for(Workstation w:this.workstations){
				//					if(equals(w.getHostId(),user.getHostId())){
				//						w.copy(user);
				//						fireModelChange();
				//						return true;
				//					}
				//				}
				//				Workstation w=new Workstation();
				//				w.copy(user);
				//				this.fireModelChange();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			MvcProperties.write(e,user);
			logger.error(e);
			//			e.printStackTrace();
			return false;
		}
	}
	
	protected void fireModelChange(){
		if(view!=null){
			view.processModelChange(this.workstations);
		}
		//		if(viewCenter!=null)
		//			viewCenter.processModelChange(this.centers);
	}
	protected void fireModelChangeCenter(){
		//		if(view!=null)
		//			view.processModelChange(this.workstations);
		if(viewCenter!=null)
			viewCenter.processModelChange(this.centers);
	}
	public void addViewListener(View view){
		this.view=view;
	}
	public void addViewListenerCenter(View view){
		this.viewCenter=view;
	}
	//工作站操作
	private String cond=null;

	public List<Workstation> get(User user)throws Exception{
		if(this.workstations==null){
			this.workstations=get();
		}
		if(user==null || user.hasPrivilege("SuperPrivilege")){
			return this.workstationsList;
		}
		
		List<Workstation> ll;
		return (ll=this.workstations.get(user.getT1()))==null?ll:this.workstations.get(user.getT2());
	}
	/**
	 * 
	 */
	public List<Workstation> get(String t1)throws Exception{
		if(this.workstations==null){
			this.workstations=get();
		}
		return this.workstations.get(t1);
	}
	public Map<String,List<Workstation>> get()throws Exception{

		if(workstations!=null){
			return this.workstations;
		}
		//		AuthModel model=AuthModel.getInstance();
		//		User user=model.getUser();
		//		String t1=user.getT1();
		//		String condi=null;


		String sql="select * from workstation";
		//		if(!user.hasPrivilege("SuperPrivilege")){
		//			cond="t1='"+user.getT1()+"'";
		//		}

		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			if(cond!=null && !cond.equals("")){
				sql+=" where "+cond;
			}
			//			sql+=" order by uolNotesTime";
			//			
			//			System.out.println("ModelDBImplUserOperateLog:get:"+sql);
			sql+=" order by t1";
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}

		this.workstations=new HashMap();
		String s=null;
		List<Workstation> ll=null;
		while(rs.next()){
			Workstation item=new Workstation();
			item.setAddr((s=rs.getString("wkAddr"))!=null?s.trim():null);
			item.setProvince((s=rs.getString("wkProvince"))!=null?s.trim():null);
			item.setCity((s=rs.getString("wkCity"))!=null?s.trim():null);
			item.setPostCode((s=rs.getString("wkCode"))!=null?s.trim():null);
			item.setMac((s=rs.getString("wkHostId"))!=null?s.trim():null);
			item.setState(rs.getByte("wkState"));
			item.setT1(rs.getString("t1"));
			item.setT2(rs.getString("t2"));
			item.setT3(rs.getString("t3"));
			item.setT4(rs.getString("t4"));
			// 施工方
			
			if((s=item.getT1())!=null && !s.equals("")){
				ll=this.workstations.get(s);
				if(ll==null){
					ll=new ArrayList<Workstation>();
					this.workstations.put(s, ll);
				}
				ll.add(item);
			}
			//终极用户
			if((s=item.getT3())!=null && !s.equals("")){
				ll=this.workstations.get(s);
				if(ll==null){
					ll=new ArrayList<Workstation>();
					this.workstations.put(s, ll);
				}
				ll.add(item);
			}
			this.workstationsList.add(item);	
		}
		this.dirty=false;
		System.out.println("ModelServerImpl.get:"+this.workstations);
		return this.workstations;

	}
	/**
	 * get workstation name by mac. New 20110107
	 * @param mac
	 * @return
	 */
	public String getWksName(String mac){
		Set set=this.workstations.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			List<Workstation> ll=this.workstations.get(it.next());
			for(Workstation wks:ll){
//				System.out.println("ModelServerImpl.getWksName:"+wks+" vssssssss "+mac);
				if(wks.getMac().equalsIgnoreCase(mac))  //Update 20130911 大小写不同，所以找不到对应项
					return "tem"+wks.getPostCode();  //返回＂tem工作站名＂的表名
			}
		}
		return null;
	}
	public List<MonitorLog> getCenter(String t1)throws Exception{
		//		if(this.centers!=null){
		//			return this.centers;
		//		}
		if(centers==null)
			return null;
		return this.centers.get(t1);
	}
	
	
	public List<MonitorLog> getCenter(User user)throws Exception{
		System.out.println("ModelServerImpl.getCenter(): centers="+centers+" user="+user);
		if(this.centers==null)
			return null;
		
		if(user==null){
			return toList(this.centers.values());
		}
		List<MonitorLog> ll;
		return (ll=this.centers.get(user.getT1()))!=null?ll:this.centers.get(user.getT2());
	}


	//	public List<Workstation> get(String cond){
	//		
	//	}
	public void delete(Workstation wks) throws Exception {
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="delete from workstation where wkCode='"+wks.getPostCode()+"'";

		//		if(AuthSession.getInstance().getUser().getType() == User.OPERATOR) {
		//			sql += " where username = '" + AuthSession.getInstance().getUser().getName() + "'";
		//		}
		try{
			stmt.executeUpdate(sql);
			
			if(wks.getT1()!=null){
				List<Workstation> ll=this.workstations.get(wks.getT1());
				if(ll!=null)
					ll.remove(wks);
			}
			if(wks.getT2()!=null){
				List<Workstation> ll=this.workstations.get(wks.getT2());
				if(ll!=null)
					ll.remove(wks);
			}
			this.workstationsList.remove(wks);
			
			System.out.println("ModelServerImpl.delete:"+this.workstations);
			//			for(int i=0;i<this.workstations.size();i++){
			//				Workstation w=this.workstations.get(i);
			//				if(w.equals(wks)){
			//					this.workstations.remove(i);
			////					this.workstations.add(i,user);
			//				}
			//			}
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
//		this.fireModelChange();
	} 


	/**
	 * 更新ＤＢ 
	 */
	public void update(Workstation user) throws Exception{
		Connection conn=connectionPool.getConnection();
		String sql="update workstation set wkState=?,wkProvince=?,wkCity=?,wkAddr=?,wkHostId=?,t1=?,t2=? where wkCode=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setByte(1,user.getState());
		stmt.setString(2, user.getProvince());
		stmt.setString(3, user.getCity());
		stmt.setString(4, user.getAddr());
		stmt.setString(5, user.getMac());
//		stmt.setString(6, user.getMobile());
		stmt.setString(6, user.getT1());
		stmt.setString(7, user.getT2());
				
		stmt.setString(8, user.getPostCode());

		//		if(AuthSession.getInstance().getUser().getState() == User.OPERATOR) {
		//			sql += " where userName = '" + AuthSession.getInstance().getUser().getName() + "'";
		//		}
		try{
			stmt.executeUpdate();
			List<Workstation> ll=this.workstations.get(user.getT1());
			for(int i=0;i<ll.size();i++){
				Workstation w=ll.get(i);
				if(w.equals(user)){
					w.copy(user);
					//					this.workstations.remove(i);
					//					this.workstations.add(i,user);
				}
			}
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		dirty=true;
		//		users=this.getUser(cond);
//		this.fireModelChange();	
	}

	/**
	 * 插入工作站信息
	 * @param item
	 * @throws Exception
	 */
	public void insert(Workstation item) throws Exception {
		List<Workstation> ll=null;//this.workstations.get(item.getT1());
		List<Workstation> ll2=null;//this.workstations.get(item.getT2());
		
		Connection conn=connectionPool.getConnection();
		//		
		String sql="insert into workstation(wkCode,wkProvince,wkCity,wkAddr,wkState,wkHostId,t1,t2,t3,t4) values(?,?,?,?,?,?,?,?,?,?);";
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, item.getPostCode());
			stmt.setString(2, item.getProvince());
			stmt.setString(3, item.getCity());
			stmt.setString(4, item.getAddr());
			stmt.setByte(5, item.getState());
			stmt.setString(6, item.getMac());
			stmt.setString(7, item.getT1());
			stmt.setString(8, item.getT2());
			stmt.setString(9, item.getT3());
			stmt.setString(10, item.getT4());
			stmt.executeUpdate();
//System.out.println("ModelServerImpl.insert:succeeding "+item);
			if(workstations!=null){
				this.workstations=new HashMap();
			}
			if(item.getT1()!=null){
				ll=this.workstations.get(item.getT1());
				if(ll==null){
					ll=new ArrayList();
				}
				if(!ll.contains(item)){
					ll.add(item);
				}
				this.workstations.put(item.getT1(), ll);
//				System.out.println("ModelServerImpl.insert:succeeding "+this.workstations.get(item.getT1()));
			}
			
			if(item.getT2()!=null){
				ll=this.workstations.get(item.getT2());
				if(ll==null){
					ll=new ArrayList();
				}
				if(!ll.contains(item)){
					ll.add(item);
				}
				this.workstations.put(item.getT2(), ll);
//				System.out.println("ModelServerImpl.insert:succeeding "+this.workstations.get(item.getT2()));
			}
			
			this.workstationsList.add(item);
//			System.out.println("ModelServlerImpl.insert:"+this.workstations);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
//		dirty=true;
		
	}

	public static void main(String s[])throws Exception{
		ModelServerImpl model=new ModelServerImpl();
		//		System.out.println(model.getUserByGroup("Agents"));
		//		User user=new User();
		//		user.setName("liming");
		//		user.setPassword("0000");
		////		user.setType(1);
		////		model.insert(user);
		//		
		//		System.out.println(model.check(user));
		////		user.setPassword("0000");
		////		model.changePassword(user);
		System.out.println(model.get());
	}
	public int getIndex(Workstation user){
		if(this.workstations==null){
			return -1;
		}
		for(int i=0;i<this.workstations.size();i++){
			if(this.workstations.get(i).equals(user)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 检测工作站是否存在
	 * @param hostId：工作站ID（邮政编码＋编号）
	 * @return
	 */
	public Workstation exists(String hostId){
		List<Workstation> ll=null;
		Set set=this.workstations.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			ll=this.workstations.get(it.next());
			for(int i=0;i<ll.size();i++){
				Workstation wks=ll.get(i);
				//			System.out.println("ModelServer:exists:"+wks.getIp()+" vs "+hostId);
				if(wks.getMac().equalsIgnoreCase(hostId)||(wks.getIp()!=null && wks.getIp().equals(hostId))){
//					System.out.println("ModelServerImpl.exists:hostId="+hostId+","+wks.getMac());
					return wks;
				}
			}
		}
		return null;
	}
	/**
	 * 检测控制指挥中心是否已存在
	 * @param hostId ：指挥中心ID
	 * @return
	 */
	public MonitorLog existsCenter(String hostId){

		List<MonitorLog> ll=null;
		Set set=this.centers.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			ll=this.centers.get(it.next());
			for(int i=0;i<this.centers.size();i++){
				MonitorLog wks=ll.get(i);
				if(wks.getHostId()!=null && wks.getHostId().equals(hostId))
					return wks;
			}
		}

		return null;
	}
	public void insert(MonitorLog item) throws Exception {
		//New 20131115
//		if(this.centersList==null){
//			this.centersList=new ArrayList();
//		}
//		if(!this.centersList.contains(item)){
//			this.centersList.add(item);
//		}
		
		List<MonitorLog> ll=null;
		ll=this.centers.get(item.getT1());
		if(ll!=null && ll.contains(item))
			return;
		//New 20131113
		if(ll==null){
			ll=new ArrayList();
			this.centers.put(item.getT1(),ll);
		}
		
		ll.add(item);
		System.out.println("ModelServer:insert:MonitorLog:"+this.centers);
	}

	/**
	 * New 20110104 设置工作站当前的状态为掉线：网络连接断开，二种情形：网络断开和工作站关闭
	 * @param skt：原连接的Socket
	 * @return 
	 */
	public boolean disconnects(Socket skt){
		System.out.println("ModelServer:disconnects"+skt+"--");
		if(skt==null)
			return false;

		List<Workstation> lw;
		Set set=this.workstations.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			lw=this.workstations.get(it.next());
			for(int i=0;lw!=null && i<lw.size();i++){
				Workstation w=lw.get(i);
				System.out.println("ModelServer:disconnects"+w.getSkt());
				if(w.getSkt()!=null && w.getSkt().equals(skt)){
					w.setSkt(null);
					w.setIp(null);
					w.setDate(new Date());
					w.setName(null);

//					this.fireModelChange();
					//log记录

					return true;

				}
			}
		}
		List<MonitorLog> lc;
		set=this.centers.keySet();
		it=set.iterator();
		while(it.hasNext()){
			lc=this.centers.get(it.next());
			for(MonitorLog w:lc){
				System.out.println("ModelServer:disconnects:center:"+w.getSkt());
				if(w.getSkt()!=null && w.getSkt().equals(skt)){
					w.setSkt(null);
					w.setIp(null);
					//				w.setHostId(null);
					w.setDate(new Date());
					w.setName(null);
					w.setWksName(null);/*brandi 1.18*/
//					this.fireModelChangeCenter();
					//log记录

					return true;

				}
			}
		}
		return false;
	}
	private ShowMessageDialog smd;
	private ShowMessageDialog smd2;
	/**
	 * 检测服务器与工作站，控制指挥中心连接情况：定时运行ping
	 */
	//{{ New 20110110
	public void startPingTask(){
		Timer timer=new Timer();
		//		tableModel.setList(model.getNewData());/*brandi*/
		timer.schedule(new TimerTask(){
			public void run(){
				//				System.out.println("pingTask start");/*brandi 1.24*/
				boolean b=true;
				List<Workstation> lw;
				Set set=workstations.keySet();
				Iterator it=set.iterator();
				while(it.hasNext()){
					lw=workstations.get(it.next());
					for(Workstation w:lw){
						//check connection to server
						if(w.getIp()!=null){
							//						int re=Client.ping(w.getIp());
							//						if(re>=4){
							try {
								b = w.getTh()!=null && w.getTh().isNetAlive();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								b=true;
							}
							//						System.out.println("ModelServer:workstation:"+w.getSkt().getInetAddress()+":"+b);
							if(w.getSkt()!=null &&!b){
								//							JOptionPane.showMessageDialog(null, "与"+w.getPostCode()+"断开"+new Date());
//								if(smd==null){
									//smd=new ShowMessageDialog("注意","与"+w.getPostCode()+"断开"+new Date());
								logger.error(String.format("与%s断开",w.getPostCode()));
									
//								}
								w.setIp(null);
								w.setSkt(null);
								w.setTh(null);
								w.setDate(new Date());
							}
						}
					}
				}
//				ModelServerImpl.this.fireModelChange();

				List<MonitorLog> lc;
				set=centers.keySet();
				it=set.iterator();
				while(it.hasNext()){
					lc=centers.get(it.next());
					for(MonitorLog w:lc){
						//check connection to server
						if(w.getIp()!=null){
							try {
								b = w.getTh()!=null && w.getTh().isNetAlive();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								b=true;
							}
							//						System.out.println("ModelServer:center:"+w.getSkt().getInetAddress()+":"+b);
							if(w.getSkt()!=null && !b){
								//Delete 20140323				JOptionPane.showMessageDialog(null, "与"+w.getHostId()+"断开"+new Date());
//								if(smd2==null){
//									smd2=new ShowMessageDialog("注意","与"+w.getHostId()+"断开"+new Date());
//								}
								//New 20140323 
								String s1=String.format("与%s断开:%s",w.getHostId(),DateFormat.getDateTimeInstance().format(new Date()));
								System.out.println(s1);
								logger.error(s1);
								
								w.setIp(null);
								w.setSkt(null);
								w.setTh(null);
								w.setDate(new Date());
							}
						}
					}
				}
				//					ModelServerImpl.this.fireModelChangeCenter();
				//				System.out.println("PingTask end!");/*brandi 1.24*/
			}
			
		}, new Date(), MvcProperties.checkLapse);
	}
	////}}

			public void processExportWorkstation(String path){
	//			try {
	//				ExcelBeanToolKit.exportWorkStation(path,workstations);
	//			} catch (Exception e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//				JOptionPane.showMessageDialog(null, e.getMessage());
	//			}
			}
			public void processExportCenter(String path){
	//			try {
	//				ExcelBeanToolKit.exportMonitorLog(path,this.centers);
	//			} catch (Exception e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//				JOptionPane.showMessageDialog(null, e.getMessage());
	//			}
			}

	/**
	 * 获取当前显示状态下的工作站列表
	 * @param showState 显示状态   0：全部； 1：网站 ； 2：独立
	 * @return 工作站列表
	 */
			public List<Workstation> getWorkstationsCurr(int showState){
				if(this.showStateWks==showState && this.workstationsCurr!=null)
					return this.workstationsCurr;
				this.showStateWks=showState;

				if(showStateWks==0){
					this.workstationsCurr=null;
					return this.workstationsList;
				}

				if(this.workstationsCurr==null){
					this.workstationsCurr=new ArrayList();
				}
				else{
					this.workstationsCurr.clear();
				}

				byte b=0;
				if(this.showStateWks==1){
					//显示网络工作站
					b=1;
				}
				for(Workstation w:this.workstationsList){
					if(w.getNet()==b){
						this.workstationsCurr.add(w);
					}
				}
				return this.workstationsCurr;
			}
			//
			public Workstation getByIndex(int index){
				return null;
			}

			public Workstation getWks(String skt){
		return this.workstationSocket.get(skt);
	}
	
	
	//			List<Workstation> ll=this.workstationsCurr==null?this.workstations:this.workstationsCurr;
	//			try{
	//				return ll.get(index);
	//			}
	//			catch(Exception e){
	//				return null;
	//			}
	//		}
			
	public  static List<MonitorLog> toList(Collection<List<MonitorLog>> cc ){
		List<MonitorLog> ll=new ArrayList();
//		Collection<List<MonitorLog>> cc=centers.values();
		for(List<MonitorLog> l:cc){
			ll.addAll(l);
		}
		
		return ll;
	}
}
