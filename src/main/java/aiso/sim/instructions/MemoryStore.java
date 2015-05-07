package aiso.sim.instructions;

import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Interrupt;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.os.MyOS;
import aiso.sim.os.syscalls.SysCallNumber;

/**
 * Class representing a memory store instruction
 * 
 * @author Herve Paulino
 *
 */
public class MemoryStore extends MemoryAccess {
	
	/**
	 * Construct a memory store operation
	 * @param address Target address
	 */
	public MemoryStore(long address) {
		super(address);
	}
	
	@Override
	public void run (CPUCore cpuCore) throws InvalidRegisterException {
	  System.out.println(this);
	  cpuCore.setRegisters(0, address);
    cpuCore.handleInterrupt(Interrupt.STORE);
	}
	
	@Override
	public String toString() {
		return "Store to memory address " + address;
	}

}
