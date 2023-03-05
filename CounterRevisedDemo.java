/**
   This file demonstrates the CounterRevised class.
*/

public class CounterRevisedDemo
{
   public static void main(String[] args)
   {
      //Create three CounterRevised objects using each of the constructors.
      CounterRevised c1 = new CounterRevised();
      CounterRevised c2 = new CounterRevised(2, 0, 4);
      CounterRevised c3 = new CounterRevised(12);
      
      //Set the remaining values for c1.
      c1.setMinR(3);
      c1.setMaxR(10);
      c1.setCountR(5);
      
      //Set the remaining values for c3.
      c3.setMinR(12);
      c3.setMaxR(13);
          
      //Display information about the objects.  
      System.out.println("c1's count is: " + c1.getCountR() 
         + "\nc1's min is: "+ c1.getMinR() + "\nc1's max is: " + c1.getMaxR());

      System.out.println("c2's count is: " + c2.getCountR() 
         + "\nc2's min is: "+ c2.getMinR() + "\nc2's max is: " + c2.getMaxR());

      System.out.println("c3's count is: " + c3.getCountR() 
         + "\nc3's min is: "+ c3.getMinR() + "\nc3's max is: " + c3.getMaxR());
   }
}