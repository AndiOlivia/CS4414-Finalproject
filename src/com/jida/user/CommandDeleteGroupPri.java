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

public class CommandDeleteGroupPri extends Command {
	static Logger logger=Logger.getLogger(CommandDeleteGroupPri.class);
	private User user;
//	private User userItem;
	private Group item;
	private Privilege pri;
	public CommandDeleteGroupPri(User user,Group item,Privilege pri){
		this.user=user;
		this.item=item;
		this.pri=pri;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ModelUser model=(ModelUser)MainServer.models.get("User");
			//insert
			model.delete(item,pri);
		
		}
		catch(Exception e){
			logger.error("Delete group-privilege failed :",e);
		}

		
	}

}
