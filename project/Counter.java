package nau.cs386.Clicker;

public class Counter {

   int count;
   int countModifier;

   public Counter(int count, int countModifier) {
      this.count = count;
      this.countModifier = countModifier;
   }

   public void countIncriment(int count) {
      this.count += count;
   }

   public void modifierIncriment(int count) {
      this.countModifier += count;
   }

   public int getCount() {
      return count;
   }

   public int getModifier() {
      return countModifier;
   }
   
   public void purchase(int count, int countModifier) {
	   this.count -= count;
	   this.countModifier = countModifier;
   }
   
   public static void main(String[] args) {
	   Counter counter = new Counter(100,0);
	   System.out.println(counter.getCount());
	   System.out.println(counter.getModifier());
	   counter.purchase(100, 10);
	   System.out.println(counter.getCount());
	   System.out.println(counter.getModifier());
   }
}
