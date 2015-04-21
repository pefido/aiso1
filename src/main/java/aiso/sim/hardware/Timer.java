package aiso.sim.hardware;

import aiso.sim.instructions.Instruction;


public class Timer extends Interrupter implements Clockable {
  
  /**
   * tempo definido para o timer lançar um interrupt(em ticks)
   */
  private static final int TIMER_TIME = 100;

  @Override
  public void tick() {
    int timer = TIMER_TIME;
    while(true){
      if(timer == 1){
        //lancar interrupt
        timer = TIMER_TIME;
      }
      timer--;
    }
  }

  @Override
  public String getDescription() {
    return "Timer";
  }

}
