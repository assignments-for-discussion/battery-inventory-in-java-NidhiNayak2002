package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    
    for(int capacity : presentCapacities){
      double sohPercentage = (capacity * 100.0) / 120.0; // soh calculation
      
      //to check SoH of batteries
      if(sohPercentage > 80){
        counts.healthy++;
      }
      else if(sohPercentage >= 65){
        counts.exchange++;
      }
      else{
        counts.failed++;
      }
    }
    return counts;
  }

  public static void main(String[] args)  {
    System.out.println("Counting batteries by SoH...\n"); 
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};// test case 1
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    
    int[] capacities2 = {};// test case 2
    CountsBySoH counts2 = countBatteriesByHealth(capacities2);
    assert(counts2.healthy == 0);
    assert(counts2.exchange == 0);
    assert(counts2.failed == 0);

    int[] capacities4 = {94,90,92,85,93};// test case 3
    CountsBySoH counts4 = countBatteriesByHealth(capacities4);
    assert(counts4.healthy == 0);
    assert(counts4.exchange == 5);
    assert(counts4.failed == 0);


    System.out.println("Done counting :)\n");
  }
}
