package aiso.sim.os;
import interrupts.IHandler;
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
  protected MyScheduler scheduler;
  protected CPUCore MyCPU;
  protected CPUCore[] MyCores;
  public Map<String, AbstractDriver> drivers;

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
    interruptList[Interrupt.IO.ordinal()] = new IHandler();
    drivers = new HashMap<String, AbstractDriver>();
    MyCores = aiso.sim.Configuration.cpuCores;
    for(int i=0; i<Configuration.devices.length; i++){
      if(!Configuration.devices[i].getDescription().equals("Timer"))// criar drivers para todos os devices menos o timer
        drivers.put(Configuration.devices[i].getDescription(), new AbstractDriver(Configuration.devices[i].getDescription()));
    }
    scheduler = new MyScheduler(MyCores);
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
  
  public AbstractDriver getDriver(String device){
    return drivers.get(device);
  }

}
