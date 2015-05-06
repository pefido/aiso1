package aiso.sim.os.syscalls;

import aiso.sim.Configuration;
import aiso.sim.hardware.CPUCore;
import aiso.sim.os.MyOS;

public class StoreHandler implements SysCallHandler{

  @Override
  public void handle(CPUCore core) throws Exception {
    /*Object[] tmp = core.getRegisters();
    for(Object a: tmp){
      System.out.println(a.toString());
    }*/
    //Configuration.mmu.load(page);
  }

}
