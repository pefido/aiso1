package aiso.sim.os;
import java.util.LinkedList;
import java.util.List;

import aiso.sim.Configuration;
import aiso.sim.Program;
import aiso.sim.hardware.Clockable;
import aiso.sim.console.*;
import aiso.sim.hardware.*;
import aiso.sim.os.SysCallInterruptHandler;

public class MyOS extends OperatingSystem{
	
	private InterruptHandler[] interruptList;
	private Console terminal;

	@Override
	public void load() {
		
		//1: listar hardware encontrado
		for(Clockable a: Configuration.devices){
			System.out.println(a.getDescription());
		}
		
		//2: inicializar estruturas de dados internas
		interruptList = new InterruptHandler[20];
		interruptList[Interrupt.SYSCALL.ordinal()] = new SysCallInterruptHandler();
		terminal = new Console();
		
		
		//3: lancar execucao da consola
		terminal.run();
	}

	@Override
	public InterruptHandler[] getInterruptVector() {
		// TODO Auto-generated method stub
		return interruptList;
	}

}
