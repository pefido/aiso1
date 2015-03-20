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

	@Override
	public void load() {
		
		//1: listar hardware encontrado
		for(int i=0; i<Configuration.devices.length; i++){
			if(Configuration.devices[i].getDescription().equals("Simple CPU core"))
				MyCores[i] = (SimpleCPUCore)Configuration.devices[i];
			System.out.println(Configuration.devices[i].getDescription());
		}
		
		//2: inicializar estruturas de dados internas
		interruptList = new InterruptHandler[20];
		interruptList[Interrupt.SYSCALL.ordinal()] = new SysCallInterruptHandler();
		MyPCB = new PCB(MyCores);
		terminal = new Console();
		
		
		//3: lancar execucao da consola
		terminal.run();
	}

	@Override
	public InterruptHandler[] getInterruptVector() {
		// TODO Auto-generated method stub
		return interruptList;
	}
	
	public PCB getPCB(){
		return MyPCB;
	}

}
