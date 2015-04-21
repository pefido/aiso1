package aiso.sim.os;

import java.util.UUID;

public class MyPCB {

  private Context myContext;
  private UUID PID;

  public MyPCB(Context context){
    myContext = context;
    PID = UUID.randomUUID();
    myContext.setPID(PID);
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
