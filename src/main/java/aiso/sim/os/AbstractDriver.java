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

  public void sendData(){
    
  }
  
  public void receiveData(){
    
  }
}
