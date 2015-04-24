package aiso.sim.hardware;

import aiso.sim.os.Logger;
import aiso.sim.os.MyPCB;
import aiso.sim.os.OperatingSystem;

public class PlacaRede implements Clockable{


  private static final int TIMER_TIME = Integer.MAX_VALUE;

  private MyPCB currentPCB;
  
  public PlacaRede(){
    currentPCB = null;
  }

  @Override
  public void tick() {
    currentPCB = OperatingSystem.getInstance().getDriver("Placa de rede").dequeue();
    if(currentPCB != null){
      //do operation with x ticks
    }
  }

  @Override
  public String getDescription() {
    return "Placa de rede";
  }

}
