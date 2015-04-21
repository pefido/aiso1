package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;

import aiso.sim.hardware.CPUCore;

public class MyScheduler {

  private Queue<MyPCB> pQueue;
  private CPUCore[] runCPUs;
  private MyPCB[] CPUJob;


  public MyScheduler(CPUCore[] cores){
    pQueue = new LinkedList<MyPCB>();
    runCPUs = cores;
    CPUJob = new MyPCB[] {null, null, null};
  }

  public void enqueue(MyPCB a){//exec
    int tempCore = -1;
    for(int i=0; i<runCPUs.length; i++){
      if(runCPUs[i].getContext() == null)
        tempCore = i;
    }
    if(tempCore != -1){
      CPUJob[tempCore] = a;
      runCPUs[tempCore].load(a.getContext());
    }
    else pQueue.add(a);
  }

  public void dequeue(CPUCore core){//exit
    int tempCore = -1;
    for(int i=0; i<runCPUs.length && i!=-1; i++){
      if(runCPUs[i].equals(core))
        tempCore = i;
    }
    if(pQueue.isEmpty()){
      CPUJob[tempCore] = null;
      runCPUs[tempCore].load(null);
    }
    else {
      CPUJob[tempCore] = pQueue.peek();
      runCPUs[tempCore].load(pQueue.remove().getContext());
    }
  }

  public void requeue(CPUCore core){//Yield
    int tempCore = -1;
    for(int i=0; i<runCPUs.length && i!=-1; i++){
      if(runCPUs[i].equals(core))
        tempCore = i;
    }
    //System.out.println(tempCore);

    pQueue.add(CPUJob[tempCore]);
    CPUJob[tempCore] = pQueue.peek();
    //System.out.println(pQueue.peek().getContext());
    runCPUs[tempCore].load(pQueue.remove().getContext());
  }
}