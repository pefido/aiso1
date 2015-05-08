package aiso.sim.hardware;

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

  //public Map<Integer, Integer> pageTable;
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
    memFrames = new LinkedList<Integer>();
    subAlg = Configuration.subAlg;
    for(boolean a: valid)
      a = false;
    for(long b: frameToPage)
      b = -1;
    
    for(int i = 0; i < TABLESIZE; i++){
      memFrames.add(i);
    }
  }
  
  /*public long getFrame(int page){
    long result = -1;
    if(valid[page] == true)
      result = pageToFrame[page];
    return result;
  }*/
  
  public void store(long page){

    if (stats == null) stats = OperatingSystem.getInstance().getStats();
    stats.memoryAccess();
    stats.pageAccess((int) page);
    
    int alocFrame;
    
    if(frameToPage[memFrames.get(0)] != -1){//se a memoria tava a ser uzada, usar algoritmo
      alocFrame = subAlg.alocFrame(pageToFrame, frameToPage, valid, memFrames, page);
      stats.discWrite();
    }
    else{
      alocFrame = memFrames.get(0);
      memFrames.remove(0);
      pageToFrame[(int) page] = alocFrame;
      frameToPage[alocFrame] = (int)page;
      valid[(int) page] = true;
      memFrames.add(alocFrame);
    }
    

    /*int alocFrame = memFrames.get(0);
    memFrames.remove(0);
    pageToFrame[(int) page] = alocFrame;
    if(frameToPage[alocFrame] != -1){//se a memoria tava a ser utilizada, guardar em disco e invalidar o bit valid
      stats.discWrite();
      valid[frameToPage[alocFrame]] = false;
    }
    frameToPage[alocFrame] = (int)page;
    valid[(int) page] = true;
    memFrames.add(alocFrame);*/
    System.out.println("maloc frame " + alocFrame + " for page " + page);
  }
  
  public void load(long page) throws Exception{

    if (stats == null) stats = OperatingSystem.getInstance().getStats();
    stats.pageAccess((int) page);

    if(valid[(int) page] == true){
      stats.memoryAccess();
      //ir buscar frame da memoria
      System.out.println("page " + page + " loaded from frame " + pageToFrame[(int)page]);
    }
    else{//não tá em memoria
      stats.pageFault();
      
      int alocFrame;
      
      if(frameToPage[memFrames.get(0)] != -1){//se a memoria tava a ser uzada, usar algoritmo
        alocFrame = subAlg.alocFrame(pageToFrame, frameToPage, valid, memFrames, page);
        stats.discWrite();
      }
      else{
        alocFrame = memFrames.get(0);
        memFrames.remove(0);
        pageToFrame[(int) page] = alocFrame;
        frameToPage[alocFrame] = (int)page;
        valid[(int) page] = true;
        memFrames.add(alocFrame);
      }
      
      
      
        /*int alocFrame = memFrames.get(0);
        if(frameToPage[alocFrame] != -1){
          valid[frameToPage[alocFrame]] = false;
        }
        memFrames.remove(0);
        pageToFrame[(int) page] = alocFrame;
        valid[(int) page] = true;
        memFrames.add(alocFrame);*/
        
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
