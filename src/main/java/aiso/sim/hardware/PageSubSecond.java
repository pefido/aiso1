package aiso.sim.hardware;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import aiso.sim.os.MyOS;

public class PageSubSecond implements PageSubAlg{

  private List<Boolean> reference;
  private boolean firstTime;
  
  public PageSubSecond(){
    firstTime = true;
  }

  @Override
  public int alocFrame(int[] pageToFrame, int[] frameToPage, boolean[] valid, List<Integer> memFrames, long page) {
    if(firstTime){
      reference = new ArrayList<Boolean>(memFrames.size());
      for(int i = 0; i<memFrames.size(); i++){
        reference.add(false);
      }
      firstTime = false;
    }
    
    int alocFrame = -1;
    boolean refBit = reference.get(0);
    
    if(refBit == false){//o reference bit tá a 0, pode ser substituido
     reference.remove(0);
     reference.add(true);
     
     alocFrame = memFrames.get(0);
     memFrames.remove(0);
     pageToFrame[(int) page] = alocFrame;
     frameToPage[alocFrame] = (int)page;
     valid[(int) page] = true;
     memFrames.add(alocFrame);
     if(frameToPage[memFrames.get(0)] != -1)//memoria n ta ocupada
       valid[frameToPage[alocFrame]] = false;
    }
    else{//o reference bit tá a 1, n pode ser removido
      reference.remove(0);
      reference.add(false);
      int tmp = memFrames.get(0);
      memFrames.remove(0);
      memFrames.add(tmp);
      alocFrame(frameToPage, frameToPage, valid, memFrames, page);
    }

    return alocFrame;
  }

}
