package aiso.sim.os;
import interrupts.IHandler;
import interrupts.MemLoadHandler;
import interrupts.MemStoreHandler;
import interrupts.TimerHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiso.sim.Configuration;
import aiso.sim.Program;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Clockable;
import aiso.sim.console.*;
import aiso.sim.hardware.*;
import aiso.sim.os.SysCallInterruptHandler;

public class MyOS extends OperatingSystem{

  protected InterruptHandler[] interruptList;
  protected MySchedulerAlg scheduler;
  protected CPUCore MyCPU;
  protected CPUCore[] MyCores;
  public Map<String, AbstractDriver> drivers;
  public MyStats stats;
  private Map<CPUCore, MyPCB> CPUJob;

  @Override
  public void load() {

    //1: listar hardware encontrado
    for(int i=0; i<Configuration.devices.length; i++){
      System.out.println(Configuration.devices[i].getDescription());
      
    }

    //2: inicializar estruturas de dados internas
    MyCores = aiso.sim.Configuration.cpuCores;
    interruptList = new InterruptHandler[20];
    interruptList[Interrupt.TIMER.ordinal()] = new TimerHandler();
    interruptList[Interrupt.SYSCALL.ordinal()] = new SysCallInterruptHandler();
    interruptList[Interrupt.IO.ordinal()] = new IHandler();
    interruptList[Interrupt.STORE.ordinal()] = new MemStoreHandler();
    interruptList[Interrupt.LOAD.ordinal()] = new MemLoadHandler();
    CPUJob = new HashMap<CPUCore, MyPCB>();
    scheduler = aiso.sim.Configuration.scheduler;
    drivers = new HashMap<String, AbstractDriver>();

    for(int i=0; i<Configuration.devices.length; i++){
      if(!Configuration.devices[i].getDescription().equals("Timer") && !Configuration.devices[i].getDescription().contains("RAM") && !Configuration.devices[i].getDescription().equals("MMU"))
        drivers.put(Configuration.devices[i].getDescription(), new AbstractDriver(Configuration.devices[i].getDescription(), Configuration.devices[i]));
    }

    terminal = new Console();
    stats = new MyStats();


    //3: lancar execucao da consola
    terminal.run();
    
  }

  @Override
  public InterruptHandler[] getInterruptVector() {
    // TODO Auto-generated method stub
    return interruptList;
  }

  public MySchedulerAlg getScheduler(){
    return scheduler;
  }

   public MyStats getStats(){
    return stats;
  } 

  public AbstractDriver getDriver(String device){
    return drivers.get(device);
  }
  
  /**
   * @return o pcb cujo contexto está atualmente a correr no core
   */
  public MyPCB getCPUJob(CPUCore core){
    return CPUJob.get(core);
  }
  
  /**
   * @param job o pcb cujo contexto vai para o core
   */
  public void setCPUJob(MyPCB job, CPUCore core){
    CPUJob.put(core, job);
  }

}
