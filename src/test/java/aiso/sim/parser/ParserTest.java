package aiso.sim.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import aiso.sim.BaseAISOTest;
import aiso.sim.hardware.CPUCore;
import aiso.sim.hardware.SimpleCPUCore;
import aiso.sim.instructions.Instruction;

import java.util.Iterator;

public class ParserTest extends BaseAISOTest {
	
	@Test
	public void test() {
		try {
			CPUCore cpuCore = new SimpleCPUCore();
			Iterator<Instruction> it = getParser().Program().iterator();
			while (it.hasNext())
				it.next().run(cpuCore);
			
			assertTrue(true);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		
	}

	@Override
	protected String getAISOFileName() {
		return "simple.aiso";
	}

}
