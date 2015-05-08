package aiso.sim.hardware;

import java.util.List;

import aiso.sim.os.MyStats;

public interface PageSubAlg {

  public int alocFrame(int[] pageToFrame, int[] frameToPage, boolean[] valid, List<Integer> memFrames, long page, MyStats stats);
  
  public void acessMemory(MyStats stats, int frame);
}
