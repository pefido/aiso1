package aiso.sim.os.syscalls;

import java.util.HashMap;
import java.util.Map;

public class SysCallTable {
	
	static final Map<SysCallNumber, SysCallHandler> table = 
			new HashMap<SysCallNumber, SysCallHandler>();
			
	static {
		table.put (SysCallNumber.SOME_SYSCALL_0, new DummySyscallHandler());
		table.put (SysCallNumber.SOME_SYSCALL_1, new DummySyscallHandler());
		table.put (SysCallNumber.LOAD_PROGRAM, new DummySyscallHandler());
		table.put (SysCallNumber.EXIT, new DummySyscallHandler());
	}
	
	public static SysCallHandler getHandler(SysCallNumber number) {
		return table.get(number);
	}
}
