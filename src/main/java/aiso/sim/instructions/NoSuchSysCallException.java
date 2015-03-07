package aiso.sim.instructions;

import aiso.sim.os.syscalls.SysCallNumber;

/**
 * Thrown when the system call identifier is not within the range of valid identifiers
 *  
 * @author Herve Paulino
 *
 */
public class NoSuchSysCallException extends Exception {

	/**
	 * Default serial versiob id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construct exception 
	 * @param number The invalid system call identifier
	 */
	public NoSuchSysCallException (int number) {
		super ("Invalid system call number " + number);
	}

	/**
	 * Construct exception 
	 * @param number The invalid system call identifier
	 */
	public NoSuchSysCallException (SysCallNumber number) {
		super ("Invalid system call number " + number);
	}
	
	/**
	 * Construct exception 
	 * @param syscall Textual representation of the invalid system call identifier
	 */
	public NoSuchSysCallException (String syscall) {
		super ("Invalid system call number " + syscall);
	}
}
