/** 
   Filename: CounterRevised.java
   Author: Hannah Ingham
   Date: 02.5.2023
   Changes: removed System.exit(0);, replaced with default values in constructors,
      changed order of if statement in increment/decrement methods
*/

public class CounterRevised 
{
   private int count; //The number within the interval
   private int min;   //Defines the minimum value for the interval
   private int max;   //Defines the maximum value for the interval
   
   /**
      The constructor sets defualt values for all fields.
   */
   public CounterRevised()
   {
      count = 0;
      min = 0;
      max = 0;
   }
   
   /**
      The constructor sets the count, min, and max variables to the argument values.
      The constructor checks to see if the count is between the interval. It will
      initialize the fields to default values if not.
      @param c The count value
      @param mn The minimum value
      @param mx The maximum value
   */
   public CounterRevised(int c, int mn, int mx)
   {
      if (c <= mx && c >= mn && mn < mx || (mx == 0 && mn == 0))
      {
         count = c;
         min = mn;
         max = mx;
      }
      else if (mn > mx || mx < mn)
      {
         System.out.println("Error - minimum value must be less than maximum value");
         count = 0;
         min = 0;
         max = 0;
      }
      else if (c > mx || c < mn)
      {
         System.out.println("Error - count value is outside range of the interval");
         count = 0;
         min = 0;
         max = 0;
      }
   }
   
   /** 
      The constructor sets the count variable to the argument value and sets
      the min and max variables to a default value. If no interval is specified,
      the count is not restricted.
      @param c The count value
   */
   public CounterRevised(int c)
   {
      count = c;
      min = 0;
      max = 0;
   }
   
   /** 
      The setCount method stores a value in the count field.
      @param c The value to store in count
   */
   public void setCountR(int c)
   {
      //Added (max == 0 && min == 0)
      if ((c <= max && c >= min) || (max == 0 && min == 0))
      {
         count = c;
      }
      else 
      {
         System.out.println("Error - count value is outside range of the interval");
      }
   }
   
   /**
      The getCount method returns the count value.
      @return The value in the count field
   */
   public int getCountR()
   {
      return count;
   }
   
   /**
      The setMin method stores a value in the min field.
      @param mn The value to store in min
   */
   public void setMinR(int mn)
   {
      if (mn < max || (max == 0 && min == 0))
      {
         min = mn;
      }
      else 
      {
         System.out.println("Error - minimum value must be less than maximum value");
      }
   } 
   
   /** 
      The getMin method returns the minimum value.
      @return The value in the min field
   */
   public int getMinR()
   {
      return min;
   }
   
   /**
      The setMax method stores a value in the max field.
      @param mx The value to store in min
   */
   public void setMaxR(int mx)
   {
      if (min < mx || (max == 0 && min == 0))
      {
         max = mx;
      }
      else 
      {
         System.out.println("Error - minimum value must be less than maximum value");
      }
   }
   
   /**
      The getMax method returns the maximum value.
      @return The value in the max field
   */
   public int getMaxR()
   {
      return max;
   }
   
   /**
      The increment method increases the count value by 1.
   */
   public void incrementR()
   {
      if (count < max)
      {
         count++;
      }
      else System.out.println("Error - count value is outside range of the interval");
   }
   
   /**
      The decrement method decreases the count value by 1.
   */
   public void decrementR()
   {
      if (count > min)
      {
         count--;
      }
      else System.out.println("Error - count value is outside range of the interval");
   }
}