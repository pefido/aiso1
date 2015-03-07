package aiso.sim.console;

import java.util.List;

/**
 * Base class for the implementation of console commands
 * 
 * @author Herve Paulino
 *
 */
public abstract class ConsoleCommand {
	
	/**
	 * The name that the user must use to invoke the command
	 * @return The name of the command
	 */
	public abstract String getCommandName();
	
	/**
	 * The implementation of the command
	 * @param arguments List of arguments that the command receives
	 */
	public abstract void run(List<String> arguments);
	
	/**
	 * A string representation of the command's usage.
	 * Posted by the console's {@link HelpCommand help} command.
	 * @return The string representation of the command's usage.
	 */
	public abstract String usage();
}
