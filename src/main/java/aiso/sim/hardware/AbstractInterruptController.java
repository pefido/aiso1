package aiso.sim.hardware;

import aiso.sim.Configuration;
import aiso.sim.os.Logger;

/**
 * The base class for the implementation of interrupt controllers
 * 
 * @author Herve Paulino
 *
 */
public abstract class AbstractInterruptController {

	/**
	 * The single instance of the interrupt controller
	 */
	private static AbstractInterruptController instance = null;
	
	/**
	 * Obtain the instance of the interrupt controller
	 * @return The interrupt controller
	 */
	public static final synchronized AbstractInterruptController getInstance() {
		if (instance == null) {
			try {
				instance = Configuration.interruptControlerClass.getConstructor().newInstance();
			}
			catch (Exception e) {
				Logger.internalError("The operating system class may not be properly "
						+ "defined in the Configuration class - got error: " + e.getLocalizedMessage());
				System.exit(1);
			}
		}
		return instance;
	}
	/**
	 * Handle the given interrupt to a CPU core
	 * @param interrupt The interrupt
	 */
	public void handleInterrupt(Interrupt interrupt) {
		selectCPUCore().handleInterrupt(interrupt);
	}
	
	/**
	 * Select the CPU core to execute the interrupt handler
	 * @return The CPU core
	 */
	protected abstract CPUCore selectCPUCore();

}
