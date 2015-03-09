package aiso.sim.os.syscalls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.InvalidRegisterException;
import aiso.sim.parser.ParseException;
import aiso.sim.parser.Parser;

public class LoadSysCallHandler implements SysCallHandler {
	
	public void handle(CPUCore core) {
		try {
			InputStream ficheiro = new FileInputStream(core.getRegister(1).toString());
			Parser myParser = new Parser(ficheiro);
			myParser.Program();
			//System.out.println(core.getRegister(1));
			//System.out.println("cenas");
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
