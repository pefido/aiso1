package aiso.sim.console;

import java.util.List;

import aiso.sim.os.OperatingSystem;


/**
 * Implementation of the "exec" command
 * 
 * @author Herve Paulino
 *
 */
public class ResetStatsCommand extends ConsoleCommand {

	/**
	 * Executes the program given as argument
	 */
	@Override
	public void run(List<String> arguments) {
    OperatingSystem.getInstance().getStats().reset();
		Console.out.println("Stats reseted");
	}

	@Override
	public String getCommandName() {
		return "reset_stats";
	}
	
	@Override
	public int getNumberArguments() {
		return 0;
	}

	@Override
	public int getNumberOptionalArguments() {
		return 0;
	}

	@Override
	public String usage() {
		return "reset_stats\t\t - reset the statistics of the SO";
	}

}
