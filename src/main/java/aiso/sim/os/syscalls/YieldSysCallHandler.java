package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.OperatingSystem;

public class YieldSysCallHandler implements SysCallHandler{

  public void handle(CPUCore core) {
    //OperatingSystem.getInstance().getScheduler().requeue(core);
	MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    Context re = (Context) core.getContext();
    scheduler.schedule(new MyPCB(re));
    core.load(scheduler.next().getContext());
  }

}
