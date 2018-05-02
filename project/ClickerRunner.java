package nau.cs386.Clicker;

import java.util.Scanner;

import java.io.*;

public class ClickerRunner {

   Counter initializeCounter()
   {
      try
      {
         FileInputStream in = new FileInputStream("gamesave.txt");
         Scanner file = new Scanner(in);
         int count = file.nextInt();
         int modifier = file.nextInt();
         file.close();
         return new Counter(count, modifier);
      }
      catch (Exception e)
      {
         return new Counter(0, 0);
      }
   }

   void saveAndQuit(Counter counter)
   {
      try
      {
         Writer out = new FileWriter("gamesave.txt");
         out.write(String.valueOf(counter.getCount()));
         out.write("\n");
         out.write(String.valueOf(counter.getModifier()));
         out.close();
      }
      catch (Exception e)
      {

      }
   }
}
