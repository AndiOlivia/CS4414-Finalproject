package com.jida.user;

import java.util.List;



import org.apache.log4j.Logger;

import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ModelUser;

public class CommandGetPrivilege extends Command {
	static Logger logger=Logger.getLogger(CommandGetPrivilege.class);
	private User user;
	private Group group;
	private String cond;
	private List<Privilege> list;
	public CommandGetPrivilege(User user,String cond){
		this.user=user;
		this.cond=cond;
	}
	public CommandGetPrivilege(Group group){
		this.group=group;
//		this.cond=cond;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Privilege> getList() {
		return list;
	}
	public void setList(List<Privilege> list) {
		this.list = list;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			if(group==null){
				ModelPrivilege model=(ModelPrivilege)MainServer.models.get("Privilege");
				//insert
				list=model.get();
			}
			else{
				ModelUser model=(ModelUser)MainServer.models.get("User");
				//insert
				list=model.get(group);
			}
		
		}
		catch(Exception e){
			logger.error("CommandGetPrivilege:",e);
			throw e;
		}

		
	}

}
