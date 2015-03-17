package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;

import aiso.sim.hardware.CPUCore;

public class PCB {
	Queue<Context> pQueue;
	CPUCore runCPU;
	
	public PCB(CPUCore core){
		pQueue = new LinkedList<Context>();
		runCPU = core;
	}
	
	public void add(Context a){//exec
		if(runCPU.getContext() == null)
			runCPU.load(a);
		else pQueue.add(a);
	}
	
	public void dequeue(){//exit
		if(pQueue.isEmpty())
			runCPU.load(null);
		else runCPU.load(pQueue.remove());
	}
	
	public void requeue(){//Yield
		pQueue.add(runCPU.getContext());
		runCPU.load(pQueue.remove());
	}
	
}
