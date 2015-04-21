package aiso.sim.os;

import java.util.Stack;
import java.util.UUID;

import aiso.sim.Program;
import aiso.sim.hardware.CPUCore;
import aiso.sim.instructions.Instruction;
import aiso.sim.instructions.InstructionList;
import aiso.sim.instructions.InstructionList.InstructionListIterator;

/**
 * A context (thread execution state) 
 * 
 * @author Herve
 *
 */
public class Context {

  /*private PCB PCBController;*/

  /**
   * CPU core where the context is running
   */
  private CPUCore cpuCore;

  /**
   * List of instructions of the current code block
   */
  private InstructionListIterator instructionList;

  /**
   * A stack of code blocks for loop and subroutine support
   */
  private Stack<InstructionListIterator> stack = new Stack<InstructionListIterator>();

  private UUID processPID;

  /**
   * Construct a context from a program
   * @param program The program
   */
  public Context(Program program) {
    this.instructionList = program.iterator();
  }

  /**
   * Next instruction to execute
   * @return The instruction
   */
  public Instruction nextInstruction() {
    return this.instructionList.next();	
  }

  /**
   * Set the core where the context is running
   * @param cpuCore The CPU core
   */
  public void setCPUCore(CPUCore cpuCore) {
    this.cpuCore = cpuCore;
  }

  /**
   * Get the core where the context is running
   * @return The CPU core
   */
  public CPUCore getCpuCore() {
    return cpuCore;
  }

  /**
   * Jump to a list of instructions
   * @param instructionList The target list of instructions
   */
  public void jump(InstructionList instructionList) {
    this.stack.push(this.instructionList);
    this.instructionList = instructionList.iterator();
  }

  /**
   * Restart the execution of the current code block 
   */
  public void loop() {
    this.instructionList.restart();	
  }

  /**
   * Jump back to the previous code block
   */
  public void jumpBack() {
    this.instructionList = this.stack.pop();
  }

  
  /**
   * Atribuir este conexto a um processo(PCB)
   * @param pid Pid do processo a que este contexto pertence
   */
  public void setPID(UUID pid){
    processPID = pid;
  }

}
