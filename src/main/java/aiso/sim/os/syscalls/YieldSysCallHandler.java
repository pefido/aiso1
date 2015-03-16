package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;

public class YieldSysCallHandler implements SysCallHandler{
	
	public void handle(CPUCore core) {
		core.getPCB().requeue();
	}

}
