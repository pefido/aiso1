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
	YIELD;
	
	
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
		switch (str) {
		case "SOME_SYSCALL_0" : return SOME_SYSCALL_0;
		case "SOME_SYSCALL_1" : return SOME_SYSCALL_1;
		case "LOAD_PROGRAM" : return LOAD_PROGRAM;
		case "EXIT" : return EXIT;
		case "YIELD" : return YIELD;
		default: throw new NoSuchSysCallException(str);
		}
	}
}
