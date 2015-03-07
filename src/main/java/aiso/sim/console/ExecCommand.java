package aiso.sim.console;

import java.util.List;

import aiso.sim.Configuration;
import aiso.sim.hardware.Interrupt;
import aiso.sim.os.syscalls.SysCallNumber;

/**
 * Implementation of the "exec" command
 * 
 * @author Herve Paulino
 *
 */
public class ExecCommand extends ConsoleCommand {

	/**
	 * Executes the program given as argument
	 */
	@Override
	public void run(List<String> arguments) {
		try {
			// For simplicity's sake we are assuming that the console is 
			// always run by CPU core 0, and thus the exec syscall commands 
			// are always targeted at that same core
			Configuration.cpuCores[0].setRegisters(0, SysCallNumber.LOAD_PROGRAM, arguments.get(0));
			Configuration.cpuCores[0].handleInterrupt(Interrupt.SYSCALL);
			
		} catch (Exception e) {
			Console.err.println(e.getMessage());
		}
	}

	@Override
	public String getCommandName() {
		return "exec";
	}

	@Override
	public String usage() {
		return "exec prog\t - execute program \"prog\"";
	}

}
