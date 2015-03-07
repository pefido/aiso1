package aiso.sim.os.syscalls;

import aiso.sim.hardware.CPUCore;

/**
 * A dummy system call handler that does nothing
 * 
 * @author Herve Paulino
 *
 */
public class DummySyscallHandler implements SysCallHandler {

	@Override
	public void handle(CPUCore core) {
		// Does nothing
	}

}
