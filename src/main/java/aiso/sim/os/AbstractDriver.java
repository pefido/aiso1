package aiso.sim.os;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aiso.sim.Configuration;
import aiso.sim.hardware.Clockable;
import aiso.sim.hardware.Interrupt;
import aiso.sim.hardware.IODevice;

public class AbstractDriver {

  private String deviceDescription;
  private Queue<MyPCB> blocked;
  private IODevice device;
  private MyPCB currentPCB;

  public AbstractDriver(String description, Clockable device){
    deviceDescription = description;
    blocked = new ConcurrentLinkedQueue<MyPCB>();
    this.device = (IODevice)device;
    currentPCB = null;
  }
  
  public void addPCB(MyPCB pcb){
    if(currentPCB == null){
      currentPCB = pcb;
      device.doOperation();
    }
    else
      blocked.add(pcb);
  }
  
  public void removePCB(){
    Configuration.cpuCores[0].handleInterrupt(Interrupt.IO);
    currentPCB = null;
    if(!blocked.isEmpty()){
      currentPCB = blocked.remove();
      device.doOperation();
    }
  }
  
  public MyPCB getCurrentPCB(){
    return currentPCB;
  }
  
  public String getDescrition(){
    return deviceDescription;
  }
}
