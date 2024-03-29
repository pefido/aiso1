package aiso.sim.hardware;

import aiso.sim.instructions.Instruction;
import aiso.sim.os.MyOS;
import aiso.sim.os.OperatingSystem;
import aiso.sim.hardware.SimpleCPUCore;

public class Timer extends Interrupter implements Clockable {
  
  /**
   * tempo definido para o timer lançar um interrupt(em ticks)
   */
  private static final int TIMER_TIME = 5000;
  
  /**
   * contador do timer
   */
  private int timer;
  
  private boolean firstTime;
  
  /**
   * core ao qual este timer está atribuido
   */
  private SimpleCPUCore core;
  
  public Timer(SimpleCPUCore core){
    this.core = core;
    timer = TIMER_TIME;
    firstTime = true;
  }

  @Override
  public void tick() {
    if(firstTime){
      timer = TIMER_TIME*100;
      firstTime = false;
    }
      if(timer == 1){
        //lancar interrupt
        core.handleInterrupt(Interrupt.TIMER);
        timer = TIMER_TIME;
      }
      timer--;
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
