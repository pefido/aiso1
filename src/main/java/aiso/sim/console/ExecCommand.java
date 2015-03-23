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
			for (String programFile: arguments) {
				Configuration.cpuCores[0].setRegisters(0, SysCallNumber.LOAD_PROGRAM, programFile);
				Configuration.cpuCores[0].handleInterrupt(Interrupt.SYSCALL);
			}
			
		} catch (Exception e) {
			Console.err.println(e.getMessage());
		}
	}

	@Override
	public String getCommandName() {
		return "exec";
	}
	
	@Override
	public int getNumberArguments() {
		return 1;
	}

	@Override
	public int getNumberOptionalArguments() {
		return Integer.MAX_VALUE - 1;
	}

	@Override
	public String usage() {
		return "exec prog\t\t - execute program \"prog\"";
	}

}
