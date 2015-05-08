package interrupts;

import aiso.sim.Configuration;
import aiso.sim.hardware.CPUCore;
import aiso.sim.os.InterruptHandler;

public class MemLoadHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
  //tirar os 20 primeiros bits para a pagina
    int page = ((int)((long)core.getRegister(0)) >> 12) & 0xfffff;
    Configuration.mmu.load(page);
    
  }

}
