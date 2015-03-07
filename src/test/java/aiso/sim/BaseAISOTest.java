package aiso.sim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import aiso.sim.parser.Parser;

public abstract class BaseAISOTest {

	protected static final String testFolder = "src" + File.separator + 
			"test" + File.separator + 
			"resources" + File.separator;
	
	public Parser getParser() throws FileNotFoundException {
		return new Parser(new FileInputStream(testFolder + getAISOFileName()));
	}
	
	protected abstract String getAISOFileName();
	
	@Test
	public abstract void test();
}
