package com.jida.user;

import org.apache.log4j.Logger;
import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelPrivilege;

public class CommandUpdatePrivilege extends Command {
	static Logger logger=Logger.getLogger(CommandUpdatePrivilege.class);
	private User user;
	private Privilege item;
	public CommandUpdatePrivilege(User user,Privilege item){
		this.user=user;
		this.item=item;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelPrivilege model=(ModelPrivilege)MainServer.models.get("Privilege");
			//insert
			model.update(item);
		
		}
		catch(Exception e){
			logger.error("CommandUpdatePrivilege:",e);
		}

		
	}

}
