package interrupts;

import aiso.sim.Configuration;
import aiso.sim.hardware.CPUCore;
import aiso.sim.os.InterruptHandler;

public class MemLoadHandler implements InterruptHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
  //tirar os 20 primeiros bits para a pagina
    /*String tmpString = Long.toHexString((long)core.getRegister(0));
    //System.out.println(core.getRegister(0));
    //System.out.println(tmpString);
    int diff = 8 - tmpString.length();
    //if(diff > 4)
      //diff = 5;
    //System.out.println(diff);
    tmpString = tmpString.substring(0, 5-diff);
    //System.out.println(tmpString);
    long page = Long.parseLong(tmpString, 16);*/
    //System.out.println(page);
    
    int page = ((int)((long)core.getRegister(0)) >> 12) & 0xfffff;
    Configuration.mmu.load(page);
    
  }

}
