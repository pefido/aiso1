package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.OperatingSystem;

public class ExitSyscallHandler implements SysCallHandler {

  public void handle(CPUCore core) {
	core.load(null);
	core.load(OperatingSystem.getInstance().getScheduler().next().getContext());
  }
}
