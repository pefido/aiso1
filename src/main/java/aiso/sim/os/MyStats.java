package aiso.sim.os;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class MyStats {
  
  long initTime;
  long CPUTime, auxCPU;
  ArrayList<String> trace;

  public MyStats() {
    initTime = System.currentTimeMillis();
    CPUTime = 0;
    trace = new ArrayList<String>();
  }
  
  public String Publish() {
    long fim = System.currentTimeMillis();
    return "Tempo decorrido: " + (fim-initTime) + "\n"
        + "CPU: " + CPUTime;
  }
  
  public Iterator<String> getTrace() {
    return trace.iterator();
  }
  
  public void plusCPU() {
    auxCPU = System.currentTimeMillis();
  }
  
  public void stopCPU() {
    CPUTime += (System.currentTimeMillis() - auxCPU);
  }
  
  public void trace(UUID uuid, String event) {
    String estring = "";
    if (uuid != null) {
     estring = uuid+"      "+event; 
    } else {
     estring = "CPU"       +"      "+event; 
    }
    trace.add(estring);
  }

  public void reset() {
    initTime = System.currentTimeMillis();
    CPUTime = 0;
  }
  
  

}
