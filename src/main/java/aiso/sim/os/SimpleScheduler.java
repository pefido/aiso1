package aiso.sim.os;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aiso.sim.hardware.CPUCore;

public class SimpleScheduler implements MySchedulerAlg{

  private Queue<MyPCB> pQueue;

  public SimpleScheduler(){
    pQueue = new ConcurrentLinkedQueue<MyPCB>();//lista thread safe
  }

  @Override
  public void schedule(MyPCB process) {
    //adicionar à fila
    pQueue.add(process);

  }

  @Override
  public MyPCB next() {
    MyPCB res = null;
    if(!pQueue.isEmpty()){
      res = pQueue.remove();
    }
    return res;
  }

  @Override
  public boolean hasNext() {
    boolean res = true;;
    if(pQueue.isEmpty())
      res = false;
    return res;
  }
}
