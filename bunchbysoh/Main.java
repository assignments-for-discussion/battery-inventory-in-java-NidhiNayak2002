package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for(int presentCap : presentCapacities){
      int soh = calculateSoh(presentCap);
      String classification = classifyBattery(soh);
      if(classification.equals("Healthy")){
        counts.healthy+=1;
      }
      else if(classification.equals("Exchange")){
        counts.exchange+=1;
      }
      else{
        counts.failed+=1;
      }
    }
    return counts;
  }
  
  public static int calculateSoh(int presentCap){//calculate the soh
    return (presentCap/120)*100;
  }
  
  public static String classifyBattery(int soh){//checks and returns the battery status
    if(soh>80 && soh<=100){
      return "Healthy";
    }
    else if(soh>=65 && soh<=80){
      return "Exchange";
    }
    else{
      return "Failed";
    }
  }
  
   public static void main(String[] args) {
    System.out.println("Counting batteries by SoH...\n");
    
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};//test case 1
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);

    int[] presentCapacities1 = {};//test case 2
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities1);
    assert(counts2.healthy == 0);
    assert(counts2.exchange == 0);
    assert(counts2.failed == 0);
    
    int[] presentCapacities2 = {64,60,62,65,63};//test case 3
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities2);
    assert(counts3.healthy == 0);
    assert(counts3.exchange == 0);
    assert(counts3.failed == 5);
    
    System.out.println("Done counting :)\n");
   
  }
   
}
