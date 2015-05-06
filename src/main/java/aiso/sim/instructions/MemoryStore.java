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
	  int[] tmp = {(int)address};
	  new SysCall(SysCallNumber.STORE, tmp).run(cpuCore);
	  System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Store to memory address " + address;
	}

}
