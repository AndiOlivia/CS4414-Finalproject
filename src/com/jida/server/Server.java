package com.jida.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.jida.MvcProperties;

//import com.jida.client.Mode?lUser;
//import com.jida.client.MvcProperties;
//import com.jida.db.ModelDBImplUser;
/**
 * 服务器：建立实例，不停地”接受连接，服务“
 */
public class Server {
	Logger logger=Logger.getLogger(Server.class);
	private ServerSocket serverSocket;
	private IoStrategy ioThreadPool;
	
	public Server (IoStrategy ioThreadPool)throws Exception{
		this.serverSocket=new ServerSocket(MvcProperties.port);
		
		this.ioThreadPool =ioThreadPool;
		
		new Thread(){
			public void run(){
				acceptConnection();
			}
		}.start();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			ModelUser model=new ModelDBImplUser();
//			IoStrategy brokerServer=new BrokerServer(model);
//			IoStrategy ioPoolManager=new IOThreadPoolManager(brokerServer);
//			new Server(ioPoolManager);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void acceptConnection(){
		Socket skt=null;
		System.out.println("Server is ready...");
		while(true){
			//accept
			try {
				skt=this.serverSocket.accept();
				System.out.println(skt.getInetAddress()+" is welcomer");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				MvcProperties.write("Server acceptConnection "+e);
				logger.error(e);
				continue;
			}
			//service
//			this.service(skt);
			this.ioThreadPool.ioService(skt);
		}
	}
}
