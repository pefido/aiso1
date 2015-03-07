package aiso.sim.os;

import java.io.PrintStream;

/**
 * A simple logging class
 * 
 * @author Herve Paulino
 *
 */
public class Logger {

	/**
	 * The output stream
	 */
	private static final PrintStream out = System.out;
	
	/**
	 * The error stream
	 */
	private static final PrintStream err = System.err;
	
	/**
	 * Emit an info message
	 * @param message The message
	 */
	public static synchronized void info(String message) {
		out.println(message);
	}
	
	/**
	 * Emit an error message
	 * @param message The message
	 */
	public static synchronized void error(String message) {
		err.println(message);
	}
	
	/**
	 * Emit an internal error message, ie an error resulting from a bug in the OS implementation)
	 * @param message The message
	 */
	public static synchronized void internalError(String message) {
		err.println("Internal error: " + message);
	}
}
