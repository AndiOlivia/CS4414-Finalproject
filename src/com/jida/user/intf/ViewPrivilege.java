package com.jida.user.intf;

import com.jida.user.intf.ControllerPrivilege;

public interface ViewPrivilege {
	public void processModelChange(Object obj);
	public void addControllerListener(ControllerPrivilege con);
}
