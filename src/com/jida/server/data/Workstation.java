package com.jida.server.data;


import java.net.Socket;
import java.util.Date;
import java.util.List;

import com.jida.server.IOThread;
import com.jida.util.ToolKit;
import com.jida.user.domObject.User;

public class Workstation implements Comparable<Workstation>,java.io.Serializable {
	public static final String defaultPassword="000000";
	public static final int ADMIN = 0;
	public static final int OPERATOR = 1;//
	public static final int OPERATOR1 = 11;
	public static final int ANONYMOUS_VISITOR = 2;
	public static final String [] codesString={"过期","正常","禁止"};//{"管理员","管理员(只读)","捡斤员","验等员","库管员"};
//	public static String titles[]={"用户名","单位","电话","移动电话","省","市","地址","状态"};
//	wkCode char(10) primary key, -- 用邮编形成的10长码
//	-- wkName varchar(10) primary key,  -- 用户名
//	wkHostId char(12), -- 工作站机器MAC
//	wkProvince char(20),
//	wkCity char(10),
//	wkAddr varchar(40), -- 住址
//	wkState tinyint  
	public static String titles[]={
		"施工方","终极用户","工程",
		"工作站码",
//		"MAC",//Delete 20130926
		"省","市",
		"地址","状态","IP",
		"登录用户","最近通讯时间",
	};
	private String name;//用户名
	private String addr;
	private String province;
	private String city;
	private String postCode;//工作站编码
	private String ip;//工作站登录的IP
	private Date date;
	private String mac;//工作站MAC
	private byte state=1;//0:expired  1 :normal 2:forbidden
	private byte color;
	transient private Socket skt;
	transient private IOThread th;
	private String t1;	// 施工方
	private String t2; //终极用户
	private String t3;	//工程名
	private String t4;
	private byte net;//0: workstation alone; 1:workstate net
	private static String [] netTitle={"独立","网络"};

	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT4() {
		return t4;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public byte getNet() {
		return net;
	}
	public void setNet(byte net) {
		this.net = net;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public byte getColor() {
		return color;
	}
	public void setColor(byte color) {
		this.color = color;
	}
	public int hashCode(){
		return this.postCode.hashCode();
	}
	public boolean equals(Object obj){
		if(obj instanceof Workstation){
			return this.postCode!=null && postCode.equals(((Workstation)obj).postCode)||
				this.mac!=null && this.mac.equals(((Workstation)obj).mac);
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
		StringBuilder sb=new StringBuilder(this.postCode);
		sb.append(",");
//		sb.append(this.mac);
//		sb.append(",");
		sb.append(this.t1);
		sb.append(",");
		sb.append(this.t2);
		sb.append(",");
//		sb.append(this.t3);
		sb.append(",");
		sb.append(this.addr);
		
//		sb.append(",");
//		sb.append(this.ip);
		return sb.toString();//+(name!=null?":"+name:"");//+"("+ip+")"+state+","+addr+this.mac;
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


	public int compareTo(Workstation wks) {
//		Update 20130216
		if(this.t1==wks.t1 || this.t1==null || this.t1.equals(wks.getT1()))
			return this.postCode.compareTo(wks.postCode);
		return this.t1.compareTo(wks.getT1());
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
		if(ip!=null && ip.charAt(0)=='/'){
			this.ip=ip.substring(1);
		}
		else
			this.ip = ip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
//	public void copy(User user){
//		this.mac=user.getmac();
//		this.addr=user.getAddr();
//		this.city=user.getCity();
//		this.date=user.getDate();
//		this.ip=user.getIp();
////		this.mobile=user.getMobile();
//		this.name=user.getName();
//		this.postCode=user.getPostCode();
//		this.province=user.getProvince();
//		this.state=user.getState();
////		this.tel=user.getTel();
////		this.type=user.getType();
//	}
	public Socket getSkt() {
		return skt;
	}
	public void setSkt(Socket skt) {
		this.skt = skt;
	}
	public Workstation clone(){
		Workstation wk=new Workstation();
		wk.name=name;
		wk.addr=addr;
		wk.province=province;
		wk.city=city;
		wk.postCode=postCode;
		wk.ip=ip;
		wk.date=date;
		wk.mac=mac;
		wk.skt=skt;
		wk.state=state;
		//New 20130513
		wk.t1=t1;
		wk.t2=t2;
		wk.t3=t3;
		return wk;
	}
	public Workstation copy(Workstation w){
		Workstation wk=this;//new Workstation();
		wk.name=w.name;
		wk.addr=w.addr;
		wk.province=w.province;
		wk.city=w.city;
		wk.postCode=w.postCode;
		wk.ip=w.ip;
		wk.date=w.date;
		wk.mac=w.mac;
		wk.skt=w.skt;
		wk.state=w.state;
		//New 20130513
		wk.t1=w.t1;
		wk.t2=w.t2;
		wk.t3=w.t3;
		return wk;
	}
	public IOThread getTh() {
		return th;
	}
	public void setTh(IOThread th) {
		this.th = th;
	}
	
	public String getNetString(){
		return this.netTitle[net];
	}
}
