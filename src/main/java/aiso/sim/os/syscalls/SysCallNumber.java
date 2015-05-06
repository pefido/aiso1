package aiso.sim.os.syscalls;

import aiso.sim.instructions.NoSuchSysCallException;

/**
 * The list of featured system calls
 * 
 * @author Herve Paulino
 *
 */
public enum SysCallNumber {
	SOME_SYSCALL_0, // Dummy syscall, replace at will 
	SOME_SYSCALL_1,	// Dummy syscall, replace at will 
	LOAD_PROGRAM,	// Load program 
	EXIT,			// Terminate the execution of the current process	
	YIELD,
	IO,//syscall para fazer io
	STORE,//escrever em memoria
	LOAD;//ler da memoria
	
	
	/**
	 * Array representation of the enum
	 */
	private static final SysCallNumber[] values = values();
	
	/**
	 * Obtain a {@link SysCallNumber} representation from an int
	 * @param number The syscall number
	 * @return The SysCallNumber
	 */
	public static SysCallNumber fromInt (int number) {
		return values[number];
	}
	
	/**
	 * Obtain a {@link SysCallNumber} representation from a string
	 * @param str The string
	 * @return The SysCallNumber
	 */
	public static SysCallNumber fromString (String str) throws NoSuchSysCallException {
		for(SysCallNumber scn: values) {
			if (scn.toString().equalsIgnoreCase(str)) {
				return scn;
			}
		}
		throw new NoSuchSysCallException(str);
	}
}
