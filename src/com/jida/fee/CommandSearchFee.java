package com.jida.fee;

import java.util.List;

import com.jida.fee.data.Fee;
import com.jida.server.Command;

public class CommandSearchFee extends Command{
	private List<Fee> list;
	private String cond;
	public CommandSearchFee(String cond){
		this.cond=cond;
	}
	public void execute()throws Exception{
		ModelFee modelFee=(ModelFee)this.model.get("Fee");
		list=modelFee.get(cond);
	}
	public List<Fee> get(){
		return list;
	}

}
