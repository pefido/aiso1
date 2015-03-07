package aiso.sim.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * The console that serves as an interface for the prompting of commands to the simulator
 * 
 * @author Herve Paulino
 *
 */
public class Console {
	
	/**
	 * A map that projects command names into their implementation
	 */
	protected static Map<String, ConsoleCommand> commands = 
			new HashMap<String, ConsoleCommand>();
	
	static {
		addCommand(new ExecCommand());
		addCommand(new HelpCommand());
		addCommand(new ShutdownCommand());
	}
	
	/**
	 * The console's output stream
	 */
	protected static PrintStream out = System.out;
	
	/**
	 * The console's error stream
	 */
	protected static PrintStream err = System.err;
	
	/**
	 * The console's execution loop 
	 */
	public void run() {
		BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			try {
				Console.out.println("aiso: ");
				processCommand(brd.readLine());

			} catch (IOException e) {
				Console.err.println("Error; " + e.getMessage());
			}			
		}
	}

	/**
	 * Process a command line
	 * @param line The line to process
	 */
	private void processCommand(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, " \t\n");
		
		if (tokenizer.hasMoreTokens()) {
			ConsoleCommand cc = commands.get(tokenizer.nextToken());
			
			if (cc == null) {
				Console.err.println("Error: command does not exist.");
			}
			else {
				List<String> args = new ArrayList<String>();
				while (tokenizer.hasMoreTokens()) {
				    args.add(tokenizer.nextToken());
				}
				cc.run(args);
			}
		}
	}
	
	/**
	 * Add a command to the set of commands offered by the console
	 * @param cc The command to add
	 */
	private static void addCommand(ConsoleCommand cc) {
		commands.put(cc.getCommandName(), cc);
	}

}
