package aiso.sim.os;
import java.util.LinkedList;
import java.util.List;
import aiso.sim.Configuration;
import aiso.sim.hardware.Clockable;
import aiso.sim.console.*;

public class MyOS extends OperatingSystem{
	
	private List<Object> jobList;
	private Console terminal;

	@Override
	public void load() {
		//1: listar hardware encontrado
		//2: inicializar estruturas de dados internas
		//3: lancar execucao da consola
		
		//1
		for(Clockable a: Configuration.devices){
			System.out.println(a.getDescription());
		}
		
		//2
		jobList = new LinkedList<Object>();
		terminal = new Console();
		
		//3
		terminal.run();
	}

	@Override
	public InterruptHandler[] getInterruptVector() {
		// TODO Auto-generated method stub
		return null;
	}

}
