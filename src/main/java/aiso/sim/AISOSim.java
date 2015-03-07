package aiso.sim;

import aiso.sim.hardware.Clock;
import aiso.sim.os.OperatingSystem;

/**
 * Entry class for the AISO simulator
 * 
 * @author Herve Paulino
 *
 */
public class AISOSim {

	public static void main(String[] args) {
		new Clock().start();
		OperatingSystem.getInstance().load();		
	}
	
}
