package aiso.sim.hardware;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import aiso.sim.Configuration;
import aiso.sim.instructions.MemoryAccess;
import aiso.sim.instructions.MemoryLoad;
import aiso.sim.os.MyOS;

public class MMU implements Clockable{

  public static int PAGESIZE = 4096;
  
  public static int TABLESIZE = (int)(aiso.sim.Configuration.ram.capacity/PAGESIZE);
  public static int ADRESSES = 1048576;

  //public Map<Integer, Integer> pageTable;
  public int[] pageToFrame;
  public int[] frameToPage;
  public boolean[] valid;
  public List<Integer> memFrames;
  
  public MMU(){
    pageToFrame = new int[ADRESSES];
    frameToPage = new int[TABLESIZE];
    valid = new boolean[ADRESSES];
    memFrames = new LinkedList<Integer>();
    for(boolean a: valid)
      a = false;
    for(long b: frameToPage)
      b = -1;
    
    for(int i = 0; i < TABLESIZE; i++){
      memFrames.add(i);
    }
  }
  
  public long getFrame(int page){
    long result = -1;
    if(valid[page] == true)
      result = pageToFrame[page];
    return result;
  }
  
  public void store(long page){
    //boolean result = false;
    //if(!freeMem.isEmpty()){
    int alocFrame = memFrames.get(0);
    memFrames.remove(0);
    pageToFrame[(int) page] = alocFrame;
    if(frameToPage[alocFrame] != -1){//se a memoria tava a ser utilizada, guardar em disco e invalidar o bit valid
      valid[frameToPage[alocFrame]] = false;
    }
    frameToPage[alocFrame] = (int)page;
    valid[(int) page] = true;
    memFrames.add(alocFrame);
    System.out.println("maloc frame " + alocFrame + " for page " + page);
    //result = true;
    //}
    //else System.out.println("mem full!!!");
    //return result;
  }
  
  public void load(long page) throws Exception{
    if(valid[(int) page] == true){
      //ir buscar frame da memoria
      System.out.println("page " + page + " loaded from frame " + pageToFrame[(int)page]);
    }
    else{//não tá em memoria
      //if(!freeMem.isEmpty()){//se existir memoria livre
        int alocFrame = memFrames.get(0);
        if(frameToPage[alocFrame] != -1){
          valid[frameToPage[alocFrame]] = false;
        }
        memFrames.remove(0);
        pageToFrame[(int) page] = alocFrame;
        valid[(int) page] = true;
        System.out.println("maloc frame " + alocFrame + " for page " + page);
        memFrames.add(alocFrame);
        //voltar a executar a instrucao
        this.load(page);
      /*}
      else{
        //usar algoritmo para libertar memoria
        System.out.println("mem full!!!");
      }*/
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
