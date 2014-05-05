package com.jida.user.domObject;

import java.util.ArrayList;
import java.util.List;

public class Group implements java.io.Serializable{
	private String name;
	private String desc;
	private List<Privilege> privileges=new ArrayList();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String toString(){
		return name+":"+desc+","+this.privileges;//",(Privilege："+this.privileges+")";	
	}
	public int hashCode(){
		return name.hashCode();
	}
	public boolean equals(Object obj){
		if(obj instanceof Group){
			return name.equalsIgnoreCase(((Group)obj).name);
		}
		return false;
	}
	public void addPrivilege(Privilege privilege){
		this.privileges.add(privilege);
	}
	public void removePrivilege(String privilegeName){
		for(Privilege privilege:privileges){
			if(privilege.getPriName().equals(privilegeName)){
				privileges.remove(privilege);
				return;
			}
		}
	}
	public List<Privilege > getprivileges(){
		return this.privileges;
	}
	public void setprivileges(List<Privilege> list){
		this.privileges=list;
	}

	
}
