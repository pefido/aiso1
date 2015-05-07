package interrupts;

import aiso.sim.Configuration;
import aiso.sim.hardware.CPUCore;
import aiso.sim.os.InterruptHandler;
import aiso.sim.os.MyOS;

public class MemStoreHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    //tirar os 20 primeiros bits para a pagina
    String tmpString = Long.toHexString((long)core.getRegister(0));
    int diff = 8 - tmpString.length();
    tmpString = tmpString.substring(0, 5-diff);
    long page = Long.parseLong(tmpString, 16);
    Configuration.mmu.store(page);
  }

}
