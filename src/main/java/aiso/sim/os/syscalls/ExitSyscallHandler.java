package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;

public class ExitSyscallHandler implements SysCallHandler {

  public void handle(CPUCore core) {
    MyStats stats = OperatingSystem.getInstance().getStats();
    MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    core.load(null);
    stats.stopCPU();
    if (scheduler.hasNext()) {
      core.load(scheduler.next().getContext());
      stats.plusCPU();
    }
  }
}
