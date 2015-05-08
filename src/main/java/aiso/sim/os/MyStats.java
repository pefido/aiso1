package aiso.sim.os;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class MyStats {

  //Estatisticas do trabalho 3
  int memacc;
  int pagfalt;
  //Páginas diferentes acedidas
  HashMap<Integer, Boolean> pagdiff = new HashMap<Integer, Boolean>();
  int pagwrite;
  
  public void memoryAccess() {
    memacc++;
  }
  
  public void pageAccess(int page) {
   pagdiff.put(page, true);
  }

  public void pageFault() {
    pagfalt++;
  }
  
  public void discWrite() {
   pagwrite++; 
  }

  //Estatisticas do trabalho 2
  long initTime;
  long CPUTime, auxCPU;
  ArrayList<String> trace;

  public MyStats() {
    initTime = System.currentTimeMillis();
    CPUTime = 0;
    trace = new ArrayList<String>();
    //T3
    memacc = 0;
    pagfalt = 0;
    //int TABLESIZE = (int)(aiso.sim.Configuration.ram.capacity/4096);
    pagwrite = -aiso.sim.Configuration.ramSize/4096;
  }
  
  public String Publish() {
    return "Número de acessos a memória:           " + memacc                + "\n"
          +"Número de páginas diferentes acedidas: " + pagdiff.size()        + "\n"
          +"Número de falta de páginas:            " + pagfalt               + "\n"
          +"Número de páginas escritas para disco: " + Math.max(pagwrite, 0) + "\n";

    //long fim = System.currentTimeMillis();
    //return "Tempo decorrido: " + (fim-initTime) + "\n"
        //+ "CPU: " + CPUTime;
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
    memacc = 0;
    pagfalt = 0;
    pagwrite = -aiso.sim.Configuration.ramSize/4096;
  }



  
  
  

}
