package aiso.sim.os;

import aiso.sim.Configuration;
import aiso.sim.console.Console;
import aiso.sim.hardware.CPUCore;

/**
 * Base class for the operating system implementation.
 * The class implements the singleton pattern.
 * 
 * @author Herve Paulino
 *
 */
public abstract class OperatingSystem {

  protected Console terminal;

  /**
   * The single instance of the operating system
   */
  private static OperatingSystem instance = null;

  /**
   * Obtain the instance of the operating system
   * @return The operating system
   */
  public static final synchronized OperatingSystem getInstance() {
    if (instance == null) {
      try {
        instance = Configuration.operatingSystemClass.getConstructor().newInstance();
      }
      catch (Exception e) {
        Logger.internalError("The operating system class may not be properly "
            + "defined in the Configuration class - got error: " + e.getLocalizedMessage());
        System.exit(1);
      }
    }
    return instance; 
  }

  /**
   * Load the operating system
   */
  public abstract void load();

  /**
   * Retrieve the interrupt vector
   * @return The interrupt vector
   */
  public  abstract InterruptHandler[] getInterruptVector();

  public abstract MySchedulerAlg getScheduler();
  public abstract MyStats getStats();
  
  public abstract AbstractDriver getDriver(String device);
  
  public abstract MyPCB getCPUJob(CPUCore core);
  
  public abstract void setCPUJob(MyPCB job, CPUCore core);

}
