package com.jida.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 服务器服务线程池管理器
 * @author YY
 *
 */
public class IOThreadPoolManager implements IoStrategy {
	private List<IOThread> threads;
	private IoStrategy brokerServer;
	
	public static final int MAX=300;
	public static final int MIN=1;
	public static IOThreadPoolManager instance;
	public IOThreadPoolManager(IoStrategy brokerServer){
		this.threads=new ArrayList();
		this.brokerServer=brokerServer;
		
		for(int i=0;i<MIN;i++){
			this.createNewThread();
		}
		instance=this;
		
	}
	/**
	 * 线程池服务实现：先找，找不到创建。最后通知线程服务。
	 */
	public void ioService(Socket skt) {
		// TODO Auto-generated method stub
		IOThread th=null;
		if((th=this.findIdleThread(skt))==null){
			th=this.createNewThread();
		}
		if(th!=null){
			th.setSocket(skt);
		}
		else{
			for(IOThread t:this.threads){
				System.out.println(t);
			}
			throw new RuntimeException("No iothread found");
		}
	}
	/**
	 * 找空闲线程
	 * @param skt：套接口
	 * @return
	 */
	/*brandi findIdleThread()*/
	public IOThread findIdleThread(Socket skt){
		for(IOThread th:this.threads){
			//check exist /*brandi 1.25*/ 
			if(th.isExist(skt)){
				try {
					th.getSkt().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				return th;
			}	
			if(th.isIdle()){
				return th;
			}
			
		}
		return null;
	}
	/**
	 * 创建新线程
	 * @return
	 */
	public IOThread createNewThread(){
		if(this.threads.size()>=MAX){
			return null;
		}
		IOThread th=new IOThread(this.brokerServer);
//		for(int i=0;i<threads.size();i++){
//			if(threads.get(i).equals(th)){
//				try {
//					threads.get(i).getSkt().close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		th.start();
		this.threads.add(th);
		
		try{
			Thread .sleep(200);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return th;
	}
	
	
}
