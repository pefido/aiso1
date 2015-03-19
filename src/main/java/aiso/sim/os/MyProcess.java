package aiso.sim.os;
import java.util.UUID;

public class MyProcess{

	private Context myContext;
	private UUID PID;
	
	public MyProcess(Context context){
		myContext = context;
		PID = UUID.randomUUID();
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
