package aiso.sim.os;

import aiso.sim.hardware.CPUCore;

/**
 * Interface for an interrupt handler
 * 
 * @author Herve Paulino
 *
 */
public interface InterruptHandler {

	/**
	 * Handler implementation
	 * @param core The core where the interrupt is being handled
	 */
	void handle(CPUCore core) throws Exception;
}
