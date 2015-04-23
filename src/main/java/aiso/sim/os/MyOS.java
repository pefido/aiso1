package aiso.sim.os;
import interrupts.TimerHandler;

import java.util.List;

import aiso.sim.Configuration;
import aiso.sim.Program;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Clockable;
import aiso.sim.console.*;
import aiso.sim.hardware.*;
import aiso.sim.os.SysCallInterruptHandler;

public class MyOS extends OperatingSystem{

  protected InterruptHandler[] interruptList;
  protected MyScheduler scheduler;
  protected CPUCore MyCPU;
  protected CPUCore[] MyCores;

  @Override
  public void load() {

    //1: listar hardware encontrado
    for(int i=0; i<Configuration.devices.length; i++){
      System.out.println(Configuration.devices[i].getDescription());
      
    }

    //2: inicializar estruturas de dados internas
    interruptList = new InterruptHandler[20];
    interruptList[Interrupt.SYSCALL.ordinal()] = new SysCallInterruptHandler();
    interruptList[Interrupt.TIMER.ordinal()] = new TimerHandler();
    MyCores = aiso.sim.Configuration.cpuCores;
    //scheduler = new MyScheduler(MyCores);
    scheduler = aiso.sim.Configuration.scheduler;
    terminal = new Console();


    //3: lancar execucao da consola
    terminal.run();
  }

  @Override
  public InterruptHandler[] getInterruptVector() {
    // TODO Auto-generated method stub
    return interruptList;
  }

  public MyScheduler getScheduler(){
    return scheduler;
  }

}
