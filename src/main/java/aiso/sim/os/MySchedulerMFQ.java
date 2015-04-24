package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aiso.sim.hardware.CPUCore;

public class MySchedulerMFQ implements MySchedulerAlg{

	public static final int NQUEUES = 4;
	private Queue<MyPCB> pQueue;
	private Queue[] qList;
  private MyPCB[] CPUJob;

	public MySchedulerMFQ(CPUCore[] cores){

		//Criar a lista de queues
		qList = new Queue[NQUEUES];
		for (int i = 0; i < NQUEUES; i++) {
			qList[i] = new ConcurrentLinkedQueue<MyPCB>();
		}

		pQueue = new ConcurrentLinkedQueue<MyPCB>();//lista thread safe
    CPUJob = new MyPCB[] {null, null, null};
	}

	@Override
	public void schedule(MyPCB process) {
	  // Se o processo era o que estava a correr no CPU, baixa-lhe a prioridade
	  if (CPUJob[0] != null && process.getPID() == CPUJob[0].getPID()) {
	    //Despromover processo
	  }
		// Saber para qual das queues vai o processo
	  // Por agora random
		int fila = (int) (Math.random() * NQUEUES);

		//Cálculo do quantum depende da fila (110 - 10*i)
		process.setQuantum(110 - 10 * fila);
		
		// Por fim adicionar à fila certa
		qList[fila].add(process);

	}

	@Override
	public MyPCB next() {
		int core = 0;
		//iterar pelas queues
		for (int i = 0; i < NQUEUES; i++) {
			Queue q = qList[i];
			if (!q.isEmpty()) {
			  MyPCB res = (MyPCB) q.remove();
				CPUJob[0] = res;
				return res;
			}
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		for (int i = 0; i < NQUEUES; i++) {
			Queue q = qList[i];
			if (!q.isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
