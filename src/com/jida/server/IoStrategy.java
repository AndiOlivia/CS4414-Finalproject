package com.jida.server;

import java.net.Socket;

/**
 * 
 * 标准服务接口
 *
 */
public interface IoStrategy {
	public void ioService(Socket skt);
	
}
