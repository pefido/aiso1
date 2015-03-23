package aiso.sim.os;

import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.os.syscalls.SysCallNumber;
import aiso.sim.os.syscalls.SysCallTable;

/**
 * The interrupt handler for system calls
 * 
 * @author Herve
 *
 */
class SysCallInterruptHandler implements InterruptHandler {

	/**
	 * The handler implementation.
	 * It inspects {@link SysCallTable} to invoke the handler associated to the system call
	 * number retrieved from register(0)
	 */
	@Override
	public void handle(CPUCore cpuCore) throws Exception{
			SysCallNumber number =  cpuCore.<SysCallNumber>getRegister(0);
			Logger.info("CPU core " + cpuCore + " is handling system call " + number);
			
			SysCallTable.getHandler(number).handle(cpuCore);
	}

}
