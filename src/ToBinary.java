
import java.util.Stack;

class ToBinary {
   // Constructor
   public ToBinary() {}
 
   // Helper Function
   private String flipBits(String bits) {
      String result = "";
      for (int i = 0; i < bits.length(); i++)
         if (bits.charAt(i) == '0') result += '1';
         else result += '0';
      return result;
   }

   // Helper Function
   private String zeroPadFront(String s, int n) {
      String result = s;
      for (int i = s.length(); i < n; i++)
         result = "0" + result;
      return result;
   }

   // Helper Function
   private String zeroPadRear(String s, int n) {
      String result = s;
      for (int i = s.length(); i < n; i++)
         result += "0";
      return result;
   }

   // Unsigned
   public String toUnsigned(int value) {
      String result = "";
      
      Stack<Integer> values = new Stack<>();
      do {
         int reminder = value % 2;
         value = value / 2;
        
         values.push(reminder);
      } 
      while (value != 0);
      
      while(!values.isEmpty()){
          result += Integer.toString(values.pop());
      }

      return result;
   }

   private boolean inSignedRange(int value, int numbits) {
      //************************************************************
      // PUT CODE HERE
      int minBits = this.toUnsigned(Math.abs(value)).length()+1; /** The minimum number of bits required to represent a signed number 
                                                           is the minimum number of bits required to represent its unsigned 
                                                           version plus one bit for the sign. For example:
                                                           For a value of 15, the minimum number of bits necessary to represent it
                                                           in unsigned binary is 4. Therefore, we need one more bit for the signed version.
                                                           Thus, 5 bits are the minimum required for its signed version.*/
      
      if (numbits < minBits)
      {
          return false;
      }
      
      else 
      {
          return true;
      }
      // Return true if the passed value can be represented in the specified number of bits
      // for Two's complement
      //************************************************************
      
   }

   // Two's Complement
   public String toSigned(int value, int numbits) {
      // Check if no overflow
      if (!inSignedRange(value, numbits))
         return "OVERFLOW";
      else {
          boolean isNeg = false;    /* Stores whether or not the value is a 
                                       negative number. */
          
          //Checks if the value is a negative number
          if (value < 0)
          {
              value = value + 1;           //If yes, add 1 to the value and
              value = Math.abs(value);     //make the value positive
              isNeg = true;                 //The value is a negative number.
          }
        
         //Stores the unflipped signed binary version
         String result = zeroPadFront(toUnsigned(value), numbits);
         
         // Checks if the value was negative
         if (isNeg)
         {
             result = flipBits(result); // if it was, the bits are flipped
         }

         return result;     //Returns the Signed Binary 
      }
   }

   // Floating Point
   public String toFloat(float value) {
      // Helpful variables
      String sign, mantissa, exponent;

      
      if (value<0)
      {
          sign ="negative";
      }
      
      //*****************************************************
      // PUT CODE HERE
      // 
      // Set sign bit to "0" or "1" based on value
      
       if(value <0 )
          sign = "1";
      else
          sign = "0";
      //*****************************************************
      
      // Use toUnsigned() to get integer portion
      String integerPortion = toUnsigned((int) value);
      value -= (int) value;

      float sum = 0;
      int power = -1;
      String decimalPortion = "";

      while (sum < value && (integerPortion.length()-1)+decimalPortion.length() <= 23) {
         //************************************************************************************
         // PUT CODE HERE
         //
         // Compute decimal portion of fixed-point
         // Determine hypothetical sum, if not greater than value append '1' and update sum
         // Otherwise append '0'
         // Be sure to decrement your power each time
         //**********************************************************************************
         
         sum = (float) Math.pow(2, power);
         //comparison
        
         
         if(value == sum)
             decimalPortion = "1";  
         else if(value > sum){                             //this part has an error that I'm trying to figure it out
             value = value - sum;                          
             if (value < sum)
             decimalPortion = "0";
             else 
                 decimalPortion = "1";
         }
         
         power--;
      }

      //*************************************************************************************
      // PUT CODE HERE
      // 
      // Compute mantissa.  Everything after the first '1' in the concatenated integer and decimal portions.
      // Be sure to zero-pad
      String ceros = zeroPadRear(decimalPortion , 23 - decimalPortion.length());
      integerPortion = integerPortion.substring(1);
      mantissa = integerPortion + decimalPortion + ceros;
      //************************************************************************************* 
     
      //*************************************************************************************
      // PUT CODE HERE
      //
      // Compute exponent.  Use the integer portion unless that part is zero,
      // Then look at the decimal portion.
      // In either case, you want to find the position of the first '1'.
      // Then be sure to bias and zero-pad.
      
      int exponentValue = integerPortion.length() - 1;
      exponentValue = exponentValue + 127;
      exponent = toUnsigned(exponentValue);
      //*************************************************************************************

      return sign + " " + mantissa + " " + exponent;
   }

  
   // Double Precision
   public String toDouble(double value) {
      // Uncomment this line if you do the extra credit
      return "EXTRA CREDIT NOT DONE";

      //**********************************************************
      // PUT EXTRA CREDIT CODE HERE
      //**********************************************************
   }
}
