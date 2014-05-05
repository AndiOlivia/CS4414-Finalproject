package com.jida.user.intf;

import java.util.List;

import com.jida.user.ViewUser;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;

public interface ModelUser {
	public List<User> getUser() throws Exception;
	public List<User> getUser(String str) throws Exception;
	public List<User> getUser(boolean refresh) throws Exception;
	public List<Group> getGroup() throws Exception;
	public List<Group> getGroup(String str) throws Exception;
	public List<Group> getGroup(boolean refresh) throws Exception;
	public List<Group> get(User user) throws Exception;
//	public List<String> get(String cond) throws Exception;
	public List<User> getUserByGroup(String groupName) throws Exception;
	public List<Privilege> get(Group group) throws Exception;
	
//	public String [] getAgentUser() throws Exception;
		public void insert(User user)throws Exception;
	public void insert(Group group)throws Exception;
	public void insert(User user,Group group)throws Exception;
	public void insert(Group group,Privilege pri)throws Exception;
	public void delete(User user)throws Exception;
	public void delete(Group group)throws Exception;
	public void update(Group group)throws Exception;
	public void delete (User user,Group group)throws Exception;
	public void delete(Group group,Privilege pri)throws Exception;
	public int getState(User user)throws Exception;
	public void update(User user)throws Exception;
	public void setState(User user) throws Exception;
	public boolean check(User user)throws Exception;
	public void changePassword(User user,String passwordNew)throws Exception;
	public int getIndex(User user);
	public int getIndex(Group group);
	public void addViewListener(ViewUser view);
}
