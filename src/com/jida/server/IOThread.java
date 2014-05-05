package com.jida.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

import com.jida.MvcProperties;
import com.jida.server.data.Workstation;
/**
 * 服务器服务线程
 * @author YY
 *
 */
public class IOThread extends Thread {
	private Socket skt;
//	private InputStream is;
//	private OutputStream os;
//	private ObjectInputStream ois;
//	private ObjectOutputStream oos;
	private int no;
	private static int count;
	private Workstation wks;
//	private static ModelRes model=new ModelRes();
	
	
	private IoStrategy brokerServer;
	
	public IOThread(IoStrategy brokerServer){
		this.brokerServer=brokerServer;
		no=count++;
		this.setName(Integer.toString(no));
	}
	public String toString(){
		return no+":"+skt==null?"none":skt.getInetAddress().toString();
	}
	
	public void setSocket(Socket skt){
		if(this.skt==null){
			this.skt=skt;
			synchronized(this){
				this.notify();
			}
		}
	}
	/*brandi 1.25*/
	public void setSkt(Socket skt){
		this.skt=skt;
	}
	public Socket getSkt(){
		return skt;
	}
	/*brandi 1.25*/
	public boolean equals(Object obj){
		if(obj instanceof IOThread){
			return skt.getInetAddress().toString().equals(((IOThread)obj).getSkt().getInetAddress().toString());
		}
		return false;
	}
	public int hasCode(){
		return this.skt.getInetAddress().toString().hashCode();
	}
	public boolean isExist(Socket skt){
		if(this.skt==null){
			return false;
		}
		return this.skt.getInetAddress().toString().equals(skt.getInetAddress().toString());
	}

	public boolean isIdle(){
		return skt==null;
	}
	/**
	 * 服务器服务过程：”等待，服务，复位“
	 */
	public void run(){
		while(true){
			//wait
			synchronized(this){
				System.out.println("IOThread:run:Thread "+no+" is in waiting stage");
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//service
			System.out.println("IOThread:run:Thread "+no+" is in servicing stage");
			this.brokerServer.ioService(skt);
			this.readBegin=-1;
			//reset
			this.skt=null;
			
		}
		
		
		
	}
	
	/**
	 * 测试网络是否连通，
	 * @return
	 */
	public boolean isNetAlive(){
		if(skt==null)
			return false;
		return skt!=null && readBegin==0 || new Date().getTime()-this.readBegin<=2*MvcProperties.checkLapse;//Update 20140417 MvcProperties.checkLapse
	}
	
	public long readBegin=-1;
}
