package interrupts;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.InterruptHandler;
import aiso.sim.os.Logger;

public class TimerHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    //Logger.info("Timer interrupt");
  }

}
