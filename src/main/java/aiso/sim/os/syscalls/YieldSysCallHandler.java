package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.OperatingSystem;

public class YieldSysCallHandler implements SysCallHandler{
	
	public void handle(CPUCore core) {
		OperatingSystem.getInstance().getPCB().requeue();
	}

}
