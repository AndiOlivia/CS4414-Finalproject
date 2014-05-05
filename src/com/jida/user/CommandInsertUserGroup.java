package com.jida.user;

import org.apache.log4j.Logger;
import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandInsertUserGroup extends Command {
	static Logger logger=Logger.getLogger(CommandInsertUserGroup.class);
	private User user;
	private Group group;
	public CommandInsertUserGroup(User user,Group group){
		this.user=user;
		this.group=group;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.insert(user,group);
		
		}
		catch(Exception e){
			logger.error("User Delete:",e);
			throw e;
		}

		
	}

}
