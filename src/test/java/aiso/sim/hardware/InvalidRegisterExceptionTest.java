package aiso.sim.hardware;

import java.util.ArrayList;

import org.junit.Test;

import aiso.sim.console.ExecCommand;
import aiso.sim.hardware.Clock;
import aiso.sim.os.OperatingSystem;
import aiso.sim.BaseAISOTest;

public class InvalidRegisterExceptionTest extends BaseAISOTest {

	@Override
	protected String getAISOFileName() {
		return "invalid_register_exception.aiso";
	}

	@SuppressWarnings("serial")
	@Test
	public void test() {
		
			new Clock().start();
			OperatingSystem.getInstance().load();
			new ExecCommand().run(new ArrayList<String>() {{ add(getAISOFileName()); }});
		
	}

}
