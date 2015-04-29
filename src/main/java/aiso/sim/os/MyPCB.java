package aiso.sim.os;

import java.util.UUID;

public class MyPCB {

  private Context myContext;
  private UUID PID;
  private int quantum;

  public MyPCB(Context context){
    myContext = context;
    PID = UUID.randomUUID();
  }
  
  public void setQuantum(int q) {
	 myContext.setQuantum(q);
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
