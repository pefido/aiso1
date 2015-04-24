package aiso.sim.os;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AbstractDriver {

  private String deviceDescription;
  private Queue<MyPCB> blocked;

  public AbstractDriver(String description){
    deviceDescription = description;
    blocked = new ConcurrentLinkedQueue<MyPCB>();
  }
  
  public void addPCB(MyPCB pcb){
    blocked.add(pcb);
  }
  
  public MyPCB dequeue(){
    MyPCB tmp = null;
    if(!blocked.isEmpty())
      tmp = blocked.remove();
    return tmp;
  }

  public void sendData(){
    
  }
  
  public void receiveData(){
    
  }
}
