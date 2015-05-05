package aiso.sim.hardware;

import java.util.HashMap;
import java.util.Map;

public class MMU implements Clockable{

  public Map<Integer, Integer> pageTable;
  
  public MMU(){
    pageTable = new HashMap<Integer, Integer>();
  }
  
  public int translatePage(int page){
    return pageTable.get(page);
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
