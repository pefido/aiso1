package aiso.sim.hardware;

import aiso.sim.os.Logger;
import aiso.sim.os.MyPCB;
import aiso.sim.os.OperatingSystem;

public class PlacaRede implements Clockable{


  private static final int OP_TICKS = 10000000;

  private int timer;

  public PlacaRede(){
    timer = 0;
  }

  @Override
  public void tick() {
      if(timer > 0){
        timer--;
        if(timer == 0){
          OperatingSystem.getInstance().getDriver("Placa de rede").removePCB();
        }
      }
  }

  
  public void doOperation(){
    timer = OP_TICKS;
  }

  @Override
  public String getDescription() {
    return "Placa de rede";
  }

}
