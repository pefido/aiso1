package aiso.sim.hardware;

import java.util.List;

import aiso.sim.os.MyStats;

public class PageSubFIFO implements PageSubAlg{

  @Override
  public int alocFrame(int[] pageToFrame, int[] frameToPage, boolean[] valid, List<Integer> memFrames, long page, MyStats stats) {

    int alocFrame;

      alocFrame = memFrames.get(0);
      memFrames.remove(0);
      pageToFrame[(int) page] = alocFrame;
      if(frameToPage[memFrames.get(0)] != -1)
        valid[frameToPage[alocFrame]] = false;
      frameToPage[alocFrame] = (int)page;
      valid[(int) page] = true;
      memFrames.add(alocFrame);

    return alocFrame;
  }

  @Override
  public void acessMemory(MyStats stats, int frame) {
    stats.memoryAccess();
    
  }

}
