package aiso.sim.hardware;

/**
 * Base class for an hardware component that may interrupt the CPU
 * 
 * @author Herve Paulino
 *
 */
public abstract class Interrupter {
	
	/**
	 * Send interrupt to the interrupt controller
	 * @param interrupt
	 */
	void interrupt(Interrupt interrupt) {
		AbstractInterruptController.getInstance().handleInterrupt(interrupt);
	}
}

