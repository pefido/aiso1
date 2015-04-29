package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;

public class ExitSyscallHandler implements SysCallHandler {

  public void handle(CPUCore core) {
    MyStats stats = OperatingSystem.getInstance().getStats();
    MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    stats.trace(MyOS.getInstance().getCPUJob(core).getPID(), "EXIT");
    MyOS.getInstance().setCPUJob(null, core);
    core.load(null);
    stats.stopCPU();
    if (scheduler.hasNext()) {
      MyPCB tmp = scheduler.next();
      MyOS.getInstance().setCPUJob(tmp, core);
      core.load(tmp.getContext());
      stats.plusCPU();
    }
  }
}
