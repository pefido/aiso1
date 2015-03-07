package aiso.sim.hardware;

import aiso.sim.Configuration;

/**
 * Class that synchronizes the executor of the hardware 
 * 
 * @author Herve Paulino
 *
 */
public class Clock extends Thread {

	/**
	 * Forever invoke method {@link Clockable#tick() tick()} upon all CPU cores and 
	 * hardware devices configure in the {@link aiso.sim.Configuration Configuration} class
	 */
	@Override
	public void run() {
		while (true) {
			for (CPUCore cpuCore : Configuration.cpuCores)
				cpuCore.tick();
			
			for (Clockable device : Configuration.devices)
				device.tick();		
		}
	}
	
}
