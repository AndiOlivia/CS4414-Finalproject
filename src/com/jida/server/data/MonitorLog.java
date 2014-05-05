package com.jida.server.data;

import java.net.Socket;
import java.util.Date;

import com.jida.server.IOThread;
import com.jida.user.domObject.User;

public class MonitorLog implements Comparable<MonitorLog> , java.io.Serializable{
	public static final String defaultPassword="000000";
	public static final String [] codesString={"过期","正常","禁止"};//{"管理员","管理员(只读)","捡斤员","验等员","库管员"};

	public static String titles[]={
//		"指挥中心",
		"MAC",
//		"省","市","地址","状态",
		"IP",
		"登录用户","登录时间",
		"被监视工作站"
	};
	private String name; //User name
//	private String addr;
//	private String province;
//	private String city;
	private String postCode;//单位
	private String ip;
	private Date date;
	private String hostId;//工作站MAC
	
	private byte state=1;//0:forbidden  1 :normal
	private String wksName;
	private byte color;
	//New 20130908
	private String  t1; //单位
	
	transient private Socket skt; 
	transient private IOThread th;
	
	
	public IOThread getTh() {
		return th;
	}
	public void setTh(IOThread th) {
		this.th = th;
	}
	public byte getColor() {
		return color;
	}
	public void setColor(byte color) {
		this.color = color;
	}
	public int hashCode(){
		return this.hostId.hashCode();
	}
	public boolean equals(Object obj){
		if(obj instanceof MonitorLog){
		
//			this.postCode!=null && postCode.equals(((MonitorLog)obj).postCode)||
			return this.hostId!=null && this.hostId.equals(((MonitorLog)obj).hostId);
//			|| 
//			MvcPorp;
		}
		return false;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
	public void setState(String stateStr){
		this.state=this.str2Code(stateStr);
	}

	public String toString(){
		return wksName+":"+name+"("+ip+")"+state+","+this.hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getPassword() {
//		return password;
//	}
//	public String getPasswordK(){
//		//加密
//		return this.password;
//	}

//	public void setPasswordK(String password) {
//		
//		this.password = password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}


	public int compareTo(MonitorLog usr) {
//		
		return this.postCode.compareTo(usr.postCode);
	}
	
	public byte str2Code(String str){
		if(str==null)
			return -1;
		for(int i=0;i<this.codesString.length;i++){
			if(this.codesString[i].equals(str)){
				return (byte)i;
			}
		}
		return -1;
	}
	public String getStateString(){
//		for(int i=0;i<this.codesString.length;i++){
//			if(this.codes[i]==state){
//				return this.codesString[i];
//			}
//		}
//		return codesString[codesString.length-1];
		return this.codesString[state];
	}
//	public void addGroup(Group group){
//		this.groups.add(group);
//	}
//	public void removeGroup(String groupName){
//		for(Group group:groups){
//			if(group.getName().equals(groupName)){
//				groups.remove(group);
//				return;
//			}
//		}
//	}
//	public List<Group > getGroups(){
//		return this.groups;
//	}
//	public void setGroups(List<Group> list){
//		this.groups=list;
//	}

//	public String getTel() {
//		return tel;
//	}

//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}

//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//	public boolean belongTo(String group){
//		if(groups==null)
//			return false;
//		for(Group g:this.groups){
//			if(g.getName().equalsIgnoreCase(group)){
//				return true;
//			}
//		}
//		return false;
//	}
//	public String getProvince() {
//		return province;
//	}
//	public void setProvince(String province) {
//		this.province = province;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
//	public short getType() {
//		return type;
//	}
//	public void setType(short type) {
//		this.type = type;
//	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public void copy(MonitorLog user){
		this.hostId=user.getHostId();
//		this.addr=user.getAddr();
//		this.city=user.getCity();
		this.date=user.getDate();
		this.ip=user.getIp();
//		this.mobile=user.getMobile();
		this.name=user.getName();
		this.postCode=user.getPostCode();
//		this.province=user.getProvince();
		this.state=user.getState();
//		this.tel=user.getTel();
//		this.type=user.getType();
	}
	public Socket getSkt() {
		return skt;
	}
	public void setSkt(Socket skt) {
		this.skt = skt;
	}
	public String getWksName() {
		return wksName;
	}
	public void setWksName(String wksName) {
		this.wksName = wksName;
	}
	
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
}
