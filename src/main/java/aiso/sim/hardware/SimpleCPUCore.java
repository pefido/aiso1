package aiso.sim.hardware;

import aiso.sim.instructions.Instruction;
import aiso.sim.os.Context;
import aiso.sim.os.OperatingSystem;
import aiso.sim.os.PCB;

public class SimpleCPUCore extends CPUCore {
	
	
	
	/**
	 * Number of registers included in each CPU core
	 */
	private final static int NUMBER_OF_REGISTERS = 20;
	
	/**
	 * The core's registers
	 */
	private final Object[] registers = new Object[NUMBER_OF_REGISTERS];
	
	/**
	 * CPU clocks that the instruction currently in execution will still take on the core
	 * before concluding
	 */
	private int instructionRunningTime;


	@Override
	public synchronized void load(Context context) {
		super.load(context);
		//TODO: ver isto 
		//instructionRunningTime = 0;
	}

	/**
	 * The fetch-decode-execute loop
	 */
	@Override
	public synchronized void tick() {
		if (context != null) {
			if (instructionRunningTime == 0) {
				try {
					// Fetch
					Instruction inst = fetch();
					// Decode
					this.instructionRunningTime = inst.getCPUClocks();
					// Execute
					inst.run(this);
				} catch (Exception e) {
					context = null;
					// TODO send exception to the OS
					e.printStackTrace();
				}
			}
			instructionRunningTime--;
		}
	}

	@Override
	public String getDescription() {
		return "Simple CPU core";
	}

	@Override
	public void handleInterrupt(Interrupt interrupt) {
		OperatingSystem.getInstance().getInterruptVector()[interrupt.ordinal()].handle(this);
	}

	@Override
	public void setRegisters(int register, Object... values) throws InvalidRegisterException {
		for (Object value : values) {
			if (register >= NUMBER_OF_REGISTERS)
				throw new InvalidRegisterException(register);
			this.registers[register++] = value;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getRegister(int i) throws InvalidRegisterException {
		if (i >= NUMBER_OF_REGISTERS)
			throw new InvalidRegisterException(i);
		return (T) registers[i];
	}

	@Override
	public Object[] getRegisters() {
		return this.registers;
	}

}
