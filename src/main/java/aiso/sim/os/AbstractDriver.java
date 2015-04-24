package aiso.sim.os;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aiso.sim.Configuration;
import aiso.sim.hardware.Clockable;
import aiso.sim.hardware.Interrupt;
import aiso.sim.hardware.PlacaRede;

public class AbstractDriver {

  private String deviceDescription;
  private Queue<MyPCB> blocked;
  private PlacaRede device;
  private MyPCB currentPCB;

  public AbstractDriver(String description, Clockable device){
    deviceDescription = description;
    blocked = new ConcurrentLinkedQueue<MyPCB>();
    this.device = (PlacaRede)device;
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
    //OperatingSystem.getInstance().getScheduler().schedule(currentPCB);
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
  
  /*public MyPCB dequeue(){
    MyPCB tmp = null;
    if(!blocked.isEmpty())
      tmp = blocked.remove();
    return tmp;
  }*/

  /*public void doOperation(int nTicks){
    
  }*/
}
