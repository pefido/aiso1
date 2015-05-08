package aiso.sim.hardware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import aiso.sim.Configuration;
import aiso.sim.instructions.MemoryAccess;
import aiso.sim.instructions.MemoryLoad;
import aiso.sim.os.MyOS;
import aiso.sim.os.MyStats;
import aiso.sim.os.OperatingSystem;

public class MMU implements Clockable{

  public static int PAGESIZE = 4096;
  
  public static int TABLESIZE = (int)(aiso.sim.Configuration.ram.capacity/PAGESIZE);
  public static int ADRESSES = 1048576;

  private int[] pageToFrame;
  private int[] frameToPage;
  private boolean[] valid;
  private List<Integer> memFrames;
  private PageSubAlg subAlg;
  
  MyStats stats;
  
  public MMU(){

    pageToFrame = new int[ADRESSES];
    frameToPage = new int[TABLESIZE];
    valid = new boolean[ADRESSES];
    memFrames = new ArrayList<Integer>(TABLESIZE);
    subAlg = Configuration.subAlg;
    for(boolean a: valid)
      a = false;
    for(long b: frameToPage)
      b = -1;
    
    for(int i = 0; i < TABLESIZE; i++){
      memFrames.add(i);
    }
  }

  public void store(long page){

    if (stats == null) stats = OperatingSystem.getInstance().getStats();
    stats.memoryAccess();
    stats.pageAccess((int) page);
    
    int alocFrame;

      alocFrame = subAlg.alocFrame(pageToFrame, frameToPage, valid, memFrames, page, stats);
      stats.discWrite();
    System.out.println("maloc frame " + alocFrame + " for page " + page);
  }
  
  public void load(long page) throws Exception{

    if (stats == null) stats = OperatingSystem.getInstance().getStats();
    stats.pageAccess((int) page);

    if(valid[(int) page] == true){
      subAlg.acessMemory(stats, pageToFrame[(int)page]);
      //ir buscar frame da memoria
      System.out.println("page " + page + " loaded from frame " + pageToFrame[(int)page]);
    }
    else{//não tá em memoria
      stats.pageFault();
      
      int alocFrame;

        alocFrame = subAlg.alocFrame(pageToFrame, frameToPage, valid, memFrames, page, stats);
        stats.discWrite();
        System.out.println("maloc frame " + alocFrame + " for page " + page);
        //voltar a executar a instrucao
        this.load(page);
    }
  }

  @Override
  public void tick() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getDescription() {
    return "MMU";
  }
}
