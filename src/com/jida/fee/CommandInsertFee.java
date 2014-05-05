package com.jida.fee;

import com.jida.fee.data.Fee;
import com.jida.server.Command;

public class CommandInsertFee extends Command {
	private Fee fee;
	public CommandInsertFee(Fee fee){
		this.fee=fee;
	}
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		ModelFee modelFee=(ModelFee)this.model.get("Fee");
		modelFee.insert(fee);
	}
}
