package com.jida.client;

import java.net.Socket;

import com.jida.client.ModelServer;

abstract public class Command1 implements java.io.Serializable {
	transient protected ModelServer model;
	transient private Socket skt;
	public abstract void execute()throws Exception;
	
	public void setModel(ModelServer model){
		this.model=model;
	}

	public Socket getSkt() {
		return skt;
	}

	public void setSkt(Socket skt) {
		this.skt = skt;
	}
}

