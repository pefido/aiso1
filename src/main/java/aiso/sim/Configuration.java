package aiso.sim;

import aiso.sim.hardware.AbstractInterruptController;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.Clockable;
import aiso.sim.hardware.MMU;
import aiso.sim.hardware.PageSubAlg;
import aiso.sim.hardware.PageSubFIFO;
import aiso.sim.hardware.PageSubSecond;
import aiso.sim.hardware.RAM;
import aiso.sim.hardware.SimpleCPUCore;
import aiso.sim.instructions.Computation;
import aiso.sim.instructions.MemoryLoad;
import aiso.sim.instructions.MemoryStore;
import aiso.sim.instructions.SysCall;
import aiso.sim.os.MySchedulerAlg;
import aiso.sim.os.MySchedulerMFQ;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;
import aiso.sim.os.MyOS;
import aiso.sim.os.SimpleScheduler;

public class Configuration {

  //Units

  public static final int KByte = 1024;
  public static final int MByte = 1024 * KByte;
  public static final int GByte = 1024 * MByte;

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
   *  The scheduler
   */
  public static final MySchedulerAlg scheduler = new SimpleScheduler() ;
  
  /**
   * algoritmo de substituição de páginas
   */
  public static final PageSubAlg subAlg = new PageSubSecond();

  /**
   * Statistics
   */
  public static final MyStats stats = new MyStats();


  /**
   * Installed RAM
   */
  public static final int ramSize = MByte;
  public static final RAM ram = new RAM(ramSize, 32);

  /**
   *  The class implementing the interrupt controller 
   */
  public static final Class<AbstractInterruptController> interruptControlerClass = null;
  
  public static final MMU mmu = new MMU();

  /**
   * The computer's set of devices
   */
  public static final Clockable[] devices = new Clockable[]{
    // Fill with hardware components
    new aiso.sim.hardware.Timer((SimpleCPUCore)cpuCores[0]),
    new aiso.sim.hardware.IODevice(),
    ram
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
