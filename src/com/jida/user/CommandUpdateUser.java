package com.jida.user;

import org.apache.log4j.Logger;
import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandUpdateUser extends Command {
	static Logger logger=Logger.getLogger(CommandUpdateUser.class);
	private User user;
	private User item;
	public CommandUpdateUser(User user,User item){
		this.user=user;
		this.item=item;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.update(item);
		
		}
		catch(Exception e){
			logger.error("User Delete:",e);
		}

		
	}

}
