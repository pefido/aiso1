package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;

import aiso.sim.hardware.CPUCore;

public class PCB {
	private Queue<MyProcess> pQueue;
	private CPUCore[] runCPUs;
	private MyProcess[] CPUJob;
	
	
	public PCB(CPUCore[] cores){
		pQueue = new LinkedList<MyProcess>();
		runCPUs = cores;
		CPUJob = new MyProcess[] {null, null, null};
	}
	
	public void add(MyProcess a){//exec
		int tempCore = -1;
		//System.out.println("cenas aqui");
		for(int i=0; i<runCPUs.length /*|| tempCore != -1*/; i++){
			if(runCPUs[i].getContext() == null)
				tempCore = i;
		}
		//System.out.println("tempcore: " + tempCore);
		if(tempCore != -1){
			//System.out.println("load crl");
			CPUJob[tempCore] = a;
			runCPUs[tempCore].load(a.getContext());
		}
		else pQueue.add(a);
		
		
		/*if(runCPU.getContext() == null){
			CPUJob = a;
			runCPU.load(a.getContext());
		}
		else pQueue.add(a);*/
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
		
		pQueue.add(CPUJob[tempCore]);
		CPUJob[tempCore] = pQueue.peek();
		runCPUs[tempCore].load(pQueue.remove().getContext());
	}
	
}
