package com.jida.user.intf;

import com.jida.user.domObject.Privilege;

public interface ControllerPrivilege {
	public void processInsert(Privilege pri);
	public void processDelete(Privilege pri);
	public void processUpdate(Privilege pri);
}
