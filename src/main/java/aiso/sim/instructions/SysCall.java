package aiso.sim.instructions;

import java.security.InvalidParameterException;

import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Interrupt;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.os.syscalls.SysCallNumber;

/**
 * Class representing a system call instruction
 * 
 * @author Herve Paulino
 *
 */
public class SysCall implements Instruction {
	
	/**
	 * The system call identifier
	 */
	private final SysCallNumber number;
	
	/**
	 * The system call's arguments
	 */
	private final int[] arguments;
	
	/**
	 * Constructor 
	 * @param number The system call identifier
	 * @param arguments The system call's arguments
	 */
	public SysCall(final SysCallNumber number, final int[] arguments) {
		if (number == null)
			throw new InvalidParameterException();
		this.number = number;
		this.arguments = arguments;
	}
	
	/**
	 * Retrieve the system call's identifier
	 * @return The identifier
	 */
	public SysCallNumber getNumber() {
		return this.number;
	}
	
	@Override
	public void run (final CPUCore cpuCore) throws InvalidRegisterException {
		cpuCore.setRegisters(0, this.number);
		for (int i = 0; i < this.arguments.length; i++) {
			cpuCore.setRegisters(i, this.number);
		}
		cpuCore.handleInterrupt(Interrupt.SYSCALL);
	}
	
	@Override
	public int getCPUClocks() {
		return 1;
	}
	
	@Override
	public String toString() {
		String result = "System call " + number;
		
		if (arguments.length > 0) {
			result += " with arguments";
			for (Integer argument : arguments)	
				result += " " + argument;
		}
		return result;
	}

}
