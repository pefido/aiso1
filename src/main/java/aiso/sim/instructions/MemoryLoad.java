package aiso.sim.instructions;

import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Interrupt;
import aiso.sim.hardware.InvalidRegisterException;

/**
 * Class representing a memory load instruction
 * 
 * @author Herve Paulino
 *
 */
public class MemoryLoad extends MemoryAccess {
	
	/**
	 * Construct the memory load operation
	 * @param address The source address
	 */
	public MemoryLoad(long address) {
		super(address);
	}
	
	@Override
	public void run (CPUCore cpuCore) throws InvalidRegisterException {
		System.out.println(this);
		cpuCore.setRegisters(0, address);
    cpuCore.handleInterrupt(Interrupt.LOAD);
	}
	
	@Override
	public String toString() {
		return "Load from memory address " + address;
	}

}
