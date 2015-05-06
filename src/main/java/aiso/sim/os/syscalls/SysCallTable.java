package aiso.sim.os.syscalls;

import java.util.HashMap;
import java.util.Map;

public class SysCallTable {
	
	static final Map<SysCallNumber, SysCallHandler> table = 
			new HashMap<SysCallNumber, SysCallHandler>();
			
	static {
		table.put (SysCallNumber.SOME_SYSCALL_0, new DummySyscallHandler());
		table.put (SysCallNumber.SOME_SYSCALL_1, new DummySyscallHandler());
		table.put (SysCallNumber.LOAD_PROGRAM, new LoadSysCallHandler());
		table.put (SysCallNumber.EXIT, new ExitSyscallHandler());
		table.put (SysCallNumber.YIELD, new YieldSysCallHandler());
		table.put (SysCallNumber.IO, new IOSyscallHandler());
		table.put (SysCallNumber.STORE, new StoreHandler());
		table.put (SysCallNumber.LOAD, new LoadHandler());
	}
	
	public static SysCallHandler getHandler(SysCallNumber number) {
		return table.get(number);
	}
}
