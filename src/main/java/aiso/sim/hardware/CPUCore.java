package aiso.sim.hardware;

import aiso.sim.instructions.Instruction;
import aiso.sim.os.Context;

/**
 * Base class for the implementation of a CPU core
 * 
 * @author Herve Paulino
 *
 */
public abstract class CPUCore implements Clockable {

  //protected PCB PCBController;


  /**
   * The context currently running in the code
   */
  protected Context context = null;

  /**
   * Load context to the core
   * @param context The context
   */
  public void load(Context context) {
    this.context = context;
    if (context != null)
      context.setCPUCore(this);
  }

  /**
   * Obtain the context currently running in the core
   * @return The context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Fetch the next instruction to execute
   * @return The instruction
   */
  protected Instruction fetch() {
    return this.context.nextInstruction(); 
  }

  /**
   * Handle an interrupt 
   * @param interrupt The interrupt to handle
   */
  public abstract void handleInterrupt(Interrupt interrupt);

  /**
   * Set the value of a sequence of registers
   * @param register The initial register to affect
   * @param values The values to store
   * @throws InvalidRegisterException Thrown if the sequence of registers to affect goes
   * beyond the number of registers supported by the CPU core
   */
  public abstract void setRegisters(int register, Object... values) throws InvalidRegisterException;

  /**
   * Obtain the core's register array
   * @return The register array
   */
  public abstract Object[] getRegisters();

  /**
   * Obtain the value of a given register
   * @param number The number of the register to read
   * @return The value stored in register(number)
   * @throws InvalidRegisterException Thrown if number is not a valid register 
   */
  public abstract <T> T getRegister(int number)  throws InvalidRegisterException;




}
