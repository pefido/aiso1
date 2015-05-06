package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyPCB;
import aiso.sim.os.OperatingSystem;
import aiso.sim.os.AbstractDriver;

public class IOSyscallHandler implements SysCallHandler {

  public void handle(CPUCore core) {//para fazer io tirar processo do core e por no driver
    //retirar processo que esta atalmente no core (e tratar de por la o proximo se existir)
    //colocar esse processo no driver do device ( OperatingSystem.getInstance().getDriver("IODevice").addPCB(pcb); )
    Context re = core.getContext();
    MyPCB tmp = MyOS.getInstance().getCPUJob(core);
    tmp.setContext(re);
    core.load(null);
    MyOS.getInstance().setCPUJob(null, core);
    if(OperatingSystem.getInstance().getScheduler().hasNext()){
      MyPCB tmp2 = MyOS.getInstance().getScheduler().next();
      MyOS.getInstance().setCPUJob(tmp2, core);
      core.load(tmp2.getContext());
    }
    OperatingSystem.getInstance().getDriver("IODevice").addPCB(tmp);
  }

}
