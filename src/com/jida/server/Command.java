package com.jida.server;

import java.net.Socket;

import com.jida.user.domObject.User;

//import com.jy.intf.ModelUser;

//import com.jida.client.ModelUser;
/**
 * 服务器用，命令设计模式的基类
 */
abstract public class Command implements java.io.Serializable {
	transient protected ModelServer model;
	transient private Socket skt;
	protected User user;
	protected String comment;
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public abstract void execute()throws Exception;
	
	public void setModel(ModelServerImpl model){
		this.model=model;
	}

	public Socket getSkt() {
		return skt;
	}

	public void setSkt(Socket skt) {
		this.skt = skt;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
