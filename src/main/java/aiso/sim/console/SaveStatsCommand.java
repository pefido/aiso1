package aiso.sim.console;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import aiso.sim.os.OperatingSystem;


/**
 * Implementation of the "exec" command
 * 
 * @author Herve Paulino
 *
 */
public class SaveStatsCommand extends ConsoleCommand {

  /**
   * Executes the program given as argument
   */
  @Override
  public void run(List<String> arguments) {
    String naem = "";
    for (String fileName: arguments) {
      naem = fileName;
    };
    String megaStats = OperatingSystem.getInstance().getStats().Publish();
    //Manda pra ficheiro
    PrintWriter out;
    try {
      out = new PrintWriter(naem);
      out.println(megaStats);
      out.close();
      Console.out.println("Stats saved");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public String getCommandName() {
    return "save_stats";
  }

  @Override
  public int getNumberArguments() {
    return 0;
  }

  @Override
  public int getNumberOptionalArguments() {
    return 1;
  }

  @Override
  public String usage() {
    return "save_stats [file]\t - write the current statistics of the SO in the console or in the given file";
  }

}
