package aiso.sim.instructions;

import aiso.sim.Configuration;
import aiso.sim.os.syscalls.SysCallNumber;

/**
 * Factory for the creation of instances of each instruction supported by the CPU cores
 * 
 * @author Herve Paulino
 *
 */
public class InstructionFactory {

	/**
	 * See {@link aiso.sim.Configuration#computationClass}
	 */
	private static Class<Computation> computationClass = Configuration.computationClass;

	/**
	 * See {@link aiso.sim.Configuration#sysCallClass}
	 */
	private static Class<SysCall> sysCallClass = Configuration.sysCallClass;

	/**
	 * See {@link aiso.sim.Configuration#memoryLoadAccessClass}
	 */
	private static Class<MemoryLoad> memoryLoadAccessClass = Configuration.memoryLoadAccessClass;

	/**
	 * See {@link aiso.sim.Configuration#memoryStoreAccessClass}
	 */
	private static Class<MemoryStore> memoryStoreAccessClass = Configuration.memoryStoreAccessClass;	
	
	/**
	 * Create an instance of a {@link Computation computation instruction}
	 * @param clockCycles Clock cycles the computation takes
	 * @return An instance of the {@link aiso.sim.Configuration#computationClass configured computation class}
	 */
	public static Computation newComputation(int clockCycles) {
		try {
			return computationClass.getConstructor(int.class).newInstance(clockCycles);
		}
		catch (Exception e) {
			System.err.println("Internal error: " + e.getLocalizedMessage());
			System.exit(1);
			return null; // dummy return 
		}
	}
	
	/**
	 * Create an instance of a {@link SysCall syscall instruction}
	 * @param sysCall The identifier of the system call
	 * @param arguments The arguments of the system call
	 * @return An instance of the {@link aiso.sim.Configuration#sysCallClass configured system call class}
	 */
	public static SysCall newSysCall(String sysCall, int[] arguments) {
		try {
			return sysCallClass.getConstructor(SysCallNumber.class, int[].class).newInstance(SysCallNumber.fromString(sysCall), arguments);
		}
		catch (Exception e) {
			System.err.println("Internal error: " + e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(1);
			return null; // dummy return 
		}
	}
	
	/**
	 * Create an instance of a {@link MemoryLoad load instruction}
	 * @param address The source address
	 * @return An instance of the {@link aiso.sim.Configuration#memoryLoadAccessClass configured memory load class}
	 */
	public static MemoryAccess newMemoryLoad(long address) {
		try {
			return memoryLoadAccessClass.getConstructor(long.class).newInstance(address);
		}
		catch (Exception e) {
			System.err.println("Internal error: " + e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(1);
			return null; // dummy return 
		}
	}

	/**
	 * Create an instance of a {@link MemoryStore store instruction}
	 * @param address The destination address
	 * @return An instance of the {@link aiso.sim.Configuration#memoryStoreAccessClass configured memory store class}
	 */
	public static MemoryAccess newMemoryStore(long address) {
		try {
			return memoryStoreAccessClass.getConstructor(long.class).newInstance(address);
		}
		catch (Exception e) {
			System.err.println("Internal error: " + e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(1);
			return null; // dummy return 
		}
	}
	
	/**
	 * Create an instance of a {@link Loop loop instruction}
	 * @param numIterations Number of iterations
	 * @param instructionList The body of the loop
	 * @return An instance of the {@link Loop class}
	 */
	public static Loop newLoop(int numIterations, InstructionList instructionList) {
		return new Loop(numIterations, instructionList);
	}
	
}
