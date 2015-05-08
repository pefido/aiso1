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
      for(boolean a: reference){
        a= false;
      }
      firstTime = false;
    }
    
    System.out.println("aqui");
    return 100;
  }

}
