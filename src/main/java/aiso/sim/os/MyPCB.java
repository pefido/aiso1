package aiso.sim.os;

import java.util.UUID;

public class MyPCB {

  private Context myContext;
  private UUID PID;
  private int quantum;

  public MyPCB(Context context){
    myContext = context;
    PID = UUID.randomUUID();
    myContext.setPID(PID);
  }
  
  public void setQuantum(int q) {
	  quantum = q;
  }
  
  public void tickQuantum() {
	  quantum--;
  }
  
  public int getQuantum() {
	  return quantum;
  }

  public UUID getPID(){
    return PID;
  }

  public Context getContext(){
    return myContext;
  }

  public void setContext(Context context){
    myContext = context;
  }
}
