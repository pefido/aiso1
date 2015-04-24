package aiso.sim.os;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aiso.sim.hardware.CPUCore;

public class MySchedulerMFQ implements MySchedulerAlg{

	public static final int NQUEUES = 4;
	private Queue<MyPCB> pQueue;
	private Queue[] qList;

	public MySchedulerMFQ(CPUCore[] cores){

		//Criar a lista de queues
		qList = new Queue[NQUEUES];
		for (int i = 0; i < NQUEUES; i++) {
			qList[i] = new ConcurrentLinkedQueue<MyPCB>();
		}

		pQueue = new ConcurrentLinkedQueue<MyPCB>();//lista thread safe
	}

	@Override
	public void schedule(MyPCB process) {
		// Saber para qual das queues vai o processo
		// Como ainda não sei como fazer isso, vai random :D
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
				return (MyPCB) q.remove();
			}
		}
		return null; // BLÉH
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
