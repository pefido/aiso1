package interrupts;

import aiso.sim.hardware.CPUCore;
import aiso.sim.os.InterruptHandler;
import aiso.sim.os.OperatingSystem;

/**
 * @author pefido
 *classe handler que trata os interrupts dos devices a fazerem input
 */
public class IHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    System.out.println("interrupt IO");
    OperatingSystem.getInstance().getScheduler().schedule(OperatingSystem.getInstance().getDriver("Placa de rede").getCurrentPCB());
    if(core.getContext() == null)
      core.load(OperatingSystem.getInstance().getScheduler().next().getContext());
  }

}
