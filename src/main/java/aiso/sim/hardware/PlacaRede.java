package aiso.sim.hardware;

import aiso.sim.os.Logger;

public class PlacaRede implements Clockable{


  private static final int TIMER_TIME = Integer.MAX_VALUE;

  @Override
  public void tick() {
    int timer = TIMER_TIME;
    while(true){
      if(timer == 1){
        //lancar interrupt
        //Logger.info("Pacote recebido");
        timer = TIMER_TIME;
      }
      timer--;
    }
  }

  @Override
  public String getDescription() {
    return "Placa de rede";
  }

}
