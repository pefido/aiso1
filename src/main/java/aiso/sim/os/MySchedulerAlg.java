package aiso.sim.os;

//Interface para os algoritmos de escalonamento
public interface MySchedulerAlg {
	
	// Receber um processo e escaloná-lo
	public void schedule(MyPCB process);
	
	// Devolver o próximo processo da fila
	public MyPCB next();
	
	// Verificar se existe próximo processo
	public boolean hasNext();

}
