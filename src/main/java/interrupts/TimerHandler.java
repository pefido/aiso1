package interrupts;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.InterruptHandler;
import aiso.sim.os.Logger;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;

public class TimerHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    
    //STATS
    MyStats stats = OperatingSystem.getInstance().getStats();
    
    MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    MyPCB tmp = MyOS.getInstance().getCPUJob(core);
    //Context re = (Context) core.getContext();
    if (core.getContext() != null) {
      stats.stopCPU();
      //TODO:Despromover processo, voltar a por lá outro
      //TODO:Só volta a por lá outro se houver!!!
      scheduler.schedule(tmp);
      tmp = scheduler.next();
      MyOS.getInstance().setCPUJob(tmp, core);
      core.load(tmp.getContext());
      stats.plusCPU();
    }
    //Logger.info("Timer interrupt");
  }

}
