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
      double sohPercentage = (capacity * 100.0) / 120.0; // Assuming rated capacity is 120 Ah
      
      //Conditions to check SoH of batteries
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

    // Given test case
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);

    
    // test with empty array
    int[] capacities2 = {};
    CountsBySoH counts2 = countBatteriesByHealth(capacities2);
    assert(counts2.healthy == 0);
    assert(counts2.exchange == 0);
    assert(counts2.failed == 0);

   // test with all the batteries healthy
    int[] capacities3 = {120,119,120,118,120};
    CountsBySoH counts3 = countBatteriesByHealth(capacities3);
    assert(counts3.healthy == 5);
    assert(counts3.exchange == 0);
    assert(counts3.failed == 0);

// test with all the batteries need exchange
    int[] capacities4 = {84,80,82,85,83};
    CountsBySoH counts4 = countBatteriesByHealth(capacities4);
    assert(counts4.healthy == 0);
    assert(counts4.exchange == 5);
    assert(counts4.failed == 0);

// test with all the batteries failed
    int[] capacities5 = {30,40,45,55,58};
    CountsBySoH counts5 = countBatteriesByHealth(capacities5);
    assert(counts5.healthy == 0);
    assert(counts5.exchange == 0);
    assert(counts5.failed == 5);
    
    System.out.println("Done counting :)\n");
  }
}
