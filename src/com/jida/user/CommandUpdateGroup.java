package com.jida.user;

import org.apache.log4j.Logger;
import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandUpdateGroup extends Command {
	static Logger logger=Logger.getLogger(CommandUpdateGroup.class);
	private User user;
//	private User item;
	private Group group;
	public CommandUpdateGroup(Group group){
		this.group=group;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//update
			model.update(group);
		}
		catch(Exception e){
			logger.error("Group update failed:"+group,e);
		}
	}
}
