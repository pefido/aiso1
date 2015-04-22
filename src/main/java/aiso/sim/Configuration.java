package aiso.sim;

import aiso.sim.hardware.AbstractInterruptController;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Clockable;
import aiso.sim.hardware.SimpleCPUCore;
import aiso.sim.instructions.Computation;
import aiso.sim.instructions.MemoryLoad;
import aiso.sim.instructions.MemoryStore;
import aiso.sim.instructions.SysCall;
import aiso.sim.os.OperatingSystem;
import aiso.sim.os.MyOS;;

public class Configuration {

  // Hardware 

  /**
   * The class implementing the behavior of a CPU core
   */
  public static final Class<SimpleCPUCore> cpuCoreClass = SimpleCPUCore.class;

  /**
   * Number of cores of the simulated CPU
   */
  public static final int numberOfCPUCores = 1;

  /**
   * The array of @see numberOfCPUCores CPU cores
   */
  public static final CPUCore[] cpuCores = new CPUCore[numberOfCPUCores];

  static {
    for (int i = 0; i < numberOfCPUCores; i++) {
      try {
        cpuCores[i] = cpuCoreClass.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  };

  /**
   *  The class implementing the interrupt controller 
   */
  public static final Class<AbstractInterruptController> interruptControlerClass = null;

  /**
   * The computer's set of devices
   */
  public static final Clockable[] devices = new Clockable[]{
    // Fill with hardware components
    //new aiso.sim.hardware.Timer((SimpleCPUCore)cpuCores[0])//o timer pertence ao unico processador que existe

  };


  // Operating System

  /**
   *  The class implementing the operating system
   */
  public static final Class<MyOS> operatingSystemClass = MyOS.class;

  // Instruction Set

  /**
   *  The class implementing the {@link aiso.sim.instructions.Computation Computation} instruction
   */
  public static final Class<Computation> computationClass = Computation.class;

  /**
   *  The class implementing the {@link aiso.sim.instructions.SysCall SysCall} instruction
   */
  public static final Class<SysCall> sysCallClass = SysCall.class;

  /**
   *  The class implementing the {@link aiso.sim.instructions.MemoryLoad MemoryLoad} instruction
   */
  public static final Class<MemoryLoad> memoryLoadAccessClass = MemoryLoad.class;

  /**
   *  The class implementing the {@link aiso.sim.instructions.MemoryStore MemoryStore} instruction
   */
  public static final Class<MemoryStore> memoryStoreAccessClass = MemoryStore.class;

}
