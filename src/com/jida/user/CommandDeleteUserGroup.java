package com.jida.user;

import org.apache.log4j.Logger;



import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandDeleteUserGroup extends Command {
	static Logger logger=Logger.getLogger(CommandDeleteUserGroup.class);
	private User user;
	private User userItem;
	private Group item;
	public CommandDeleteUserGroup(User user,User userItem,Group item){
		this.user=user;
		this.item=item;
		this.userItem=userItem;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.delete(userItem,item);
		
		}
		catch(Exception e){
			logger.error("User Delete:",e);
		}

		
	}

}
