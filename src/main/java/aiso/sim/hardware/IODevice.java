package aiso.sim.hardware;

import aiso.sim.os.Logger;
import aiso.sim.os.MyPCB;
import aiso.sim.os.OperatingSystem;

public class IODevice implements Clockable{


  private static final int OP_TICKS = 99999999;

  private int timer;

  public IODevice(){
    timer = 0;
  }

  @Override
  public void tick() {
      if(timer > 0){
        timer--;
        if(timer == 0){
          OperatingSystem.getInstance().getDriver("IODevice").removePCB();
        }
      }
  }

  
  public void doOperation(){
    timer = OP_TICKS;
  }

  @Override
  public String getDescription() {
    return "IODevice";
  }

}
