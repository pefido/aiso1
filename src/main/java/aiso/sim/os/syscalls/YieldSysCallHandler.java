package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.OperatingSystem;

public class YieldSysCallHandler implements SysCallHandler{

  public void handle(CPUCore core) {
	MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    Context re = (Context) core.getContext();
    MyPCB tmp = MyOS.getInstance().getCPUJob();
    tmp.setContext(re);
    scheduler.schedule(tmp);
    MyPCB tmp2 = scheduler.next();
    MyOS.getInstance().setCPUJob(tmp2);
    core.load(tmp2.getContext());
  }

}
