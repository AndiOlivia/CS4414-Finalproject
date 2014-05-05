package com.jida.client;

import java.io.IOException;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.gui.panel.ShowMessageDialog;
import com.jida.server.Command;
import com.jida.server.CommandPing;
import com.jida.user.AuthModel;
import com.jida.user.AuthSession;
import com.jida.user.CommandUpdateUser;

//import com.jida.server.CommandGet;
//import com.jida.server.CommandInsert;
/**
 * 客户端：支持域名解析
 */
public class Client {
	static Logger logger=Logger.getLogger(Client.class);
	protected Socket skt;
	protected InputStream is;
	protected OutputStream os;
	protected ObjectInputStream ois;
	protected ObjectOutputStream oos;
	protected byte state;



	private static Client inst;
	public static Client getInstance(){
		if(inst==null){
			try {
				inst=new Client(MvcProperties.hostName,MvcProperties.port);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e);
			}
		}
		return inst;
	}
	protected Client(String host,int port)throws Exception{ //\\192.168.21.150\
		String h=MvcProperties.hostIP=Client.getIPByDNS(host);
		String s;
		if(h==null){
//			JOptionPane.showMessageDialog(null, s="域名解析错误或失败："+host);
			s=String.format("域名解析错误或失败：%s", host);
			throw new RuntimeException(s);
		}
		connect(h,port);
	}
	protected Client(String host)throws Exception{/*brandi 1.11*/
		int port=MvcProperties.port+1;
		connect(host,port);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(Client.getIPByDNS(MvcProperties.hostName));
		ping("192.168.21.100");
		ping("192.168.21.109");
		ping("192.1.21.100");
		// TODO Auto-generated method stub
//		String host;
//		int port;
//		host=JOptionPane.showInputDialog("输入主机名");
//		if(host==null || host.equals("")){
//		host=MvcProperties.host;
//		}
//		String s=JOptionPane.showInputDialog("输入端口号");
//		if(s==null || s.equals("")){
//		port=MvcProperties.port;
//		}
//		else{
//		port=Integer.parseInt(s);
//		}

//		try {
//		Client client=new Client(host,port);
//		for(int i=0;i<5;i++){
//		CommandGet comDish=new CommandGet(i);
//		client.write(comDish);
//		Object obj=client.read();
//		if(obj instanceof CommandGet){
//		System.out.println(((CommandGet)obj).get()+" comes");
//		}
//		else{
//		System.out.println(obj);
//		}

//		CommandInsert comDrink=new CommandInsert(i);
//		client.write(comDrink);
//		obj=client.read();
//		if(obj instanceof CommandInsert){
//		System.out.println(((CommandInsert)obj).get()+" comes");
//		}
//		else{
//		System.out.println(obj);
//		}
//		}
////		client.write("Hello");
////		Object obj=client.read();
////		System.out.println(obj + " From server "+client.getServerIP());

//		} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
	}
	public InetAddress getServerIP(){
		return skt.getInetAddress();
	}

	public void connect()throws Exception{
		//{{ New 20110110 
		MvcProperties.hostIP=this.getIPByDNS(MvcProperties.hostName);
		//}}

		connect(MvcProperties.hostIP,MvcProperties.port);

	}
	public void connect(String host,int port)throws Exception{
//		if(skt!=null){
//		//New 20110109 如果已有连接，中间断掉，只需再连　？？？
//		SocketAddress sa=new InetSocketAddress(host,port);
//		skt.connect(sa);
//		}
//		else{
		skt=new Socket(host,port);
//		}
		is=skt.getInputStream();
		os=skt.getOutputStream();
		oos=new ObjectOutputStream(os);
		ois=null;
	}
	public synchronized Object read()throws Exception{
		if(ois==null){
			ois=new ObjectInputStream(is);
		}
		
		
		Object obj=ois.readObject();
//		System.out.println("Client.read:"+obj);
		if(obj instanceof String  && ((String)obj).equals("End...")){
			//工作站停止被监控信号，正由另一监控中心监控
			//停止监控
			System.out.println("Receive End Message from workstation:"+skt.getInetAddress());
			try{
				close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//停止线程　ViewWk
//			ViewWk.stopMonitoring();
			//显示
//			JOptionPane.showMessageDialog(null, "工作站正被另一监控中心监控，本监控中心停止监控！");
		}//End New
		return obj;
	}
	public synchronized void write(Object obj)throws Exception{

		oos.reset();
		oos.writeObject(obj);
	}

	public static String getIPByDNS(String dns){
		try {
			InetAddress inet=InetAddress.getByName(dns);
			if(inet!=null)
				return inet.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return null;
	}
	//New 20110108
	static private byte buf[]=new byte[512];
	public static int ping(String dns){
		String ip=getIPByDNS(dns);
		String cmd="ping "+dns;
		int re=0;
		try {
			System.out.println(cmd);
			Process process = Runtime.getRuntime().exec("cmd /c "+ cmd);
//			Thread.sleep(8000);
			process.waitFor();
//			System.out.println(dns+":"+process.exitValue());
			InputStream is=process.getInputStream();

			is.read(buf);
			String s=new String(buf);
//			System.out.println(s);
			int index=s.indexOf("Lost = ");
			if(index<0){
				throw new Exception("Ping failed");
			}
			s=s.substring(index+7,index+8);
//			System.out.println(s);
			re=Integer.parseInt(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Ping "+dns,e);
			re=4;
		}
		if(re>0){
			logger.info(ip+" 4 package lost ");
		}
		return re;
	}

	public void close()throws Exception{
		System.out.println("Client.close()");
		if(skt!=null){
			skt.close();
		}
		skt=null;
		
	}
	
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	private Command com=new CommandPing();
	private ShowMessageDialog smd;
	public boolean isAlive(){
		if(skt==null || skt.isClosed())
			return false;
		try {
//			boolean b= skt!=null && skt.getKeepAlive();
//			System.out.println("Client isAlive:"+b); 
//			return b;
			write(com);
			Object obj=read();
			if(obj instanceof Command){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			smd=new ShowMessageDialog("注意","与"+MvcProperties.hostName+"断开"+new Date());
			//New 20140418
			logger.error(String.format("与%s断开",MvcProperties.hostName ));
			skt=null;

			return false;
		}
	}
}
