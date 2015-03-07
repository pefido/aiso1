package aiso.sim.console;

import java.util.List;

/**
 * Implementation of the "shutdown" command
 * 
 * @author Herve Paulino
 *
 */
public class ShutdownCommand extends ConsoleCommand {

	/**
	 * Shuts down the simulator
	 */
	@Override
	public void run(List<String> arguments) {
		Console.out.println("AISO simulator shutting down");
		System.exit(0);
	}

	@Override
	public String getCommandName() {
		return "shutdown";
	}

	@Override
	public String usage() {
		return "shutdown\t - terminate the execution of the OS";
	}

}
