package aiso.sim.instructions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

import aiso.sim.BaseAISOTest;

public class InvalidSysCallTest extends BaseAISOTest {

	@Override
	protected String getAISOFileName() {
		return "invalid_syscall.aiso";
	}

	@Test
	public void test() {
		try {
			getParser();
		} catch (FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			fail();			
		} catch (Exception e) {
			if (e instanceof NoSuchSysCallException)
				assertTrue(true);			
			else
				fail();	
		}
	}
}
