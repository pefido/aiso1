package aiso.sim.hardware;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import aiso.sim.os.MyOS;
import aiso.sim.os.MyStats;

public class PageSubSecond implements PageSubAlg{

  private List<Boolean> reference;
  private int counter;
  private boolean firstTime;
  
  public PageSubSecond(){
    firstTime = true;
    counter = 0;
  }

  @Override
  public int alocFrame(int[] pageToFrame, int[] frameToPage, boolean[] valid, List<Integer> memFrames, long page, MyStats stats) {
    if(firstTime){
      reference = new ArrayList<Boolean>(memFrames.size());
      for(int i = 0; i<memFrames.size(); i++){
        reference.add(false);
      }
      firstTime = false;
    }
    
    int alocFrame;

    while(reference.get(counter) == true){
      reference.set(counter, false);
      counter++;
      if(counter == memFrames.size())
        counter = 0;
    }

    alocFrame = memFrames.get(counter);
    if(frameToPage[alocFrame] != -1)//memoria ta ocupada
      valid[frameToPage[alocFrame]] = false;
    pageToFrame[(int) page] = alocFrame;
    frameToPage[alocFrame] = (int)page;
    valid[(int) page] = true;
    
    reference.set(counter, true);
    counter ++;
    if(counter == memFrames.size())
      counter = 0;

    return alocFrame;
  }

  @Override
  public void acessMemory(MyStats stats, int frame) {
    stats.memoryAccess();
    reference.set(frame, true);
  }

}
