package aiso.sim.os.syscalls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import aiso.sim.Program;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.os.Context;
import aiso.sim.parser.ParseException;
import aiso.sim.parser.Parser;

public class LoadSysCallHandler implements SysCallHandler {
	
	public void handle(CPUCore core) {
		try {
			System.out.println("cenas");
			InputStream ficheiro = new FileInputStream(core.getRegister(1).toString());
			Parser myParser = new Parser(ficheiro);
			Program myProgram = myParser.Program();
			System.out.println(core.getPCB());
			core.getPCB().add(new Context(myProgram));
			
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
