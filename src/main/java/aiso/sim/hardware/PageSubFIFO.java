package aiso.sim.hardware;

import java.util.List;

public class PageSubFIFO implements PageSubAlg{

  @Override
  public int alocFrame(int[] pageToFrame, int[] frameToPage, boolean[] valid, List<Integer> memFrames, long page) {

    int alocFrame = memFrames.get(0);
    memFrames.remove(0);
    pageToFrame[(int) page] = alocFrame;
    valid[frameToPage[alocFrame]] = false;
    frameToPage[alocFrame] = (int)page;
    valid[(int) page] = true;
    memFrames.add(alocFrame);
    return alocFrame;
  }

}
