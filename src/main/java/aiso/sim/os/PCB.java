package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;

import aiso.sim.hardware.CPUCore;

public class PCB {
	private Queue<MyProcess> pQueue;
	private CPUCore runCPU;
	private MyProcess CPUJob;
	
	
	public PCB(CPUCore core){
		pQueue = new LinkedList<MyProcess>();
		runCPU = core;
		CPUJob = null;
	}
	
	public void add(MyProcess a){//exec
		if(runCPU.getContext() == null){
			CPUJob = a;
			runCPU.load(a.getContext());
		}
		else pQueue.add(a);
	}
	
	public void dequeue(){//exit
		if(pQueue.isEmpty()){
			CPUJob = null;
			runCPU.load(null);
		}
		else {
			CPUJob = pQueue.peek();
			runCPU.load(pQueue.remove().getContext());
		}
	}
	
	public void requeue(){//Yield
		pQueue.add(CPUJob);
		CPUJob = pQueue.peek();
		runCPU.load(pQueue.remove().getContext());
	}
	
}
