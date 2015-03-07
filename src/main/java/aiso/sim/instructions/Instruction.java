package aiso.sim.instructions;

import aiso.sim.hardware.CPUCore;

/**
 * Interface for the set of instructions supported by the AISO CPU cores
 * 
 * @author Herve Paulino
 *
 */
public interface Instruction {
	
	/**
	 * The implementation of the instruction
	 * @param cpuCore The CPU core where the instruction is running
	 * @throws Exception Raised if the instruction accesses resources it should not
	 */
	public abstract void run(final CPUCore cpuCore) throws Exception;
	
	/**
	 * The number of the CPU clocks the instruction takes to execute
	 * @return The number of the CPU clocks
	 */
	public abstract int getCPUClocks();
}
