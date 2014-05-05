package com.jida.server;

public class CommandPing extends Command { 
	private byte state=0;
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		state=1;
	}
	public byte getState(){
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}

}
