package aiso.sim.os;

public class MyStats {
  
  long initTime;
  long CPUTime, auxCPU;

  public MyStats() {
    initTime = System.currentTimeMillis();
    CPUTime = 0;
  }
  
  public String Publish() {
    long fim = System.currentTimeMillis();
    return "Tempo decorrido: " + (fim-initTime) + "\n"
        + "CPU: " + CPUTime;
  }
  
  public void plusCPU() {
    auxCPU = System.currentTimeMillis();
  }
  
  public void stopCPU() {
    CPUTime += (System.currentTimeMillis() - auxCPU);
  }

  public void reset() {
    initTime = System.currentTimeMillis();
  }
  
  

}
