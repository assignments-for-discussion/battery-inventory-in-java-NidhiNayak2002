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
      if(classification == "Healthy"){
        counts.healthy+=1;
      }
      else if(classification == "Exchange"){
        counts.exchange+=1;
      }
      else{
        counts.failed+=1;
      }
    }
    return counts;
  }
  
  public static int calculateSoh(int presentCap){
    return (presentCap/120)*100;
  }
  
  public static String classifyBattery(int soh){
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
  
  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};
    CountsBySoH counts1 = countBatteriesByHealth(presentCapacities);
    assert(counts1.healthy == 2);
    assert(counts1.exchange == 3);
    assert(counts1.failed == 1);

    int[] presentCapacities = {};
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities);
    assert(counts2.healthy == 0);
    assert(counts2.exchange == 0);
    assert(counts2.failed == 0);
    
    int[] presentCapacities = {64,60,62,65,63};
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities);
    assert(counts3.healthy == 0);
    assert(counts3.exchange == 5);
    assert(counts3.failed == 0);
    
    
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
