package com.jida.server.data;

import java.util.Date;

import com.jida.user.domObject.User;

public class RemoteManager {
	private User user;
	private Date dateBegin;
	private String mac;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
}
