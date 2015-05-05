package aiso.sim.hardware;

import java.util.HashMap;
import java.util.Map;

public class TLB implements Clockable{

  public Map<Integer, Integer> localPageTable;
  private CPUCore core;
  
  public TLB(CPUCore core){
    localPageTable = new HashMap<Integer, Integer>();
    this.core = core;
  }
  
  public CPUCore getCore(){
    return core;
  }

  @Override
  public void tick() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getDescription() {
    return "TLB do core " + core.getDescription();
  }
}
