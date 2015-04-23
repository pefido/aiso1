package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.MyPCB;
import aiso.sim.os.OperatingSystem;

public class YieldSysCallHandler implements SysCallHandler{

  public void handle(CPUCore core) {
    //OperatingSystem.getInstance().getScheduler().requeue(core);
    Context re = (Context) core.getContext();
    core.load(OperatingSystem.getInstance().getScheduler().next().getContext());
    OperatingSystem.getInstance().getScheduler().schedule(new MyPCB(re));
  }

}
