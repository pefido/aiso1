package aiso.sim.hardware;

import aiso.sim.instructions.Instruction;
import aiso.sim.hardware.SimpleCPUCore;

public class Timer extends Interrupter implements Clockable {
  
  /**
   * tempo definido para o timer lançar um interrupt(em ticks)
   */
  private static final int TIMER_TIME = 1000000000;
  
  /**
   * core ao qual este timer está atribuido
   */
  private SimpleCPUCore core;
  
  public Timer(SimpleCPUCore core){
    this.core = core;
  }

  @Override
  public void tick() {
    int timer = TIMER_TIME;
    while(true){
      if(timer == 1){
        //lancar interrupt
        core.handleInterrupt(Interrupt.TIMER);
        timer = TIMER_TIME;
      }
      timer--;
    }
  }

  @Override
  public String getDescription() {
    return "Timer";
  }
  
  /**
   * associar este timer a um core
   * @param core core com o qual este timer vai ficar associado
   */
  public void setCore(SimpleCPUCore core){
    this.core = core;
  }
  
  /**
   * @return core a qual este timer esta associado
   */
  public SimpleCPUCore getCore(){
    return core;
  }

}
