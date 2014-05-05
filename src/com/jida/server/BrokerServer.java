package com.jida.server;

import java.io.InputStream;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

import org.apache.log4j.Logger;

//import com.jy.intf.ModelUser;
import com.jida.MvcProperties;

//import com.jida.client.ModelUser;
/**
 * 服务器上代理服务类：实现与工作站，控制指挥中心的基于命令设计模式的对象通讯
 */
public class BrokerServer implements IoStrategy {
	Logger logger=Logger.getLogger(BrokerServer.class);

//	private InputStream is;
//	private OutputStream os;
//	private ObjectInputStream ois;
//	private ObjectOutputStream oos;
//	public long readBegin=-1;

	private ModelServerImpl model;
	public BrokerServer(ModelServerImpl model){
		this.model=model;
	}

	/**
	 * 服务实现：基于Command设计模式。当通讯故障时，用ping检测（另线程实现）。
	 */
	public  void ioService(Socket skt) {
		// TODO Auto-generated method stub
//		System.out.println("BrokerServer.run():Thread "+Thread.currentThread().getName()+" is servicing for "+skt.getInetAddress());
		try {
			InputStream is=skt.getInputStream();
			OutputStream os=skt.getOutputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			((IOThread)(Thread.currentThread())).readBegin=0;
			while(true){
				//New 20110918
				((IOThread)(Thread.currentThread())).readBegin=new Date().getTime();
				//New 20131113 加入同步，否则命令    //Delete 20131114 服务进行中时，另有请求被同步，无法运行下去。 //Update 20131114 当监控中心工作时，有定时线程与主线程同时请求服务
				synchronized(Thread.currentThread()){
					Object obj=ois.readObject();//1

					((IOThread)(Thread.currentThread())).readBegin=0;
					//				System.out.println("BrokerServer:ioService:::"+obj);
					if(obj instanceof Command){
						Command com=(Command)obj;
						//					System.out.println("BrokerServer ioService:skt(hashCode:"+skt.hashCode()+" localPort:"+skt.getLocalPort()+")");
						com.setSkt(skt);
						com.setModel(model);//2
						try{
							com.execute();//3

						}catch(Exception e){
							e.printStackTrace();
							oos.writeObject(e);
							continue;
						}

						//New 20110416
						oos.reset();
						//End 20110416

						oos.writeObject(com);//4
						//					System.out.println("BrokerServer:ioService:"+com);
					}
					else{
						oos.writeObject("Illegal Command:"+obj);	
					}
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("BrokerServer ioService 时：",e);
			System.out.println("Bye from brokerServer ,"+skt.getInetAddress());
			//New 20110104 客户端掉线
			ModelServerImpl server=(ModelServerImpl)MainServer.models.get("Server");
			server.disconnects(skt);
			((IOThread)(Thread.currentThread())).readBegin=-1;
			
		}
	}

}




