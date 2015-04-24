package aiso.sim.os.syscalls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import aiso.sim.Program;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.os.Context;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyPCB;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;
import aiso.sim.parser.ParseException;
import aiso.sim.parser.Parser;

public class LoadSysCallHandler implements SysCallHandler {

  public void handle(CPUCore core) {
    MyStats stats = OperatingSystem.getInstance().getStats();
    try {
      InputStream ficheiro = new FileInputStream(core.getRegister(1).toString());
      Parser myParser = new Parser(ficheiro);
      Program myProgram = myParser.Program();
      OperatingSystem.getInstance().getScheduler().schedule(new MyPCB(new Context(myProgram)));
      if (core.getContext() == null) {
        stats.plusCPU();
        MyPCB next = OperatingSystem.getInstance().getScheduler().next();
        stats.trace(next.getContext().getPID(), "LOAD");
        MyOS.getInstance().setCPUJob(next);
        System.out.println(next.getPID().toString());
    	  core.load(next.getContext());
      }

    } catch (InvalidRegisterException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
