package com.jida.user;

import org.apache.log4j.Logger;



import com.jida.MvcProperties;
import com.jida.server.Command;
import com.jida.server.MainServer;
import com.jida.server.ModelServer;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;

public class CommandInsertGroupPri extends Command {
	static Logger logger=Logger.getLogger(CommandInsertGroupPri.class);
	private Privilege pri;
	private Group group;
	public CommandInsertGroupPri(Group group,Privilege pri){
		this.pri=pri;
		this.group=group;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.insert(group,pri);
		
		}
		catch(Exception e){
			logger.error("Insert group-privilege failed:",e);
			throw e;
		}

		
	}

}
