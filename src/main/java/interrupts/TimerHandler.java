package interrupts;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.Context;
import aiso.sim.os.InterruptHandler;
import aiso.sim.os.Logger;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.OperatingSystem;

public class TimerHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    MySchedulerAlg scheduler = OperatingSystem.getInstance().getScheduler();
    Context re = (Context) core.getContext();
    if (core.getContext() != null) {
      //TODO:Despromover processo, voltar a por lá outro
      scheduler.schedule(new MyPCB(re));
      core.load(scheduler.next().getContext());
    }
    //Logger.info("Timer interrupt");
  }

}
