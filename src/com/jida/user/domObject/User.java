package com.jida.user.domObject;

import java.net.Socket;

import java.util.Date;
import java.util.List;

import com.jida.util.ToolKit;
import com.jida.user.AuthSession;
//import com.jida.user.UserGenerate;


public class User implements Comparable<User>,java.io.Serializable {
	public static final String defaultPassword="000000";
//	public static final int ADMIN = 0;
//	public static final int OPERATOR = 1;//
//	public static final int OPERATOR1 = 11;
//	public static final int ANONYMOUS_VISITOR = 2;
//	public static final int [] codes={0,11,2,3,4};
	public static final String [] codesString={"Forbidden","Normal"};//
	public static String titles[]={"User Name","Tel","Mobile","Province","City","Address","Zip","State","Password"};
	private String name;
	private String password="111111";
	private List<Group> groups;
	private String tel;
	private String mobile;
	private String addr;
	private String province;
	private String city;
	private String postCode;//Corp
	private String id;
	private String ip;
	private Date date;
	private short type;//Client,Server
	private String hostId;//MAC
//	transient Socket skt;
//	private int type = -1;
	private byte state;//0:forbidden  1 :normal
	private String t1;	// corp
	private String t2; //terminal corp
	transient private byte colorOption;
	private String result;
	
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public byte getColorOption() {
		return colorOption;
	}

	public void setColorOption(byte colorOption) {
		this.colorOption = colorOption;
//		System.out.println(t1+","+name+","+this.colorOption);
	}

	public User(){
		
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
	public void setT2(String t2) {
		this.t2 = t2;
	}

	public int hashCode(){
		return t1.hashCode()*this.name.hashCode();

	}
	public boolean equals(Object obj){
		if(obj instanceof User){
			return name.equals(((User)obj).name) && t1.equals(((User)obj).name );
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
		return name+"("+password+")"+state+","+this.hostId+","+mobile+","+addr+this.groups+","+	t1+","+t2+","+result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public String getPasswordK(){
		//加密
		return this.password;
	}

	public void setPasswordK(String password) {
		
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int compareTo(User usr) {
//		
		String t1=usr.t1;
		if(this.t1==t1 || this.t1==null || this.t1.equals(t1))
			return this.name.compareTo(usr.name);
		return this.t1.compareTo(t1);
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
	public void addGroup(Group group){
		this.groups.add(group);
	}
	public void removeGroup(String groupName){
		for(Group group:groups){
			if(group.getName().equals(groupName)){
				groups.remove(group);
				return;
			}
		}
	}
	public List<Group > getGroups(){
		return this.groups;
	}
	public void setGroups(List<Group> list){
		this.groups=list;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public boolean belongTo(String group){
		if(groups==null)
			return false;
		for(Group g:this.groups){
			if(g.getName().equalsIgnoreCase(group)){
				return true;
			}
		}
		return false;
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
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
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
	
	public boolean hasPrivilege(String priName){
//		if(this.type==AuthSession.LOGINALONE)
//			return true;
		if(this.groups==null)
			return false;
		String ss[]=priName.split(" |,|;");
		for(Group g:this.groups){
			System.out.println("User:hasPrivilege:"+g);
			List<Privilege> l=g.getprivileges();
			for(Privilege p:l){
				for(String s:ss){
//					System.out.println("User:hasPrivilege:"+s+"="+p.getPriName());
					if(p.getPriName().equalsIgnoreCase(s))
						return true;
				}
			}
		}
		return false;
	}
	
	public String getHostId() {
		return hostId;
	}
	public void setHostId(byte[] hostId) {
		this.hostId = ToolKit.getHexString(hostId);
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	
	
	public void copy(User user){
		this.addr=user.addr;
		this.city=user.city;
		this.date=user.date;
		this.groups=user.groups;
//		this.hostId=user.hostId;
		this.id=user.id;
		this.ip=user.ip;
		this.mobile=user.mobile;
		this.name=user.name ;
		this.password=user.password;
		this.postCode=user.postCode;
		this.state=user.getState();
		this.t1=user.t1;
		this.t2=user.t2;
		this.tel=user.tel;
//		System.out.println("User.copy()"+this);
	}
}
